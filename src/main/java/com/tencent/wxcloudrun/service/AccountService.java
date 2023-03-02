package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.LoginRequest;
import com.tencent.wxcloudrun.model.Account;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-springboot-demo01
 * @Date_Time: 2023/3/2 15:53
 */
public interface AccountService {
    Account login(LoginRequest login);

}
