package com.tencent.wxcloudrun.mapper;

import com.tencent.wxcloudrun.entity.PlayList;

import java.util.List;
import java.util.Map;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/24 13:12
 */
public interface PlayListMapper {
    boolean saveQueryPlayList(PlayList playList);
    List<PlayList> queryPlayList();
    Long queryNetEaseIdByUserId(Long userId);
}
