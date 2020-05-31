import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;


public class Driver 
{
    public static void main(String args[])
    {
        
        System.out.println("Financial Management Program");

        Checking person1 = new Checking(1,"Carlos","Rodrig","fake@mail", 100.00);
        Checking person2 = new Checking(2,"Craft","jankins","real@mail", 200.00);
        Checking person3 = new Checking(3,"Jon","Ram","fortnite@mail", 300.00);
        Equity person4 = new Equity(4, "James", "Rag", "good@mail");
        person4.makeStockPurchase(new StockPurchase("MSFT",2,20.00, "Microsoft"));
        person4.makeStockPurchase(new StockPurchase("GOOG",3,102.00,"Google"));


        
        person1.deposit(100.00);
        person1.withDraw(50.00);

        person2.deposit(100.00);
        person2.deposit(200.00);

        person3.withDraw(300.00);
        person3.deposit(55.00);

        ArrayList<Account>accounts = new ArrayList<Account>();
        accounts.add(person1);
        accounts.add(person2);
        accounts.add(person3);
        accounts.add(person4);

        generateReport(accounts);

    }

    public static void generateReport(ArrayList<Account>acc)
    {
        //start of html file
        Collections.sort(acc);
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<body>");
        builder.append("<h1>");
        builder.append("<Strong>");
        builder.append("Financial Accounts");
        builder.append("</Strong>");
        builder.append("</h1>");
        builder.append("</br>");
        builder.append("</br>"); 

        //loop through accounts + ask for html (in order of value)
        for(Account account : acc)
        {
            builder.append(account.makeReport());
        }
        builder.append("</body>");
        //end html
        builder.append("</html>");
        
        try{
            //instanceof function
            BufferedWriter writer = new BufferedWriter(new FileWriter(".\\report.html"));
            writer.write(builder.toString());
            try{
                writer.close();
            }
            catch(IOException closeFail)
            {
                System.out.println("The file was not able to close ");
            }
        }
        catch(IOException innerFail)
        {
            System.out.println("Could not make the file");
        }

    }
}