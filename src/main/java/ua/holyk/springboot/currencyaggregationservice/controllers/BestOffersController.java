package ua.holyk.springboot.currencyaggregationservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.holyk.springboot.currencyaggregationservice.CurrencyAggregationServiceApplication;
import ua.holyk.springboot.currencyaggregationservice.entities.BestOffer;
import ua.holyk.springboot.currencyaggregationservice.entities.Buys;
import ua.holyk.springboot.currencyaggregationservice.entities.Sells;
import ua.holyk.springboot.currencyaggregationservice.sorts.BestBuySort;
import ua.holyk.springboot.currencyaggregationservice.sorts.BestSellSort;
import ua.holyk.springboot.currencyaggregationservice.sorts.CurrenciesSort;

import javax.ws.rs.GET;
import java.util.ArrayList;

/**
 * This class allows you to display best offers of buy/sell currencies
 */
@RestController
public class BestOffersController {

    BestBuySort bestBuySort = new BestBuySort();
    BestSellSort bestSellSort = new BestSellSort();

    /**
     * This method allows you to display best offers of buy/sell currencies
     * @return ArrayList of all best offers
     */
    @GET
    @RequestMapping("/bestOffers")
    public ArrayList<BestOffer> getBestOffers(){
        ArrayList<Buys> bestBuys = bestBuySort.bestBuySort(CurrencyAggregationServiceApplication.finalList);
        ArrayList<Sells> bestSells = bestSellSort.bestSellSort(CurrencyAggregationServiceApplication.finalList);

        ArrayList<BestOffer> bestOffers = new ArrayList<>();
        for(int i = 0; i < bestBuys.size(); i++) {
            BestOffer bestOffer = new BestOffer(bestBuys.get(i), bestSells.get(i));
            bestOffers.add(bestOffer);
        }
        return bestOffers;
    }
}
