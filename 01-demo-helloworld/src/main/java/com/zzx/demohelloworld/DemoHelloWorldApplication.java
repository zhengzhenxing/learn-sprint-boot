package com.zzx.demohelloworld;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * SpringBoot启动类
 * </p>
 */
@SpringBootApplication
@RestController
public class DemoHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHelloWorldApplication.class, args);
    }

    /**
     * Hello，World
     * 例：GET http://localhost:8080/demo/hello
     * 例：GET http://localhost:8080/demo/hello?who=zzx
     *
     * @param who 参数，非必须
     * @return Hello, ${who}
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {
        if (StrUtil.isBlank(who)) {
            who = "World";
        }
        return StrUtil.format("Hello, {}!", who);
    }

}
