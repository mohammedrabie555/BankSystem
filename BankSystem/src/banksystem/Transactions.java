package banksystem;

public class Transactions {
    static int serialNumber = 0;
    String transactionType;
    double runningBalanca;
    Account account;

    public Transactions(String transactionType) {
        this.transactionType = transactionType;
        serialNumber++;
    }
//    double getRunningBalance(){
//        return 
//    }
}
