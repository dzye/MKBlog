package com.mikey.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    private BeanCopyUtils() {
    }

    public static <E, T> T copyBean(E source, Class<T> clazz) {
        T result = null;
        try {
            result = clazz.newInstance();
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <E, T> List<T> copyBeanList(List<E> source, Class<T> clazz) {
        return source.stream().map(o -> copyBean(o, clazz)).collect(Collectors.toList());
    }
}
