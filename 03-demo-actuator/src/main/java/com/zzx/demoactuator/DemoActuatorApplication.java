package com.zzx.demoactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动类
 * </p>
 *
 * 例：http://localhost:8090/sys/actuator
 * 例：http://localhost:8090/sys/actuator/health
 */
@SpringBootApplication
public class DemoActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoActuatorApplication.class, args);
    }

}
