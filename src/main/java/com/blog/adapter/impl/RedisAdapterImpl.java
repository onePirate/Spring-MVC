package com.blog.adapter.impl;

import com.blog.adapter.RedisAdapter;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @function:
 * @Author: gaodawei
 * @Date: 2018/1/16 16:13
 */
@Service("redisAdapter")
public class RedisAdapterImpl implements RedisAdapter{

    private Jedis jedis = new Jedis("localhost");

    /**
     * 获得值
     * @param key
     * @return
     */
    public byte[] getRedisObj(byte[] key){
        return jedis.get(key);
    }

    /**
     * 保存值
     * @param key
     * @param val
     * @param timeout
     * @return
     */
    public boolean saveRedisObj(byte[] key,byte[] val,Integer timeout){
        String res="";
        if(timeout==-1){
            res=jedis.set(key,val);
        }else{
            res=jedis.setex(key,timeout,val);
        }
        return "OK".equalsIgnoreCase(res);
    }

    /**
     * 删除值
     * @param key
     * @return
     */
    public void removeObj(byte[] key){
        saveRedisObj(key,"".getBytes(),0);
    }
}
