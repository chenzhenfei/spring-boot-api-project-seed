package com.company.project.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenzhenfei
 * @title: SwaggerConfig
 * @projectName spring-boot-api-project-seed
 * @description: Swagger2 配置类
 * @date 2020/3/3022:39
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final static String SWAGGER_SCAN_BASE_PACKAGE ="com.company.project";
    @Bean
    public Docket createRestApi(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("SpringBoot with Swagger Documentation")
                .description("for the Application")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact(new Contact("chenzhenfei", "com.xx.xxx", "916927902@qq.com"))
                .version("1.0")
                .build();
    }


}
