/**
 * The type FieldHelper.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import javax.persistence.Entity;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FieldHelper {

    private static final FieldHelper fieldHelper = new FieldHelper();

    public List<EntityField> getFields(Class<?> entityClass) {
        List<EntityField> fields = this._getFields(entityClass, (List) null, (Integer) null);
        List<EntityField> properties = this.getProperties(entityClass);
        Set<EntityField> usedSet = new HashSet();
        Iterator var5 = fields.iterator();

        while (true) {
            while (var5.hasNext()) {
                EntityField field = (EntityField) var5.next();
                Iterator var7 = properties.iterator();

                while (var7.hasNext()) {
                    EntityField property = (EntityField) var7.next();
                    if (!usedSet.contains(property) && field.getName().equals(property.getName())) {
                        field.setJavaType(property.getJavaType());
                        break;
                    }
                }
            }

            return fields;
        }
    }

    private List<EntityField> _getFields(Class<?> entityClass, List<EntityField> fieldList, Integer level) {
        if (fieldList == null) {
            fieldList = new ArrayList();
        }

        if (level == null) {
            level = 0;
        }

        if (entityClass.equals(Object.class)) {
            return (List) fieldList;
        } else {
            Field[] fields = entityClass.getDeclaredFields();
            int index = 0;

            for (int i = 0; i < fields.length; ++i) {
                Field field = fields[i];
                if (!Modifier.isStatic(field.getModifiers())) {
                    if (level != 0) {
                        ((List) fieldList).add(index, new EntityField(field, (PropertyDescriptor) null));
                        ++index;
                    } else {
                        ((List) fieldList).add(new EntityField(field, (PropertyDescriptor) null));
                    }
                }
            }

            Class<?> superClass = entityClass.getSuperclass();
            return (List) (superClass == null || superClass.equals(Object.class) || !superClass.isAnnotationPresent(Entity.class) && (Map.class.isAssignableFrom(superClass) || Collection.class.isAssignableFrom(superClass)) ? fieldList : this._getFields(entityClass.getSuperclass(), (List) fieldList, level + 1));
        }
    }

    public List<EntityField> getProperties(Class<?> entityClass) {
        ArrayList entityFields = new ArrayList();

        BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(entityClass);
        } catch (IntrospectionException var9) {
            throw new RuntimeException(var9);
        }

        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        PropertyDescriptor[] var5 = descriptors;
        int var6 = descriptors.length;

        for (int var7 = 0; var7 < var6; ++var7) {
            PropertyDescriptor desc = var5[var7];
            if (desc.getWriteMethod() != null && desc.getReadMethod() != null && !"class".equals(desc.getName())) {
                entityFields.add(new EntityField((Field) null, desc));
            }
        }

        return entityFields;
    }

    public FieldHelper() {
    }

    public static List<EntityField> getAll(Class<?> entityClass) {
        List<EntityField> fields = fieldHelper.getFields(entityClass);
        List<EntityField> properties = fieldHelper.getProperties(entityClass);
        List<EntityField> all = new ArrayList();
        Set<EntityField> usedSet = new HashSet();

        Iterator var5;
        EntityField property;
        for (var5 = fields.iterator(); var5.hasNext(); all.add(property)) {
            property = (EntityField) var5.next();
            Iterator var7 = properties.iterator();

            while (var7.hasNext()) {
                property = (EntityField) var7.next();
                if (!usedSet.contains(property) && property.getName().equals(property.getName())) {
                    property.copyFromPropertyDescriptor(property);
                    usedSet.add(property);
                    break;
                }
            }
        }

        var5 = properties.iterator();

        while (var5.hasNext()) {
            property = (EntityField) var5.next();
            if (!usedSet.contains(property)) {
                all.add(property);
            }
        }

        return all;
    }
}
