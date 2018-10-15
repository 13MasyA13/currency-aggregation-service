package ua.holyk.springboot.currencyaggregationservice.tools;

import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;

import java.util.ArrayList;

/**
 * This interface helps to define method to delete bank from the app's memory
 */
public interface ExcludingSort {

    /**
     *
     * Realisation of this method helps you to delete bank from app's memory what you want to delete
     * @param exchangeRates ArrayList what contains app's data
     * @param bankName Bank what you want to delete
     * @return ArrayList without bank what you want to delete
     */
    ArrayList<ExchangeRates> excludingSort(ArrayList<ExchangeRates> exchangeRates, String bankName);
}
