package ua.holyk.springboot.currencyaggregationservice.file_filters;

import java.io.File;
import java.util.ArrayList;

/**
 * This interface helps to filter all files by extensions
 */
public interface Filter {

    /**
     * Realisation of this method helps you to filter from all of files only .json files
     * @return ArrayList of JSON files
     */
    ArrayList<File> JSONFiles();

    /**
     * Realisation of this method helps you to filter from all of files only .xml files
     * @return ArrayList of XML files
     */
    ArrayList<File> XMLFiles();

    /**
     * Realisation of this method helps you to filter from all of files only .csv files
     * @return ArrayList of CSV files
     */
    ArrayList<File> CSVFiles();
}
