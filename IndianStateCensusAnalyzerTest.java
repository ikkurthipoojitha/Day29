package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class IndianStateCensusAnalyzerTest {

    CensusAnalyzer censusAnalyzer = new CensusAnalyzer();

    @Test
    public void givenStateCensusCSVFile_whenCountRecords_ShouldReturnTrue() throws IOException {
        try {
            Assertions.assertEquals(29,censusAnalyzer.getStateCensusRecord("C:\\Users\\Poojitha\\IdeaProjects\\Day29\\src\\main\\resources\\IndiaStateCensusData.csv",""));
        } catch (CensusAnalyzerException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenIncorrectStateCensusCSVFile_whenChecked_ShouldReturnFalse() throws IOException {
        try {
            Assertions.assertEquals(29, censusAnalyzer.getStateCensusRecord("C:\\Users\\Poojitha\\IdeaProjects\\Day29\\src\\main\\resources\\IndiaStateCensusData.csv",""));
        } catch (CensusAnalyzerException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyzerException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
        }
    }
    @Test
    public void givenInCorrectStateCensus_whenCSVFileType_shouldReturnFalse() throws IOException {
        try {
            Assertions.assertEquals(29, censusAnalyzer.getStateCensusRecord("C:\\Users\\Poojitha\\IdeaProjects\\Day29\\src\\main\\resources\\IndiaStateCensusData.csv",""));
        } catch (CensusAnalyzerException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyzerException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
        }

    }
    @Test
    public void givenCorrectStateCensusCSVFile_whenDelimiterIncorrect_shouldReturnFalse() throws IOException {

        try {
            Assertions.assertEquals(29, censusAnalyzer.getStateCensusRecord("C:\\Users\\Poojitha\\IdeaProjects\\Day29\\src\\main\\resources\\IndiaStateCensusData.csv",""));
        } catch (CensusAnalyzerException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyzerException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
        }

    }
    @Test
    public void givenCorrectStateCensusCSVFile_whenHeaderIncorrect_shouldReturnFalse() throws IOException {
        try {
            Assertions.assertEquals(29, censusAnalyzer.getStateCensusRecord("C:\\Users\\Poojitha\\IdeaProjects\\Day29\\src\\main\\resources\\IndiaStateCensusData.csv",""));
        } catch (CensusAnalyzerException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyzerException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
        }

    }
    @Test
    public void givenMessageJsonFile_whenForStateName_shouldReturnAlphabeticOrder() throws IOException, CensusAnalyzerException {
        try {
            Assertions.assertEquals(29, censusAnalyzer.getStateCensusRecord("/home/admin142/IdeaProjects/IndianStateSensusAnalyser/StateCensusData.csv","getState"));
        } catch (CensusAnalyzerException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyzerException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
        }
    }
    @Test
    public void givenMessageJsonFile_whenForPopulation_shouldReturnMostPopulationState() throws IOException, CensusAnalyzerException {
        try {
            Assertions.assertEquals(29, censusAnalyzer.getStateCensusRecord("C:\\Users\\Poojitha\\IdeaProjects\\Day29\\src\\main\\resources\\IndiaStateCensusData.csv"," getPopulation"));
        } catch (CensusAnalyzerException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyzerException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
        }
    }
    @Test
    public void givenMessageJsonFile_whenForPopulationDensity_shouldReturnPopulationDensity() throws IOException, CensusAnalyzerException {

        try {
            Assertions.assertEquals(29, censusAnalyzer.getStateCensusRecord("C:\\Users\\Poojitha\\IdeaProjects\\Day29\\src\\main\\resources\\IndiaStateCensusData.csv","getDensityPerSqKm"));
        } catch (CensusAnalyzerException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyzerException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
        }
    }
    @Test
    public void givenMessageJsonFile_whenForArea_shouldReturnSortedStateArea() throws IOException, CensusAnalyzerException {
        try {
            Assertions.assertEquals(29, censusAnalyzer.getStateCensusRecord("C:\\Users\\Poojitha\\IdeaProjects\\Day29\\src\\main\\resources\\IndiaStateCensusData.csv","getAreaInSqKm"));
        } catch (CensusAnalyzerException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyzerException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
        }
    }
}
