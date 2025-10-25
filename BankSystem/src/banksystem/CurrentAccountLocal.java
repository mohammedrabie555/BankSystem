package banksystem;

public class CurrentAccountLocal extends CurrentAccount{
    private String currency;

    public CurrentAccountLocal(String status, double actualBalance, String currency) {
        super(status, actualBalance);
        this.currency = currency;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    @Override
    String getAccountType() {
        return "Current Local Account";
    }
    
    @Override
    public String getAccountNumber(){
        return Client.serial + "001";
    }

    @Override
    public String toString() {
        return "\nAccount type: "+getAccountType()+
               "\nAccount number: "+getAccountNumber()+
               "\nActual Balance: "+getActualBalance()+" "+getCurrency()+
               "\nStatus: "+getStatus();
    }

}
