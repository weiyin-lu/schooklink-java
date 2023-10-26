package online.weiyin.interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CORSInterceptor
 * @Description 跨域拦截器
 * @Version 1.0.0
 * @Time 2023/10/14 下午 06:20
 * @Author 卢子昂
 */
public class CORSInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //表示接受任意域名的请求,也可以指定域名
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        //该字段可选，是个布尔值，表示是否可以携带cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT,PATCH, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length,Authorization,Accept");

        // 如果当前请求中包含option请求  放行
        if (HttpMethod.OPTIONS.equals(request.getMethod())){
            return true;
        }
        return true;
    }
}
