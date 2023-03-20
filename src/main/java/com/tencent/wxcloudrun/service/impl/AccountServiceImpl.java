package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.mapper.AccountMapper;
import com.tencent.wxcloudrun.request.LoginRequest;
import com.tencent.wxcloudrun.request.RegisterRequest;
import com.tencent.wxcloudrun.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 17:53
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Override
    public LoginRequest login(LoginRequest loginRequest) {
        LoginRequest login = accountMapper.login(loginRequest);
        return login;
    }

    @Override
    public boolean register(RegisterRequest registerRequest) {
        boolean b=false;
        if (!ObjectUtils.isEmpty(accountMapper.queryUserByUserName(registerRequest.getUserName()))){
            return false;
        }else {
            b = accountMapper.register(registerRequest);
        }

        return b;
    }
}
