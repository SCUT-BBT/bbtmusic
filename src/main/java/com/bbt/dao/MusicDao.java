package com.bbt.dao;

import com.bbt.model.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yuan on 7/29/16.
 */
public interface MusicDao {
    List<Music> getAllMusic(@Param("offset")int offset,@Param("size")int size);

    List<Music> selectMusicByName(@Param("musicName") String musicName, @Param("offset") int offset, @Param("size") int size);
}
