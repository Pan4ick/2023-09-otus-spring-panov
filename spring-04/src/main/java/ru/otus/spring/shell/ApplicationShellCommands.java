package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.spring.domian.QuizResult;
import ru.otus.spring.domian.Student;
import ru.otus.spring.service.LocalizedIOService;
import ru.otus.spring.service.QuizRunnerService;
import ru.otus.spring.service.QuizService;
import ru.otus.spring.service.ResultService;
import ru.otus.spring.service.StudentService;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationShellCommands {

    private Student student;

    private QuizResult quizResult;

    private final StudentService studentService;

    private final LocalizedIOService ioService;

    private final QuizService quizService;

    private final ResultService resultService;

    private final QuizRunnerService quizRunnerService;

    @ShellMethod(value = "Start app in default mode", key = {"a", "app"})
    public void startApp() {
        quizRunnerService.run();
    }

    @ShellMethod(value = "Login command", key = {"l", "log", "login"})
    public void login() {
        student = studentService.determineStudent();
        ioService.printFormattedLineLocalized("Shell.command.success.login", student.getFullName());
    }

    @ShellMethod(value = "Start quiz", key = {"s", "start", "go"})
    @ShellMethodAvailability(value = "isStudentRegistered")
    public void startQuiz() {
        quizResult = quizService.executeQuiz(student);
        ioService.printLineLocalized("Shell.command.results.message");
    }

    @ShellMethod(value = "See results", key = {"r", "res", "results"})
    @ShellMethodAvailability(value = "isQuizEnded")
    public void seeResults() {
        resultService.showResult(quizResult);
    }

    private Availability isStudentRegistered() {
        return student == null ? Availability.unavailable("you should register first, use \"l\" command")
                : Availability.available();
    }

    private Availability isQuizEnded() {
        return quizResult == null ? Availability.unavailable("you should finish quiz first, use \"s\" command")
                : Availability.available();
    }


}
