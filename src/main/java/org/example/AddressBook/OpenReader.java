package org.example.AddressBook;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.exceptions.CsvException;

public class OpenReader {

    private static final String CSV_FILE_PATH = "C:\\Users\\Poojitha\\IdeaProjects\\day28\\src\\main\\resources\\person.csv";

    public static void main(String[] args) throws IOException {

        try(
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVReader csvReader =  new CSVReader(reader);
                ){
            String[] nextRecord = new String[0];
            while((nextRecord = csvReader.readNext()) != null){
                System.out.println("firstName:" + nextRecord[0]);
                System.out.println("lastName:" + nextRecord[1]);
                System.out.println("city:" + nextRecord[2]);
                System.out.println("state:" + nextRecord[3]);
                System.out.println("email:" + nextRecord[4]);
                System.out.println("phone:" + nextRecord[5]);
                System.out.println("zip:" + nextRecord[6]);
                System.out.println("------------------");
                System.out.println();

            }
//            List<String[]> records = (List<String[]>) csvReader.readAll();
//            for(String[] record : records){
//                System.out.println("Name:" + record[0]);
//                System.out.println("email:" + record[1]);
//                System.out.println("phone:" + record[2]);
//            }
        }  catch(IOException | CsvException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
