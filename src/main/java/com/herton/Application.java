package com.herton;

import com.herton.common.ExtendedJpaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.herton"})
@EnableJpaRepositories(repositoryBaseClass = ExtendedJpaRepository.class, basePackages = {"com.herton"})
@ServletComponentScan
@EntityScan({"com.herton"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
