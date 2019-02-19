package com.wangyuxuan.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/19 13:46
 * @Description:
 */

@Component
public class TimeInterceptor implements HandlerInterceptor {

    /**
     *
     * 功能描述: preHandle方法在处理拦截之前执行
     *
     * @param: [request, response, handler]
     * @return: boolean
     * @auther: wangyuxuan
     * @date: 2019/2/19 13:56
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("处理拦截之前");
        request.setAttribute("startTime", System.currentTimeMillis());
        System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod) handler).getMethod().getName());
        return true;
    }

    /**
     *
     * 功能描述: postHandle只有当被拦截的方法没有抛出异常成功时才会处理
     *
     * @param: [request, response, handler, modelAndView]
     * @return: void
     * @auther: wangyuxuan
     * @date: 2019/2/19 13:57
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("开始处理拦截");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("【拦截器】耗时 " + (System.currentTimeMillis() - start));
    }

    /**
     *
     * 功能描述: afterCompletion方法无论被拦截的方法抛出异常与否都会执行
     *
     * @param: [request, response, handler, ex]
     * @return: void
     * @auther: wangyuxuan
     * @date: 2019/2/19 13:57
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("处理拦截之后");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("【拦截器】耗时 " + (System.currentTimeMillis() - start));
        System.out.println("异常信息 " + ex);
    }
}
