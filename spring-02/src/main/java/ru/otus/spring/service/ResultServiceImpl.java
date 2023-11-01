package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.config.QuizConfig;
import ru.otus.spring.domian.QuizResult;

@RequiredArgsConstructor
@Service
public class ResultServiceImpl implements ResultService {

    private final QuizConfig quizConfig;

    private final IOService ioService;

    @Override
    public void showResult(QuizResult quizResult) {
        ioService.printLine("");
        ioService.printFormattedLine("Student: %s", quizResult.getStudent().getFullName());
        ioService.printFormattedLine("Test results: %d/%d, need: %d", quizResult.getRightAnswersCount(),
                quizResult.getQuestionsCount(), quizConfig.getRightAnswersCountToPass());

        if (quizResult.getRightAnswersCount() >= quizConfig.getRightAnswersCountToPass()) {
            ioService.printLine("Congratulations! You passed test!");
            return;
        }
        ioService.printLine("Sorry. You fail test.");
    }
}
