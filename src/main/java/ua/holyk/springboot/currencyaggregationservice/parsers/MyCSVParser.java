package ua.holyk.springboot.currencyaggregationservice.parsers;

import au.com.bytecode.opencsv.CSVReader;
import ua.holyk.springboot.currencyaggregationservice.CurrencyAggregationServiceApplication;
import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;
import ua.holyk.springboot.currencyaggregationservice.tools.EditBankName;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class allows you to parse .csv files
 */
public class MyCSVParser implements Parse {

    EditBankName editBankName = new EditBankName();

    /**
     * This method parses all .csv files to ExchangeRates objects
     * @param files ArrayList of files witch defines in folder for parse
     * @return ArrayList of ExchangeRates objects
     */
    @Override
    public ArrayList<ExchangeRates> parseListOfFiles(ArrayList<File> files) {
        ArrayList<ExchangeRates> currencyList = new ArrayList<>();
        try {
            for (int i = 0; i < files.size(); i++) {
                CSVReader csvReader = new CSVReader(new FileReader(files.get(i)),
                        ',', '"', 0);
                String[] nextLine;
                while ((nextLine = csvReader.readNext()) != null) {
                    if (nextLine != null) {
                        ExchangeRates exchangeRates = new ExchangeRates();
                        exchangeRates.setNameOfBank(editBankName.editBankName(files.get(i).getName()));
                        exchangeRates.setCurrencyCode(nextLine[0]);
                        exchangeRates.setBuy(Double.parseDouble(nextLine[1]));
                        exchangeRates.setSell(Double.parseDouble(nextLine[2]));

                        exchangeRates.setAllowedToBuy(true);
                        exchangeRates.setAllowedToSell(true);

                        CurrencyAggregationServiceApplication.currencyCodes.add(nextLine[0]);
                        CurrencyAggregationServiceApplication.bankNames.add(exchangeRates.getNameOfBank());
                        CurrencyAggregationServiceApplication.fileNames.add(files.get(i).getName());

                        currencyList.add(exchangeRates);
                    }
                }
            }
        } catch (FileNotFoundException exc) {
            System.out.println("FileNotFoundException : " + exc.toString());
        } catch (IOException exc) {
            System.out.println("IOException : " + exc.toString());
        }
        return currencyList;
    }

    /**
     * This method helps to parse one file with .csv extension
     * @param file File what you want to parse to ExchangeRates object
     * @return ExchangeRates object
     */
    @Override
    public ArrayList<ExchangeRates> parseOneFile(File file) {
        ArrayList<ExchangeRates> list = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file),
                    ',', '"', 0);
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                if (nextLine != null) {
                    ExchangeRates exchangeRates = new ExchangeRates();
                    exchangeRates.setNameOfBank(editBankName.editBankName(file.getName()));
                    exchangeRates.setCurrencyCode(nextLine[0]);
                    exchangeRates.setBuy(Double.parseDouble(nextLine[1]));
                    exchangeRates.setSell(Double.parseDouble(nextLine[2]));
                    exchangeRates.setAllowedToSell(true);
                    exchangeRates.setAllowedToBuy(true);

                    CurrencyAggregationServiceApplication.currencyCodes.add(nextLine[0]);
                    CurrencyAggregationServiceApplication.bankNames.add(exchangeRates.getNameOfBank());
                    CurrencyAggregationServiceApplication.finalList.add(exchangeRates);
                    CurrencyAggregationServiceApplication.fileNames.add(file.getName());

                    list.add(exchangeRates);
                }
            }
        } catch (FileNotFoundException exc) {
            System.out.println(exc.toString());
        } catch (IOException exc) {
            System.out.println(exc.toString());
        }

        return list;
    }
}
