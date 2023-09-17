package id.sip.books.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@Profile(value = {"dev"})
public class SwaggerConfig {
	
	@Value("${swagger.dev.url}")
	private String devUrl;
	
	@Bean
	public OpenAPI openApi() {
		Server devServer = new Server();
	    devServer.setUrl(devUrl);
	    devServer.setDescription("Server URL in Development environment");
	    
	    Info info = new Info()
	            .title("Tutorial Management API")
	            .version("1.0")
//	            .contact(contact)
	            .description("This API exposes endpoints to manage tutorials.").termsOfService("http://localhost:8083/termsOfService")
//	            .license(mitLicense)
	            ;

	        return new OpenAPI().info(info).servers(List.of(devServer));
	}

}
