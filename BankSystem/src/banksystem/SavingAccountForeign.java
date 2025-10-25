package banksystem;

public class SavingAccountForeign extends SavingAccount{
    private String currency;
    public SavingAccountForeign(String status, double actualBalance, String currency) {
        super(status, actualBalance);
        this.currency = currency;
    }

    @Override
    public String getAccountNumber() {
        return Client.serial + "002";
    }

    @Override
    String getAccountType() {
        return "Saving Foreign Account";
    }
    
    @Override
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "\nAccount type: "+getAccountType()+
               "\nAccount number: "+getAccountNumber()+
               "\nActual Balance: "+getActualBalance()+" "+getCurrency()+
               "\nStatus: "+getStatus();
    }

    
}
