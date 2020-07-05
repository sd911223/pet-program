package com.pet.annotation;


import com.pet.exception.BusinessException;
import com.pet.model.PetUser;
import com.pet.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 有@LoginUser注解的方法参数，注入当前登录用户
 */
@Component
@Slf4j
public class LoginUserHandlerMethod implements HandlerMethodArgumentResolver {
    private final String AUTH_TOKEN = "token";

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(PetUser.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public PetUser resolveArgument(MethodParameter methodParameter,
                                   ModelAndViewContainer modelAndViewContainer,
                                   NativeWebRequest nativeWebRequest,
                                   WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String token = request.getHeader(AUTH_TOKEN);
        if (StringUtils.isEmpty(token)) {
            throw new BusinessException(HttpStatus.UNAUTHORIZED.value(),"token失效，请重新登录");
        }
        PetUser user = jwtUtils.getUser(token);
        return user;
    }
}
