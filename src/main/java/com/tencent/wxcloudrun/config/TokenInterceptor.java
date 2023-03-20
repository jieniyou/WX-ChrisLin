package com.tencent.wxcloudrun.config;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 20:43
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        //token通过验证返回为true继续访问
        if (!(ObjectUtils.isEmpty(token))||token!=null){
            boolean result= JwtUtil.verify(token);
            if (result){
                return true;
            }
        }
        //token验证不通过 返回失败提示
        Result result=Result.fail(403,"You do not have permission!",null);
        response.getWriter().write(JSONObject.toJSONString(result));
        return false;
    }
}
