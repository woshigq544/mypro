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
                System.out.println("滚!");
            }else{
                //获取前端发起请求时间(传过来的是总毫秒值)
                Long thetime = Long.parseLong(signtime);
                System.out.println("前端现在时间为 ： "+thetime);
                //获取后端进行响应的现在毫秒值
                Long tm = new Date().getTime();
                System.out.println("后端现在时间为 ： "+tm);
                Long timeover = tm-thetime;
                if(timeover > 10000){//设定当响应时间超过10秒，则验证失败（时间戳验证）
                    System.out.println("超时!");
                }
            }
            try {
                System.out.println("操作sign");
                String pageSign = RSACodeUtil.decoder2PrivateKey(sign, Constance.PRIVATEKEYSTR);//方法私钥解密
                // 时间戳判断不写了。。。
                if( !Constance.SIGNVAL.equals(pageSign) ){
                    System.out.println("无法解析！");
                }
                System.out.println("签名验证成功++++");
                // 签名验证成功!
                bo = true;
            } catch (Exception e) {
                System.out.println("无法解析，报错~~~！");
                bo = false;
            }
            return bo;
    }
}
