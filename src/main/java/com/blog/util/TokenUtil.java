package com.blog.util;

import com.alibaba.fastjson.JSONObject;
import com.blog.enums.StateEnum;
import com.blog.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;
/**
 * @function
 * @author 作者 : gaodawei
 * @Email 邮箱 : 695390275@qq.com
 * @date 创建时间：2017年12月27日 下午4:41:09
 * @version 1.0
 */


/**
 * token的工具类
 *
 * @author caotao
 */
@Component
public class TokenUtil {

    private static Logger logger = LoggerFactory.getLogger(TokenUtil.class);

    private static Integer TOKENLENGTH = 600;// token过期时间间隔 单位：秒
    private static Boolean IGNORE_TOKEN_VOLIDATION = false;

    private static RedisService<JSONObject> redisService;

    public void setRedisService(RedisService<JSONObject> redisService) {
        TokenUtil.redisService = redisService;
    }

    public static void setTOKENLENGTH(Integer TOKENLENGTH) {
        TokenUtil.TOKENLENGTH = TOKENLENGTH;
    }

    public static void setIgnoreTokenVolidation(Boolean ignoreTokenVolidation) {
        IGNORE_TOKEN_VOLIDATION = ignoreTokenVolidation;
    }

    /**
     * 生成一个token
     */
    public static String generateToken(String key) {
        String token = UUID.randomUUID().toString();
        JSONObject tokenJson = new JSONObject();
        tokenJson.put("Token", token);
        tokenJson.put("currentTime", System.currentTimeMillis());
        synchronized (redisService) {
            redisService.saveRedisObj(key, tokenJson, TOKENLENGTH);
        }
        return token;
    }
    /**
     * 验证Token是否过期
     *
     * @param tokenData
     * @param key
     * @return
     */
    public static StateEnum volidateToken(String key, String tokenData) {
        if (IGNORE_TOKEN_VOLIDATION) {
            logger.info("【忽略验证Token是否过期】");
            return StateEnum.STATE_200;
        }
        JSONObject tokenJson = (JSONObject) redisService.getRedisObj(key);
        if(tokenJson == null){
            return StateEnum.STATE_201;
        }
        if (tokenJson.get("Token").equals(tokenData)) {
            long tokenTime = tokenJson.getLongValue("currentTime");
            long tokenLength = System.currentTimeMillis()/1000 - tokenTime;
            //判断是否已过期
            if (tokenLength >= TOKENLENGTH) {
                redisService.removeObj(key);
                return StateEnum.STATE_201;
            }
            //更新用户的最近一次操作时间
            tokenJson.put("currentTime", System.currentTimeMillis());
            redisService.saveRedisObj(key, tokenJson, TOKENLENGTH);
            return StateEnum.STATE_200;
        }
        //被迫下线
        else if (!tokenJson.get("Token").equals(tokenData)) {
            return StateEnum.STATE_202;
        }
        //已过期
        else {
            return StateEnum.STATE_201;
        }
    }
}
