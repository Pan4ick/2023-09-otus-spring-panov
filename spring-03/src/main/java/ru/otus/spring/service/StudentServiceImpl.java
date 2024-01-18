package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.config.QuizConfig;
import ru.otus.spring.domian.Student;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final QuizConfig quizConfig;

    private final LocalizedIOService ioService;

    @Override
    public Student determineStudent() {
        var firstName = ioService.readStringWithPromptLocalized("Student.service.first.name.input");
        var lastName = ioService.readStringWithPromptLocalized("Student.service.last.name.input");
        var age = ioService.readIntForRangeWithPromptLocalized(quizConfig.getMinStudentsAge(),
                quizConfig.getMaxStudentsAge(), "Student.service.age.input",
                "Student.service.age.error");
        return new Student(firstName, lastName, age);
    }

}
