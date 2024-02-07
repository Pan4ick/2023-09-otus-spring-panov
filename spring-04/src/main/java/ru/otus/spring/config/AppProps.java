package ru.otus.spring.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;
import java.util.Map;

@RequiredArgsConstructor
@ConfigurationProperties(prefix = "quiz")
public class AppProps implements QuizConfig, QuizFileNameProvider, LocaleConfig {

    @Getter
    private final int rightAnswersCountToPass;

    private final Map<String, String> fileNameByLocaleTag;

    @Getter
    private final Locale locale;

    @Getter
    private final int maxStudentsAge;

    @Getter
    private final int minStudentsAge;

    @Override
    public String getQuizFileName() {
        return fileNameByLocaleTag.get(locale.toLanguageTag());
    }
}
