package com.br.marcelosv.cicd.cicdproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CICDApplication {

    public static void main(String[] args) {
        SpringApplication.run(CICDApplication.class, args);
    }

    @Value("${nome.ambiente}")
    private String ambiente;

    @Value("${versao.ambiente}")
    private String versao;

    @ResponseBody
    @GetMapping("/status")
    public String status() {
        return "Olá, você está no ambiente de " + ambiente + " na versão " + versao + "\n";
    }

}