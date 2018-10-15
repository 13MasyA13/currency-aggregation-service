package ua.holyk.springboot.currencyaggregationservice.tools;

import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * This class allows you to delete bank what you want to delete
 */
public class ExcludingBank implements ExcludingSort {

    /**
     * This method allows you to delete bank from app's memory what you want to delete
     * @param exchangeRates ArrayList what contains app's data
     * @param bankName Bank what you want to delete
     * @return ArrayList without bank what you want to delete
     */
    @Override
    public ArrayList<ExchangeRates> excludingSort(ArrayList<ExchangeRates> exchangeRates, String bankName) {
        ArrayList<ExchangeRates> filteredList =
                (ArrayList<ExchangeRates>) exchangeRates.stream().
                        filter(x -> !x.getNameOfBank().equals(bankName))
                        .collect(Collectors.toList());
        return filteredList;
    }
}
