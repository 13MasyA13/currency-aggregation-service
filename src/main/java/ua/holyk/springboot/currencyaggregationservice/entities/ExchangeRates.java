package ua.holyk.springboot.currencyaggregationservice.entities;

/**
 * This entity contains all fields what contains currencies in app
 */
public class ExchangeRates {

    private String currencyCode;

    private double buy;
    private double sell;

    private double reserveBuy;
    private double reserveSell;

    private boolean isAllowedToBuy;
    private boolean isAllowedToSell;

    private String nameOfBank;

    public ExchangeRates() {

    }

    public ExchangeRates(String currencyCode, double buy, double sell, double reserveBuy, double reserveSell, boolean isAllowedToBuy, boolean isAllowedToSell, String nameOfBank) {
        this.currencyCode = currencyCode;
        this.buy = buy;
        this.sell = sell;
        this.reserveBuy = reserveBuy;
        this.reserveSell = reserveSell;
        this.isAllowedToBuy = isAllowedToBuy;
        this.isAllowedToSell = isAllowedToSell;
        this.nameOfBank = nameOfBank;
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

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public boolean isAllowedToBuy() {
        return isAllowedToBuy;
    }

    public void setAllowedToBuy(boolean allowedToBuy) {
        isAllowedToBuy = allowedToBuy;
    }

    public boolean isAllowedToSell() {
        return isAllowedToSell;
    }

    public void setAllowedToSell(boolean allowedToSell) {
        isAllowedToSell = allowedToSell;
    }

    public double getReserveBuy() {
        return reserveBuy;
    }

    public void setReserveBuy(double reserveBuy) {
        this.reserveBuy = reserveBuy;
    }

    public double getReserveSell() {
        return reserveSell;
    }

    public void setReserveSell(double reserveSell) {
        this.reserveSell = reserveSell;
    }

    @Override
    public String toString() {
        return "ExchangeRates{" +
                "currencyCode='" + currencyCode + '\'' +
                ", buy=" + buy +
                ", sell=" + sell +
                ", reserveBuy=" + reserveBuy +
                ", reserveSell=" + reserveSell +
                ", isAllowedToBuy=" + isAllowedToBuy +
                ", isAllowedToSell=" + isAllowedToSell +
                ", nameOfBank='" + nameOfBank + '\'' +
                '}';
    }
}
