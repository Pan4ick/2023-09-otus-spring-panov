package ru.otus.spring.service;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spring.domian.QuizResult;
import ru.otus.spring.domian.Student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class QuizRunnerServiceImplTest {

    @MockBean
    private QuizService quizService;

    @MockBean
    private StudentService studentService;

    @MockBean
    private ResultService resultService;

    @Autowired
    private QuizRunnerServiceImpl quizRunnerService;

    @Test
    void shouldCreateQuizResultCorrectly() {
        Student testStudent = new Student("First", "Last", 23);
        QuizResult expectedQuizResult = new QuizResult(testStudent);
        expectedQuizResult.setQuestionsCount(5);
        expectedQuizResult.setRightAnswersCount(3);

        when(studentService.determineStudent()).thenReturn(testStudent);
        when(quizService.executeQuiz(testStudent)).thenReturn(expectedQuizResult);

        quizRunnerService.run();

        var captor = ArgumentCaptor.forClass(QuizResult.class);
        verify(resultService).showResult(captor.capture());
        var actualQuizResult = captor.getValue();
        assertThat(actualQuizResult).isEqualTo(expectedQuizResult);
    }
}