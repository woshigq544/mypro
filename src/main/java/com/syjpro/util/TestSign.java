package com.syjpro.util;


import com.syjpro.finalthings.Constance;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Date;

public class TestSign {
    public static boolean signshowvalues(String sign,String signtime)
            throws IOException, ServletException {
            boolean bo = false;
            if( sign == null ){//签名验证
                System.out.println("签名验证失败！！请求被拒绝---------------------------------");
            }else{
                //获取前端发起请求时间(传过来的是总毫秒值)
                Long thetime = Long.parseLong(signtime);
                System.out.println("前端现在时间为 ： "+thetime+"秒");
                //获取后端进行响应的现在毫秒值
                Long tm = new Date().getTime();
                System.out.println("后端现在时间为 ： "+tm+"秒");
                Long timeover = tm-thetime;
                if(timeover > 20000){//设定当响应时间超过20秒，则验证失败（时间戳验证）
                    System.out.println("验证请求过期+++++++++++++++++++++++++++++++++++++++++++++");
                }else{
                    try {
                        System.out.println("正在比对的明文 ="+sign);
                        String pageSign = RSACodeUtil.decoder2PrivateKey(sign, Constance.PRIVATEKEYSTR);//方法私钥解密
                        // 时间戳判断不写了。。。
                        if( !Constance.SIGNVAL.equals(pageSign) ){
                            System.out.println("秘钥比对失败------------------------------------");
                        }
                        System.out.println("签名验证成功++++++++++++++++++++++++++++++++++++++++++");
                        // 签名验证成功!
                        bo = true;
                    } catch (Exception e) {
                        System.out.println("签名解析出错++++++++++++++++++++++++++++++++++++++++++");
                        bo = false;
                    }
                }
            }
            return bo;
    }
}
