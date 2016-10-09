package com.bbt.controller;

import com.bbt.model.Result;
import com.bbt.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by yuan on 10/9/16.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Resource
    CommentService commentService;

    @RequestMapping("/all")
    @ResponseBody
    public Result getAllComments(){
        Result result=commentService.getAllComments();
        return result;
    }

    @RequestMapping(value = "/{commentId}/message",method = RequestMethod.GET)
    @ResponseBody
    public Result getMessage(@PathVariable(value = "commentId")int commentId){
        Result result=commentService.getMessageByCommentId(commentId);
        return result;
    }

}
