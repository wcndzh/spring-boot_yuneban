package com.ning.server.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能: Swagger的配置类
 *
 * @Program: yeb
 * @Author WCN
 * @description 注解信息：@EnableSwagger2 使swagger2生效 @ComponentScan(basePackages =
 * {"com.steven.demo.controller"}) 需要扫描的controller包路径 @Configurable 配置注解，自动在本类上下文加载一些环境变量信息
 */
@EnableOpenApi     //swagger3
@EnableWebMvc     //不写这个SpringBoot必报错 防止SpringBoot用自己的缺省配置
@Configuration
//@ComponentScan(basePackages = {"com.ning.server.controller"})
//@EnableSwagger2  //这个是swagger2的开启注解，3不用了

//public class Swagger2Config implements WebMvcConfigurer
public class Swagger2Config {

    //配置swagger2要扫面的接口包
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ning.server.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("云E办接口文档")
                .description("云E办接口文档")
                .contact(new Contact("王昌宁", "http:localhost:8081/doc.html", "1499584131@qq.com"))
                .version("1.0")
                .build();
    }

    /**
     * 设置授权信息
     */
    private List<SecurityScheme> securitySchemes() {
        //设置请求头
        List<ApiKey> result = new ArrayList<>();
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "Header");
        result.add(apiKey);
        return Collections.singletonList(apiKey);
    }

    private List<SecurityContext> securityContexts() {
        //设置需要登录认证的路劲
        List<SecurityContext> result = new ArrayList<>();
        result.add(getContextByPath("/*"));
        return result;
    }

    //swagger全局拦截配置
    private SecurityContext getContextByPath(String pathRegex) {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    //返回默认授权
    private List<SecurityReference> defaultAuth() {
        ArrayList<SecurityReference> result = new ArrayList<>();
        //  授权范围(所有的接口)
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEveryThing");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization", authorizationScopes));
        return result;

    }
}
