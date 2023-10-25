package ru.otus.spring.domian;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuizQuestionTest {

    private static final String QUESTION = "Question?";
    private static final String ANSWER = "Answer";

    @Test
    void shouldHaveCorrectConstructor() {
        Answer quizQuestion = new Answer(QUESTION, ANSWER);
        assertEquals(QUESTION, quizQuestion.getTest());
        assertEquals(ANSWER, quizQuestion.getRightAnswer());
    }

    @Test
    void setQuestion() {
        Answer quizQuestion = new Answer();
        quizQuestion.setTest(QUESTION);
        assertEquals(QUESTION, quizQuestion.getTest());
    }

    @Test
    void setAnswer() {
        Answer quizQuestion = new Answer();
        quizQuestion.setRightAnswer(ANSWER);
        assertEquals(ANSWER, quizQuestion.getRightAnswer());
    }

}