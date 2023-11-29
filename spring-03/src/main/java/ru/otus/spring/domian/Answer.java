package ru.otus.spring.domian;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Answer(String text, LocalDateTime answersTime) {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public String getFormattedAnswersTime() {
        return answersTime.format(DATE_TIME_FORMATTER);
    }

}
