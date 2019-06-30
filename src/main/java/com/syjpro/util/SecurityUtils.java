package com.syjpro.util;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密
 * @author waver
 */
public class SecurityUtils {


    /**
     * @auther: gq
     * @return: java.lang.String
     * @date: 2019/4/25 0025 21:12
     * md5加密的方法
     */
    public static String encodeMD5(String message){
        return DigestUtils.md5Hex(message);
    }

    public static String encodeMD53Times(String message){
        for (int i=0;i<3;i++){
            message = DigestUtils.md5Hex(message);
        }
        return message;
    }


    public static String encodeMD51024(String message){
        for (int i=0;i<1024;i++){
            message = DigestUtils.md5Hex(message);
        }
        return message;
    }

    public static String encodeSha256(String message){
        return DigestUtils.sha256Hex(message);
    }

    public static String encodeSha512(String message){
        return DigestUtils.sha512Hex(message);
    }
}
