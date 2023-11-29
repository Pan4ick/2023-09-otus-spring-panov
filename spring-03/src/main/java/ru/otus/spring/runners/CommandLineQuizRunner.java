package ru.otus.spring.runners;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.otus.spring.service.QuizRunnerService;
import ru.otus.spring.service.QuizService;

@RequiredArgsConstructor
@Component
public class CommandLineQuizRunner implements CommandLineRunner {

    private final QuizRunnerService quizRunnerService;

    @Override
    public void run(String... args) throws Exception {
        quizRunnerService.run();
    }
}
