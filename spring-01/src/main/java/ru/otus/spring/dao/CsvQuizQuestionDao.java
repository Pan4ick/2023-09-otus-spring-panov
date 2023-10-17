package ru.otus.spring.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;
import ru.otus.spring.domian.Answer;
import ru.otus.spring.exceptions.CsvConvertException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CsvQuizQuestionDao implements QuizDao {

    private final String csvFileName;

    public CsvQuizQuestionDao(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    @Override
    public List<Answer> getQuestions() throws CsvConvertException {
        CsvMapper csvMapper = new CsvMapper();
        try (InputStream csvStream = new ClassPathResource(csvFileName).getInputStream()) {
            CsvSchema schema = csvMapper.schema().withHeader();
            MappingIterator<Answer> questionMappingIterator = csvMapper.readerFor(Answer.class)
                    .with(schema)
                    .readValues(csvStream);
            return questionMappingIterator.readAll();
        } catch (IOException ex) {
            throw new CsvConvertException(ex.getMessage());
        }
    }

}
