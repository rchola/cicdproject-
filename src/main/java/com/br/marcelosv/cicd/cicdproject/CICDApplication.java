package com.br.marcelosv.cicd.cicdproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CICDApplication {

    public static void main(String[] args) {
        SpringApplication.run(CICDApplication.class, args);
    }

    @GetMapping("/status")
    public String status() {
        return "OK";
    }

}
