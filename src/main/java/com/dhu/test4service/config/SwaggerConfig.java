package com.dhu.test4service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

//页面是swagger-ui.html，可以在swagger-ui的包里面看到
@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {

    //配置swagger 的 Docket 的bean实例，就这一个
    @Bean
    public Docket docket(){

        //可以在这里设置，如果测试环境开启swagger，如果上线就关闭

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("大龙")
                .apiInfo(apiInfo())
                .select()
                //RequestHandlerSelectors   配置要扫描接口的方式
                //     basePackage：指定要扫描的包，现在就只有controller里的接口，没有默认接口/error了
                //     any()：扫描全部
                //     none()：不扫描
                //     none()：不扫描
                //     withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                //     withMethodAnnotation：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.dhu.test4service.controller"))
                //paths：过滤什么路径，意思是只扫描一定路径下的接口，这样就只有一个/index接口了
                //.paths(PathSelectors.ant("/index/**"))
                .build()
                //这里select().apis().build()是一整套
                ;
    }

    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("第四小组","","1364527147@qq.com");
        return new ApiInfo(
                "test4 API Ducument",
                "如果接口没有指定请求方式。就会导致一个接口有7个\n分别表示不同调用方式",
                "1.0",
                "",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }

}
