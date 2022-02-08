package com.jjangchen.todolistbackend.web.config;

import com.jjangchen.todolistbackend.web.interceptor.AttachInterceptor;
import com.jjangchen.todolistbackend.web.resolver.TodoOauthRequestMethodArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final AttachInterceptor attachInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/docs/**").addResourceLocations("classpath:/static/docs/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(attachInterceptor).addPathPatterns("/todos/*");
    }

/*    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new TodoOauthRequestMethodArgumentResolver());
    }*/
}
