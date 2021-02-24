# 02-demo-properties

> 本 demo 演示如何获取配置文件的自定义配置，以及如何多环境下的配置文件信息的获取

## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <artifactId>demo-properties</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>demo-properties</name>
    <description>Demo project for Spring Boot</description>

    <parent>
        <groupId>com.zzx</groupId>
        <artifactId>learn-sprint-boot</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <properties>
        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
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
        <finalName>demo-properties</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>

</project>
```

## ApplicationProperty.java

```java
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
```

## DeveloperProperty.java

```java
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
```

## PropertyController.java

```java
/**
 * <p>
 * 测试Controller
 * </p>
 */
@RestController
public class PropertyController {
    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    @GetMapping("/property")
    public Dict index() {
        return Dict.create().set("applicationProperty", applicationProperty).set("developerProperty", developerProperty);
    }
}
```

## additional-spring-configuration-metadata.json

> 位置： src/main/resources/META-INF/additional-spring-configuration-metadata.json

```json
{
  "properties": [
    {
      "name": "application.name",
      "type": "java.lang.String",
      "description": "Description for application.name."
    },
    {
      "name": "application.version",
      "type": "java.lang.String",
      "description": "Description for application.version."
    },
    {
      "name": "developer.id",
      "type": "java.lang.Long",
      "defaultValue": null,
      "description": "Description for developer.id."
    },
    {
      "name": "developer.name",
      "type": "java.lang.String",
      "defaultValue": "zzx",
      "description": "Description for developer.name."
    },
    {
      "name": "developer.sex",
      "type": "java.lang.String",
      "defaultValue": "男",
      "description": "Description for developer.name."
    }
  ]
}
```

