package org.example;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CensusAnalyzer<T extends Comparable<T>> {
    List<IndiaCensusCSV> CsvCensusDataList = new ArrayList<>();
    public int getStateCensusRecord(String FilePath,String methodname) throws CensusAnalyzerException
    {
        int stateCount = 0;
        Reader reader = null;
        try
        {
            reader = Files.newBufferedReader(Paths.get(FilePath));
            CsvToBean<IndiaCensusCSV> csvToBean = new CsvToBeanBuilder(reader).withType(IndiaCensusCSV.class)
                    .withIgnoreLeadingWhiteSpace(true).build();
            Iterator<IndiaCensusCSV> CsvStateIterator = csvToBean.iterator();

            while (CsvStateIterator.hasNext())
            {
                stateCount++;
                IndiaCensusCSV csvUser = CsvStateIterator.next();
                CsvCensusDataList.add(csvUser);
            }
            sortMethod(CsvCensusDataList,methodname);
            storeDataIntoJSON(CsvCensusDataList);
        }

        catch (IOException e)
        {
            throw new CensusAnalyzerException("File Not Found", CensusAnalyzerException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME);
        }
        catch (RuntimeException | IllegalAccessException | NoSuchMethodException e)
        {
            throw new CensusAnalyzerException("Cannot Map CSV Header Or issue With Delimiter...", CensusAnalyzerException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return stateCount;
    }

    public void sortMethod(List<IndiaCensusCSV> censuses,String methodname) throws CensusAnalyzerException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        for(int i=0;i<CsvCensusDataList.size()-1;i++) {
            for (int j = 0; j < CsvCensusDataList.size() - i - 1; j++) {

                Class aClass = CsvCensusDataList.get(j).getClass();
                Method methodcall = aClass.getDeclaredMethod(methodname);
                T CSVvalue1 = (T) ((Method) methodcall).invoke(CsvCensusDataList.get(j));

                Class aClass1 = CsvCensusDataList.get(j).getClass();
                Method methodcall1 = aClass1.getDeclaredMethod(methodname);
                T CSVvalue2 = (T) methodcall1.invoke(CsvCensusDataList.get(j+1));
                if (CSVvalue1.compareTo(CSVvalue2) < 0) {
                    IndiaCensusCSV temp = CsvCensusDataList.get(j);
                    CsvCensusDataList.set(j, CsvCensusDataList.get(j + 1));
                    CsvCensusDataList.set(j + 1, temp);
                }
            }

        }
        for(int k=0;k<CsvCensusDataList.size();k++){
            System.out.println(CsvCensusDataList.get(k).state);
        }

    }
    public void  storeDataIntoJSON(List<IndiaCensusCSV> censusList)
    {
        String FilePath="C:\\Users\\Poojitha\\IdeaProjects\\Day29\\src\\main\\resources\\state.json";
         Gson gson = new Gson();
        String json = gson.toJson(CsvCensusDataList);
        FileWriter writer = null;
        try {
            writer = new FileWriter(FilePath);
            writer.write(json);
            writer.close();
        }catch(Exception e) {

            e.printStackTrace();
        }

    }
}
