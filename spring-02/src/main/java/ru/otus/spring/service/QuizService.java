package ru.otus.spring.service;

import ru.otus.spring.domian.QuizResult;
import ru.otus.spring.domian.Student;

public interface QuizService {

    QuizResult executeQuiz(Student student);

}
