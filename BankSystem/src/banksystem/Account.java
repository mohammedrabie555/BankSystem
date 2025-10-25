package banksystem;

public abstract class Account {
    private String status;
    private int annualInterestRate;
    private double actualBalance;

    public Account(String status, double actualBalance) {
        this.status = status;
        this.actualBalance = actualBalance;
    }
    public void withdraw(double amount) throws InsufficientBalanceException{
        if(amount > actualBalance)
            throw new InsufficientBalanceException("Insufficient balance");
        actualBalance -= amount;
    }
    public void deposite(double amount) throws UnAllowedDepositedRangeException{
        if(amount < 50 || amount >10000)
            throw new UnAllowedDepositedRangeException("un-allowed deposited range!");
        actualBalance += amount;
    }
    public double getActualBalance() {
        return actualBalance;
    }

    public void setActualBalance(double actualBalance) {
        this.actualBalance = actualBalance;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(int annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    public abstract String getCurrency();
    public abstract String getAccountNumber();
    
    abstract String getAccountType();
    
    @Override
    public abstract String toString();
}
