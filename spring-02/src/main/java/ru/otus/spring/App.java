package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.spring.service.QuizRunnerService;

@ComponentScan
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        QuizRunnerService quizRunnerService = context.getBean(QuizRunnerService.class);

        quizRunnerService.run();

    }
}