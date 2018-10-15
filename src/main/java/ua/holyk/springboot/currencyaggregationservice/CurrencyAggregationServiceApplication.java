package ua.holyk.springboot.currencyaggregationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;
import ua.holyk.springboot.currencyaggregationservice.file_filters.BankFilesFilter;
import ua.holyk.springboot.currencyaggregationservice.parsers.MyCSVParser;
import ua.holyk.springboot.currencyaggregationservice.parsers.MyJSONParser;
import ua.holyk.springboot.currencyaggregationservice.parsers.MyXMLParser;
import ua.holyk.springboot.currencyaggregationservice.tools.ConcatCurrenciesLists;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Class for executing app
 */
@SpringBootApplication
public class CurrencyAggregationServiceApplication {

    public static HashSet<String> currencyCodes = new HashSet<>();
    public static HashSet<String> bankNames = new HashSet<>();
    public static HashSet<String> fileNames = new HashSet<>();
    public static ArrayList<ExchangeRates> finalList;


    /**
     * Main method of app
     * @param args Console arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CurrencyAggregationServiceApplication.class, args);

        BankFilesFilter bankFilesFilter = new BankFilesFilter();

        ArrayList<File> CSV_files = bankFilesFilter.CSVFiles();
        ArrayList<File> XML_files = bankFilesFilter.XMLFiles();
        ArrayList<File> JSON_files = bankFilesFilter.JSONFiles();

        MyJSONParser myJSONParser = new MyJSONParser();
        ArrayList<ExchangeRates> json = myJSONParser.parseListOfFiles(JSON_files);

        MyCSVParser myCSVParser = new MyCSVParser();
        ArrayList<ExchangeRates> csv = myCSVParser.parseListOfFiles(CSV_files);

        MyXMLParser myXMLParser = new MyXMLParser();
        ArrayList<ExchangeRates> xml = myXMLParser.parseListOfFiles(XML_files);

        finalList = ConcatCurrenciesLists.concatLists(xml, json, csv);
        finalList.stream().forEach(x -> System.out.println(x));
    }
}
