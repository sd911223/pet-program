package com.live.service.impl;


import com.live.service.IRedisService;
import com.live.util.LogUtil;
import com.live.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service("redisService")
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private RedisTemplate phpRedisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private DefaultRedisScript<Long> redisScript;

    @Value("${redis.prefix}")
    private String prefix;

    @Value("${redis.token}")
    private String token;

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = phpRedisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存设置时效时间
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = phpRedisTemplate.opsForValue();
            operations.set(key, value);
            phpRedisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    @Override
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    @Override
    public void removePattern(final String pattern) {
        Set<Serializable> keys = phpRedisTemplate.keys(pattern);
        if (keys.size() > 0) {
            phpRedisTemplate.delete(keys);
        }
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    @Override
    public void remove(final String key) {
        if (exists(key)) {
            phpRedisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    @Override
    public boolean exists(final String key) {
        return phpRedisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    @Override
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = phpRedisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    @Override
    public Object getToken(String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = phpRedisTemplate.opsForValue();
        result = operations.get(prefix + token + key + ":");
        return result;
    }

    /**
     * 哈希 添加
     *
     * @param key
     * @param hashKey
     * @param value
     */
    @Override
    public void hmSet(String key, Object hashKey, Object value) {
        HashOperations<String, Object, Object> hash = phpRedisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    /**
     * 哈希获取数据
     *
     * @param key
     * @param hashKey
     * @return
     */
    @Override
    public Object hmGet(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = phpRedisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    /**
     * 列表添加
     *
     * @param k
     * @param v
     */
    @Override
    public void lPush(String k, Object v) {
        ListOperations<String, Object> list = phpRedisTemplate.opsForList();
        list.rightPush(k, v);
    }

    /**
     * 列表获取
     *
     * @param k
     * @param l
     * @param l1
     * @return
     */
    @Override
    public List<Object> lRange(String k, long l, long l1) {
        ListOperations<String, Object> list = phpRedisTemplate.opsForList();
        return list.range(k, l, l1);
    }

    /**
     * 集合添加
     *
     * @param key
     * @param value
     */
    @Override
    public void add(String key, Object value) {
        SetOperations<String, Object> set = phpRedisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * 集合获取
     *
     * @param key
     * @return
     */
    @Override
    public Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = phpRedisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     *
     * @param key
     * @param value
     * @param scoure
     */
    @Override
    public void Add(String key, Object value, double scoure) {
        ZSetOperations<String, Object> zset = phpRedisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    /**
     * 有序集合获取
     *
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    @Override
    public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String, Object> zset = phpRedisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }

    /**
     * 判定redis中是否存在该key
     *
     * @param redisKey redis键，不能为空
     * @return 存在：返回true，不存在：返回false（redisKey为空则返回false）
     */
    @Override
    public boolean hasKey(String redisKey) {
        if (!StringUtil.isNotNull(redisKey)) {
            return false;
        }

        try {
            return phpRedisTemplate.hasKey(redisKey);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 设置redisKey失效时间
     *
     * @param redisKey redis键，不能为空
     * @param time     时间(秒) time>0
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空或time<=0：返回false）
     */
    @Override
    public boolean setExpire(String redisKey, long time) {
        if (!StringUtil.isNotNull(redisKey) || time <= 0) {
            return false;
        }

        try {
            phpRedisTemplate.expire(redisKey, time, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 获取redisKey失效时间
     *
     * @param redisKey redis键，不能为空
     * @return 查询成功:返回失效时间(秒)，返回0：永久有效（redisKey为空则返回-1）
     */
    @Override
    public long getExpire(String redisKey) {
        if (!StringUtil.isNotNull(redisKey)) {
            return -1;
        }

        try {
            return phpRedisTemplate.getExpire(redisKey, TimeUnit.SECONDS);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return 0;
    }

    /**
     * 新增key-value（时间无限期）
     *
     * @param redisKey redis键，不能为空
     * @param value    值
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空则返回false）
     */
    @Override
    public boolean addValue(String redisKey, Object value) {
        if (!StringUtil.isNotNull(redisKey)) {
            return false;
        }

        try {
            phpRedisTemplate.opsForValue().set(redisKey, value);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 新增key-value并设置时间
     *
     * @param redisKey redis键，不能为空
     * @param value    值
     * @param time     时间(秒) time>0
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空或time<=0：返回false）
     */
    @Override
    public boolean addValue(String redisKey, Object value, long time) {
        if (!StringUtil.isNotNull(redisKey) || time <= 0) {
            return false;
        }

        try {
            phpRedisTemplate.opsForValue().set(redisKey, value, time, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 获取redis键对应的值
     *
     * @param redisKey redis键，不能为空
     * @return 操作成功：返回键对应的值，操作失败：返回null（redisKey为空则返回null）
     */
    @Override
    public Object getValue(String redisKey) {
        if (!StringUtil.isNotNull(redisKey)) {
            return null;
        }

        try {
            return phpRedisTemplate.opsForValue().get(redisKey);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return null;
    }

    /**
     * 删除单个redisKey
     *
     * @param redisKey redis键，不能为空
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空则返回false）
     */
    @Override
    public boolean deleteValue(String redisKey) {
        if (!StringUtil.isNotNull(redisKey)) {
            return false;
        }

        try {
            phpRedisTemplate.delete(redisKey);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 批量删除redisKey
     *
     * @param redisKeyList 批量redis键，不能为空
     * @return 操作成功：返回true，操作失败：返回false（redisKeyList为空则返回false）
     */
    @Override
    public boolean deleteValueList(List<String> redisKeyList) {
        if (CollectionUtils.isEmpty(redisKeyList)) {
            return false;
        }

        try {
            phpRedisTemplate.delete(redisKeyList);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 新增list
     *
     * @param redisKey redis键，不能为空
     * @param value    值
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空则返回false）
     */
    @Override
    public boolean addList(String redisKey, Object value) {
        if (!StringUtil.isNotNull(redisKey)) {
            return false;
        }

        try {
            phpRedisTemplate.opsForList().rightPush(redisKey, value);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 新增list并设置失效时间
     *
     * @param redisKey redis键，不能为空
     * @param value    值
     * @param time     时间(秒) time>0
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空或time<=0：返回false）
     */
    @Override
    public boolean addList(String redisKey, Object value, long time) {
        if (!StringUtil.isNotNull(redisKey) || time <= 0) {
            return false;
        }

        try {
            phpRedisTemplate.opsForList().rightPush(redisKey, value);
            return setExpire(redisKey, time);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 新增list（追加list）
     *
     * @param redisKey  redis键，不能为空
     * @param valueList 值
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空则返回false）
     */
    @Override
    public boolean addList(String redisKey, List<Object> valueList) {
        if (!StringUtil.isNotNull(redisKey)) {
            return false;
        }

        try {
            phpRedisTemplate.opsForList().rightPushAll(redisKey, valueList);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 新增list并设置失效时间（追加list）
     *
     * @param redisKey  redis键，不能为空
     * @param valueList 值
     * @param time      时间(秒)
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空或time<=0：返回false）
     */
    @Override
    public boolean addList(String redisKey, List<Object> valueList, long time) {
        if (!StringUtil.isNotNull(redisKey) || time <= 0) {
            return false;
        }

        try {
            phpRedisTemplate.opsForList().rightPushAll(redisKey, valueList);
            return setExpire(redisKey, time);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 获取list
     *
     * @param redisKey redis键，不能为空
     * @return 查询成功：返回list，查询失败：返回null（redisKey为空则返回null）
     */
    @Override
    public List<Object> getList(String redisKey) {
        if (!StringUtil.isNotNull(redisKey)) {
            return null;
        }

        try {
            return phpRedisTemplate.opsForList().range(redisKey, 0, getListSize(redisKey));
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return null;
    }

    /**
     * 获取list（通过索引下标）
     *
     * @param redisKey redis键，不能为空
     * @param start    开始位置
     * @param end      结束位置
     * @return 查询成功：返回list，查询失败：返回null（start-end：0到-1代表所有值，redisKey为空则返回null）
     */
    @Override
    public List<Object> getList(String redisKey, long start, long end) {
        if (!StringUtil.isNotNull(redisKey)) {
            return null;
        }

        try {
            return phpRedisTemplate.opsForList().range(redisKey, start, end);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return null;
    }

    /**
     * 获取list中单个值（通过索引下标）
     *
     * @param redisKey redis键，不能为空
     * @param index    索引下标，index>=0时（0：表头，1：第二个元素），index<0时（-1：表尾，-2：倒数第二个元素）
     * @return 查询成功：返回list中单个值，查询失败：返回null（redisKey为空则返回null）
     */
    @Override
    public Object getListIndex(String redisKey, long index) {
        if (!StringUtil.isNotNull(redisKey)) {
            return null;
        }

        try {
            return phpRedisTemplate.opsForList().index(redisKey, index);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return null;
    }

    /**
     * 获取list长度大小
     *
     * @param redisKey redis键，不能为空
     * @return 查询成功：返回list长度大小，查询失败：返回0（redisKey为空则返回0）
     */
    @Override
    public long getListSize(String redisKey) {
        if (!StringUtil.isNotNull(redisKey)) {
            return 0;
        }

        try {
            return phpRedisTemplate.opsForList().size(redisKey);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return 0;
    }

    /**
     * 修改list中的某条数据（通过索引下标）
     *
     * @param redisKey redis键，不能为空
     * @param index    索引下标
     * @param value    新值
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空则返回false）
     */
    @Override
    public boolean updateListIndex(String redisKey, long index, Object value) {
        if (!StringUtil.isNotNull(redisKey)) {
            return false;
        }

        try {
            phpRedisTemplate.opsForList().set(redisKey, index, value);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 保存list开始下标和结束下标之间的元素（包括开始下标和结束下标）
     *
     * @param redisKey redis键
     * @param start    开始下标，大于0
     * @param end      结束下标，大于0
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空则返回false，start或end小于0返回false）
     */
    @Override
    public boolean trimList(String redisKey, long start, long end) {
        if (!StringUtil.isNotNull(redisKey) || start < 0 || end < 0) {
            return false;
        }

        try {
            phpRedisTemplate.opsForList().trim(redisKey, start, end);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 保存list开始下标和结束下标之间的元素（包括开始下标和结束下标）
     *
     * @param redisKey redis键
     * @param start    开始下标，大于0
     * @param end      结束下标，大于0
     * @param time     时间(秒)
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空或time<=0，start或end小于0返回false）
     */
    @Override
    public boolean trimList(String redisKey, long start, long end, long time) {
        if (!StringUtil.isNotNull(redisKey) || start < 0 || end < 0 || time <= 0) {
            return false;
        }

        try {
            phpRedisTemplate.opsForList().trim(redisKey, start, end);
            return setExpire(redisKey, time);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 新增map
     *
     * @param redisKey redis键，不能为空
     * @param map      HashMap<Object, Object>值
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空则返回false）
     */
    @Override
    public boolean addMap(String redisKey, Map<Object, Object> map) {
        if (!StringUtil.isNotNull(redisKey)) {
            return false;
        }

        try {
            phpRedisTemplate.opsForHash().putAll(redisKey, map);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 新增map并设置失效时间
     *
     * @param redisKey redis键，不能为空
     * @param map      HashMap<Object, Object>值
     * @param time     时间(秒) time>0
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空或time<=0：返回false）
     */
    @Override
    public boolean addMap(String redisKey, Map<Object, Object> map, long time) {
        if (!StringUtil.isNotNull(redisKey) || time <= 0) {
            return false;
        }

        try {
            phpRedisTemplate.opsForHash().putAll(redisKey, map);
            return setExpire(redisKey, time);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 新增map值
     *
     * @param redisKey redis键，不能为空
     * @param mapKey   map键
     * @param mapValue map值
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空则返回false）
     */
    @Override
    public boolean addMapValue(String redisKey, Object mapKey, Object mapValue) {
        if (!StringUtil.isNotNull(redisKey)) {
            return false;
        }

        try {
            phpRedisTemplate.opsForHash().put(redisKey, mapKey, mapValue);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 新增map值并设置失效时间
     *
     * @param redisKey redis键，不能为空
     * @param mapKey   map键
     * @param mapValue map值
     * @param time     时间(秒) time>0
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空或time<=0：返回false）
     */
    @Override
    public boolean addMapValue(String redisKey, Object mapKey, Object mapValue, long time) {
        if (!StringUtil.isNotNull(redisKey) || time <= 0) {
            return false;
        }

        try {
            phpRedisTemplate.opsForHash().put(redisKey, mapKey, mapValue);
            return setExpire(redisKey, time);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 获取Map
     *
     * @param redisKey redis键，不能为空
     * @return 操作成功：返回HashMap值，操作失败：返回null（redisKey为空则返回空）
     */
    @Override
    public Map<Object, Object> getMap(String redisKey) {
        if (!StringUtil.isNotNull(redisKey)) {
            return null;
        }

        try {
            return phpRedisTemplate.opsForHash().entries(redisKey);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return null;
    }

    /**
     * 获取Map值
     *
     * @param redisKey redis键，不能为空
     * @param mapKey   map键
     * @return 操作成功：返回HashMap值，操作失败：返回null（redisKey为空则返回空）
     */
    @Override
    public Object getMapValue(String redisKey, Object mapKey) {
        if (!StringUtil.isNotNull(redisKey)) {
            return null;
        }
        return phpRedisTemplate.opsForHash().get(redisKey, mapKey);
    }

    /**
     * 删除Map中的mapValue值
     *
     * @param redisKey redis键，不能为空
     * @param mapKey   map键，不能为空，可以多个map键
     * @return 操作成功：返回true，操作失败：返回false（redisKey为空或mapKey为null：返回false）
     */
    @Override
    public boolean deleteMapValue(String redisKey, Object... mapKey) {
        if (!StringUtil.isNotNull(redisKey) || mapKey == null) {
            return false;
        }

        try {
            phpRedisTemplate.opsForHash().delete(redisKey, mapKey);
            return true;
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    /**
     * 判断Map中是否有该mapKey-mapValue
     *
     * @param redisKey redis键，不能为空
     * @param mapKey   map键，不能为空
     * @return 存在：返回true，不存在：返回false（redisKey为空或mapKey为空：返回false）
     */
    @Override
    public boolean hasKeyForMap(String redisKey, String mapKey) {
        if (!StringUtil.isNotNull(redisKey) || !StringUtil.isNotNull(mapKey)) {
            return false;
        }

        try {
            return phpRedisTemplate.opsForHash().hasKey(redisKey, mapKey);
        } catch (Exception e) {
            LogUtil.printErrorLog(e);
        }
        return false;
    }

    @Override
    public boolean tryLock(String key, String value, Long timeOut) {

        boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(key, value);
        if (flag) {
            stringRedisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
        }

        return flag;
    }

    @Override
    public boolean unLock(String key, String value) {
        //使用Lua脚本：先判断是否是自己设置的锁，再执行删除
        Long result = stringRedisTemplate.execute(redisScript, Arrays.asList(key, value));
        //返回最终结果
        return new Long(1).equals(result);
    }
}
