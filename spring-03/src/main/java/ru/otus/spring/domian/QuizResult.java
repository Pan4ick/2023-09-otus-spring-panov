package ru.otus.spring.domian;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuizResult {

    private final Student student;

    private final List<Question> answeredQuestions;

    private final List<Answer> usersAnswers;

    private int rightAnswersCount;

    private int questionsCount;

    public QuizResult(Student student) {
        this.student = student;
        this.answeredQuestions = new ArrayList<>();
        this.usersAnswers = new ArrayList<>();
    }

    public void applyAnswer(Question question, Answer answer) {
        answeredQuestions.add(question);
        questionsCount++;
        usersAnswers.add(answer);
        if (question.rightAnswer().equals(answer.text())) {
            rightAnswersCount++;
        }
    }
}
