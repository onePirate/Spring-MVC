package com.blog.controller;

import com.blog.util.*;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @function:
 * @Author: gaodawei
 * @Date: 2018/1/17 13:04
 */
public class SystemControllerTest {
    /**
     * 将DESKey用公钥加密
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void clientencryptKeyTest() throws UnsupportedEncodingException {
        String msg = "00000000";
        System.out.println("加密前的数据：" + msg);
        String publicKeyStr = "PFJTQUtleVZhbHVlPjxNb2R1bHVzPkFQc1VlSFFTWTUzSVRTVU1FbTREYytiZU9SV25zYmR4WDZhclh6dEEvSkRmWHJxMCtQTi9la2pVNVBEaVJkYXIvNWVzZVBRSjIzc1J3QXdyeUpHMlVDeGpQbExSWkRMNTFZYUVLTy9oL3VYaytkUmxTZk8wTWdsVkNCRVFCVzNTeWFYVExsOWdVYW5EWXJHd1MrcXBid053T2lhR1JBTlBoNk56WEJhaFZKeTU8L01vZHVsdXM+PEV4cG9uZW50PkFRQUI8L0V4cG9uZW50PjwvUlNBS2V5VmFsdWU+";
        PublicKey publicKey = RSAHelper.decodePublicKeyFromXml(StringsUtil.bytesToString(BlogBase64.decode(publicKeyStr.getBytes())).replace(" ", "+"));
        String message = URLEncoder.encode(StringsUtil.bytesToString(BlogBase64.encode(RSAHelper.encryptData(msg.getBytes(), publicKey))), "utf-8");
        System.out.println("加密后的数据：" + URLDecoder.decode(message));
    }
    
    public static void main(String[] args) {
    	String priKeyStr="PFJTQUtleVZhbHVlPjxNb2R1bHVzPkFNRXY3WHN5RFZZRy9OUmlXWEE4SUpVVU0wcUlLelhhc1A2R2lvQ0Z0TnlPSlZSMVRLL1VScy9QZ0RuTXAwVzU3MXQwVDJET0RnMDk5dmt6OWZibUxhcHdlU0M2OHJQams1anpaOUhXTDNTdFJoMlZkYlkrOEJhS055Z3JaNFlWOXh3TU82T28xbWNHS3R0MmdNY1ZzQVFCcGNCUjFpQlhNOFlienExUXp4ZDM8L01vZHVsdXM+PEV4cG9uZW50PkFRQUI8L0V4cG9uZW50PjxEPkFMZ3R5bHBtaUtKWXZSaDZ2MHdxZHVIS1JYQXNUQTNtOWxGaTBZN2dhbUxQdmpVOE02VjZXeHhxZHBRa1VlRSsrRDBYc1VuWWlUc0V0WDQybEt3VUhMbTBmOHFBUVFZcHlqZzFJZXNDRGVNeExFb1ZoU3J4Snl1cHdBd3o1UEFPaHJob3RoVXpaNTZsYm95THpNdU02NCtWQmNmWHZQSjc3ODcrMURWNXZrRjU8L0Q+PFA+QVBhSHpGd2owM0R4eklZQWhzeXRad0lMTW9heEdRZVB5VjMrV28zOFAzb1I5SUxJY1d3VWJKWUx0emovWUhTSHVNYS9GSUNoTU9uN0NVT3cxb2JwQS8wPTwvUD48UT5BTWlibHpJOGNwc0JOUDd0enlnemJ6ZEJjYTExR05ReW9tSXI1NzVJVUhEQmt3QjE3ZkZFUjFiR2VTRXhMZk1MWTh5Qzl4b2JGOUJNem1jQzRjbzdVWU09PC9RPjxEUD5BSS96NDhTNXRyRnd2N2hQZm1idHFnUnJmV2xnNS9pZVlUcmRWd3NwaS9jL25NTHhRQ21ZRTMvWi8zYnN4K25EaG9XbTlkWFdTYldXdkdZbVVGNGVtaEU9PC9EUD48RFE+QUxsOVZJSjQ3aWR4S0VXSU1vSWpmUFNFcU00UWRoTFBkdUo3WWw3SmtzZVAxWk1aZUJnY1lESldkbTVBZ1JJNE4rRkVQNk45NWJrUEs5S0lFYXJpeW0wPTwvRFE+PEludmVyc2VRPkFKamFkRzlBaVpDTThhOG9TWE5zN0VlY0wzL21rNHhRTHN6N2ZmQ0luenR2eVVpL3F5M24rZUFnb3JHVUlUcDFXZWxwZEpHZEQvL2hkL21FR3hLVlo2WT08L0ludmVyc2VRPjwvUlNBS2V5VmFsdWU+";
    	String needDecryStr="UkQEEfre8lz1ZBH5UVMiONvjh14mtazyVJPu2wHLEm1mDyDmb99TUdZg69ujj5gOl86NLpyJxDHw1yRsAZipHonI+wq0xuTldpFZWojloXvttWptPoYSjon1qxBgrl2ULGWtTOKuvsjssag6QqgiKCNMdRf93h/u4d9FoJ9vMTk=";
    	
    	PrivateKey priKey = RSAHelper.decodePrivateKeyFromXml(StringsUtil.bytesToString(BlogBase64.decode(priKeyStr.getBytes())));
        byte[] bt2 = RSAHelper.decryptData(BlogBase64.decode(needDecryStr.getBytes()), priKey);
        String desKey = StringsUtil.bytesToString(bt2);
        System.out.println("获得postDESKey解密数据为："+desKey);
	}
    
    /**
     * 对密码进行MD5加密
     */
    @Test
    public void encryptPWDTest() {
        String pwd = "123456";
        String enPwd = MD5EncryptUtil.compute(pwd);
        System.out.println("加密后的密码是：" + enPwd);
    }

    /**
     * 对需要加密的数据进行加密
     */
    @Test
    public void encryptMsgTest() throws Exception {
        String msg = "{\"account\":\"daweis\",\"pwd\":\"E10ADC3949BA59ABBE56E057F20F883E\"}";
        String enMsg = DESEncrype.encryptDES(msg, "00000000");
        System.out.println("DES加密的数据为："+enMsg);
    }


}
