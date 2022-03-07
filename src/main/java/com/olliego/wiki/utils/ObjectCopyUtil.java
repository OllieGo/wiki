package com.olliego.wiki.utils;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.beans.BeanUtils;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ObjectCopyUtil {
    public ObjectCopyUtil() {
    }

    public static <SourceBean, TargetBean> TargetBean bean2Bean(SourceBean request, Class<TargetBean> cls) {
        if (null == request) {
            return null;
        } else {
            try {
                TargetBean result = cls.newInstance();
                BeanUtils.copyProperties(request, result);
                return result;
            } catch (Exception var4) {
                throw new IllegalArgumentException("对象copy异常，请检查", var4);
            }
        }
    }

    public static <SourceBean, TargetBean> TargetBean bean2Bean(SourceBean sourceBean, Class<TargetBean> targetBeanClass, String... ignoreProperties) {
        if (null == sourceBean) {
            return null;
        } else {
            try {
                TargetBean targetBean = targetBeanClass.newInstance();
                BeanUtils.copyProperties(sourceBean, targetBean, ignoreProperties);
                return targetBean;
            } catch (Exception var5) {
                throw new IllegalArgumentException("对象copy异常，请检查", var5);
            }
        }
    }

    public static <SourceBean, TargetBean> List<TargetBean> beanList2BeanList(List<SourceBean> request, Class<TargetBean> cls) {
        if (request == null) {
            return null;
        } else {
            List<TargetBean> result = Lists.newArrayList();
            Iterator var3 = request.iterator();

            while(var3.hasNext()) {
                SourceBean obj = (SourceBean) var3.next();
                result.add(bean2Bean(obj, cls));
            }

            return result;
        }
    }

    public static Map<String, Object> bean2Map(Object obj) {
        HashMap params = Maps.newHashMap();

        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);

            for(int i = 0; i < descriptors.length; ++i) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                }
            }

            return params;
        } catch (Exception var6) {
            throw new IllegalArgumentException("javabean实体类转为map类型异常，请检查", var6);
        }
    }

    public static Object map2Bean(Map<String, Object> map, Class<?> beanClass) {
        if (map == null) {
            return null;
        } else {
            Object obj = null;

            try {
                obj = beanClass.newInstance();
                Field[] fields = obj.getClass().getDeclaredFields();
                Field[] var4 = fields;
                int var5 = fields.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    Field field = var4[var6];
                    int mod = field.getModifiers();
                    if (!Modifier.isStatic(mod) && !Modifier.isFinal(mod)) {
                        field.setAccessible(true);
                        field.set(obj, map.get(field.getName()));
                    }
                }

                return obj;
            } catch (Exception var9) {
                throw new IllegalArgumentException("map转换javabean实体类异常，请检查", var9);
            }
        }
    }
}
