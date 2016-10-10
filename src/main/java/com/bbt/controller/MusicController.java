package com.bbt.controller;

import com.bbt.authorization.annnotation.Authorization;
import com.bbt.authorization.annnotation.CurrentUser;
import com.bbt.authorization.model.UserInfo;
import com.bbt.model.Result;
import com.bbt.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yuan on 7/29/16.
 */
@Controller
@RequestMapping("/music")
public class MusicController {

    @Resource
    MusicService musicService;

    @RequestMapping("/all")
    public @ResponseBody Result getAllMusic(@RequestParam("page") int page,@RequestParam("size") int size){
        Result result=musicService.getAllMusic(page,size);
        return result;
    }

    @RequestMapping(value = "/queries",method = RequestMethod.GET)
    public @ResponseBody Result searchMusic(@RequestParam("musicName") String musicName, @RequestParam("page") int page, @RequestParam("size") int size){
        Result result=musicService.searchMusic(musicName,page,size);
        return result;
    }

    @RequestMapping(value = "/favorites/all",method = RequestMethod.GET)
    @Authorization
    public @ResponseBody Result getAllFavoriteMusics(@CurrentUser UserInfo userInfo,@RequestParam("page")int page,@RequestParam("size")int size){
        Result result=musicService.getAllFavoriteMusics(userInfo,page,size);
        return result;
    }

    @RequestMapping(value = "/favorites/add",method = RequestMethod.POST)
    @Authorization
    public @ResponseBody Result addFavoriteMusic(@CurrentUser UserInfo userInfo,@RequestParam("musicId")int musicId){
        Result result=musicService.addFavoriteMusic(userInfo,musicId);
        return result;
    }

}
