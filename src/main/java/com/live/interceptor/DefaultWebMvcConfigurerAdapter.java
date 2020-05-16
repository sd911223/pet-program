package com.live.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring MVC 的辅助配置, 用来注册拦截器.
 *
 * @author shitou
 */
@Configuration
public class DefaultWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {


    @Bean
    public AppInterceptor getDefaultWebMvcConfigurerAdapter() {
        return new AppInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 访问权限控制
        registry.addInterceptor(getDefaultWebMvcConfigurerAdapter())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**");
    }


}
