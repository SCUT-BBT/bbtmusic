package com.bbt.service.impl;

import com.bbt.dao.CommentDao;
import com.bbt.model.Comment;
import com.bbt.model.Message;
import com.bbt.model.Result;
import com.bbt.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuan on 10/9/16.
 */
@Service
public class CommentServiceImpl implements CommentService{

    @Resource
    CommentDao commentDao;

    public Result getAllComments() {
        Result result=new Result();
        List<Comment> comments=commentDao.selectComment();
        result.setCode(200);
        result.setData(comments);
        return result;
    }

    public Result getMessageByCommentId(int commentId) {
        Result result=new Result();
        List<Message> messages=commentDao.selectMessagesByCommentId(commentId);
        result.setData(messages);
        result.setCode(200);
        return result;
    }
}
