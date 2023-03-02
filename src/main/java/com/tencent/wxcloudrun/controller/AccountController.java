package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.LoginRequest;
import com.tencent.wxcloudrun.dto.RegisterRequest;
import com.tencent.wxcloudrun.model.Account;
import com.tencent.wxcloudrun.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-springboot-demo01
 * @Date_Time: 2023/3/2 16:20
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    final AccountService accountService;
    final Logger logger;
    private Account account;

    public AccountController(@Autowired AccountService accountService) {
        this.accountService = accountService;
        this.logger = LoggerFactory.getLogger(AccountController.class);
    }

    /**
     * 登录
     * @param login 登陆参数
     * @return 响应
     */
    @PostMapping("/login")
    ApiResponse login(LoginRequest login){
        System.out.println("当前正在尝试登录的用户:"+login);
        Account account = null;
        try {
            account = accountService.login(login);
            logger.info("/account/login username:{}",account.getAccount());
            return ApiResponse.ok("登陆成功",account.getAccount());
        } catch (Exception e) {
            return ApiResponse.error("登陆失败");
        }

    }

    @PostMapping("/register")
    ApiResponse register(RegisterRequest register){
        System.out.println("当前:"+register.getAccount()+"-->用户正在尝试注册");
        try {
            boolean regStatus = accountService.register(register);
            logger.info("注册状态:regStatus:{}",regStatus);
            return ApiResponse.ok("注册成功",register.getAccount());
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.error("注册失败");
        }

    }
}
