package com.tencent.wxcloudrun.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.tencent.wxcloudrun.entity.PlayList;
import com.tencent.wxcloudrun.mapper.PlayListMapper;
import com.tencent.wxcloudrun.service.PlayListService;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/23 21:19
 */
@Service
public class PlayListServiceImpl implements PlayListService {
    @Resource
    private PlayListMapper playListMapper;
    private PlayList playList;

    HttpClient client= HttpClients.createDefault();
    JSONObject jsonObject=null;
    HttpGet get;
    HttpResponse res;
    @Override
    public JSONObject queryPlayListByUserId(int offset, int limit, String uid) {
        String url = "http://music.163.com/api/user/playlist?offset="+offset+"&limit="+limit+"&uid="+uid;
        get=new HttpGet(url);
        try {
            res=client.execute(get);
            if (res.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                String result= EntityUtils.toString(res.getEntity());
                jsonObject=JSONObject.parseObject(result);

                try {
                    saveQueryPlayList(jsonObject);
                } catch (Exception e) {
                    System.err.println("存入数据库失败");
                }

            }
        } catch (IOException e) {
            System.err.println("获取歌单失败");
        }
        return jsonObject;

    }
    private void saveQueryPlayList(JSONObject jsonObject){
        JSONArray playlists = jsonObject.getJSONArray("playlist");
        for (Object playlist : playlists) {
            HashMap map=JSON.parseObject(playlist.toString(), HashMap.class);
            Long id = (Long) map.get("id");
            Long userId = (Long) map.get("userId");
            String coverImgUrl = (String) map.get("coverImgUrl");
            String name = (String) map.get("name");
            String description = (String) map.get("description");
            playList=new PlayList(id,userId,coverImgUrl,name,description);
            playListMapper.saveQueryPlayList(playList);
        }
    }
}
