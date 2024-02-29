package ru.otus.spring.domian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class QuizResultTest {


    private final Student student = new Student("Test", "Test", 23);

    private QuizResult quizResult;

    @BeforeEach
    void setUp() {
        Map<Question, Answer> questionAnswerMap = Map.of(new Question("Capital of GB", "London"), new Answer("London", null),
                new Question("Capital of Russia", "Moscow"), new Answer("London", null),
                new Question("Right question", "Right"), new Answer("Right", null),
                new Question("Your size", "11"), new Answer("11", null),
                new Question("Test question", "Test Answer"), new Answer("Wrong", null));
        quizResult = new QuizResult(student);
        for (Map.Entry<Question, Answer> entry : questionAnswerMap.entrySet()) {
            quizResult.applyAnswer(entry.getKey(), entry.getValue());
        }
    }

    @Test
    void shouldCountRightAnswers() {
        assertThat(quizResult.getRightAnswersCount()).isEqualTo(3);
    }

    @Test
    void shouldCountQuestions() {
        assertThat(quizResult.getQuestionsCount()).isEqualTo(5);
    }

}