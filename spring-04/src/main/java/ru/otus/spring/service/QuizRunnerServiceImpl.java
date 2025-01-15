package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuizRunnerServiceImpl implements QuizRunnerService {

    private final QuizService quizService;

    private final StudentService studentService;

    private final ResultService resultService;

    @Override
    public void run() {
        var student = studentService.determineStudent();
        var quizResult = quizService.executeQuiz(student);
        resultService.showResult(quizResult);
    }
}
