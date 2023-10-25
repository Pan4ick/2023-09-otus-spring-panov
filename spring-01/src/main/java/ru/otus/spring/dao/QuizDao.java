package ru.otus.spring.dao;

import ru.otus.spring.domian.Answer;

import java.util.List;

public interface QuizDao {

    public List<Answer> getQuestions();

}
