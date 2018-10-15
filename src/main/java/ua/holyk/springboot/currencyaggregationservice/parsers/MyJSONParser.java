package ua.holyk.springboot.currencyaggregationservice.parsers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ua.holyk.springboot.currencyaggregationservice.CurrencyAggregationServiceApplication;
import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;
import ua.holyk.springboot.currencyaggregationservice.tools.EditBankName;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class allows you to parse .json files
 */
public class MyJSONParser implements Parse {

    EditBankName editBankName = new EditBankName();

    /**
     * This method parses all .json files to ExchangeRates objects
     * @param files ArrayList of files witch defines in folder for parse
     * @return ArrayList of ExchangeRates objects
     */
    @Override
    public ArrayList<ExchangeRates> parseListOfFiles(ArrayList<File> files) {
        ArrayList<ExchangeRates> currencyList = new ArrayList<>();

        for(int i = 0; i < files.size(); i++) {
            try {
                Object obj = new JSONParser().parse(new FileReader(files.get(i)));
                JSONObject jsonObject = (JSONObject) obj;

                String bankName = editBankName.editBankName(files.get(i).getName());

                for(int j = 0; j < jsonObject.size(); j++) {
                    Object currencyObject = jsonObject.get("currency-" + j);
                    JSONObject currencyJSONobject = (JSONObject) currencyObject;

                    String currencyCode = (String) currencyJSONobject.get("currency-code");
                    Double buy = (Double) currencyJSONobject.get("buy");
                    Double sell = (Double) currencyJSONobject.get("sell");

                    ExchangeRates exchangeRates = new ExchangeRates();
                    exchangeRates.setNameOfBank(bankName);
                    exchangeRates.setCurrencyCode(currencyCode);
                    exchangeRates.setBuy(buy);
                    exchangeRates.setSell(sell);
                    exchangeRates.setAllowedToBuy(true);
                    exchangeRates.setAllowedToSell(true);

                    CurrencyAggregationServiceApplication.currencyCodes.add(currencyCode);
                    CurrencyAggregationServiceApplication.bankNames.add(bankName);
                    CurrencyAggregationServiceApplication.fileNames.add(files.get(i).getName());

                    currencyList.add(exchangeRates);
                }
            } catch (ParseException exc) {
                System.out.println("Parse Exception : " + exc.toString());
            } catch (IOException exc) {
                System.out.println("IOException : " + exc.toString());
            }
        }
        return currencyList;
    }

    /**
     * This method helps to parse one file with .json extension
     * @param file File what you want to parse to ExchangeRates object
     * @return ExchangeRates object
     */
    @Override
    public ArrayList<ExchangeRates> parseOneFile(File file) {
        ArrayList<ExchangeRates> list = new ArrayList<>();
        try {
            Object obj = new JSONParser().parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;

            String bankName = editBankName.editBankName(file.getName());

            for(int j = 0; j < jsonObject.size(); j++) {
                Object currencyObject = jsonObject.get("currency-" + j);
                JSONObject currencyJSONobject = (JSONObject) currencyObject;

                String currencyCode = (String) currencyJSONobject.get("currency-code");
                Double buy = (Double) currencyJSONobject.get("buy");
                Double sell = (Double) currencyJSONobject.get("sell");

                ExchangeRates exchangeRates = new ExchangeRates();
                exchangeRates.setNameOfBank(bankName);
                exchangeRates.setCurrencyCode(currencyCode);
                exchangeRates.setBuy(buy);
                exchangeRates.setSell(sell);
                exchangeRates.setAllowedToBuy(true);
                exchangeRates.setAllowedToSell(true);

                CurrencyAggregationServiceApplication.currencyCodes.add(currencyCode);
                CurrencyAggregationServiceApplication.bankNames.add(bankName);
                CurrencyAggregationServiceApplication.fileNames.add(file.getName());
                CurrencyAggregationServiceApplication.finalList.add(exchangeRates);
                list.add(exchangeRates);
            }
        } catch (ParseException exc) {
            System.out.println("Parse Exception : " + exc.toString());
        } catch (IOException exc) {
            System.out.println("IOException : " + exc.toString());
        }

        return list;
    }
}
