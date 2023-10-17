package ru.otus.spring.exceptions;

import java.io.IOException;

public class CsvConvertException extends IOException {
    public CsvConvertException(String message) {
        super(message);
    }

    public CsvConvertException(String message, Throwable ex) {
        super(message, ex);
    }
}
