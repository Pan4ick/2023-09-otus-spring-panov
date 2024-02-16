package ru.otus.spring.runners;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import ru.otus.spring.service.QuizRunnerService;

@RequiredArgsConstructor
public class CommandLineQuizRunner implements CommandLineRunner {

    private final QuizRunnerService quizRunnerService;

    @Override
    public void run(String... args) {
        quizRunnerService.run();
    }
}
