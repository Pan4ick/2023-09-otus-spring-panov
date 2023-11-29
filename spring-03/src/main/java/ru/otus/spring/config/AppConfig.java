package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@Configuration
public class AppConfig implements QuizConfig, QuizFileNameProvider {

    @Value("${quiz.rightAnswersCountToPass}")
    private int rightAnswersCountToPass;

    @Value("${quiz.fileName}")
    private String quizFileName;

    @Override
    public int getRightAnswersCountToPass() {
        return rightAnswersCountToPass;
    }

    @Override
    public String getQuizFileName() {
        return quizFileName;
    }
}
