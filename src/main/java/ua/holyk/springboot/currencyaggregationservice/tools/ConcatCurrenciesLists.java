package ua.holyk.springboot.currencyaggregationservice.tools;

import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;
import java.util.ArrayList;

/**
 * This class helps to union couple ArrayLists of ExchangeRates objects
 */
public class ConcatCurrenciesLists {

    /**
     * This method helps you to union couple ArrayLists of parsed objects
     * @param xmlList List of parsed XML objects
     * @param jsonList List of parsed JSON objects
     * @param csvList List of parsed CSV objects
     * @return List of all data in the all app
     */
    public static ArrayList<ExchangeRates> concatLists(ArrayList<ExchangeRates> xmlList,
                                                       ArrayList<ExchangeRates> jsonList, ArrayList<ExchangeRates> csvList){
        ArrayList<ExchangeRates> finalList = new ArrayList<>();

        xmlList.stream().forEach(x -> finalList.add(x));
        jsonList.stream().forEach(x -> finalList.add(x));
        csvList.stream().forEach(x -> finalList.add(x));

        return finalList;
    }
}
