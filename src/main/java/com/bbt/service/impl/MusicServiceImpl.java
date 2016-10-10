package com.bbt.service.impl;

import com.bbt.authorization.model.UserInfo;
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


    public Result searchMusic(String musicName, int page, int size) {
        Result result=new Result();
        musicName="%"+musicName+"%";
        int offset=(page-1)*size;
        List<Music> musics=musicDao.selectMusicByName(musicName,offset,size);
        result.setData(musics);
        result.setCode(200);
        return result;
    }

    public Result getAllFavoriteMusics(UserInfo userInfo, int page, int size) {
        Result result=new Result();
        int userId=userInfo.getUserId();
        int offset=(page-1)*size;
        List<Music> musics=musicDao.selectFavoriteMusicByUserId(userId,offset,size);
        result.setCode(200);
        result.setData(musics);
        return result;
    }

    public Result addFavoriteMusic(UserInfo userInfo, int musicId) {
        Result result=new Result();
        int userId=userInfo.getUserId();
        musicDao.addFavoriteMusic(userId,musicId);
        result.setCode(200);
        return result;
    }
}
