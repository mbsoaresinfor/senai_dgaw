package br.com.mbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	 @Bean
	    public Docket api() { 
	     
	    	Docket docket =  new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("br.com.mbs.controller"))
	        .paths(PathSelectors.any())
	        .build()
	        .useDefaultResponseMessages(false)
	        .apiInfo(apiInfo());
	        
	        
	        return docket;
	    }
	 
	  private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Exemplo de API REST")
	                .description("Este e um projeto exemplo, desenvolvido para ser utilizado "
	                		+ "em minhas aulas de programacao")
	                .version("1.0.0")                
	                .contact(new Contact("Marcelo Soares", "", "mbsoares.infor@gmail.com"))
	                .build();
	    }
}
