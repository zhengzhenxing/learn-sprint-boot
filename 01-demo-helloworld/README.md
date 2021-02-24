# 01-demo-helloworld

## Runing spring boot demo helloworld

```sh
 $ mvn spring-boot:run
```
##
> 本 demo 演示如何使用 Spring Boot 写一个hello world

### pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <artifactId>demo-helloworld</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>demo-helloworld</name>

    <parent>
        <groupId>com.zzx</groupId>
        <artifactId>learn-sprint-boot</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>1.8</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
        </dependency>
    </dependencies>

    <build>
        <finalName>demo-helloworld</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

### 01-demo-helloworld

```java
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
```

### application.properties

```properties
server.port=8080
server.servlet.context-path=/demo
```

