package ua.holyk.springboot.currencyaggregationservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.holyk.springboot.currencyaggregationservice.CurrencyAggregationServiceApplication;
import ua.holyk.springboot.currencyaggregationservice.entities.Buys;
import ua.holyk.springboot.currencyaggregationservice.entities.Sells;

import ua.holyk.springboot.currencyaggregationservice.sorts.CurrenciesSort;

import javax.ws.rs.GET;
import java.util.ArrayList;

/**
 * This class allows you to get currencies sorted (or not) by ascending or descending
 */
@RestController
public class SellsBuysController {

    CurrenciesSort currenciesSort = new CurrenciesSort();

    /**
     * This method allows you to get currencies buys by code param
     * @param code Code of currency what you want to get
     * @return ArrayList of currencies filtered by code param
     */
    @GET
    @RequestMapping("/buys/{code}/")
    public ArrayList<Buys> getBuyOfCodeWithoutSort(@PathVariable String code) {
        return currenciesSort.buySort(CurrencyAggregationServiceApplication.finalList, code);
    }

    /**
     * This method allows you to get currencies buys by code param and type of sort
     * @param code Code of currency what you want to get
     * @param typeOfSort Type of sort what you want to do (descending or ascending)
     * @return ArrayList of currencies filtered by code param and sorted by sort type
     */
    @GET
    @RequestMapping("/buys/{code}/{typeOfSort}")
    public ArrayList<Buys> getBuyOfCodeWithSort(@PathVariable String code,
                                                @PathVariable String typeOfSort) {
        switch (typeOfSort) {
            case"descendingSort":
                return currenciesSort.descendingBuySort(CurrencyAggregationServiceApplication.finalList,
                        code);

            case"ascendingSort":
                return currenciesSort.ascendingBuySort(CurrencyAggregationServiceApplication.finalList,
                        code);
            default:
                return null;
        }
    }

    /**
     * This method allows you to get currencies sells by code
     * @param code Code of currency what you want to get
     * @return ArrayList of currencies filtered by code param
     */
    @GET
    @RequestMapping("/sells/{code}/")
    public ArrayList<Sells> getSellOfCodeWithoutSort(@PathVariable String code) {
        return currenciesSort.sellSort(CurrencyAggregationServiceApplication.finalList, code);
    }

    /**
     * This method allows you to get currencies sells by code param and type of sort
     * @param code Code of currency what you want to get
     * @param typeOfSort Type of sort what you want to do (descending or ascending)
     * @return ArrayList of currencies filtered by code param and sorted by sort type
     */
    @GET
    @RequestMapping("/sells/{code}/{typeOfSort}")
    public ArrayList<Sells> getSellOfCodeWithSort(@PathVariable String code,
                                                  @PathVariable String typeOfSort) {
        switch (typeOfSort) {
            case"descendingSort":
                return currenciesSort.descendingSellSort(CurrencyAggregationServiceApplication.finalList,
                        code);
            case"ascendingSort":
                return currenciesSort.ascendingSellSort(CurrencyAggregationServiceApplication.finalList,
                        code);
            default:
                return null;
        }
    }
}
