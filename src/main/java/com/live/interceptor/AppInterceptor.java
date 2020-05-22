package com.live.interceptor;

import com.alibaba.fastjson.JSON;
import com.live.common.ResultEnum;
import com.live.common.ResultUtil;
import com.live.util.PHPSerializerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户拦截器
 *
 * @author shitou
 */
@Component
public class AppInterceptor implements HandlerInterceptor {

    @Value("${redis.prefix}")
    private String prefix;

    @Value("${redis.token}")
    private String redisToken;

    @Autowired
    private StringRedisTemplate redisTemplate;

//    private static final List<String> noLoginResources = new ArrayList<String>() {
//        private static final long serialVersionUID = 1L;
//
//        {
//            add("/user/findPassword");
//            add("/user/login");
//            add("/error");
//            add("/sendCode/sendPhoneCode");
//            add("/app/company/versions");
//            add("/open/validateCompany");
//            add("/user/forget");
//            add("/company/account/income/add");
//            add("/company/byCompanyId");
//            add("/company/companyNotice");
//            add("/company/identity/queryUserIdentity");
//            add("/company/identity/getCompanyLegalPerson");
//            add("/open/queryCompanyByUrl");
//            add("/open/querySubCompanyList");
//            add("/user/checkoutPassword");
//            add("/user/checkoutPhone");
//            add("/user/getPhone");
//            add("/user/resetPassword");
//            add("/user/validatePhoneForforget");
//            add("/user/listUserByPhone");
//            add("/swagger");
//        }
//    };


    /**
     * 在请求到达运行的方法之前，用于拦截非法请求
     * 在controlller之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controlller) throws Exception {
        // 不需要进行访问控制的资源过滤

//        String uri = request.getRequestURI();
//        for (String resource : noLoginResources) {
//            if (uri.startsWith(resource)) {
//                return true;
//            }
//        }
        String token = request.getHeader("Authorization");
        //如果不是映射到方法直接通过
        if (!(controlller instanceof HandlerMethod)) {
            return true;
        }
        if (token == null || token.equals("")) {
            response.getWriter().write(JSON.toJSONString(ResultUtil.error(ResultEnum.LOGIN_IS_OVERDUE.getStatus(), ResultEnum.LOGIN_IS_OVERDUE.getMsg())));
            return false;
        }
        String redisTokenStr = redisTemplate.opsForValue().get(prefix + redisToken + token + ":");
        if (StringUtils.isEmpty(redisTokenStr)) {
            response.getWriter().write(JSON.toJSONString(ResultUtil.error(ResultEnum.LOGIN_IS_OVERDUE.getStatus(), ResultEnum.LOGIN_IS_OVERDUE.getMsg())));
            return false;
        }
//        LiveUser user = PHPSerializerHelper.convertJavaBean(redisTokenStr, LiveUser.class);
//        if (null == user) {
//            response.getWriter().write(JSON.toJSONString(ResultUtil.error(ResultEnum.LOGIN_IS_OVERDUE.getStatus(), ResultEnum.LOGIN_IS_OVERDUE.getMsg())));
//            return false;
//        }
        return true;

    }


    /**
     * 用于重定向方法，这个方法可以重新返回一个新的页面，进行新的数据展示
     * 在controller之后
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 所有程序完成之后最终会执行的方法，一般用于销毁对象IO等操作
     * 在postHandle之后
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

}
