package com.ljb.sbdemo.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.show}")
    private boolean swaggerShow;


    static List<Parameter> webParameters = new ArrayList<Parameter>();

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SbDemo API")
                .description("SbDemo API")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("sbDemo", "", ""))
                .build();
    }

    @Bean
    public Docket reportManageApi() {
        return new Docket(DocumentationType.SWAGGER_2).enable(swaggerShow).groupName("sbDemoApi")
                .genericModelSubstitutes(DeferredResult.class)
                // .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false).forCodeGeneration(true).pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ljb.sbdemo.controller"))
                .paths(Predicates.or(PathSelectors.regex("/.*")))// 过滤的接口
                .build().globalOperationParameters(webParameters).apiInfo(apiInfo());
    }


}
