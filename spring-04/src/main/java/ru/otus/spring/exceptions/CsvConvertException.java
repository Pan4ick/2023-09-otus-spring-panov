package ru.otus.spring.exceptions;

public class CsvConvertException extends RuntimeException {
    public CsvConvertException(String message, Throwable ex) {
        super(message, ex);
    }
}
