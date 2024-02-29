package ru.otus.spring.dao;

import ru.otus.spring.domian.Question;

import java.util.List;

public interface QuizDao {

    public List<Question> getQuestions();

}
