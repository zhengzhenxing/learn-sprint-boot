package com.zzx.demoproperties.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 项目配置
 * </p>
 */
@Data
@Component
@PropertySource(value = {"classpath:application-${spring.profiles.active}.properties"}, encoding = "utf-8")
public class ApplicationProperty {
    @Value("${application.name}")
    private String name;

    @Value("${application.version}")
    private String version;
}
