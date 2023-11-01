package ru.otus.spring.domian;

public record Student(String firstName, String lastName, int age) {

    public String getFullName() {
        return String.format("%s %s, %d", firstName, lastName, age);
    }
}
