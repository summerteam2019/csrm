/**
 * The type BaseController.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.ognl.OgnlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

@RestController
public class BaseController {
    protected static final String DEFAULT_PAGE = "1";
    protected static final String DEFAULT_PAGE_SIZE = "10";
    protected static final String SYS_VALIDATION_PREFIX = "hap.validation.";
    protected static final String DEFAULT_VIEW_HOME = "";
    @Autowired
    private DefaultConfiguration configuration;
    @Autowired
    private MessageSource messageSource;
    @Qualifier("mvcValidator")
    @Autowired
    private Validator validator;
    private Logger logger = LoggerFactory.getLogger(BaseController.class);

    public BaseController() {
    }

    protected String getViewPath() {
        return this.configuration != null ? this.configuration.getDefaultViewPath() : "";
    }

    protected Validator getValidator() {
        return this.validator;
    }

    public MessageSource getMessageSource() {
        return this.messageSource;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder, HttpServletRequest request) {
    }

    protected void checkToken(HttpServletRequest request, Collection<? extends BaseDto> dtos) throws TokenException {
        if (request != null) {
            this.checkToken(request.getSession(false), dtos);
        }

    }

    protected void checkToken(HttpSession session, Collection<? extends BaseDto> dtos) throws TokenException {
        TokenUtils.checkToken(session, dtos);
    }

    protected void checkToken(HttpServletRequest request, BaseDto baseDto) throws TokenException {
        if (request != null) {
            this.checkToken(request.getSession(false), baseDto);
        }

    }

    protected void checkToken(HttpSession session, BaseDto baseDto) throws TokenException {
        TokenUtils.checkToken(session, baseDto);
    }

    @ExceptionHandler({Exception.class})
    public Object exceptionHandler(Exception exception, HttpServletRequest request) {
        this.logger.error(exception.getMessage(), exception);
        Throwable thr = this.getRootCause(exception);
        IBaseException be;
        Locale locale;
        String messageKey;
        String message;
        if (!RequestUtil.isAjaxRequest(request) && !RequestUtil.isAPIRequest(request) && !ServletFileUpload.isMultipartContent(request)) {
            ModelAndView view = new ModelAndView("500");
            if (thr instanceof IBaseException) {
                be = (IBaseException) thr;
                locale = RequestContextUtils.getLocale(request);
                messageKey = be.getDescriptionKey();
                message = this.messageSource.getMessage(messageKey, be.getParameters(), messageKey, locale);
                view.addObject("message", message);
            }

            return view;
        } else {
            ResponseData res = new ResponseData(false);
            if (thr instanceof IBaseException) {
                be = (IBaseException) thr;
                locale = RequestContextUtils.getLocale(request);
                messageKey = be.getDescriptionKey();
                message = this.messageSource.getMessage(messageKey, be.getParameters(), messageKey, locale);
                res.setCode(be.getCode());
                res.setMessage(message);
            } else {
                res.setMessage(thr.toString());
            }

            return res;
        }
    }

    protected String getErrorMessage(Errors errors, HttpServletRequest request) {
        Locale locale = RequestContextUtils.getLocale(request);
        String errorMessage = null;

        ObjectError error;
        for (Iterator var5 = errors.getAllErrors().iterator(); var5.hasNext(); errorMessage = error.getCode()) {
            error = (ObjectError) var5.next();
            if (error.getDefaultMessage() != null) {
                if (error instanceof FieldErrorWithBean) {
                    errorMessage = this.getStandardFieldErrorMessage((FieldErrorWithBean) error, locale);
                } else {
                    errorMessage = this.messageSource.getMessage(error.getDefaultMessage(), (Object[]) null, locale);
                }
                break;
            }
        }

        return errorMessage;
    }

    protected String nls(HttpServletRequest request, String code, Object[] args) {
        Locale locale = RequestContextUtils.getLocale(request);
        return this.messageSource.getMessage(code, args, code, locale);
    }

    protected String nls(HttpServletRequest request, String code) {
        Locale locale = RequestContextUtils.getLocale(request);
        return this.messageSource.getMessage(code, (Object[]) null, code, locale);
    }

    protected String getStandardFieldErrorMessage(FieldErrorWithBean fieldError, Locale locale) {
        String field = fieldError.getField();
        Class clazz = fieldError.getTargetBean().getClass();
        clazz = this.findDeclareClass(clazz, field);
        String fieldPromptMessageKey = clazz.getSimpleName() + "." + field;
        String fieldPrompt = this.messageSource.getMessage(fieldPromptMessageKey.toLowerCase(), (Object[]) null, locale);
        String code = "hap.validation." + fieldError.getCode().toLowerCase();
        String msg = this.messageSource.getMessage(code, new Object[]{fieldPrompt}, fieldError.getDefaultMessage(), locale);
        if (code.equalsIgnoreCase(msg) && fieldError.getDefaultMessage() != null) {
            msg = fieldPrompt + " : " + fieldError.getDefaultMessage();
        }

        return msg;
    }

    private Class findDeclareClass(Class fromClass, String fieldName) {
        Class clazz = fromClass;

        while (clazz.getSuperclass() != null) {
            try {
                clazz.getDeclaredField(fieldName);
                return clazz;
            } catch (NoSuchFieldException var5) {
                clazz = clazz.getSuperclass();
            }
        }

        return fromClass;
    }

    private Throwable getRootCause(Throwable throwable) {
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }

        if (throwable instanceof OgnlException && ((OgnlException) throwable).getReason() != null) {
            return this.getRootCause(((OgnlException) throwable).getReason());
        } else {
            return throwable;
        }
    }

    protected Long getUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Long) session.getAttribute("userId");
    }

    protected Long getRoleId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Long) session.getAttribute("roleId");
    }

    protected String getLanguage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute("locale");
    }
}
