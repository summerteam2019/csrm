/**
 * The type EntityField.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class EntityField {
    private String name;
    private Field field;
    private Class<?> javaType;
    private Method setter;
    private Method getter;

    public EntityField(Field field, PropertyDescriptor propertyDescriptor) {
        if (field != null) {
            this.field = field;
            this.name = field.getName();
            this.javaType = field.getType();
        }

        if (propertyDescriptor != null) {
            this.name = propertyDescriptor.getName();
            this.setter = propertyDescriptor.getWriteMethod();
            this.getter = propertyDescriptor.getReadMethod();
            this.javaType = propertyDescriptor.getPropertyType();
        }

    }

    public void copyFromPropertyDescriptor(EntityField other) {
        this.setter = other.setter;
        this.getter = other.getter;
        this.javaType = other.javaType;
        this.name = other.name;
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        boolean result = false;
        if (this.field != null) {
            result = this.field.isAnnotationPresent(annotationClass);
        }

        if (!result && this.setter != null) {
            result = this.setter.isAnnotationPresent(annotationClass);
        }

        if (!result && this.getter != null) {
            result = this.getter.isAnnotationPresent(annotationClass);
        }

        return result;
    }

    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        T result = null;
        if (this.field != null) {
            result = this.field.getAnnotation(annotationClass);
        }

        if (result == null && this.setter != null) {
            result = this.setter.getAnnotation(annotationClass);
        }

        if (result == null && this.getter != null) {
            result = this.getter.getAnnotation(annotationClass);
        }

        return result;
    }

    public <T extends Annotation> T[] getAnnotations(Class<T> annotationClass) {
        T[] result = null;
        if (this.field != null) {
            result = this.field.getAnnotationsByType(annotationClass);
        }

        if (result == null && this.setter != null) {
            result = this.setter.getAnnotationsByType(annotationClass);
        }

        if (result == null && this.getter != null) {
            result = this.getter.getAnnotationsByType(annotationClass);
        }

        return result;
    }

    public String getName() {
        return this.name;
    }

    public Class<?> getJavaType() {
        return this.javaType;
    }

    public void setJavaType(Class<?> javaType) {
        this.javaType = javaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            boolean var10000;
            label35: {
                EntityField that = (EntityField)o;
                if (this.name != null) {
                    if (this.name.equals(that.name)) {
                        break label35;
                    }
                } else if (that.name == null) {
                    break label35;
                }

                var10000 = false;
                return var10000;
            }

            var10000 = true;
            return var10000;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.name != null ? this.name.hashCode() : 0;
    }
}

