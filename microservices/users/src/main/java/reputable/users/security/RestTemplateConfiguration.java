package reputable.users.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplateBuilder()
                .basicAuthentication("admin", "admin")
                .build();


        return restTemplate;
    }

    //configured headers here to avoid Content-Type error
    @Bean
    HttpHeaders headers(){
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
