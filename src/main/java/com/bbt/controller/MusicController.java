package com.bbt.controller;

import com.bbt.model.Result;
import com.bbt.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public @ResponseBody Result getAllMusic(){
        Result result=musicService.getAllMusic();
        return result;
    }

}
