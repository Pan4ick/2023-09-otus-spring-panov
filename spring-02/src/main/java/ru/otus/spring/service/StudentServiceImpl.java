package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.domian.Student;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private static final int MIN_AGE = 5;

    private static final int MAX_AGE = 110;

    private static final String AGE_ERROR_MESSAGE = "Please, enter your real age: ";

    private final IOService ioService;

    @Override
    public Student determineStudent() {
        var firstName = ioService.readStringWithPrompt("Please input your first name: ");
        var lastName = ioService.readStringWithPrompt("Please input your last name: ");
        var age = ioService.readIntForRangeWithPrompt(MIN_AGE, MAX_AGE, "Please input your age: ", AGE_ERROR_MESSAGE);
        return new Student(firstName, lastName, age);
    }

}
