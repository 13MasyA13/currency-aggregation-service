package ua.holyk.springboot.currencyaggregationservice.tools;

import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;
import java.util.ArrayList;

/**
 * This class helps you to do some things with currencies
 */
public class CurrencyOperations {

    /**
     * This method helps you to ban to sell via code of currency and name of bank
     * @param list List of all currencies in the app
     * @param code Code of currency what you want to ban to sell
     * @param bank Bank of currency what you want to ban to sell
     */
    public static void banSell(ArrayList<ExchangeRates> list, String code, String bank) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCurrencyCode().equals(code) &
            list.get(i).getNameOfBank().equals(bank)){
                list.get(i).setAllowedToSell(false);
                list.get(i).setReserveSell(list.get(i).getSell());
                list.get(i).setSell(0.0);
            } else {
                continue;
            }
        }
    }

    /**
     * This method allows you to ban currency's buy by code and bank param
     * @param code Code of currency what you want to ban to buy
     * @param bank Bank of currency what you want to ban to buy
     * @return Operation success (or not) message
     */
    public static void banBuy(ArrayList<ExchangeRates> list, String code, String bank) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCurrencyCode().equals(code) &
                    list.get(i).getNameOfBank().equals(bank)){
                list.get(i).setAllowedToBuy(false);
                list.get(i).setReserveBuy(list.get(i).getBuy());
                list.get(i).setBuy(0.0);
            } else {
                continue;
            }
        }
    }

    /**
     * This method allows you to allow currency's sell by code and bank param
     * @param code Code of currency what you want to allow to sell
     * @param bank Bank of currency what you want to allow to sell
     * @return
     */
    public static void allowSell(ArrayList<ExchangeRates> list, String code, String bank) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCurrencyCode().equals(code) &
                    list.get(i).getNameOfBank().equals(bank)){
                list.get(i).setAllowedToSell(true);
                list.get(i).setSell(list.get(i).getReserveSell());
            } else {
                continue;
            }
        }
    }

    /**
     * This method allows you to allow currency's buy by code and bank param
     * @param code Code of currency what you want to allow to buy
     * @param bank Bank of currency what you want to allow to buy
     * @return
     */
    public static void allowBuy(ArrayList<ExchangeRates> list, String code, String bank) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCurrencyCode().equals(code) &
                    list.get(i).getNameOfBank().equals(bank)){
                list.get(i).setAllowedToBuy(true);
                list.get(i).setBuy(list.get(i).getReserveBuy());
            } else {
                continue;
            }
        }
    }

    /**
     * This method allows you to set sell of currency what you choose via currency's code and bank
     * @param code Code of currency what you want to update
     * @param bank Bank of currency what you want to update
     * @param value Value what you want to set to currency's sell
     * @return
     */
    public static void setSell(ArrayList<ExchangeRates> list, String code, String bank, double sell) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCurrencyCode().equals(code) &
                    list.get(i).getNameOfBank().equals(bank)){
                list.get(i).setSell(sell);
            } else {
                continue;
            }
        }
    }

    /**
     * This method allows you to set buy of currency what you choose via currency's code and bank
     * @param code Code of currency what you want to update
     * @param bank Bank of currency what you want to update
     * @param value Value what you want to set to currency's buy
     * @return
     */
    public static void setBuy(ArrayList<ExchangeRates> list, String code, String bank, double buy) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCurrencyCode().equals(code) &
                    list.get(i).getNameOfBank().equals(bank)){
                list.get(i).setBuy(buy);
            } else {
                continue;
            }
        }
    }
}
