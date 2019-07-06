/**
 * The type DTOClassInfo.
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date ${.now?string["yyyy/MM/dd"]}
 */

package com.kb.csrm.util;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

public final class DTOClassInfo {
    private static final Comparator<EntityField> FIELD_COMPARATOR = Comparator.comparing(EntityField::getName);
    private static final Class<? extends Annotation>[] CONCERNED_ANNOTATION = new Class[]{Id.class};
    private static final Map<Class<?>, EntityField[]>[] CLASS_ANNO_MAPPING;
    private static final Map<Class<?>, Map<String, EntityField>> CLASS_FIELDS_MAPPING;
    private static final Map<String, String> CAMEL_UL_MAP;
    private static final Map<String, String> UL_CAMEL_MAP;

    private DTOClassInfo() {
    }

    public static EntityField[] getIdFields(Class<?> clazz) {
        return getFields0(clazz, 0);
    }

    public static EntityField[] getChildrenFields(Class<?> clazz) {
        return getFields0(clazz, 1);
    }

    public static EntityField[] getMultiLanguageFields(Class<?> clazz) {
        return getFields0(clazz, 2);
    }

    private static EntityField[] getFields0(Class<?> clazz, int idx) {
        EntityField[] fields = (EntityField[]) CLASS_ANNO_MAPPING[idx].get(clazz);
        if (fields == null) {
            analysis(clazz);
            fields = (EntityField[]) CLASS_ANNO_MAPPING[idx].get(clazz);
        }

        return fields;
    }

    public static EntityField[] getFieldsOfAnnotation(Class<?> clazz, Class<? extends Annotation> annoType) {
        int idx = Arrays.asList(CONCERNED_ANNOTATION).indexOf(annoType);
        return idx != -1 ? getFields0(clazz, idx) : new EntityField[0];
    }

    private static void analysis(Class<?> clazz) {
        List<EntityField> fields = FieldHelper.getAll(clazz);
        fields.sort(FIELD_COMPARATOR);
        List<EntityField>[] lists = new List[CONCERNED_ANNOTATION.length];

        for (int i = 0; i < CONCERNED_ANNOTATION.length; ++i) {
            lists[i] = new ArrayList();
        }

        Map<String, EntityField> fieldMap = new HashMap();
        Iterator var4 = fields.iterator();

        while (var4.hasNext()) {
            EntityField f = (EntityField) var4.next();

            for (int i = 0; i < CONCERNED_ANNOTATION.length; ++i) {
                if (f.getAnnotation(CONCERNED_ANNOTATION[i]) != null) {
                    lists[i].add(f);
                }
            }

            fieldMap.put(f.getName(), f);
        }

        CLASS_FIELDS_MAPPING.put(clazz, fieldMap);

        for (int i = 0; i < CLASS_ANNO_MAPPING.length; ++i) {
            EntityField[] fs = (EntityField[]) lists[i].toArray(new EntityField[lists[i].size()]);
            CLASS_ANNO_MAPPING[i].put(clazz, fs);
        }

    }

    public static EntityField getEntityField(Class<?> clazz, String field) {
        Map<String, EntityField> map = (Map) CLASS_FIELDS_MAPPING.get(clazz);
        if (map == null) {
            analysis(clazz);
            map = (Map) CLASS_FIELDS_MAPPING.get(clazz);
        }

        return (EntityField) map.get(field);
    }

    public static Map<String, EntityField> getEntityFields(Class<?> clazz) {
        Map<String, EntityField> map = (Map) CLASS_FIELDS_MAPPING.get(clazz);
        if (map == null) {
            analysis(clazz);
        }

        return map;
    }

    public static String camelToUnderLine(String camel) {
        String ret = (String) CAMEL_UL_MAP.get(camel);
        if (ret == null) {
            ArrayList<String> tmp = new ArrayList();
            int lastIdx = 0;

            for (int i = 0; i < camel.length(); ++i) {
                if (Character.isUpperCase(camel.charAt(i))) {
                    tmp.add(camel.substring(lastIdx, i).toLowerCase());
                    lastIdx = i;
                }
            }

            tmp.add(camel.substring(lastIdx));
            ret = StringUtils.join(tmp.toArray(), "_");
            CAMEL_UL_MAP.put(camel, ret);
        }

        return ret;
    }

    public static String underLineToCamel(String str) {
        String camel = (String) UL_CAMEL_MAP.get(str);
        if (camel == null) {
            String[] array = str.toLowerCase().split("_");

            for (int i = 1; i < array.length; ++i) {
                array[i] = StringUtils.capitalize(array[i]);
            }

            camel = StringUtils.join(array);
            UL_CAMEL_MAP.put(str, camel);
        }

        return camel;
    }

    public static String getColumnName(EntityField field) {
        Column col = (Column) field.getAnnotation(Column.class);
        return col != null && !StringUtils.isEmpty(col.name()) ? col.name() : camelToUnderLine(field.getName());
    }

    public static String getTableName(Class<?> clazz) {
        String tableName = null;
        Table anonotation = getTableAnnotation(clazz);
        if (anonotation != null) {
            tableName = anonotation.name();
        }

        return tableName;
    }

    static Table getTableAnnotation(Class<?> clazz) {
        Table annotation = null;
        annotation = (Table) clazz.getAnnotation(Table.class);
        if (annotation == null && clazz.getSuperclass() != null) {
            annotation = getTableAnnotation(clazz.getSuperclass());
        }

        return annotation;
    }

    static {
        CLASS_ANNO_MAPPING = new HashMap[CONCERNED_ANNOTATION.length];
        CLASS_FIELDS_MAPPING = new HashMap();

        for (int i = 0; i < CLASS_ANNO_MAPPING.length; ++i) {
            CLASS_ANNO_MAPPING[i] = new HashMap();
        }

        CAMEL_UL_MAP = new HashMap();
        UL_CAMEL_MAP = new HashMap();
    }
}
