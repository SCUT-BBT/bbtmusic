package com.bbt.model;

/**
 * Created by yuan on 10/9/16.
 */
public class Comment {
    private User user;
    private Music music;
    private int id;
    private String content;
    private String date;

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {

        return content;
    }

    public String getDate() {
        return date;
    }

    public Music getMusic() {
        return music;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
