package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.domian.Student;

import static ru.otus.spring.helpers.StringsStorage.AGE_ERROR_MESSAGE;
import static ru.otus.spring.helpers.StringsStorage.AGE_INPUT;
import static ru.otus.spring.helpers.StringsStorage.FIRST_NAME_INPUT;
import static ru.otus.spring.helpers.StringsStorage.SECOND_NAME_INPUT;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private static final int MIN_AGE = 5;

    private static final int MAX_AGE = 110;

    private final IOService ioService;

    @Override
    public Student determineStudent() {
        var firstName = ioService.readStringWithPrompt(FIRST_NAME_INPUT);
        var lastName = ioService.readStringWithPrompt(SECOND_NAME_INPUT);
        var age = ioService.readIntForRangeWithPrompt(MIN_AGE, MAX_AGE, AGE_INPUT, AGE_ERROR_MESSAGE);
        return new Student(firstName, lastName, age);
    }

}
