package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.Result;
import com.tencent.wxcloudrun.request.LoginRequest;
import com.tencent.wxcloudrun.request.RegisterRequest;
import com.tencent.wxcloudrun.service.AccountService;
import com.tencent.wxcloudrun.utils.JwtUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 17:58
 */
@RequestMapping("user")
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping("login")
    public Result login(@RequestBody LoginRequest loginRequest){
        LoginRequest login= accountService.login(loginRequest);
        if (!ObjectUtils.isEmpty(login)){
            String token = JwtUtil.sign(login.getUserName());
            return Result.success("登陆成功",token);
        }else {
            return Result.fail("账号或密码错误",null);
        }

    }
    @PostMapping("register")
    public Result register(@RequestBody RegisterRequest registerRequest){
        System.out.println(registerRequest);
        boolean register = accountService.register(registerRequest);
        if (register){
            return Result.success("注册成功",null);
        }else {
            return Result.fail("用户已存在",null);
        }
    }
}
