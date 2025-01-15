package ru.otus.spring.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.otus.spring.config.QuizFileNameProvider;
import ru.otus.spring.domian.Question;
import ru.otus.spring.exceptions.CsvConvertException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CsvQuestionDao implements QuestionDao {

    private final QuizFileNameProvider csvFileName;

    @Override
    public List<Question> getQuestions() {
        CsvMapper csvMapper = new CsvMapper();
        try (InputStream csvStream = new ClassPathResource(csvFileName.getQuizFileName()).getInputStream()) {
            CsvSchema schema = csvMapper.schema().withHeader();
            MappingIterator<Question> questionMappingIterator = csvMapper.readerFor(Question.class)
                    .with(schema)
                    .readValues(csvStream);
            return questionMappingIterator.readAll();
        } catch (IOException ex) {
            throw new CsvConvertException(ex.getMessage(), ex);
        }
    }

}
