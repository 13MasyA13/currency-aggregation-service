package ua.holyk.springboot.currencyaggregationservice.sorts;

import ua.holyk.springboot.currencyaggregationservice.entities.Buys;
import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;
import ua.holyk.springboot.currencyaggregationservice.entities.Sells;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * This class helps you to sort currencies
 */
public class CurrenciesSort implements Sort {

    /**
     * This method helps you to ascending sort Buys objects by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to ascending sort
     * @return List of Buys objects sorted by ascending
     */
    public ArrayList<Buys> ascendingBuySort(ArrayList<ExchangeRates> exchangeRates, String currencyCode) {
        ArrayList<ExchangeRates> filteredList =
                (ArrayList<ExchangeRates>) exchangeRates
                        .stream().filter(x -> x.getCurrencyCode().equals(currencyCode))
                        .collect(Collectors.toList());

        filteredList.sort(new Comparator<ExchangeRates>() {
            @Override
            public int compare(ExchangeRates o1, ExchangeRates o2) {
                if(o1.getBuy() > o2.getBuy()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        ArrayList<Buys> buysList = new ArrayList<>(filteredList.size());
        for(int i = 0; i < filteredList.size(); i++) {
            Buys buys = new Buys(filteredList.get(i));
            buysList.add(buys);
        }
        return buysList;
    }

    /**
     * This method helps you to descending sort Buys objects by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to descending sort
     * @return List of Buys objects sorted by descending
     */
    public ArrayList<Buys> descendingBuySort(ArrayList<ExchangeRates> exchangeRates, String currencyCode) {
        ArrayList<ExchangeRates> filteredList =
                (ArrayList<ExchangeRates>) exchangeRates
                        .stream().filter(x -> x.getCurrencyCode().equals(currencyCode))
                        .collect(Collectors.toList());

        filteredList.sort(new Comparator<ExchangeRates>() {
            @Override
            public int compare(ExchangeRates o1, ExchangeRates o2) {
                if(o1.getBuy() < o2.getBuy()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        ArrayList<Buys> buysList = new ArrayList<>(filteredList.size());
        for(int i = 0; i < filteredList.size(); i++) {
            Buys buys = new Buys(filteredList.get(i));
            buysList.add(buys);
        }
        return buysList;
    }

    /**
     * This method helps you to ascending sort Sells objects by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to ascending sort
     * @return List of Sells objects sorted by ascending
     */
    @Override
    public ArrayList<Sells> ascendingSellSort(ArrayList<ExchangeRates> exchangeRates, String currencyCode) {
        ArrayList<ExchangeRates> filteredList =
                (ArrayList<ExchangeRates>) exchangeRates
                        .stream().filter(x -> x.getCurrencyCode().equals(currencyCode))
                        .collect(Collectors.toList());

        filteredList.sort(new Comparator<ExchangeRates>() {
            @Override
            public int compare(ExchangeRates o1, ExchangeRates o2) {
                if(o1.getSell() > o2.getSell()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        ArrayList<Sells> sellsList = new ArrayList<>(filteredList.size());
        for(int i = 0; i < filteredList.size(); i++) {
            Sells buys = new Sells(filteredList.get(i));
            sellsList.add(buys);
        }
        return sellsList;
    }

    /**
     * This method helps you to ascending sort Sells objects by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to descending sort
     * @return List of Sells objects sorted by descending
     */
    @Override
    public ArrayList<Sells> descendingSellSort(ArrayList<ExchangeRates> exchangeRates, String currencyCode) {
        ArrayList<ExchangeRates> filteredList =
                (ArrayList<ExchangeRates>) exchangeRates
                        .stream().filter(x -> x.getCurrencyCode().equals(currencyCode))
                        .collect(Collectors.toList());

        filteredList.sort(new Comparator<ExchangeRates>() {
            @Override
            public int compare(ExchangeRates o1, ExchangeRates o2) {
                if(o1.getSell() < o2.getSell()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        ArrayList<Sells> sellsList = new ArrayList<>(filteredList.size());
        for(int i = 0; i < filteredList.size(); i++) {
            Sells buys = new Sells(filteredList.get(i));
            sellsList.add(buys);
        }
        return sellsList;
    }

    /**
     * This method allows you to sort all currency only by buy by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to sort
     * @return ArrayList of sorted currencies by buy and by currency code
     */
    @Override
    public ArrayList<Buys> buySort(ArrayList<ExchangeRates> exchangeRates, String currencyCode) {
        ArrayList<ExchangeRates> filteredList =
                (ArrayList<ExchangeRates>) exchangeRates
                        .stream().filter(x -> x.getCurrencyCode().equals(currencyCode))
                        .collect(Collectors.toList());

        ArrayList<Buys> buysList = new ArrayList<>(filteredList.size());
        for(int i = 0; i < filteredList.size(); i++) {
            Buys buys = new Buys(filteredList.get(i));
            buysList.add(buys);
        }
        return buysList;
    }

    /**
     * This method allows you to sort all currency only by sell and by currency code
     * @param exchangeRates List of app's data
     * @param currencyCode Code of currency what you want to sort
     * @return ArrayList of sorted currencies by sell and by currency code
     */
    @Override
    public ArrayList<Sells> sellSort(ArrayList<ExchangeRates> exchangeRates, String currencyCode) {
        ArrayList<ExchangeRates> filteredList =
                (ArrayList<ExchangeRates>) exchangeRates
                        .stream().filter(x -> x.getCurrencyCode().equals(currencyCode))
                        .collect(Collectors.toList());

        ArrayList<Sells> sellsList = new ArrayList<>(filteredList.size());
        for(int i = 0; i < filteredList.size(); i++) {
            Sells buys = new Sells(filteredList.get(i));
            sellsList.add(buys);
        }
        return sellsList;
    }

    /**
     * This method helps you to sort ExchangeRates objects by descending, by buys and by curreny code
     * @param exchangeRates List of app's data
     * @param currencyCode Currency code of currency what you want to sort
     * @return ArrayList of sorted currencies by descending,by buys and by currency code
     */
    @Override
    public ArrayList<ExchangeRates> descendingBuySortWithExchanges(ArrayList<ExchangeRates> exchangeRates, String currencyCode) {
        ArrayList<ExchangeRates> filteredList =
                (ArrayList<ExchangeRates>) exchangeRates
                        .stream().filter(x -> x.getCurrencyCode().equals(currencyCode))
                        .collect(Collectors.toList());

        filteredList.sort(new Comparator<ExchangeRates>() {
            @Override
            public int compare(ExchangeRates o1, ExchangeRates o2) {
                if(o1.getBuy() < o2.getBuy()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        return filteredList;
    }

    /**
     * This method helps you to sort ExchangeRates objects by descending, by sells and by curreny code
     * @param exchangeRates List of app's data
     * @param currencyCode Currency code of currency what you want to sort
     * @return ArrayList of sorted currencies by descending, by sells and by currency code
     */
    @Override
    public ArrayList<ExchangeRates> descendingSellSortWithExchanges(ArrayList<ExchangeRates> exchangeRates, String currencyCode) {
        ArrayList<ExchangeRates> filteredList =
                (ArrayList<ExchangeRates>) exchangeRates
                        .stream().filter(x -> x.getCurrencyCode().equals(currencyCode))
                        .collect(Collectors.toList());

        filteredList.sort(new Comparator<ExchangeRates>() {
            @Override
            public int compare(ExchangeRates o1, ExchangeRates o2) {
                if(o1.getSell() < o2.getSell()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        return filteredList;
    }
}
