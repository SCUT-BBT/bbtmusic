package com.bbt.authorization.resolver;

import com.bbt.authorization.annnotation.CurrentUser;
import com.bbt.authorization.config.AuthorizationConstant;
import com.bbt.authorization.model.UserInfo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by yuan on 10/4/16.
 */
public class UserInfoMethodArgumentResolver implements HandlerMethodArgumentResolver{
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(CurrentUser.class)&&methodParameter.getParameterType().isAssignableFrom(UserInfo.class);
    }

    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        UserInfo userInfo= (UserInfo) nativeWebRequest.getAttribute(AuthorizationConstant.USERINFO, RequestAttributes.SCOPE_REQUEST);
        return userInfo;
    }
}
