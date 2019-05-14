package com.blog.service.impl;


import com.blog.adapter.RedisAdapter;
import com.blog.service.RedisService;
import com.blog.util.SerializeUtil;
import com.blog.util.StringsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月27日 下午7:49:18 
* @version 1.0 
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisAdapter redisAdapter;

    @Override
    public Object getRedisObj(String key) {
        byte[] result=redisAdapter.getRedisObj(SerializeUtil.serialize(key));
        return SerializeUtil.unserialize(result);
    }

    @Override
    public boolean saveRedisObj(String key, Object obj, Integer timeout) {
        if(StringsUtil.isEmpty(key) || timeout==null || obj == null){
            return false;
        }
        byte[] bKey = SerializeUtil.serialize(key);
        byte[] bObj = SerializeUtil.serialize(obj);
        boolean flag = redisAdapter.saveRedisObj(bKey,bObj,timeout);
        return flag;
    }

    @Override
    public void removeObj(String key){
        byte[] bKey = SerializeUtil.serialize(key);
        redisAdapter.removeObj(bKey);
    }
}
