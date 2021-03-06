package ua.holyk.springboot.currencyaggregationservice.file_filters;

import java.io.File;
import java.io.FilenameFilter;

/**
 * This class helps you to filter all files what located in files directory by file extension
 */
public class CSVFileFilter implements FilenameFilter {

    /**
     * This methods helps you to find all files with extension of .csv
     * @param dir File object what contains path to directory where all files are located
     * @param name Param what helps to find files with extension .csv
     * @return Value what helps to find required file
     */
    public boolean accept(File dir, String name) {
        return name.endsWith(".csv");
    }
}
