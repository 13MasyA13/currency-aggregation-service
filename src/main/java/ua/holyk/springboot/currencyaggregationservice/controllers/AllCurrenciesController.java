package ua.holyk.springboot.currencyaggregationservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.holyk.springboot.currencyaggregationservice.CurrencyAggregationServiceApplication;
import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;

import javax.ws.rs.GET;
import java.util.ArrayList;

/**
 * This class allows you to get all data of app
 */
@RestController
public class AllCurrenciesController {

    /**
     * This method allows you to get all currencies of app
     * @return ArrayList of all currencies avalible in app
     */
    @GET
    @RequestMapping("/allCurrencies")
    public ArrayList<ExchangeRates> getAllCurrencies(){
        return CurrencyAggregationServiceApplication.finalList;
    }
}
