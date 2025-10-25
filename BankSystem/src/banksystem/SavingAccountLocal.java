package banksystem;

public class SavingAccountLocal extends SavingAccount{

    private String currency;

    public SavingAccountLocal(String status, double actualBalance, String currency) {
        super(status, actualBalance);
        this.currency = currency;
    }
    
    @Override
    public String getAccountNumber() {
        return Client.serial + "001";
    }

    @Override
    String getAccountType() {
        return "Saving Local Account";
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
