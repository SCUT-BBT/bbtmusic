package com.bbt.authorization.interceptor;

import com.bbt.authorization.annnotation.Authorization;
import com.bbt.authorization.config.AuthorizationConstant;
import com.bbt.authorization.model.Token;
import com.bbt.authorization.model.UserInfo;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by yuan on 10/4/16.
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method=handlerMethod.getMethod();
        Authorization authorization=method.getAnnotation(Authorization.class);
        if(authorization==null)
            return true;
        String tokenStr=request.getHeader(AuthorizationConstant.TOKEN);
        Token token=new Token(tokenStr);
        if(checkToken(token)){
            UserInfo userInfo=token.getUserInfo();
            request.setAttribute(AuthorizationConstant.USERINFO,userInfo);
            return true;
        }
        return false;
    }

    private boolean checkToken(Token token) {
        UserInfo userInfo=token.getUserInfo();
        if(userInfo==null)
            return false;
        return true;
    }

}
