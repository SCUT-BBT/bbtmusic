package com.bbt.controller;

import com.bbt.authorization.model.UserInfo;
import com.bbt.authorization.annnotation.Authorization;
import com.bbt.authorization.annnotation.CurrentUser;
import com.bbt.model.Result;
import com.bbt.model.User;
import com.bbt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yuan on 10/2/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    /**
     * 注册新用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user){
        return userService.register(user);
    }

    /**
     * 用户登陆
     * @param user
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    @RequestMapping(value="/info",method = RequestMethod.GET)
    @ResponseBody
    @Authorization
    public Result info(HttpServletRequest request, @CurrentUser UserInfo userInfo){
//        UserInfo userInfo= (UserInfo) request.getAttribute(AuthorizationConstant.USERINFO);
        return new Result();
    }
}
