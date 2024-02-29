package ru.otus.spring.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring.config.QuizFileNameProvider;
import ru.otus.spring.domian.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CsvQuizQuestionDaoTest {

    private final QuizFileNameProvider csvFileName = new QuizFileNameProvider() {
        @Override
        public String getQuizFileName() {
            return "quiz.csv";
        }
    };

    @Test
    void shouldGetQuestionsAndAnswersFromFile() {
        QuizDao quizDao = new CsvQuizQuestionDao(csvFileName);
        List<Question> quizQuestions = quizDao.getQuestions();
        assertThat(quizQuestions)
                .hasSize(5)
                .satisfiesExactly(input -> {
                            assertThat(input.text()).isEqualTo("Why?");
                            assertThat(input.rightAnswer()).isEqualTo("Because");
                        },
                        input1 -> {
                            assertThat(input1.text()).isEqualTo("What?");
                            assertThat(input1.rightAnswer()).isEqualTo("That");
                        },
                        input2 -> {
                            assertThat(input2.text()).isEqualTo("How many?");
                            assertThat(input2.rightAnswer()).isEqualTo("A lot");
                        },
                        input3 -> {
                            assertThat(input3.text()).isEqualTo("How you doing?");
                            assertThat(input3.rightAnswer()).isEqualTo("Good");
                        },
                        input4 -> {
                            assertThat(input4.text()).isEqualTo("Really?");
                            assertThat(input4.rightAnswer()).isEqualTo("Yes");
                        });
    }

}