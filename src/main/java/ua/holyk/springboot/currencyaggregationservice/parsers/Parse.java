package ua.holyk.springboot.currencyaggregationservice.parsers;

import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;
import java.io.File;
import java.util.ArrayList;

/**
 * This interface helps you to declare methods to parse List of files or single file
 */
public interface Parse {

    /**
     * Realisation of this method helps you to parse List of files
     * @param files ArrayList of files
     * @return ArrayList of Exchange objects
     */
    ArrayList<ExchangeRates> parseListOfFiles(ArrayList<File> files);

    /**
     * Realisation of this method helps you to parse one single file
     * @param file FIle what you want to parse
     * @return ExchangeRates object
     */
    ArrayList<ExchangeRates> parseOneFile(File file);
}
