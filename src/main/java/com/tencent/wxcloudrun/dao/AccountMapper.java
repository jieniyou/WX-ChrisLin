package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.LoginRequest;
import com.tencent.wxcloudrun.dto.RegisterRequest;
import com.tencent.wxcloudrun.model.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-springboot-demo01
 * @Date_Time: 2023/3/2 15:57
 */
@Mapper
public interface AccountMapper {
    Account login(LoginRequest login);
    boolean register(RegisterRequest register);
}
