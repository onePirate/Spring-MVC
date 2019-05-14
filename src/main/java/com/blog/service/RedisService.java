package com.blog.service;

/**
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月27日 下午7:48:39 
* @version 1.0 
 */
public interface RedisService<T> {

    /**
     * 获得值
     * @param key
     * @return
     */
    public Object getRedisObj(String key);

    /**
     * 保存值
     * @param key
     * @param obj
     * @param timeout -1:永久保存，单位：秒
     * @return
     */
    public boolean saveRedisObj(String key,T obj,Integer timeout);

    /**
     * 删除值
     * @param key
     * @return
     */
    public void removeObj(String key);

}
