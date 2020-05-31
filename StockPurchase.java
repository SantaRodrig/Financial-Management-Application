public class StockPurchase
{
    private String tickerSymbol;
    private int numOfShares;
    private double purchasePrice;
    private String stockName;

    public StockPurchase(String ticSymbol, int shares, double purchasePrice, String stockName)
    {

        setTickerSymbol(ticSymbol);
        setShares(shares);
        setPurchasedPrice(purchasePrice);
        setStockName(stockName);
    }

    public void setTickerSymbol(String ticSymbol)
    {
        tickerSymbol = ticSymbol;
    }

    public String getTickerSymbol()
    {
        return tickerSymbol;
    }

    public void setShares(int shares)
    {
        numOfShares = shares;
    }

    public int getShares()
    {
        return numOfShares;
    }

    public void setPurchasedPrice(double purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }

    public double getPurchasePrice()
    {
        return purchasePrice;
    }

    public void setStockName(String stockName)
    {
        this.stockName = stockName;
    }

    public String getStockName()
    {
        return stockName;
    }
}