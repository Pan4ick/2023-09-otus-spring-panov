package ru.otus.spring.domian;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuizQuestionTest {

    private static final String QUESTION = "Question?";
    private static final String ANSWER = "Answer";

    @Test
    void shouldHaveCorrectConstructor() {
        QuizQuestion quizQuestion = new QuizQuestion(QUESTION, ANSWER);
        assertEquals(QUESTION, quizQuestion.getQuestion());
        assertEquals(ANSWER, quizQuestion.getAnswer());
    }

    @Test
    void setQuestion() {
        QuizQuestion quizQuestion = new QuizQuestion();
        quizQuestion.setQuestion(QUESTION);
        assertEquals(QUESTION, quizQuestion.getQuestion());
    }

    @Test
    void setAnswer() {
        QuizQuestion quizQuestion = new QuizQuestion();
        quizQuestion.setAnswer(ANSWER);
        assertEquals(ANSWER, quizQuestion.getAnswer());
    }

}