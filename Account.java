public abstract class Account implements Comparable<Account>
{
    private int accountNumber;
    private String firstName;
    private String lastName;
    private String email;

    public Account(int accountNum, String fName, String lName, String eMail)
    {
        setAccountNum(accountNum);
        setFirstName(fName);
        setLastName(lName);
        setEMail(eMail);

    }

    public void setAccountNum(int accountNum)
    {
        if(accountNum < 0)
        {
            accountNum = Math.abs(accountNum);
        }
        accountNumber = accountNum;
    }

    public int getAccountNum()
    {
        return accountNumber;
    }

    public void setFirstName(String fName)
    {
        firstName = fName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lName)
    {
        lastName = lName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setEMail(String eMail)
    {
        email = eMail;
    }

    public String getEMail()
    {
        return email;
    }



        @Override
        public int compareTo(Account otherAcc)
        {
            int retVal;
            if(this.getCurrentValue() < otherAcc.getCurrentValue())
            {
                retVal = 1;
            }
            else if(this.getCurrentValue() == otherAcc.getCurrentValue())
            {
                retVal = 0;
            }
            else
            {
                retVal = -1;
            }

            return retVal;
    }



    public String makeReport()
    {
        StringBuilder builder = new StringBuilder();

        builder.append("<Strong>");
        builder.append("Account id: ");
        builder.append(getAccountNum());
        builder.append("</Strong>");
        builder.append("</br>");

        builder.append("First Name: ");
        builder.append(getFirstName());
        builder.append("</br> ");

        builder.append("Last Name: ");
        builder.append(getLastName());
        builder.append("</br>");

        builder.append("e-Mail: ");
        builder.append(getEMail());
        builder.append("</br>");

        return builder.toString();
    }

    public abstract double getCurrentValue();
}

