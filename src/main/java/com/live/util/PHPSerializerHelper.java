package com.live.util;
import org.phprpc.util.PHPSerializer;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
public class PHPSerializerHelper {
    private static PHPSerializer phpSerializer = new PHPSerializer();

    private static String ENCODING = "utf-8";

    private PHPSerializerHelper(){}

    public PHPSerializer getInstance() {

        return phpSerializer;
    }

    public static <T> T convertJavaBean(String text, Class<T> clazz) throws UnsupportedEncodingException, InvocationTargetException, IllegalAccessException {

        return (T) phpSerializer.unserialize(text.getBytes(ENCODING), clazz);
    }
}
