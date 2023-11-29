package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.spring.service.QuizRunnerService;
import ru.otus.spring.service.QuizRunnerServiceImpl;

@SpringBootApplication()
class QuizApp {

    public static void main(String[] args) {
        SpringApplication.run(QuizApp.class, args);
    }

}
