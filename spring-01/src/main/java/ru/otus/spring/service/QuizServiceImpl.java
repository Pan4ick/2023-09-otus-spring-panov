package ru.otus.spring.service;

import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.domian.Answer;
import ru.otus.spring.exceptions.CsvConvertException;

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
        try {
            questions = dao.getQuestions();
        } catch (CsvConvertException e) {
            throw new RuntimeException(e);
        }
        if (questions != null) {
            for (Answer question : questions) {
                ioService.printLine(question.getTest());
            }
        }
    }

}
