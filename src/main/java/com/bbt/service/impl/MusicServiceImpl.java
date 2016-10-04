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

    public Result getAllMusic(int page,int size) {
        Result result=new Result();
        int offset=(page-1)*size;
        List<Music> musics=musicDao.getAllMusic(offset,size);
        result.setData(musics);
        result.setCode(200);
        return result;
    }
}
