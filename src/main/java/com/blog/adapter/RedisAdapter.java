package com.blog.adapter;

/**
 * @function:
 * @Author: gaodawei
 * @Date: 2018/1/16 16:12
 */
public interface RedisAdapter {

    /**
     * 获得值
     * @param key
     * @return
     */
    public byte[] getRedisObj(byte[] key);

    /**
     * 保存值
     * @param key
     * @param val
     * @param timeout -1:永久保存，单位：秒
     * @return
     */
    public boolean saveRedisObj(byte[] key,byte[] val,Integer timeout);

    /**
     * 删除值
     * @param key
     * @return
     */
    public void removeObj(byte[] key);
}
