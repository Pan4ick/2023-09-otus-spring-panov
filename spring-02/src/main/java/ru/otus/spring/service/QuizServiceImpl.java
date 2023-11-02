package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.domian.Answer;
import ru.otus.spring.domian.Question;
import ru.otus.spring.domian.QuizResult;
import ru.otus.spring.domian.Student;

import java.time.LocalDateTime;

import static ru.otus.spring.helpers.StringsStorage.QUIZ_MESSAGE;
import static ru.otus.spring.helpers.StringsStorage.MESSAGE_TO_ENTER;
import static ru.otus.spring.helpers.StringsStorage.EMPTY_LINE;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizDao dao;

    private final IOService ioService;

    public QuizServiceImpl(QuizDao dao, IOService ioService) {
        this.dao = dao;
        this.ioService = ioService;
    }

    @Override
    public QuizResult executeQuiz(Student student) {
        ioService.printFormattedLine(QUIZ_MESSAGE);
        var questions = dao.getQuestions();
        var quizResult = new QuizResult(student);

        if (questions != null) {
            for (Question question : questions) {
                ioService.printLine(question.text());
                String answerStr = ioService.readStringWithPrompt(MESSAGE_TO_ENTER);
                Answer answer = new Answer(answerStr, LocalDateTime.now());
                ioService.printLine(answer.getFormattedAnswersTime());
                ioService.printLine(EMPTY_LINE);
                quizResult.applyAnswer(question, answer);
            }
        }
        return quizResult;
    }

}
