package banksystem;

import static banksystem.BankDashboard.userCredentials;
import java.util.Scanner;

public class BankSystem {
    
    static Scanner s = new Scanner(System.in);
    static BankDashboard bankDashboard = new BankDashboard();
    static ATM atm = new ATM();
    static Account a = new CurrentAccountForeign("fdfd", 0, "dfd");
    public static void main(String[] args) {
        System.out.println(a.getClass());
        System.out.println("Welcome to City Bank: ");
            while(true){
            System.out.println("""
                               
                               1. Add new client (and create new account)
                               2. Add new account to current client
                               3. Display client information
                               4. Update/modify client information
                               5. Remove client
                               6. Remove account from client
                               7. ATM
                               8. Contact support
                               9. Exit
                                """);
            String selection = s.nextLine();
            switch(selection){
                case "1" -> {
                    bankDashboard.addNewClient();
                }
                case "2" -> {
                    bankDashboard.addAccountToCurrentClient();
                }
                case "3" -> {
                    bankDashboard.displayClientInfo();
                }
                case "4" -> {
                    bankDashboard.updateClientInfo();
                }
                case "5" -> {
                    bankDashboard.removeClient();
                }
                case "6" -> {
                    bankDashboard.removeAccountFromClient();
                }
                case "7" -> {
                    String user = null;
                    String pass;
                    Client client;
                    if(bankDashboard.clients.isEmpty()){
                        System.out.println("No clients found!\n");
                        break;
                    }
                    System.out.println("Welcome to City Bank ATM");
                    System.out.println("You have 3 attemps to login if you failed the 3, Your account(s) will be blocked!\n");
                    int i;
                    for(i = 1; i <= 3; i++){
                        System.out.println("Attempt: "+ i);
                        System.out.print("Please enter the username: ");
                        user = s.nextLine().trim();
                        System.out.print("\nPlease Enter your password: ");
                        pass = s.nextLine();
                        if(atm.loginValidation(user, pass)){
                            break;
                        }
                        else{
                            System.out.println("username/password is incorrect\n");
                        }
                    }
                    if(userCredentials.containsKey(user)){
                        client = userCredentials.get(user);
                        if(!atm.statusValidation(user)){
                            System.out.println("\nYour account(s) have been already blocked, Please contact support\n");
                            break;
                        }
                        if(i == 4){
                            if(client.account.size() == 1){
                                client.account.get(0).setStatus("Deactive");
                            }
                            else{
                                client.account.get(0).setStatus("Deactive");
                                client.account.get(1).setStatus("Deactive");
                            }
                            System.out.println("You failed to login 3 times, Your account(s) have been blocked!\n");
                            break;
                        }
                    }
                    
                    if(atm.statusValidation(user)){
                        System.out.println("\nLogged in successfully!\n");
                        boolean flag = true;
                        while(flag){
                            System.out.println("""
                                               1. Balance Inquiry
                                               2. Withdraw
                                               3. Deposite
                                               4. Change password
                                               5. quit

                                               """);

                            switch(s.nextLine()){
                                case "1" -> {
                                    atm.balanceInquiry();
                                    System.out.println("\nDo you want to do another operation ?\n1. Yes\n2. No\n");
                                    while(true){
                                        switch(s.nextLine().trim()){
                                            case "1" -> {
                                                flag = true;
                                            }
                                            case "2" -> {
                                                flag = false;
                                            }
                                            default -> {
                                                System.out.println("Invalid selection!\n");
                                                continue;
                                            }
                                        }
                                        break;
                                    }
                                }
                                case "2" -> {
                                    atm.withdraw();
                                    System.out.println("\nDo you want to do another operation ?\n1. Yes\n2. No\n");
                                    while(true){
                                        switch(s.nextLine().trim()){
                                            case "1" -> {
                                                flag = true;
                                            }
                                            case "2" -> {
                                                flag = false;
                                            }
                                            default -> {
                                                System.out.println("Invalid selection!\n");
                                                continue;
                                            }
                                        }
                                        break;
                                    }
                                }
                                case "3" -> {
                                    atm.deposite();
                                    System.out.println("\nDo you want to do another operation ?\n1. Yes\n2. No\n");
                                    while(true){
                                        switch(s.nextLine().trim()){
                                            case "1" -> {
                                                flag = true;
                                            }
                                            case "2" -> {
                                                flag = false;
                                            }
                                            default -> {
                                                System.out.println("Invalid selection!\n");
                                                continue;
                                            }
                                        }
                                        break;
                                    }
                                }
                                case "4" -> {
                                    atm.changeAccountPassword();
                                    System.out.println("\nDo you want to do another operation ?\n1. Yes\n2. No\n");
                                    while(true){
                                        switch(s.nextLine().trim()){
                                            case "1" -> {
                                                flag = true;
                                            }
                                            case "2" -> {
                                                flag = false;
                                            }
                                            default -> {
                                                System.out.println("Invalid selection!\n");
                                                continue;
                                            }
                                        }
                                        break;
                                    }
                                }
                                case "5" -> {
                                    flag = false;
                                }
                                default -> {
                                    System.out.println("Invalid selection!\n");
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("\nLogin failed!\n");
                        System.out.println("Sorry, Your account(s) have been blocked! please contact support!\n");
                    }
                }
                case "8" -> {
                    Client client;
                    System.out.print("""
                                       Welcome to support center!
                                       We know that your account(s) have been blocked
                                       Please enter your username to unblock your accounts: 
                                       """);
                    String username = s.nextLine().trim();
                    if(userCredentials.containsKey(username)){
                        client = userCredentials.get(username);
                        if(client.account.size() == 1){
                            client.account.get(0).setStatus("Active");
                        }
                        else{
                            client.account.get(0).setStatus("Active");
                            client.account.get(1).setStatus("Active");
                        }
                    }
                    System.out.println("\nUnblocked successfully, Now you can use your account(s) safely!\n");
                }
                case "9" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid selection!\n");
                }
            }
        }
    }
    
}
