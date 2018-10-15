package ua.holyk.springboot.currencyaggregationservice.entities;

/**
 * This entity contains currencies for get buy data
 */
public class Buys {

    private double buy;

    private String nameOfBank;
    private String currencyCode;

    public Buys(ExchangeRates exchangeRates) {
        this.nameOfBank = exchangeRates.getNameOfBank();
        this.currencyCode = exchangeRates.getCurrencyCode();
        if(exchangeRates.isAllowedToBuy() == false) {
            this.buy = 0.0;
        } else {
            this.buy = exchangeRates.getBuy();
        }
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
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
        return "Buys{" +
                "buy=" + buy +
                ", nameOfBank='" + nameOfBank + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
