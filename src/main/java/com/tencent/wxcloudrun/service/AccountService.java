package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.request.LoginRequest;
import com.tencent.wxcloudrun.request.RegisterRequest;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 17:53
 */

public interface AccountService {
    LoginRequest login(LoginRequest loginRequest);
    boolean register(RegisterRequest registerRequest);
}
