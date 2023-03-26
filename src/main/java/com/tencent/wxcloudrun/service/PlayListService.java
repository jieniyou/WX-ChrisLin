package com.tencent.wxcloudrun.service;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.entity.PlayList;

import java.util.List;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/23 21:18
 */
public interface PlayListService {
    JSONObject queryPlayListByUserId(int offset, int limit, Long userId);
    List<PlayList> queryPlayList();
}
