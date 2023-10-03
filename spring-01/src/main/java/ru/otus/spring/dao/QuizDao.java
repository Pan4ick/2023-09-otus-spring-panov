package ru.otus.spring.dao;

import ru.otus.spring.domian.QuizQuestion;

import java.util.List;

public interface QuizDao {

    public List<QuizQuestion> getQuestions();
}
