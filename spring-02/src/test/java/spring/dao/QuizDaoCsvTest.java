//package spring.dao;
//
//import org.junit.jupiter.api.Test;
//import ru.otus.spring.dao.CsvQuizQuestionDao;
//import ru.otus.spring.dao.QuizDao;
//import ru.otus.spring.domian.Question;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class QuizDaoCsvTest {
//
//    @Test
//    void shouldGetQuestions() {
//        QuizDao quizDao = new CsvQuizQuestionDao("quiz.csv");
//        List<Question> quizQuestions = quizDao.getQuestions();
//        assertThat(quizQuestions)
//                .hasSize(5)
//                .satisfiesExactly(input1 -> assertThat(input1.getText()).isEqualTo("Why?"),
//                        input2 -> assertThat(input2.getText()).isEqualTo("What?"),
//                        input3 -> assertThat(input3.getText()).isEqualTo("How many?"),
//                        input4 -> assertThat(input4.getText()).isEqualTo("How you doing?"),
//                        input5 -> assertThat(input5.getText()).isEqualTo("Really?"));
//    }
//
//}