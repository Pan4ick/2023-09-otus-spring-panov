package ru.otus.spring.domian;

public class Answer {

    private String test;

    private String rightAnswer;

    //Необходим для работы MappingIterator
    public Answer() {

    }

    public Answer(String test, String rightAnswer) {
        this.test = test;
        this.rightAnswer = rightAnswer;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

}
