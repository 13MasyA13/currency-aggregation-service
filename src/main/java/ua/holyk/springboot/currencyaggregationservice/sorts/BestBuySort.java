package ua.holyk.springboot.currencyaggregationservice.sorts;

import ua.holyk.springboot.currencyaggregationservice.CurrencyAggregationServiceApplication;
import ua.holyk.springboot.currencyaggregationservice.entities.Buys;
import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;

import java.util.ArrayList;

/**
 * This class helps you to sort all data to Buys objects
 */
public class BestBuySort {

    /**
     * This method helps you to sort all ExchangeRates objects to Buys objects
     * @param exchangeRates List of app's data
     * @return List of Buys objects
     */
    public ArrayList<Buys> bestBuySort(ArrayList<ExchangeRates> exchangeRates){
        ArrayList<Buys> bestBuysList = new ArrayList<>();

        ArrayList<String> allCurrencies = new ArrayList<>(CurrencyAggregationServiceApplication.currencyCodes);

        for(int i = 0; i < allCurrencies.size(); i++) {
            String currentCurrencyCode = allCurrencies.get(i);

            CurrenciesSort currenciesSort = new CurrenciesSort();
            ArrayList<ExchangeRates> sortedList = currenciesSort.descendingBuySortWithExchanges(exchangeRates, currentCurrencyCode);

            Buys buys = new Buys(sortedList.get(0));
            buys.setNameOfBank(sortedList.get(0).getNameOfBank());
            buys.setBuy(sortedList.get(0).getBuy());
            buys.setCurrencyCode(currentCurrencyCode);

            bestBuysList.add(buys);

        }
        return bestBuysList;
    }
}
