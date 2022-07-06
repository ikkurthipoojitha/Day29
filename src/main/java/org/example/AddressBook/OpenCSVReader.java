package org.example.AddressBook;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class OpenCSVReader {

    private static final String CSV_FILE_PATH = "C:\\Users\\Poojitha\\IdeaProjects\\day28\\src\\main\\resources\\person.csv";

    public static void main(String[] args) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        ) {

            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<CSVUser> csvUsers = csvToBean.parse();
            for(CSVUser csvUser : csvUsers){
                System.out.println("firstname:" + csvUser.getFirstname());
                System.out.println("last name:" + csvUser.getLastName());
                System.out.println("city:" + csvUser.getCity());
                System.out.println("state:" + csvUser.getState());
                System.out.println("email:" + csvUser.getEmail());
                System.out.println("phone:" + csvUser.getPhone());
                System.out.println("zip:" + csvUser.getZipcode());

            }
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}

//            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();
//
//            while (csvUserIterator.hasNext()) {
//                CSVUser csvUser = csvUserIterator.next();
//                System.out.println("Name:" + csvUser.getName());
//                System.out.println("email:" + csvUser.getEmail());
//                System.out.println("phone:" + csvUser.getPhone());
//            }

