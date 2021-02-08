package com.zzx.demoproperties.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 开发人员配置信息
 * </p>
 */
@Data
@ConfigurationProperties(prefix = "developer")
@PropertySource(value = {"classpath:application-${spring.profiles.active}.properties"}, encoding = "utf-8")
@Component
public class DeveloperProperty {
    private long id;
    private String name;
    private String sex;
}
