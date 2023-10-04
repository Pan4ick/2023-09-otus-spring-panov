package ru.otus.spring.domian;

public class QuizQuestion {

    private String question;

    private String answer;

    //Необходим для работы MappingIterator
    public QuizQuestion() {

    }

    public QuizQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
