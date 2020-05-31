public class Transaction
{
    private String type;
    private Double amount;

    public Transaction(String type, double amount)
    {
        setType(type);
        setAmount(amount);
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public Double getAmount()
    {
        return amount;
    }
}