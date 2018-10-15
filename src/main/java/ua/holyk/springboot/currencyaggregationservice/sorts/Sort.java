package ua.holyk.springboot.currencyaggregationservice.sorts;

import ua.holyk.springboot.currencyaggregationservice.entities.Buys;
import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;
import ua.holyk.springboot.currencyaggregationservice.entities.Sells;

import java.util.ArrayList;

public interface Sort {

    /**
     * Realisation of this method helps you to ascending sort Buys objects by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to ascending sort
     * @return List of Buys objects sorted by ascending
     */
    ArrayList<Buys> ascendingBuySort(ArrayList<ExchangeRates> exchangeRates, String currencyCode);

    /**
     * Realisation of this method helps you to descending sort Buys objects by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to descending sort
     * @return List of Buys objects sorted by descending
     */
    ArrayList<Buys> descendingBuySort(ArrayList<ExchangeRates> exchangeRates, String currencyCode);

    /**
     * Realisation of this method helps you to ascending sort Sells objects by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to ascending sort
     * @return List of Sells objects sorted by ascending
     */
    ArrayList<Sells> ascendingSellSort(ArrayList<ExchangeRates> exchangeRates, String currencyCode);

    /**
     * Realisation of this method helps you to ascending sort Sells objects by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to descending sort
     * @return List of Sells objects sorted by descending
     */
    ArrayList<Sells> descendingSellSort(ArrayList<ExchangeRates> exchangeRates, String currencyCode);

    /**
     * Realisation of this method allows you to sort all currency only by buy by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to sort
     * @return ArrayList of sorted currencies by buy and by currency code
     */
    ArrayList<Buys> buySort(ArrayList<ExchangeRates> exchangeRates, String currencyCode);

    /**
     * Realisation of this method allows you to sort all currency only by sell and by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to sort
     * @return ArrayList of sorted currencies by sell and by currency code
     */
    ArrayList<Sells> sellSort(ArrayList<ExchangeRates> exchangeRates, String currencyCode);

    /**
     * Realisation of this method helps you to sort ExchangeRates objects by descending, by buys and by curreny code
     * @param exchangeRates List of app's data
     * @param currencyCode Currency code of currency what you want to sort
     * @return ArrayList of sorted currencies by descending,by buys and by currency code
     */
    ArrayList<ExchangeRates> descendingBuySortWithExchanges(ArrayList<ExchangeRates> exchangeRates, String currencyCode);

    /**
     * Realisation of this method helps you to sort ExchangeRates objects by descending, by sells and by curreny code
     * @param exchangeRates List of app's data
     * @param currencyCode Currency code of currency what you want to sort
     * @return ArrayList of sorted currencies by descending, by sells and by currency code
     */
    ArrayList<ExchangeRates> descendingSellSortWithExchanges(ArrayList<ExchangeRates> exchangeRates, String currencyCode);
}
