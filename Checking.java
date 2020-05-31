import java.util.*;
//Checking is having a problem with using compare but why??
public class Checking extends Account
{
    private Double balance;
    private ArrayList<Transaction>history = new ArrayList<Transaction>();

    public Checking(int accountNum, String fName, String lName, String eMail, Double bal)
    {
        super(accountNum, fName, lName, eMail);

        setBalance(bal);
    }

    public void setBalance(Double bal)
    {
        balance = bal;
    }

    public Double getBalance()
    {
        return balance;
    }

    public void deposit(double amt)
    {
        Transaction t = new Transaction("Deposit", amt);
        history.add(t);
        balance = balance + amt;
    }

    public void withDraw(double amt)
    {
        Transaction t = new Transaction("Withdraw", amt);
        history.add(t);
        balance = balance - amt;
    }

    @Override
    public double getCurrentValue()
    {
        return getBalance();
    }


    @Override
    public String makeReport()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(super.makeReport());

        builder.append("Tranaction history: ");
        builder.append("</br>");

        for(Transaction transaction : history)//Is this how to show the list of transactions made
        {
            if(transaction.getType() == "Deposit")
            {
                builder.append("Deposits: ");
                builder.append(transaction.getAmount());
                builder.append("</br>");
            }
            else
            {
                builder.append("Withdraw: ");
                builder.append(transaction.getAmount());
                builder.append("</br>");
            }
        }

        builder.append("Balance: ");
        builder.append(getBalance());
        builder.append("</br>");

        builder.append("Account total value: ");

        builder.append(getCurrentValue());
        builder.append("</br>");
        builder.append("</br>");

        return builder.toString();
    }


}