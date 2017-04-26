/*
 * Copyright Banco Nacional de Mexico, S.A.
 * Integrante de Grupo Financiero Banamex.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.citibanamex.api.locator.atm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * This is a ATM locator microservice application used to fetch nearby banamex
 * atms and branches
 * 
 * @author AM241297
 *
 */
@SpringBootApplication
@EnableSwagger2
public class CitibanamexApiAtmBranchLocatorApplication {
	private static final Logger log = LoggerFactory.getLogger(CitibanamexApiAtmBranchLocatorApplication.class);
	/**
	 * This is main method to trigger the spring boot application of ATM branch
	 * Locator
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("In main method of CitibanamexApiAtmBranchLocatorApplication...");
		SpringApplication.run(CitibanamexApiAtmBranchLocatorApplication.class, args);
	}

	/**
	 * This method is for swagger documentation
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("ATM Branch Locator").apiInfo(apiInfo()).select()
				.paths(regex("/v1/banamex/atms/nearby.*")).build();
	}

	/**
	 * This method is for swagger documentation
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("ATM Branch Locator Swagger").description("ATM Branch Locator API Documentation")
				.termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open").contact("AM241297")
				.license("Apache License Version 2.0")
				.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE").version("2.0")
				.build();
	}
	/**
	 * To handle 404 Not Found Exception
	 * @return
	 */
	@Bean
	DispatcherServlet dispatcherServlet () {
	   DispatcherServlet ds = new DispatcherServlet();
	   ds.setThrowExceptionIfNoHandlerFound(true);
	   return ds;
	}
}
