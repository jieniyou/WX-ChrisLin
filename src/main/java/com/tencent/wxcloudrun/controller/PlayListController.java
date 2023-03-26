package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.config.Result;
import com.tencent.wxcloudrun.entity.PlayList;
import com.tencent.wxcloudrun.service.PlayListService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @GetMapping("queryPlayListByUserId/{userId}")
    public Result queryPlayListByUserId(@PathVariable Long userId){
        JSONObject playList = playListService.queryPlayListByUserId(0, 10, userId);
        if (ObjectUtils.isEmpty(playList)||playList==null||"".equals(playList)){
            return Result.fail("获取歌单失败",null);
        }
        return Result.success(playList);
    }
    @GetMapping("queryPlayList")
    public Result queryPlayList(){
        List<PlayList> playLists = playListService.queryPlayList();
        if (ObjectUtils.isEmpty(playLists)){
            return Result.fail();
        }else {
            return Result.success(playLists);
        }
    }
}
