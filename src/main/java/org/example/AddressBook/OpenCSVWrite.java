package org.example.AddressBook;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWrite {

    private static final String OBJECT_LIST_SAMPLE = "C:\\Users\\Poojitha\\IdeaProjects\\day28\\src\\main\\resources\\address.csv";

    public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(OBJECT_LIST_SAMPLE));
                ){
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            List<CSVUser> myUser = new ArrayList<>();
            myUser.add(new CSVUser("a","b","AP","Guntur","abc@gmail.com","9087654321","522001"));
            myUser.add(new CSVUser("b","ko","UP","Guntur","abcd@gmail.com","96778954321","522002"));

            beanToCsv.write(myUser);

        } 
    }
}