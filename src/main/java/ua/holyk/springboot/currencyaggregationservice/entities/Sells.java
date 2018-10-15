package ua.holyk.springboot.currencyaggregationservice.entities;

/**
 * This entity contains currencies for get sell data
 */
public class Sells {

    private double sell;

    private String nameOfBank;
    private String currencyCode;

    public Sells(ExchangeRates exchangeRates) {
        this.nameOfBank = exchangeRates.getNameOfBank();
        this.currencyCode = exchangeRates.getCurrencyCode();
        if(exchangeRates.isAllowedToSell() == false) {
            this.sell = 0.0;
        } else {
            this.sell = exchangeRates.getSell();
        }
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "Sells{" +
                "sell=" + sell +
                ", nameOfBank='" + nameOfBank + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
