/**
 * The type Validator.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.metadata.ConstraintDescriptor;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;

@Component
public class ComplexCommonValidator extends OptionalValidatorFactoryBean {
    private Logger logger = LoggerFactory.getLogger(ComplexCommonValidator.class);

    public ComplexCommonValidator() {
    }

    @Override
    public void validate(Object target, Errors errors) {
        Validator targetValidator = this.getValidator();
        if (targetValidator != null) {
            if (target instanceof List) {
                Iterator var4 = ((List)target).iterator();

                while(var4.hasNext()) {
                    Object obj = var4.next();
                    this.validate(obj, errors);
                }
            } else {
                this.processConstraintViolations(targetValidator.validate(target, new Class[0]), errors);
                EntityField[] var10 = DTOClassInfo.getChildrenFields(target.getClass());
                int var11 = var10.length;

                for(int var6 = 0; var6 < var11; ++var6) {
                    EntityField f = var10[var6];

                    try {
                        Object children = PropertyUtils.getProperty(target, f.getName());
                        if (children != null) {
                            this.validate(children, errors);
                        }
                    } catch (Exception var9) {
                        if (this.logger.isErrorEnabled()) {
                            this.logger.error(var9.getMessage(), var9);
                        }
                    }
                }
            }
        }

    }

    @Override
    protected void processConstraintViolations(Set<ConstraintViolation<Object>> violations, Errors errors) {
        Iterator var3 = violations.iterator();

        while(true) {
            ConstraintViolation violation;
            String field;
            FieldError fieldError;
            do {
                if (!var3.hasNext()) {
                    return;
                }

                violation = (ConstraintViolation)var3.next();
                field = this.determineField(violation);
                fieldError = errors.getFieldError(field);
            } while(fieldError != null && fieldError.isBindingFailure());

            try {
                ConstraintDescriptor<?> cd = violation.getConstraintDescriptor();
                String errorCode = this.determineErrorCode(cd);
                Object[] errorArgs = this.getArgumentsForConstraint(errors.getObjectName(), field, cd);
                if (errors instanceof BindingResult) {
                    BindingResult bindingResult = (BindingResult)errors;
                    String nestedField = bindingResult.getNestedPath() + field;
                    if ("".equals(nestedField)) {
                        String[] errorCodes = bindingResult.resolveMessageCodes(errorCode);
                        bindingResult.addError(new ObjectError(errors.getObjectName(), errorCodes, errorArgs, violation.getMessage()));
                    }
                } else {
                    errors.rejectValue(field, errorCode, errorArgs, violation.getMessage());
                }
            } catch (NotReadablePropertyException var15) {
                StringBuilder sb = new StringBuilder(256);
                sb.append("JSR-303 validated property '").append(field);
                sb.append("' does not have a corresponding accessor for Spring data binding - ");
                sb.append("check your DataBinder's configuration (bean property versus direct field access)");
                throw new IllegalStateException(sb.toString(), var15);
            }
        }
    }
}