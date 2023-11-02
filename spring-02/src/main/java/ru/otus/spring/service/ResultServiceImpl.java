package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.config.QuizConfig;
import ru.otus.spring.domian.QuizResult;

import static ru.otus.spring.helpers.StringsStorage.EMPTY_LINE;
import static ru.otus.spring.helpers.StringsStorage.FAILED_TEST_OUTPUT;
import static ru.otus.spring.helpers.StringsStorage.PASSED_TEST_OUTPUT;
import static ru.otus.spring.helpers.StringsStorage.QUIZ_RESULTS_OUTPUT;
import static ru.otus.spring.helpers.StringsStorage.STUDENT_OUTPUT;

@RequiredArgsConstructor
@Service
public class ResultServiceImpl implements ResultService {

    private final QuizConfig quizConfig;

    private final IOService ioService;

    @Override
    public void showResult(QuizResult quizResult) {
        ioService.printLine(EMPTY_LINE);
        ioService.printFormattedLine(STUDENT_OUTPUT, quizResult.getStudent().getFullName());
        ioService.printFormattedLine(QUIZ_RESULTS_OUTPUT, quizResult.getRightAnswersCount(),
                quizResult.getQuestionsCount(), quizConfig.getRightAnswersCountToPass());

        if (quizResult.getRightAnswersCount() >= quizConfig.getRightAnswersCountToPass()) {
            ioService.printLine(PASSED_TEST_OUTPUT);
            return;
        }
        ioService.printLine(FAILED_TEST_OUTPUT);
    }
}
