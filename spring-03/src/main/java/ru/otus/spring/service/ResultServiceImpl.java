package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.config.QuizConfig;
import ru.otus.spring.domian.QuizResult;

@RequiredArgsConstructor
@Service
public class ResultServiceImpl implements ResultService {

    private final QuizConfig quizConfig;

    private final LocalizedIOService ioService;

    @Override
    public void showResult(QuizResult quizResult) {
        ioService.printLine("");
        ioService.printFormattedLineLocalized("Result.service.student.output", quizResult.getStudent().getFullName());
        ioService.printFormattedLineLocalized("Result.service.quiz.results.output", quizResult.getRightAnswersCount(),
                quizResult.getQuestionsCount(), quizConfig.getRightAnswersCountToPass());

        if (quizResult.getRightAnswersCount() >= quizConfig.getRightAnswersCountToPass()) {
            ioService.printLineLocalized("Result.service.passed.test.output");
            return;
        }
        ioService.printLineLocalized("Result.service.failed.test.output");
    }
}
