package online.weiyin.config;

import online.weiyin.interceptor.CORSInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    CORSInterceptor getCorsIntercepter() {
        return new CORSInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        CORS拦截器，对所有路径生效
        registry.addInterceptor(getCorsIntercepter()).addPathPatterns("/**");
    }
}
