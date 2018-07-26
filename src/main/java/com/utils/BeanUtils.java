/**
 * 版权所有(C) ZHIHUISHU 2015-2025
 * Copyright 2010-2020 ZHIHUISHU
 * 创建日期：2016/1/12 15:16
 * 创建人：shenhui
 */
package com.utils;

import net.sf.cglib.beans.BeanCopier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ivan
 */
public final class BeanUtils {
    private BeanUtils() {

    }

    private static final Logger LOG = LoggerFactory.getLogger(BeanUtils.class);

    /*
     * 用来缓存BeanCopier的缓存
     */
    private static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIER_CACHE = new ConcurrentHashMap();

    private static BeanCopier getBeanCopier(Class<?> sourceClass, Class<?> destClass) {
        String key = sourceClass.getCanonicalName() + ":" + destClass.getCanonicalName();
        BeanCopier beanCopier = BEAN_COPIER_CACHE.get(key);
        if (beanCopier == null) {
            beanCopier = BeanCopier.create(sourceClass, destClass, false);
            BEAN_COPIER_CACHE.putIfAbsent(key, beanCopier);
        }
        return beanCopier;
    }

    /**
     * 复制某个对象为目标对象类型的对象 当source与target对象属性名相同, 但数据类型不一致时，source的属性值不会复制到target对象
     *
     * @param <T>
     *            目标对象类型参数
     * @param source
     *            源对象
     * @param destType
     *            目标对象类型
     * @return
     */
    public static <T> T copyAs(Object source, Class<T> destType) {
        if (source == null || destType == null) {
            return null;
        }
        try {
            BeanCopier beanCopier = getBeanCopier(source.getClass(), destType);
            T dest = destType.newInstance();
            beanCopier.copy(source, dest, null);
            return dest;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 复制源对象集合到目标对象列表
     *
     * @param <T>
     * @param source
     * @param destType
     * @return
     */
    public static <T, K> List<K> copyAs(Collection<T> source, Class<K> destType) {
        if (source == null || destType == null) {
            return Collections.EMPTY_LIST;
        }

        List<K> result = new ArrayList<K>();
        if (source.isEmpty()) {
            return result;
        }
        try {
            Iterator<T> iterator = source.iterator();
            Class<?> sourceClass = iterator.next().getClass();
            BeanCopier beanCopier = getBeanCopier(sourceClass, destType);
            for (Object object : source) {
                K dest = destType.newInstance();
                beanCopier.copy(object, dest, null);
                result.add(dest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 复制属性：从源对象复制和目标对象相同的属性
     *
     * @param source
     *            源对象
     * @param target
     *            目标对象
     */
    public static void copy(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass());
        beanCopier.copy(source, target, null);
    }

    /**
     * 复制属性：从源对象复制和目标对象相同的属性，除了忽略的属性之外
     * 如果属性名相同，但数据类型不同，会抛出运行时异常FatalBeanException
     *
     * @param source
     *            源对象
     * @param target
     *            目标对象
     * @param ignoreProperties
     *            忽略属性
     */
    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
    }

    /**
     * 将Map对象拷贝到Bean，Map中的key对应Bean的属性名，value对应属性值
     *
     * @param source
     * @param target
     */
//    public static void copyMapToObject(Map<?, ?> source, Object target) {
//        try {
//            org.apache.commons.beanutils.BeanUtils.populate(target, source);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    /**
     * 把对象当作Map用
     *
     * @param obj
     *            对象
     * @return Map
     */
//    public static Map<String, Object> getProperties(Object obj) {
//        return new org.apache.commons.beanutils.BeanMap(obj);
//    }

    /**
     * 设置属性
     *
     * @param bean
     *            目标对象
     * @param name
     *            属性名
     * @param value
     *            属性值
     */
    public static void setProperty(Object bean, String name, Object value) {
        try {
            org.apache.commons.beanutils.BeanUtils.setProperty(bean, name, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取属性
     *
     * @param bean
     *            目标对象
     * @param name
     *            属性名
     */
    public static Object getProperty(Object bean, String name) {
        try {
            return org.apache.commons.beanutils.BeanUtils.getProperty(bean, name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置Field值
     *
     * @param bean
     *            要设置对象
     * @param fieldName
     *            字段名
     * @param value
     *            值
     */
    public static void setFieldValue(Object bean, String fieldName, Object value) {
        try {
            Field field = findField(bean.getClass(), fieldName);
            field.setAccessible(true);
            field.set(bean, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 取得指定名称的Field, 子类找不到, 去父类里找
     *
     * @param clz
     *            类
     * @param fieldName
     *            指定名称
     * @return 找不到返回null
     */
    public static Field findField(Class<?> clz, String fieldName) {
        Field f = null;
        try {
            f = clz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            if (clz.getSuperclass() != null) {
                f = findField(clz.getSuperclass(), fieldName);
            }
            if (LOG.isTraceEnabled()) {
                LOG.trace(e.getMessage(), e);
            }
        }
        return f;
    }

    /**
     * 用于model修改时的对象复制,把srcModel复制到destModel,srcModel中为null的字段不复制，同名且类型相同的属性才复制
     *
     * @param srcModel
     *            表单提交的源对象
     * @param destModel
     *            数据库中的目标对象
     */
    public static void copyNotNullProperties(Object srcModel, Object destModel) {
        if (srcModel == null || destModel == null) {
            return;
        }

        try {
            PropertyDescriptor[] srcDescriptors = Introspector.getBeanInfo(srcModel.getClass()).getPropertyDescriptors();
            PropertyDescriptor[] destDescriptors = Introspector.getBeanInfo(destModel.getClass()).getPropertyDescriptors();
            Map<String, PropertyDescriptor> destPropertyNameDescriptorMap = new HashMap<String, PropertyDescriptor>();
            for (PropertyDescriptor destPropertyDescriptor : destDescriptors) {
                destPropertyNameDescriptorMap.put(destPropertyDescriptor.getName(), destPropertyDescriptor);
            }
            for (PropertyDescriptor srcDescriptor : srcDescriptors) {
                PropertyDescriptor destDescriptor = destPropertyNameDescriptorMap.get(srcDescriptor.getName());
                if (destDescriptor != null && destDescriptor.getPropertyType() == srcDescriptor.getPropertyType()
                        && destDescriptor.getPropertyType() != Class.class) {// 类型相同的属性才复制
                    Object val = srcDescriptor.getReadMethod().invoke(srcModel);
                    if (val != null && destDescriptor.getWriteMethod() != null) {// not
                                                                                 // null
                        destDescriptor.getWriteMethod().invoke(destModel, val);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
