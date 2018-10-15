package ua.holyk.springboot.currencyaggregationservice.sorts;

import ua.holyk.springboot.currencyaggregationservice.CurrencyAggregationServiceApplication;
import ua.holyk.springboot.currencyaggregationservice.entities.Sells;
import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;

import java.util.ArrayList;

/**
 * This class helps you to sort all data to Sells objects
 */
public class BestSellSort {

    /**
     * This method helps you to sort all ExchangeRates objects to Sells objects
     * @param exchangeRates List of app's data
     * @return List of Sells objects
     */
    public ArrayList<Sells> bestSellSort(ArrayList<ExchangeRates> exchangeRates) {
        ArrayList<Sells> bestSellsList = new ArrayList<>();

        ArrayList<String> allCurrencies = new ArrayList<>(CurrencyAggregationServiceApplication.currencyCodes);

        for(int i = 0; i < allCurrencies.size(); i++) {
            String currentCurrencyCode = allCurrencies.get(i);

            CurrenciesSort sort = new CurrenciesSort();

            ArrayList<ExchangeRates> sortedList = sort.descendingSellSortWithExchanges(exchangeRates, currentCurrencyCode);

            Sells sells = new Sells(sortedList.get(0));
            sells.setNameOfBank(sortedList.get(0).getNameOfBank());
            sells.setSell(sortedList.get(0).getSell());
            sells.setCurrencyCode(currentCurrencyCode);


            bestSellsList.add(sells);

        }
        return bestSellsList;
    }
}
