/**
 * The type TokenUtils.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;

public class TokenUtils {
    public static final String SECURITY_KEY = "securityKey";
    private static Logger logger = LoggerFactory.getLogger(TokenUtils.class);

    private TokenUtils() {
    }

    public static String getSecurityKey(HttpSession session) {
        return session == null ? null : (String)session.getAttribute("securityKey");
    }

    public static String setSecurityKey(HttpSession session) {
        String secKey = UUID.randomUUID().toString();
        session.setAttribute("securityKey", secKey);
        return secKey;
    }

    public static String generateToken(String securityKey, BaseDto dto) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(securityKey).append(':').append(dto.getClass().getName());
        EntityField[] var3 = DTOClassInfo.getIdFields(dto.getClass());
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            EntityField f = var3[var5];

            try {
                stringBuilder.append(':').append(Objects.toString(PropertyUtils.getProperty(dto, f.getName()), ""));
            } catch (Exception var8) {
                throw new RuntimeException(var8);
            }
        }

        return DigestUtils.md5Hex(stringBuilder.toString());
    }

    public static void generateAndSetToken(String securityKey, BaseDto dto) {
        String token = generateToken(securityKey, dto);
        dto.set_token(token);
    }

    public static void generateAndSetToken(String securityKey, Collection<? extends BaseDto> dtos) {
        Iterator var2 = dtos.iterator();

        while(var2.hasNext()) {
            BaseDto dto = (BaseDto)var2.next();
            generateAndSetToken(securityKey, dto);
        }

    }

    public static void checkToken(String securityKey, BaseDto dto) throws TokenException {
        String token = dto.get_token();
        if (token == null) {
            throw new TokenException("msg.error.token_not_exists", dto);
        } else if (!token.equalsIgnoreCase(generateToken(securityKey, dto))) {
            if (logger.isDebugEnabled()) {
                logger.debug("token check failed.token:{}, class:{}", dto.get_token(), dto.getClass().getName());
            }

            throw new TokenException(dto);
        } else {
            EntityField[] var3 = DTOClassInfo.getChildrenFields(dto.getClass());
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                EntityField f = var3[var5];

                try {
                    Object fieldValue = PropertyUtils.getProperty(dto, f.getName());
                    if (fieldValue instanceof BaseDto) {
                        checkToken(securityKey, (BaseDto)fieldValue);
                    } else if (fieldValue instanceof Collection) {
                        checkToken(securityKey, (Collection)fieldValue);
                    }
                } catch (Exception var8) {
                    throw new RuntimeException(var8);
                }
            }

        }
    }

    public static void checkToken(HttpSession session, BaseDto dto) throws TokenException {
        String securityKey = getSecurityKey(session);
        if (securityKey == null) {
            if (logger.isWarnEnabled()) {
                logger.warn("check skipped due to securityKey not exists.");
            }

        } else {
            checkToken(securityKey, dto);
        }
    }

    public static void checkToken(String securityKey, Collection<? extends BaseDto> baseDtos) throws TokenException {
        if (baseDtos != null && !baseDtos.isEmpty()) {
            Class<?> clazz = ((BaseDto)baseDtos.iterator().next()).getClass();
            EntityField[] ids = DTOClassInfo.getIdFields(clazz);
            Iterator var4 = baseDtos.iterator();

            while(var4.hasNext()) {
                BaseDto dto = (BaseDto)var4.next();
                if (hasIDValue(dto, ids)) {
                    checkToken(securityKey, dto);
                }
            }
        }

    }

    private static boolean hasIDValue(Object obj, EntityField[] ids) {
        EntityField[] var2 = ids;
        int var3 = ids.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            EntityField f = var2[var4];

            try {
                if (PropertyUtils.getProperty(obj, f.getName()) == null) {
                    return false;
                }
            } catch (Exception var7) {
                throw new RuntimeException(var7);
            }
        }

        return true;
    }

    public static void checkToken(HttpSession session, Collection<? extends BaseDto> baseDtos) throws TokenException {
        String securityKey = getSecurityKey(session);
        if (securityKey == null) {
            if (logger.isWarnEnabled()) {
                logger.warn("check skipped due to securityKey not exists.");
            }

        } else {
            checkToken(securityKey, baseDtos);
        }
    }
}
