package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.config.Result;
import com.tencent.wxcloudrun.service.PlayListService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/23 21:49
 */
@RequestMapping("music")
@RestController
public class PlayListController {
    @Resource
    private PlayListService playListService;
    @GetMapping("queryPlayList")
    public Result queryPlayListByUserId(){
        JSONObject playList = playListService.queryPlayListByUserId(0, 10, "7922337058");
        if (ObjectUtils.isEmpty(playList)||playList==null||"".equals(playList)){
            return Result.fail("获取歌单失败",null);
        }
        return Result.success(playList);
    }
}
