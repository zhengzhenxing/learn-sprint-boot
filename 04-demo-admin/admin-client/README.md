# admin-client

> 本 demo 主要演示了普通项目如何集成 Spring Boot Admin，并把自己的运行状态交给 Spring Boot Admin 进行展现。

## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.zzx</groupId>
        <artifactId>demo-admin</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>admin-client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>
    <name>admin-client</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-client</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <finalName>admin-client</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

## application.properties

```properties
server.port=8080
server.servlet.context-path=/demo

# Spring Boot Admin展示的客户端项目名，不设置，会使用自动生成的随机id
spring.application.name=learn-sprint-boot-admin-client
# Spring Boot Admin 服务端地址
spring.boot.admin.client.url=http://localhost:8000/
# 客户端端点信息的安全认证信息
spring.boot.admin.client.instance.metadata.user.name=${spring.security.user.name}
spring.boot.admin.client.instance.metadata.user.password=${spring.security.user.password}

spring.security.user.name=zzx
spring.security.user.password=123456

# 端点健康情况，默认值"never"，设置为"always"可以显示硬盘使用情况和线程情况
management.endpoint.health.show-details=always
# 设置端点暴露的哪些内容，默认["health","info"]，设置"*"代表暴露所有可访问的端点
management.endpoints.web.exposure.include=*
```

