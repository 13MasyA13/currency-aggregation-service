package ua.holyk.springboot.currencyaggregationservice.entities;

/**
 * This entity contains best offers of all currencies in app
 */
public class BestOffer {

    private String currencyCode;

    private double buy;
    private String buysBankName;

    private double sell;
    private String sellsBankName;

    public BestOffer(Buys buys, Sells sells) {
        this.buy = buys.getBuy();
        this.sell = sells.getSell();

        this.currencyCode = buys.getCurrencyCode();

        this.buysBankName = buys.getNameOfBank();
        this.sellsBankName = sells.getNameOfBank();
    }

    public String getBuysBankName() {
        return buysBankName;
    }

    public void setBuysBankName(String buysBankName) {
        this.buysBankName = buysBankName;
    }

    public String getSellsBankName() {
        return sellsBankName;
    }

    public void setSellsBankName(String sellsBankName) {
        this.sellsBankName = sellsBankName;
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
}
