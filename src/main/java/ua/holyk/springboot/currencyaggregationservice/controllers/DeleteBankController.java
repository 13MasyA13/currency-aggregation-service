package ua.holyk.springboot.currencyaggregationservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.holyk.springboot.currencyaggregationservice.CurrencyAggregationServiceApplication;
import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;
import ua.holyk.springboot.currencyaggregationservice.tools.ExcludingBank;
import javax.ws.rs.DELETE;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class allow you to delete bank from app's data
 */
@RestController
public class DeleteBankController {

    /**
     * This method allows you to delete bank fro app's data by name of bank
     * @param bankName Bank what you whant to delete from app's data
     * @return Confirmation message
     */
    @DELETE
    @RequestMapping(value = "/deleteBank/{bankName}")
    public String deleteBankByName(@PathVariable String bankName) {

        boolean tmp = false;
        Iterator<String> iterator = CurrencyAggregationServiceApplication.bankNames.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().equals(bankName)){
                tmp = true;
            }
        }

        if(tmp == false){
            return null;
        }

        ExcludingBank excludingBank = new ExcludingBank();
        ArrayList<ExchangeRates> list = excludingBank.excludingSort
                (CurrencyAggregationServiceApplication.finalList, bankName);
        CurrencyAggregationServiceApplication.finalList = list;
        return "<h1> " + bankName + " has succesfully deleted!</h1>";
    }
}
