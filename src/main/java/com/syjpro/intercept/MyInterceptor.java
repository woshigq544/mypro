package com.syjpro.intercept;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptor implements WebMvcConfigurer {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    /** 配置需要放过拦截的请求路径，如登录请求，静态资源等 */
    private String[] staticurl = {"/login","/tologin","/assets/**","/loginup","/toregist"};

    /**
     * @auther: gq
     * @param registry
     * @return: void
     * @date: 2019/4/10 17:56
     * 重写addInterceptors方法
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new InterceptorAdaptor()).addPathPatterns("/**").excludePathPatterns(staticurl);//拦截请求

        logger.info("Interceptor Loading。。are you READY???。。。。。。。。。。。。");
    }
}
