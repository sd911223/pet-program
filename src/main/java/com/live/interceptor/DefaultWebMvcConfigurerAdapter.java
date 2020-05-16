package com.live.interceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Spring MVC 的辅助配置, 用来注册拦截器.
 *
 * @author hugy
 */
@Configuration
public class DefaultWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

//    @Resource
//    private ApplicationContext applicationContext;

    @Bean
    public AppInterceptor getDefaultWebMvcConfigurerAdapter() {
        return new AppInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 访问权限控制
//        AppInterceptor companyAPPInterceptor = applicationContext.getBean(AppInterceptor.class);
        registry.addInterceptor(getDefaultWebMvcConfigurerAdapter())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**");
    }


}
