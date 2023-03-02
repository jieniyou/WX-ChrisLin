package com.tencent.wxcloudrun.config;

import lombok.Data;

import java.util.HashMap;

@Data
public final class ApiResponse {

  private Integer code;
  private String message;
  private Object data;

  private ApiResponse(int code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }
  
  public static ApiResponse ok() {
    return new ApiResponse(200, "操作成功", new HashMap<>());
  }

  public static ApiResponse ok(Object data) {
    return new ApiResponse(200, "", data);
  }

  public static ApiResponse ok(String message,Object data) {
    return new ApiResponse(200, message, data);
  }


  public static ApiResponse error() {
    return new ApiResponse(404, "操作失败", new HashMap<>());
  }
  public static ApiResponse error(String message) {
    return new ApiResponse(404, message, new HashMap<>());
  }
}
