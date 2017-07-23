package com.alan.springcloudconsulexample;

import com.alan.springcloudconsulexample.services.IConsulFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Configuration
@EnableAutoConfiguration
@RefreshScope
public class SpringCloudConsulExampleApplication {

    @Value("${consul.example.value}")
    private String value;
    @Value("${spring.cloud.consul.config.prefix}")
    private String path;
    @Value("${spring.application.name}")
    private String applicationName;
    @Autowired
    private IConsulFileService consulFileService;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsulExampleApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        consulFileService.getAllFiles(path.concat("/").concat(applicationName), ".vm", true);
        return "Hello world : " + value;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
