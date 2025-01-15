package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domian.Answer;
import ru.otus.spring.domian.Question;
import ru.otus.spring.domian.QuizResult;
import ru.otus.spring.domian.Student;

import java.time.LocalDateTime;


@Service
public class QuizServiceImpl implements QuizService {

    private final QuestionDao dao;

    private final LocalizedIOService ioService;

    public QuizServiceImpl(QuestionDao dao, LocalizedIOService ioService) {
        this.dao = dao;
        this.ioService = ioService;
    }

    @Override
    public QuizResult executeQuiz(Student student) {
        ioService.printFormattedLineLocalized("Quiz.service.quiz.message");
        var questions = dao.getQuestions();
        var quizResult = new QuizResult(student);

        for (Question question : questions) {
            ioService.printLine(question.text());
            String answerStr = ioService.readStringWithPromptLocalized("Quiz.service.enter.message");
            Answer answer = new Answer(answerStr, LocalDateTime.now());
            ioService.printFormattedLine(answer.getFormattedAnswersTime());
            ioService.printLine("");
            quizResult.applyAnswer(question, answer);
        }

        return quizResult;
    }

}
