package banksystem;

public class CurrentAccountForeign extends CurrentAccount{
    private String currency;

    public CurrentAccountForeign(String status, double actualBalance, String currency) {
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
        return "Current Foreign Account";
    }
    
    @Override
    public String getAccountNumber(){
        return Client.serial + "002";
    }

    @Override
    public String toString() {
        return "\nAccount type: "+getAccountType()+
               "\nAccount number: "+getAccountNumber()+
               "\nActual Balance: "+getActualBalance()+" "+getCurrency()+
               "\nStatus: "+getStatus();
    }

}
