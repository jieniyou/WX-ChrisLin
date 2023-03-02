package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.AccountMapper;
import com.tencent.wxcloudrun.dto.LoginRequest;
import com.tencent.wxcloudrun.dto.RegisterRequest;
import com.tencent.wxcloudrun.model.Account;
import com.tencent.wxcloudrun.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-springboot-demo01
 * @Date_Time: 2023/3/2 15:56
 */
@Service
public class AccountServiceImpl implements AccountService {
    final AccountMapper accountMapper;
    public AccountServiceImpl(@Autowired AccountMapper accountMapper){
        this.accountMapper=accountMapper;
    }
    @Override
    public Account login(LoginRequest login) {
        return accountMapper.login(login);
    }

    @Override
    public boolean register(RegisterRequest register) {
        return accountMapper.register(register);
    }
}
