import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
public class Equity extends Account
{

    private ArrayList<StockPurchase>sp = new ArrayList<StockPurchase>();
    private HashMap<String,Double> hmap = new HashMap<String,Double>();

    public Equity(int accountNum, String fName, String lName, String eMail)
    {
        super(accountNum, fName, lName, eMail);
    }

    public void makeStockPurchase(StockPurchase purch)
    {
        sp.add(purch);
    }

    @Override
    public double getCurrentValue()
    {
        double value =0;
        String nextline;
        
        try{
            File file = new File(".\\currentPrices.txt");
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine())
            {
                nextline = sc.nextLine();
                String [] parts = nextline.split(" ");
                String symbol = parts[0];
                Double currentValue = Double.parseDouble(parts[1]);
                hmap.put(symbol,currentValue);
            }
            for(StockPurchase purch: sp)
            {
                value += hmap.get(purch.getTickerSymbol()) * purch.getShares();
            }

            sc.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Scan of file could not happen");
        }


        return value;

    }

    public double getDifference()
    {
        double originalPurchase = 0;
        double difference;
        for(StockPurchase purch: sp)
        {
            originalPurchase += (purch.getPurchasePrice()*purch.getShares());
        }

        difference = getCurrentValue() - originalPurchase;

        return difference;
    }

    @Override
    public String makeReport()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(super.makeReport());

        builder.append("Equity Report: ");
        builder.append("</br>");
        builder.append("</br>");

        for(StockPurchase purch: sp)
        {
            builder.append("Stock Name: ");
            builder.append(purch.getStockName());
            builder.append("</br>");

            builder.append("Ticker Symbol:" );
            builder.append(purch.getTickerSymbol());
            builder.append("</br>");

            builder.append("Value: ");
            builder.append(hmap.get(purch.getTickerSymbol()));
            builder.append("</br>");
            builder.append("</br>");
        }

        builder.append("Equity Total Value: ");
        builder.append(getCurrentValue());
        builder.append("</br>");

        builder.append("Profit/Loss: ");
        builder.append(getDifference());
        builder.append("</br>");
        builder.append("</br>");

        return builder.toString();
    }
    
}