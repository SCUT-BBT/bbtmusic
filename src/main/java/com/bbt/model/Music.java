package com.bbt.model;

/**
 * Created by yuan on 7/29/16.
 */
public class Music {
    private Integer id;
    private String musicName;
    private String musicUrl;
    private String picUrl;
    private Artist artist;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getMusicName() {
        return musicName;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public Artist getArtist() {
        return artist;
    }
}
