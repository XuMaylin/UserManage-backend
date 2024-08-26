package org.example.usermanagebackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //启用Swagger API文档
public class SwaggerConfig {

    /**
     * 返回实例Docket(Swagger API摘要)
     * 在方法中指定扫描的控制器包路径,
     * 只有在此路径下的Controller类才会自动生成Swagger API文档
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.example.usermanagebackend"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户管理")
                .description("用户管理相关接口")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact("XuMeilin")
                .version("1.0")
                .build();
    }
}
