package online.weiyin.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import online.weiyin.interceptor.CORSInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName WebMvcConfig
 * @Description web配置类
 * @Version 1.0.0
 * @Time 2023/10/14 下午 06:17
 * @Author 卢子昂
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //    装配拦截器bean
    @Bean
    CORSInterceptor getCorsInterceptor() {
        return new CORSInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        CORS拦截器，对所有路径生效
        registry.addInterceptor(getCorsInterceptor()).addPathPatterns("/**");
//        ST-token拦截器，注解鉴权、路由拦截
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }
}
