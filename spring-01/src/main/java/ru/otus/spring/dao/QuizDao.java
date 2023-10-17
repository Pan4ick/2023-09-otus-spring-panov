package ru.otus.spring.dao;

import ru.otus.spring.domian.Answer;
import ru.otus.spring.exceptions.CsvConvertException;

import java.util.List;

public interface QuizDao {

    public List<Answer> getQuestions() throws CsvConvertException;

}
