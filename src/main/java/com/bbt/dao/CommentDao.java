package com.bbt.dao;

import com.bbt.model.Comment;
import com.bbt.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yuan on 10/9/16.
 */
public interface CommentDao {
    /**
     * 获取所有评论
     * @return
     */
    List<Comment> selectComment();

    List<Message> selectMessagesByCommentId(@Param("commentId") int commentId);
}
