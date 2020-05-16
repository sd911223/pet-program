package com.live.util.redis;

import com.alibaba.fastjson.JSONObject;
import com.live.model.LiveUser;
import org.phprpc.util.AssocArray;
import org.phprpc.util.PHPSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PHPSerializationRedisSerializer<T>  implements RedisSerializer<T> {

    private final PHPSerializer phpSerializer = new PHPSerializer();
    private final static String CHARSET = "utf-8";

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        byte[] bytes = null;
        try {
            phpSerializer.setCharset(CHARSET);
            bytes = phpSerializer.serialize(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        Object obj = null;
        Map<String,Object> map = null;
        try {
            phpSerializer.setCharset(CHARSET);
            obj = phpSerializer.unserialize(bytes);
            map = converToMap(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return (T)JSONObject.toJSONString(map);
    }

    private Map<String,Object> converToMap(Object obj) {
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> preMap = ((AssocArray) obj).toLinkedHashMap();
        for (Map.Entry<String,Object> entry : preMap.entrySet()) {
            if(entry.getValue() == null) {
                continue;
            }
            if(entry.getValue() instanceof  Integer)  {
                resultMap.put(entry.getKey(), entry.getValue());
            }else {
                resultMap.put(entry.getKey(), new String((byte[]) entry.getValue()));
            }

        }

        return  resultMap;
    }
}
