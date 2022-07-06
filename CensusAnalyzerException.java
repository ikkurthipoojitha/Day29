package org.example;

public class CensusAnalyzerException extends Exception {
    enum ExceptionType {
        CENSUS_FILE_PROBLEM,
        BINDING_PROBLEM_AT_RUNTIME,
        INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER
    }

    ExceptionType type;

    public CensusAnalyzerException(String message, ExceptionType type) {
        super(message);
        this.type = type;


    }

    public CensusAnalyzerException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
