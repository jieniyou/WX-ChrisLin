package com.tencent.wxcloudrun.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.tencent.wxcloudrun.utils.SnowFlow;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 17:01
 */
@Data
@NoArgsConstructor
public class RegisterRequest {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id=SnowFlow.nextId();
    private String userName;
    private String userPassword;
    private String userNickName;
    private String userAvatar;
    private String userEmail;
    private String userPhone;

    public RegisterRequest(String userName, String userPassword, String userNickName,String userAvatar, String userEmail, String userPhone) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userNickName = userNickName;
        this.userAvatar = userAvatar;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }
}
