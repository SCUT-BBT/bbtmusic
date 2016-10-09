package com.bbt.service;

import com.bbt.model.Result;

/**
 * Created by yuan on 10/9/16.
 */
public interface CommentService {
    /**
     * 获取所有音乐
     * @return
     */
    Result getAllComments();

    Result getMessageByCommentId(int commentId);
}
