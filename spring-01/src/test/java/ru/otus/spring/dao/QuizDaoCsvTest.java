package ru.otus.spring.dao;

import org.junit.jupiter.api.Test;
import ru.otus.spring.domian.QuizQuestion;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuizDaoCsvTest {

    @Test
    void shouldGetQuestions() {
        QuizDao quizDao = new QuizDaoCsv("quiz.csv");
        List<QuizQuestion> quizQuestions = quizDao.getQuestions();
        assertThat(quizQuestions)
                .hasSize(5)
                .satisfiesExactly(input1 -> assertThat(input1.getQuestion()).isEqualTo("Why?"),
                        input2 -> assertThat(input2.getQuestion()).isEqualTo("What?"),
                        input3 -> assertThat(input3.getQuestion()).isEqualTo("How many?"),
                        input4 -> assertThat(input4.getQuestion()).isEqualTo("How you doing?"),
                        input5 -> assertThat(input5.getQuestion()).isEqualTo("Really?"));
    }

}