//package spring.domian;
//
//import org.junit.jupiter.api.Test;
//import ru.otus.spring.domian.Question;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class QuizQuestionTest {
//
//    private static final String QUESTION = "Question?";
//    private static final String ANSWER = "Answer";
//
//    @Test
//    void shouldHaveCorrectConstructor() {
//        Question quizQuestion = new Question(QUESTION, ANSWER);
//        assertEquals(QUESTION, quizQuestion.getText());
//        assertEquals(ANSWER, quizQuestion.getRightAnswer());
//    }
//
//    @Test
//    void setQuestion() {
//        Question quizQuestion = new Question();
//        quizQuestion.setText(QUESTION);
//        assertEquals(QUESTION, quizQuestion.getText());
//    }
//
//    @Test
//    void setAnswer() {
//        Question quizQuestion = new Question();
//        quizQuestion.setRightAnswer(ANSWER);
//        assertEquals(ANSWER, quizQuestion.getRightAnswer());
//    }
//
//}