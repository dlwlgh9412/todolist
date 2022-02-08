package com.jjangchen.todolistbackend.web.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@EnableConfigurationProperties
@PropertySource("classpath:properties/${spring.profiles.active}/oauth-api-parameter.properties")
public class OauthApiParameterProperties {
    @Value("${kakao.secure_resource}")
    private String secureResource;

    @Value("${kakao.property_keys}")
    private String propertyKeys;
}
