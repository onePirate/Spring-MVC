package com.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.blog.bean.EncryptBean;
import com.blog.bean.LoginInfoBean;
import com.blog.model.Keys;
import com.blog.service.RedisService;
import com.blog.util.*;
import com.blog.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author 作者 : gaodawei
 * @version 1.0
 * @function
 * @Email 邮箱 : 695390275@qq.com
 * @date 创建时间：2017年12月22日 上午1:23:45
 */
@RestController
@RequestMapping("system")
public class SystemController {

    private static Logger log = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private RedisService<Keys> redisService;

    @RequestMapping("login")
    public Result<?> entrance(@CookieValue String deviceId, @RequestBody EncryptBean encryptBean) throws Exception {
        log.info("*****login");
        String enMsg = encryptBean.getMsg();
        Keys key = (Keys) redisService.getRedisObj(deviceId);
        log.info("\n*****解密前的数据：{}",enMsg);
        String deMsg = DESEncrype.decryptDES(enMsg, key.getDesKey());
        log.info("\n*****解密后的数据：{}",deMsg);
        LoginInfoBean loginInfoBean = JSONObject.parseObject(deMsg,LoginInfoBean.class);
        String token = TokenUtil.generateToken(loginInfoBean.getAccount());
        return ResultUtil.success(token);
    }

    /**
     * 获取公钥
     *
     * @param deviceId
     * @return
     * @throws IOException
     */
    @RequestMapping("getPubKey")
    public Result<?> getPubKey(@CookieValue String deviceId) throws IOException {
        KeyPair keyPair = RSAHelper.generateRSAKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        String pubKeyStr = StringsUtil.bytesToString(BlogBase64.encode(RSAHelper.encodePublicKeyToXml(publicKey).getBytes()));
        String priKeyStr = StringsUtil.bytesToString(BlogBase64.encode(RSAHelper.encodePrivateKeyToXml(privateKey).getBytes()));
        /**先去取出，判断DESKey为不为null，不为null则将不为null的值取出重新保存*/
        Keys key = (Keys) redisService.getRedisObj(deviceId);
        if (key == null) {
            key = new Keys();
        }
        key.setPrivateKey(priKeyStr);
        log.info("根据DeviceID将用户公钥存入redis -> DeviceId:{}", deviceId);
        redisService.saveRedisObj(deviceId, key, -1);
        return ResultUtil.success(pubKeyStr);
    }

    /**
     * 保存公钥
     *
     * @param deviceId
     * @param paramJson
     * @return
     * @throws IOException
     */
    @RequestMapping("postDesKey")
    public Result<?> postDesKey(@CookieValue String deviceId, @RequestBody JSONObject paramJson) throws IOException {
        Keys key = (Keys) redisService.getRedisObj(deviceId);
        PrivateKey priKey = RSAHelper.decodePrivateKeyFromXml(StringsUtil.bytesToString(BlogBase64.decode(key.getPrivateKey().getBytes())));
        byte[] bt2 = RSAHelper.decryptData(BlogBase64.decode(paramJson.getString("key").toString().getBytes()), priKey);
        String desKey = StringsUtil.bytesToString(bt2);
        synchronized (redisService) {
            key.setDesKey(desKey);
            redisService.saveRedisObj(deviceId, key, -1);
        }
        return ResultUtil.success();
    }

    @RequestMapping("success")
    public Result<?> success() throws IOException {
        log.info("*****success:");
        return ResultUtil.success();
    }

    @RequestMapping("error")
    public Result<?> error() throws IOException {
        log.info("*****error:");
        return ResultUtil.success();
    }

}
