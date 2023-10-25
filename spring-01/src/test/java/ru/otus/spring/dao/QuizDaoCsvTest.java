package ru.otus.spring.dao;

import org.junit.jupiter.api.Test;
import ru.otus.spring.domian.Answer;
import ru.otus.spring.exceptions.CsvConvertException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuizDaoCsvTest {

    @Test
    void shouldGetQuestions() {
        QuizDao quizDao = new CsvQuizQuestionDao("quiz.csv");
        List<Answer> quizQuestions = quizDao.getQuestions();
        assertThat(quizQuestions)
                .hasSize(5)
                .satisfiesExactly(input1 -> assertThat(input1.getTest()).isEqualTo("Why?"),
                        input2 -> assertThat(input2.getTest()).isEqualTo("What?"),
                        input3 -> assertThat(input3.getTest()).isEqualTo("How many?"),
                        input4 -> assertThat(input4.getTest()).isEqualTo("How you doing?"),
                        input5 -> assertThat(input5.getTest()).isEqualTo("Really?"));
    }

}