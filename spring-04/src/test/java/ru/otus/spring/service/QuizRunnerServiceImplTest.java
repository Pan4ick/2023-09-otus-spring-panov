package ru.otus.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.domian.QuizResult;
import ru.otus.spring.domian.Student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuizRunnerServiceImplTest {

    @Mock
    private QuizService quizService;

    @Mock
    private StudentService studentService;

    @Mock
    private ResultService resultService;

    @InjectMocks
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