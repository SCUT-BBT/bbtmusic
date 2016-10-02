package com.bbt.service.impl;

import com.bbt.dao.MusicDao;
import com.bbt.model.Music;
import com.bbt.model.Result;
import com.bbt.service.MusicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuan on 7/29/16.
 */
@Service
public class MusicServiceImpl implements MusicService{

    @Resource
    MusicDao musicDao;

    public Result getAllMusic() {
        Result result=new Result();
        List<Music> musics=musicDao.getAllMusic();
        result.setData(musics);
        result.setStatusOk();
        return result;
    }
}
