package com.bbt.model;

/**
 * Created by yuan on 10/9/16.
 */
public class Message {
    private int id;
    private String content;
    private User user;
    private int commentId;
    private String date;

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getCommentId() {

        return commentId;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
