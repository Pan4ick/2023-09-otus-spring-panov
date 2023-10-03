package ru.otus.spring.service;

import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.domian.QuizQuestion;

import java.util.List;

public class QuizServiceImpl implements QuizService {

    private final QuizDao dao;

    public QuizServiceImpl(QuizDao dao) {
        this.dao = dao;
    }

    @Override
    public void startQuiz() {
        List<QuizQuestion> questions = dao.getQuestions();
        for (QuizQuestion question : questions) {
            System.out.println(question.getQuestion());
        }
    }
}
