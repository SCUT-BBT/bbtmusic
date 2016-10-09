package com.bbt.service;

import com.bbt.model.Result;

/**
 * Created by yuan on 7/29/16.
 */
public interface MusicService {
    /**
     * 获取所有音乐
     * @param page
     * @param size
     * @return
     */
    Result getAllMusic(int page,int size);

    /**
     * 根据音乐名字来搜索音乐
     * @param musicName
     * @param page
     * @param size
     * @return
     */
    Result searchMusic(String musicName, int page, int size);
}
