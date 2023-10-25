package ru.otus.spring.service;

import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.domian.Answer;

import java.util.List;

public class QuizServiceImpl implements QuizService {

    private final QuizDao dao;

    private final IOService ioService;

    public QuizServiceImpl(QuizDao dao, IOService ioService) {
        this.dao = dao;
        this.ioService = ioService;
    }

    @Override
    public void startQuiz() {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        List<Answer> questions;
        questions = dao.getQuestions();
        if (questions != null) {
            for (Answer question : questions) {
                ioService.printLine(question.getTest());
            }
        }
    }

}
