package com.xiaomin.xmloginbackground.utils;

import com.xiaomin.xmloginbackground.service.AdminService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: xm-login-background
 * @Date_Time: 2022/10/13 22:26
 */
@Component
public class UserInterceptor implements HandlerInterceptor {
    @Resource
    private AdminService adminService;
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        if (adminService == null) {
            BeanFactory factory= WebApplicationContextUtils
                    .getRequiredWebApplicationContext(request.getServletContext());
            adminService= (AdminService) factory.
                    getBean("adminService");
        }
        if (token != null) {
            String account = JWTUtil.getUserNameByToken(request);
            try {
                boolean result = JWTUtil.verify(token, account, adminService.getPasswordByName(account));
                if (result){
                    return true;
                }
            } catch (Exception e) {
                System.err.println("token无效");
            }

        }
        response.sendRedirect(request.getContextPath()+"/Login");
        return false;
    }
}
