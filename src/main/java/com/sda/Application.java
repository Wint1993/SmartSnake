package com.sda;


import com.sda.dto.UserDTO;
import com.sda.mapper.UserMapper;
import com.sda.model.User;
import com.sda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Objects;
import java.util.UUID;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Learning Spring Boot")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST Api with Swagger")
                .description("Api allows modifying different values")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("Niklas Heidloff")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }

    @Override
    public void run(String... strings) throws Exception {
        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword("user");
        user1.setUuid(UUID.randomUUID().toString());
        user1 = userRepository.save(user1);

        UserDTO userDTO = new UserDTO();
        User user3 = userMapper.toUser(userDTO);
        user3.setUsername("user1");
        user3.setPassword("user1");
        user3.setUuid(UUID.randomUUID().toString());
        userDTO = userMapper.toUserDTO(userRepository.save(user3));

        UserDTO userDTO1 = new UserDTO();
        User user2 = userMapper.toUser(userDTO1);
        user2.setUsername("user2");
        user2.setPassword("user2");
        user2.setUuid(UUID.randomUUID().toString());
        userDTO1 = userMapper.toUserDTO(userRepository.save(user2));

    }


}
