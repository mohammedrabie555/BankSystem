package banksystem;
import static InputManipulation.InputManipulations.onlyNumbers;
import static banksystem.BankDashboard.userCredentials;
import java.util.List;
import java.util.Scanner;
import static InputManipulation.InputManipulations.onlyNumbersDouble;

public class ATM {
    static Scanner s = new Scanner(System.in);
    Client client;
    Account account;
    
    boolean statusValidation(String username){
        if(userCredentials.containsKey(username)){
            client = userCredentials.get(username);
            if(client.account.size() == 1 && client.account.get(0).getStatus().equals("Active")){
                return true;
            }
            else return client.account.size() == 2 && client.account.get(0).getStatus().equals("Active");
        }
        return false;
    }
    boolean loginValidation(String username, String password){
        client = null;
        if(userCredentials.containsKey(username)){
            client = userCredentials.get(username);
            if(client.getPassWord().equals(password)){
                return true;
            }
        }
        return false;
    }
    
    void withdraw(){
        account = null;
        String currency;
        boolean flag = true;
        while(flag){
            System.out.println("1. Saving account\n2. Current account\n");
            switch(s.nextLine()){
                case "1" -> {
                    if(client.account.size() == 1){
                        account = client.account.get(0);
                        currency = client.account.get(0).getCurrency();
                        String accountType = client.account.get(0).getAccountType();
                        if(accountType.equals("Saving Local Account") ||
                           accountType.equals("Saving Foreign Account") ){
                            withdrawalAmounts(account, currency);
                        }
                        else{
                            System.out.println("No saving account found!\n");
                        }
                    }
                    else{
                        int savingLocal = 0;
                        int savingForeign = 0;
                        for (int i = 0; i < 2; i++) {
                            String accountType = client.account.get(i).getAccountType();
                            if(accountType.equals("Saving Local Account")  ){
                                savingLocal++;
                            }
                            else if (accountType.equals("Saving Foreign Account")){
                                savingForeign++;
                            }
                        }
                        
                        if(savingLocal == 0 && savingForeign == 0){
                            System.out.println("No saving account found!\n");
                        }
                        
                        if(savingForeign == 1 && savingLocal == 0){
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                if(account.getAccountType().equals("Saving Foreign Account")){
                                    withdrawalAmounts(account, currency);
                                }
                            }
                        }
                        if(savingLocal == 1 && savingForeign == 0){
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                if(account.getAccountType().equals("Saving Local Account")){
                                    withdrawalAmounts(account, currency);
                                }
                            }
                        }
                        
                        if(savingLocal == 1 && savingForeign == 1){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                        }
                        
                        if(savingForeign == 2){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                        }
                        if(savingLocal == 2){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                        }
                    }
                    flag = false;
                }
                case "2" -> {
                    if(client.account.size() == 1){
                        account = client.account.get(0);
                        currency = client.account.get(0).getCurrency();
                        String accountType = client.account.get(0).getAccountType();
                        if(accountType.equals("Current Local Account") ||
                           accountType.equals("Current Foreign Account") ){
                            withdrawalAmounts(account, currency);
                        }
                        else{
                            System.out.println("No current account found!\n");
                        }
                    }
                    
                    else{
                        int curentLocal = 0;
                        int curentForeign = 0;
                        for (int i = 0; i < 2; i++) {
                            String accountType = client.account.get(i).getAccountType();
                            if(accountType.equals("Current Local Account")  ){
                                curentLocal++;
                            }
                            else if (accountType.equals("Current Foreign Account")){
                                curentForeign++;
                            }
                        }
                        
                        if(curentLocal == 0 && curentForeign == 0){
                            System.out.println("No current account found!\n");
                        }
                        
                        if(curentForeign == 1 && curentLocal == 0){
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                if(account.getAccountType().equals("Current Foreign Account")){
                                    withdrawalAmounts(account, currency);
                                }
                            }
                        }
                        if(curentLocal == 1 && curentForeign == 0){
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                if(account.getAccountType().equals("Current Local Account")){
                                    withdrawalAmounts(account, currency);
                                }
                            }
                        }
                        
                        if(curentLocal == 1 && curentForeign == 1){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                        }
                        
                        if(curentForeign == 2){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                        }
                        if(curentLocal == 2){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                        }
                    }
                    
                    flag = false;
                }
                default -> {
                    System.out.println("Invalid account type!\n");
                }
            }
        }
    }
    void withdrawalAmounts(Account account, String currency){
        System.out.println("""
                           1. 100
                           2. 200
                           3. 300
                           4. 400
                           5. 500
                           6. 1000
                           7. 2000
                           8. 4000
                           9. Another amount
                           """);
        switch (s.nextLine()){
            case "1" -> {
                withdrawBalance(account, 100, currency);
            }
            case "2" -> {
                withdrawBalance(account, 200, currency);
            }
            case "3" -> {
                withdrawBalance(account, 300, currency);
            }
            case "4" -> {
                withdrawBalance(account, 400, currency);
            }
            case "5" -> {
                withdrawBalance(account, 500, currency);
            }
            case "6" -> {
                withdrawBalance(account, 1000, currency);
            }
            case "7" -> {
                withdrawBalance(account, 2000, currency);
            }
            case "8" -> {
                withdrawBalance(account, 4000, currency);
            }
            case "9" -> {
                double amount;
                while(true){
                    System.out.println("Enter the amount you want to withdraw"
                            +"\n    *Note: minimum withdrawal amount is 50 " + currency + 
                             "\n    *Maximum withdrawal amount 8,000 " + currency);
                    amount = onlyNumbersDouble(s.nextLine());
                    if(amount >= 50 && amount <= 8000){
                        break;
                    }
                    else if(amount == -1 | amount == -2){
                        System.out.println("Spaces, special characters or letters are not allowed here!\n");
                    }
                    else{
                        System.out.println("unallowed withdrawal range!\n");
                        return;
                    }
                }
                withdrawBalance(account , amount, currency);
            }
            default -> {
                System.out.println("Invalid Selection!\n");
            }
        }
    }
    void withdrawBalance(Account account, double amount, String currency){
        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage() + "\n");
            return;
        }
        System.out.printf("%,.2f %s  has been withdrawn!\nthe remaining balance is: %,.2f %s\n\n",
                amount,currency,account.getActualBalance(),currency);
    }
    void deposite(){
        withdrawAndDeposite("deposite");
    }
    void depositedAmounts(Account account, String currency){
        double amount;
            while(true){
                System.out.printf("Enter the amount you want to deposite: %n    "
                        + "*Note: minimum deposited amount is 50 %s%n    "+
                        "*Maximum deposited amount 10,000 %s%n", currency, currency);
                amount = onlyNumbersDouble(s.nextLine());
                if(amount%50 == 0){
                    break;
                }
                else if(amount == -1 | amount == -2){
                    System.out.println("Spaces, special characters or letters are not allowed here!\n");
                }
                else{
                    System.out.println("The deposited amount must be 50 or its multiplications.\n");
                    return;
                }
            }
            depositeBalance(account, amount, currency);
    }
    void depositeBalance(Account account, double amount, String currency){
        try {
            account.deposite(amount);
        } catch (UnAllowedDepositedRangeException e) {
            System.out.println(e.getMessage() + "\n");
            return;
        }
        System.out.printf("%,.2f %s  has been deposited!\nthe new balance is: %,.2f %s\n\n",
                amount,currency,account.getActualBalance(),currency);
    }
    
    void withdrawAndDeposite(String operationType){
        account = null;
        String currency;
        boolean flag = true;
        while(flag){
            System.out.println("1. Saving account\n2. Current account\n");
            switch(s.nextLine()){
                case "1" -> {
                    if(client.account.size() == 1){
                        account = client.account.get(0);
                        currency = client.account.get(0).getCurrency();
                        String accountType = client.account.get(0).getAccountType();
                        if(accountType.equals("Saving Local Account") ||
                           accountType.equals("Saving Foreign Account") ){
                            
                            if(operationType.equals("withdraw")){
                                withdrawalAmounts(account, currency);
                            }
                            else{
                                depositedAmounts(account, currency);
                            }
                            
                        }
                        else{
                            System.out.println("No saving account found!\n");
                        }
                    }
                    else{
                        int savingLocal = 0;
                        int savingForeign = 0;
                        for (int i = 0; i < 2; i++) {
                            String accountType = client.account.get(i).getAccountType();
                            if(accountType.equals("Saving Local Account")  ){
                                savingLocal++;
                            }
                            else if (accountType.equals("Saving Foreign Account")){
                                savingForeign++;
                            }
                        }
                        
                        if(savingLocal == 0 && savingForeign == 0){
                            System.out.println("No saving account found!\n");
                        }
                        
                        if(savingForeign == 1 && savingLocal == 0){
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                if(account.getAccountType().equals("Saving Foreign Account")){
                                    if(operationType.equals("withdraw")){
                                        withdrawalAmounts(account, currency);
                                    }
                                    else{
                                        depositedAmounts(account, currency);
                                    }
                                }
                            }
                        }
                        if(savingLocal == 1 && savingForeign == 0){
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                if(account.getAccountType().equals("Saving Local Account")){
                                    if(operationType.equals("withdraw")){
                                        withdrawalAmounts(account, currency);
                                    }
                                    else{
                                        depositedAmounts(account, currency);
                                    }
                                }
                            }
                        }
                        
                        if(savingLocal == 1 && savingForeign == 1){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            if(operationType.equals("withdraw")){
                                withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                            else{
                                depositedAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                        }
                        
                        if(savingForeign == 2){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            if(operationType.equals("withdraw")){
                                withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                            else{
                                depositedAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                        }
                        if(savingLocal == 2){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            if(operationType.equals("withdraw")){
                                withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                            else{
                                depositedAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                        }
                    }
                    flag = false;
                }
                case "2" -> {
                    if(client.account.size() == 1){
                        account = client.account.get(0);
                        currency = client.account.get(0).getCurrency();
                        String accountType = client.account.get(0).getAccountType();
                        if(accountType.equals("Current Local Account") ||
                           accountType.equals("Current Foreign Account") ){
                            if(operationType.equals("withdraw")){
                                withdrawalAmounts(account, currency);
                            }
                            else{
                                depositedAmounts(account, currency);
                            }
                        }
                        else{
                            System.out.println("No current account found!\n");
                        }
                    }
                    
                    else{
                        int curentLocal = 0;
                        int curentForeign = 0;
                        for (int i = 0; i < 2; i++) {
                            String accountType = client.account.get(i).getAccountType();
                            if(accountType.equals("Current Local Account")  ){
                                curentLocal++;
                            }
                            else if (accountType.equals("Current Foreign Account")){
                                curentForeign++;
                            }
                        }
                        
                        if(curentLocal == 0 && curentForeign == 0){
                            System.out.println("No current account found!\n");
                        }
                        
                        if(curentForeign == 1 && curentLocal == 0){
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                if(account.getAccountType().equals("Current Foreign Account")){
                                    if(operationType.equals("withdraw")){
                                        withdrawalAmounts(account, currency);
                                    }
                                    else{
                                        depositedAmounts(account, currency);
                                    }
                                }
                            }
                        }
                        if(curentLocal == 1 && curentForeign == 0){
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                if(account.getAccountType().equals("Current Local Account")){
                                    if(operationType.equals("withdraw")){
                                        withdrawalAmounts(account, currency);
                                    }
                                    else{
                                        depositedAmounts(account, currency);
                                    }
                                }
                            }
                        }
                        
                        if(curentLocal == 1 && curentForeign == 1){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            if(operationType.equals("withdraw")){
                                withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                            else{
                                depositedAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                            
                        }
                        
                        if(curentForeign == 2){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            if(operationType.equals("withdraw")){
                                withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                            else{
                                depositedAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                        }
                        if(curentLocal == 2){
                            int selectedAccount;
                            for (int i = 0; i < 2; i++) {
                                account = client.account.get(i);
                                currency = account.getCurrency();
                                System.out.println((i+1) + ". " + account.getAccountType()+
                                        "\n" + "Balance: " + account.getActualBalance() +" "+ currency + "\n");
                                
                            }
                            while(true){
                                selectedAccount = onlyNumbers(s.nextLine().trim());
                                if(selectedAccount > 0 && selectedAccount <= 2){
                                    break;
                                }
                                else if(selectedAccount == -1 || selectedAccount == -2){
                                    System.out.println("Only numbers are allowed here!\n");
                                }
                                else{
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                            currency = client.account.get(selectedAccount - 1).getCurrency();
                            if(operationType.equals("withdraw")){
                                withdrawalAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                            else{
                                depositedAmounts(client.account.get(selectedAccount - 1), currency);
                            }
                        }
                    }
                    
                    flag = false;
                }
                default -> {
                    System.out.println("Invalid account type!\n");
                }
            }
        }
    }
    
    void balanceInquiry(){
        boolean flag = true;
        while(flag){
            System.out.println("1. Saving account\n2. Current account\n");
            switch(s.nextLine()){
                case "1" -> {
                    savingBalance(client.account, "saving");
                    flag = false;
                }
                case "2" -> {
                    currentBalance(client.account, "current");
                    flag = false;
                }
                default -> {
                    System.out.println("Invalid account type!\n");
                }
            }
        }
    }
    void savingBalance(List <Account> account, String type){
        int numberOfAccounts = account.size();
        int c;
        String currency;
        String accountType;
        if(account.size() == 1){
            accountType = account.get(0).getAccountType();
            currency = account.get(0).getCurrency();
            if(accountType.equals("Saving Local Account") ||
               accountType.equals("Saving Foreign Account") ){
                System.out.println("Available balance: " + 
                        account.get(0).getActualBalance() + " " + currency + "\n"); 

            }
            else{
                System.out.println("No " + type + " account found!\n");
            }
        }
        else{
            c = 0;
            for (int i = 0; i < numberOfAccounts; i++) {
                accountType = account.get(i).getAccountType();
                currency = account.get(i).getCurrency();
                if(accountType.equals("Saving Local Account") ||
                   accountType.equals("Saving Foreign Account") ){
                    System.out.println("Available balance: " + 
                        account.get(i).getActualBalance() + " " + currency + "\n"); 
                    c++;
                }
            }
            if(c == 0){
                System.out.println("No " + type + " account found!\n");
            }
        }
    }
    void currentBalance(List <Account> account, String type){
        int numberOfAccounts = account.size();
        int c;
        String currency;
        String accountType;
        if(account.size() == 1){
            currency = account.get(0).getCurrency();
            accountType = account.get(0).getAccountType();
            if(accountType.equals("Current Local Account") ||
               accountType.equals("Current Foreign Account") ){
                System.out.println("Available balance: " + 
                        account.get(0).getActualBalance() + " " + currency + "\n"); 

            }
            else{
                System.out.println("No " + type + " account found!\n");
            }
        }
        else{
            c = 0;
            for (int i = 0; i < numberOfAccounts; i++) {
                accountType = account.get(i).getAccountType();
                currency = account.get(i).getCurrency();
                if(accountType.equals("Current Local Account") ||
                   accountType.equals("Current Foreign Account") ){
                    System.out.println("Available balance: " + 
                        account.get(i).getActualBalance() + " " + currency + "\n"); 
                    c++;
                }
            }
            if(c == 0){
                System.out.println("No " + type + " account found!\n");
            }
        }
    }
    
    void changeAccountPassword(){
        int upperCase;
        int lowerCase;
        int digit;
        int specialChar;
        String oldPassword;
        String newPassword;
        
        while(true){
            upperCase = 0;
            lowerCase = 0;
            digit = 0;
            specialChar = 0;
            System.out.print("Please enter the old password: ");
            
            while(true){
                oldPassword = s.nextLine();
                if(client.getPassWord().equals(oldPassword)){
                    break;
                }
                else{
                    System.out.printf("%nThe old password you entered is wrong!%n%n"
                            + "Please enter the old password correctly: ");
                }
            }

            System.out.println("""
                               
                               Set the new password for your account: 
                               - Please note, the password length should be at least 8 characters but not exceed 32 characters, 
                               - Should contain at least: 
                                    * 1 uppercase character
                                    * 1 lowercase character
                                    * 1 digit
                                    * 1 special character
                               """);
            
            char [] str = s.nextLine().toCharArray();
            
            for (int i = 0; i < str.length; i++) {
                if(str[i] >= 65 && str[i] <= 90){
                    upperCase++;
                }
                if(str[i] >= 97 && str[i] <= 122){
                    lowerCase++;
                }
                if(str[i] >= 48 && str[i] <= 57){
                    digit++;
                }
                if((str[i] >= 32 && str[i] <= 47) || (str[i] >= 58 && str[i] <= 64) ||
                   (str[i] >= 91 && str[i] <= 96) || (str[i] >= 123 && str[i] <= 126)){
                    specialChar++;
                }
            }
            if(!(str.length >= 8 && str.length <= 32)){
                System.out.println("\nThe password length is not within the required length!");
                continue;
            }
            if(upperCase == 0){
                System.out.println("No uppercas found!");
            }
            if(lowerCase == 0){
                System.out.println("No lowercase found!");
            }
            if(digit == 0){
                System.out.println("No digit found!");
            }
            if(specialChar == 0){
                System.out.println("No special character found!\n");
            }
            if(!(upperCase == 0 || lowerCase == 0 || digit == 0 || specialChar == 0 )){
                newPassword = String.valueOf(str);
                break;
            }
        }
        client.setPassWord(newPassword);
        System.out.println("\nThe password has been changed successfully!\n");
    }
    
}
