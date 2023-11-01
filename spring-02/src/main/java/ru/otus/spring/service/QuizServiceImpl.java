package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.domian.Answer;
import ru.otus.spring.domian.Question;
import ru.otus.spring.domian.QuizResult;
import ru.otus.spring.domian.Student;

import java.time.LocalDateTime;

@Service
public class QuizServiceImpl implements QuizService {

    private static final String MESSAGE_TO_ENTER = "Enter your answer: ";

    private final QuizDao dao;

    private final IOService ioService;

    public QuizServiceImpl(QuizDao dao, IOService ioService) {
        this.dao = dao;
        this.ioService = ioService;
    }

    @Override
    public QuizResult executeQuiz(Student student) {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        var questions = dao.getQuestions();
        var quizResult = new QuizResult(student);

        if (questions != null) {
            for (Question question : questions) {
                ioService.printLine(question.text());
                String answerStr = ioService.readStringWithPrompt(MESSAGE_TO_ENTER);
                Answer answer = new Answer(answerStr, LocalDateTime.now());
                ioService.printLine(answer.getFormattedAnswersTime());
                ioService.printLine("");
                quizResult.applyAnswer(question, answer);
            }
        }
        return quizResult;
    }

}
