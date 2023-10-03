package ru.otus.spring.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;
import ru.otus.spring.domian.QuizQuestion;

import java.io.InputStream;
import java.util.List;

public class QuizDaoCsv implements QuizDao {

    private final String csvFileName;

    public QuizDaoCsv(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    @Override
    public List<QuizQuestion> getQuestions() {
        CsvMapper csvMapper = new CsvMapper();
//        csvMapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        CsvSchema schema = csvMapper.schema().withHeader();
        try {
            InputStream csvStream = new ClassPathResource(csvFileName).getInputStream();
            MappingIterator<QuizQuestion> questionMappingIterator = csvMapper.readerFor(QuizQuestion.class)
                    .with(schema)
                    .readValues(csvStream);
            return questionMappingIterator.readAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
