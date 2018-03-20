package com.barbeqjue.digibooky.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.barbeqjue.digibooky.domain","com.barbeqjue.digibooky.services","com.barbeqjue.digibooky.api"})
@SpringBootApplication
public class DigibookyRunner {

    public static void main(String[] args) {

        SpringApplication.run(DigibookyRunner.class, args);

    }
}
