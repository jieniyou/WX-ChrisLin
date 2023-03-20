package com.tencent.wxcloudrun.mapper;

import com.tencent.wxcloudrun.request.LoginRequest;
import com.tencent.wxcloudrun.request.RegisterRequest;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 17:28
 */
public interface AccountMapper {
    LoginRequest login(LoginRequest loginRequest);
    boolean register(RegisterRequest registerRequest);

    LoginRequest queryUserByUserName(String userName);
}
