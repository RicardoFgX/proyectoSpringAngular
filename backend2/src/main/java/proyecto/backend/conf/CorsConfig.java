package proyecto.backend.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/login")
		.allowedOrigins("http://localhost:4200")
		.allowedHeaders("POST", "Content-Type","X-Requested-With","accept","Origin",
				"Access-Control-Request-Method","Access-Control-Request-Headers")
		.allowedMethods("PUT", "DELETE","OPTIONS", "GET", "POST", "HEAD")
		.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials", "Authorization");
		registry.addMapping("/api/coches/**")
		.allowedOrigins("http://localhost:4200")
		.allowedHeaders("GET", "POST", "HEAD", "DELETE", "PUT", "Content-Type","X-Requested-With","accept","Origin",
				"Access-Control-Request-Method","Access-Control-Request-Headers")
		.allowedMethods("PUT", "DELETE","OPTIONS", "GET", "POST", "HEAD")
		.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials", "Authorization");
    }
   
}