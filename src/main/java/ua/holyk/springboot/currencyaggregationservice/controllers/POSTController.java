package ua.holyk.springboot.currencyaggregationservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.holyk.springboot.currencyaggregationservice.CurrencyAggregationServiceApplication;
import ua.holyk.springboot.currencyaggregationservice.tools.CurrencyOperations;
import javax.ws.rs.POST;

/**
 * This class allows you to update some fields of avalible currencies
 */
@RestController
public class POSTController {

    /**
     * This method allows you to ban currency's sell by code and bank param via HTTP request
     * @param code Code of currency what you want to ban
     * @param bank Bank of currency what you want to ban
     * @return Confirmation message and link to check what's wrong
     */
    @POST
    @RequestMapping("/{bank}/{code}/banSell")
    public String banSell(@PathVariable String code, @PathVariable String bank) {
        CurrencyOperations.banSell(CurrencyAggregationServiceApplication.finalList, code, bank);
        return "<h1> Currency with code " + code + " from bank " + bank + " got banned to sell";
    }

    /**
     * This method allows you to ban currency's buy by code and bank param via HTTP request
     * @param code Code of currency what you want to ban to buy
     * @param bank Bank of currency what you want to ban to buy
     * @return Confirmation message and link to check what's wrong
     */
    @POST
    @RequestMapping("/{bank}/{code}/banBuy")
    public String banBuy(@PathVariable String code, @PathVariable String bank) {
        CurrencyOperations.banBuy(CurrencyAggregationServiceApplication.finalList, code, bank);
        return "<h1> Currency with code " + code + " from bank " + bank + " got banned to buy";
    }

    /**
     * This method allows you to allow currency's sell by code and bank param via HTTP request
     * @param code Code of currency what you want to allow to sell
     * @param bank Bank of currency what you want to allow to sell
     * @return Confirmation message and link to check what's wrong
     */
    @POST
    @RequestMapping("/{bank}/{code}/allowSell")
    public String allowSell(@PathVariable String code, @PathVariable String bank) {
        CurrencyOperations.allowSell(CurrencyAggregationServiceApplication.finalList, code, bank);
        return "<h1> Currency with code " + code + " from bank " + bank + " got allowed to sell";
    }

    /**
     * This method allows you to allow currency's buy by code and bank param via HTTP request
     * @param code Code of currency what you want to allow to buy
     * @param bank Bank of currency what you want to allow to buy
     * @return Confirmation message and link to check what's wrong
     */
    @POST
    @RequestMapping("/{bank}/{code}/allowBuy")
    public String allowBuy(@PathVariable String code, @PathVariable String bank) {
        CurrencyOperations.allowBuy(CurrencyAggregationServiceApplication.finalList, code, bank);
        return "<h1> Currency with code " + code + " from bank " + bank + " got allowed to buy";
    }

    /**
     * This method allows you to set sell of currency what you choose via currency's code and bank via HTTP request
     * @param code Code of currency what you want to update
     * @param bank Bank of currency what you want to update
     * @param value Value what you want to set to currency's sell
     * @return Confirmation message and link to check what's wrong
     */
    @POST
    @RequestMapping("/{bank}/{code}/setSell/{value}")
    public String setSell(@PathVariable String code, @PathVariable String bank,
                          @PathVariable double value) {
        CurrencyOperations.setSell(CurrencyAggregationServiceApplication.finalList, code, bank, value);
        return "<h1> Currency's 'sell' with code " + code + " from bank " + bank + " got updated to " + value;
    }

    /**
     * This method allows you to set buy of currency what you choose via currency's code and bank via HTTP request
     * @param code Code of currency what you want to update
     * @param bank Bank of currency what you want to update
     * @param value Value what you want to set to currency's buy
     * @return Confirmation message and link to check what's wrong
     */
    @POST
    @RequestMapping("/{bank}/{code}/setBuy/{value}")
    public String setBuy(@PathVariable String code, @PathVariable String bank,
                         @PathVariable double value) {
        CurrencyOperations.setBuy(CurrencyAggregationServiceApplication.finalList, code, bank, value);
        return "<h1> Currency's 'buy' with code " + code + " from bank " + bank + " got updated to " + value;
    }
}
