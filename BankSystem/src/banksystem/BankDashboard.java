package banksystem;
//import static InputManipulation.InputManipulations.passwordSpecific;
import static InputManipulation.InputManipulations.onlyLetters;
import static InputManipulation.InputManipulations.lettersNumbersAndCharacters;
import static InputManipulation.InputManipulations.numbersAndLetters;
import static InputManipulation.InputManipulations.onlyNumbersDouble;
import static InputManipulation.InputManipulations.numbersAndLettersWithoutSpaces;
import static InputManipulation.InputManipulations.onlyStringNumbers;
import static InputManipulation.InputManipulations.onlyNumbers;
import com.sun.source.tree.ContinueTree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class BankDashboard {
    
    static HashMap <String, Client> userCredentials = new HashMap<>();
    static Scanner s = new Scanner(System.in);
    ArrayList <Client> clients = new ArrayList<>();
    int numberOfClients = 0;
    int numberOfAccounts;
    int selectedClient;
    
    void addNewClient(){
        String firstName;
        String lastName;
        int age;
        String address;
        String govID;
        String jobTitel;
        String password;
        String userName;
        
        while(true){
            System.out.print("Enter the first name: ");
            firstName = onlyLetters(s.nextLine().trim());
            if(!firstName.equals("")){
                break;
            }
            else{
                System.out.println("Spaces, special character or numbers are not allowed here!\n");
            }
        }
        
        while(true){
            System.out.print("Enter the last name: ");
            lastName = onlyLetters(s.nextLine().trim());
            if(!lastName.equals("")){
                break;
            }
            else{
                System.out.println("Spaces, special character or numbers are not allowed here!\n");
            }
        }
        
        while(true){
            System.out.print("Enter the client age: ");
            age = onlyNumbers(s.nextLine());
            if(age >= 18 && age <= 120){
                break;
            }
            else if(age == -1 || age == -2){
                System.out.println("Spaces, special character or letters are not allowed here!\n");
            }
            else{
                System.out.println("Age should between 18 ~ 120 years.\n");
            }
        }
        
        while(true){
            System.out.print("Enter the client address: ");
            address = lettersNumbersAndCharacters(s.nextLine().trim());

            if(address.equals(" ")){
                continue;
            }
            if(!address.equals("")){
                break;
            }
        }
        while(true){
            System.out.print("Enter the client government ID: ");
            govID = onlyStringNumbers(s.nextLine().trim());

            if(govID.equals(" ")){
                continue;
            }
            if(govID.length()!= 14){
                System.out.println("The government ID length must be 14 characters only\n");
                continue;
            }
            if(!govID.equals("")){
                break;
            }
            else{
                System.out.println("Spaces, Special characters or letters are not allowed here!\n");
            }
        }
        while(true){
            System.out.print("Enter the client job title: ");
            jobTitel = onlyLetters(s.nextLine().trim());
            if(jobTitel.equals(" ")){
                continue;
            }
            if(!jobTitel.equals("")){
                break;
            }
            else{
                System.out.println("Special characters or numbers are not allowed here!\n");
            }
        }
        while(true){
            System.out.println("""
                               
                               Create new user name: 
                               - Please note, the username length should be at least 12 characters, but not exceed 32 characters
                               - You should not include spaces or special characters in your username.""");
            
            userName = numbersAndLettersWithoutSpaces(s.nextLine().trim()).toLowerCase();
            
            if(userName.equals("")){
                System.out.println("Spaces or special characters are not allowed here!\n");
                continue;
            }
            if(userName.length() >= 12 && userName.length() <= 32){
                if(!userCredentials.containsKey(userName)){
                    break;
                }
                else{
                    System.out.println("\nSorry this username already exists! your username should be unique.");
                }
            }
            else{
                System.out.println("The username length should be at least 12 characters but not exceed 32 characters!\n");
            }
        }
        
        int upperCase;
        int lowerCase;
        int digit;
        int specialChar;
        
        while(true){
            upperCase = 0;
            lowerCase = 0;
            digit = 0;
            specialChar = 0;
            
            System.out.println("""
                               
                               Set a new password for your account: 
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
                password = String.valueOf(str);
                break;
            }
        }
        
        System.out.println("Client information saved!");
        clients.add(new Client(firstName, lastName, age, address, govID, jobTitel, password, userName));
        userCredentials.put(userName, clients.get(numberOfClients));
        
        numberOfAccounts = 0;
        boolean flag = true;
        do{
            while(true){
                System.out.println("""

                                   Select Account type:
                                   1. Current with local currency
                                   2. Saving with local currency
                                   3. Current foreign currency
                                   4. Saving foreign currency
                                   """);

                switch(s.nextLine().trim()){
                    case "1" -> {
                        addLocalAndCurrent("current", "local", numberOfClients);
                    }
                    case "2" -> {
                        addLocalAndCurrent("saving", "local", numberOfClients);
                    }
                    case "3" -> {
                        addLocalAndCurrent("current", "foreign", numberOfClients);
                    }
                    case "4" -> {
                        addLocalAndCurrent("saving", "foreign", numberOfClients);
                    }
                    default -> {
                        System.out.println("Invalid Selection");
                        continue;
                    }
                }
                break;
            }
            if(numberOfAccounts == 2){
                System.out.println("You cannot add more than 2 accounts to any client, returning to main menu...\n");
                numberOfClients++;
                return;
            }
            System.out.println("You have one remaining account to be added, Do you want to add it to the client ? \n1. Yes\n2. No");
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
        }while(flag);
        numberOfClients++;
    }
    void addAccountToCurrentClient(){
        if(clients.isEmpty()){
            System.out.println("No clients found!\n");
        }
        else{
            
            displayClientInfo();
            while(true){
                System.out.println("""
                                   Select the client you want to add another account to him/her:
                                       *Note: if the client has 2 accounts, you cannot add one more account to him/her.
                                   """);
                selectedClient = onlyNumbers(s.nextLine().trim());
                
                if(selectedClient > 0 && selectedClient <= numberOfClients){
                    break;
                }
                else if(selectedClient == -1 || selectedClient == -2){
                    System.out.println("Spaces, special character or letters are not allowed here!\n");
                }
                else{
                    System.out.println("Invalid client!\n");
                }
            }
            if(clients.get(selectedClient - 1).account.size() == 2){
                System.out.println("You cannot add more than 2 accounts to this client!\n");
                return;
            }
            while(true){
                System.out.println("""

                                   Select Account type:
                                   1. Current with local currency
                                   2. Saving with local currency
                                   3. Current foreign currency
                                   4. Saving foreign currency
                                   """);

                switch(s.nextLine().trim()){
                    case "1" -> {
                        addLocalAndCurrent("current", "local", selectedClient-1);
                    }
                    case "2" -> {
                        addLocalAndCurrent("saving", "local", selectedClient-1);
                    }
                    case "3" -> {
                        addLocalAndCurrent("current", "foreign", selectedClient-1);
                    }
                    case "4" -> {
                        addLocalAndCurrent("saving", "foreign", selectedClient-1);
                    }
                    default -> {
                        System.out.println("Invalid Selection");
                        continue;
                    }
                }
                break;
            }
        }
    }
    void addLocalAndCurrent(String type, String region, int clientNumber){
//        numberOfClients = clientNumber ;
        numberOfAccounts = clients.get(clientNumber).account.size();
        String accountStatus;
        double deposite;
        String currency;
        //class banksystem.CurrentAccountLocal
        
            while(true){
                System.out.println("Set the account status: \n1. Active \n2. Deactive");
                switch(s.nextLine().trim()){
                    case "1" -> {
                        accountStatus = "Active";
                    }
                    case "2" -> {
                        accountStatus = "Deactive";
                    }
                    default -> {
                        System.out.println("Invalid selection!\n");
                        continue;
                    }
                }
                break;
            }
            int initialDepoite;
            if(region.equals("local")){
                initialDepoite = 1000;
                currency = "EGP";
            }
            else{
                initialDepoite = 500;
                while(true){
                    System.out.println("Select the foreign currency: \n1. USD\n2. EUR\n3. GPB");
                    switch(s.nextLine()){
                        case "1" -> {
                            currency = "USD";
                        }
                        case "2" -> {
                            currency = "EUR";
                        }
                        case "3" -> {
                            currency = "GPB";
                        }
                        default -> {
                            System.out.println("Invalid currency!\n");
                            continue;
                        }
                    }
                    break;
                }
            }
            while(true){
                System.out.println("Please put the initial deposite for your account (Minimum deposite "+initialDepoite+" "+currency+"): ");
                deposite = onlyNumbers(s.nextLine().trim());
                if(deposite >= initialDepoite){
                    break;
                }
                else if(deposite == -1 || deposite == -2){
                    System.out.println("Spaces, special character or letters are not allowed here!\n");
                }
                else{
                    System.out.println("Minimum deposite is: " + initialDepoite + " " + currency);
                }
            }

            if(type.equals("current") && region.equals("local")){
                clients.get(clientNumber).account.add(new CurrentAccountLocal(accountStatus, deposite, currency));
            }
            else if(type.equals("current") && region.equals("foreign")){
                clients.get(clientNumber).account.add(new CurrentAccountForeign(accountStatus, deposite, currency));
            }
            else if(type.equals("saving") && region.equals("local")){
                clients.get(clientNumber).account.add(new SavingAccountLocal(accountStatus, deposite, currency));
            }
            else{
                clients.get(clientNumber).account.add(new SavingAccountForeign(accountStatus, deposite, currency));
            }
            System.out.println("\n" + type + " account with "+ region +" currency has been created for this client.\n");
            numberOfAccounts++;
    }
    void displayClientInfoWithoutAccounts(){
        numberOfClients = clients.size();
        System.out.println("Number of clients in database is: " + numberOfClients + "\n");
        for (int i = 0; i < numberOfClients; i++) {
            clients.get(i).display();
            System.out.println("____________________________________");
        }
    }
    void displayClientInfo(){
        if(clients.isEmpty()){
            System.out.println("No clients found!\n");
        }
        else{
            numberOfClients = clients.size();
            System.out.println("Number of clients in database is: " + numberOfClients + "\n");
            for (int i = 0; i < numberOfClients; i++) {
                System.out.println((i+1) + ". "+clients.get(i));
                for (int j = 0; j < clients.get(i).account.size(); j++) {
                    System.out.println((j+1) + ". "+clients.get(i).account.get(j));
                    System.out.println();
                }
                System.out.println("____________________________________");
            }
        }
    }
    void displayClientInfoAndAccountStatus(){
        if(clients.isEmpty()){
            System.out.println("No clients found!\n");
        }
        else{
            numberOfClients = clients.size();
            System.out.println("Number of clients in database is: " + numberOfClients + "\n");
            for (int i = 0; i < numberOfClients; i++) {
                System.out.println((i+1) + ". "+clients.get(i));
                for (int j = 0; j < clients.get(i).account.size(); j++) {
                    System.out.println((j+1) + ". Account type: "+clients.get(i).account.get(j).getAccountType());
                    System.out.println("Account status: "+clients.get(i).account.get(j).getStatus());
                    System.out.println();
                }
                System.out.println("____________________________________");
            }
        }
    }
    
    void updateClientInfo(){
        if(clients.isEmpty()){
            System.out.println("No clients found!\n");
            return;
        }
        numberOfClients = clients.size();
        boolean flag1 = true;
        while (flag1){
            displayClientInfoAndAccountStatus();
            while(true){
                System.out.print("Please select the client you want to upadte his/her info: ");
                selectedClient = onlyNumbers(s.nextLine().trim());
                if(selectedClient > 0 && selectedClient <= numberOfClients){
                    break;
                }
                else if(selectedClient == -1 || selectedClient == -2){
                    System.out.println("Spaces, special character or letters are not allowed here!\n");
                }
                else{
                    System.out.println("Invalid client!\n");
                }
            }
            boolean flag2 = true;
            while(flag2){
                System.out.println("""
                                   
                                   Please select what to update: 
                                   1. First name
                                   2. Last name
                                   3. Age
                                   4. Address
                                   5. Governmental ID
                                   6. Job title
                                   7. Switch account status
                                   8. Return to select another client
                                   9. Return to the main menu
                                   
                                   """);
                switch(s.nextLine().trim()){
                    case "1" -> {
                        update("first name", selectedClient - 1);
                    }
                    case "2" -> {
                        update("last name", selectedClient - 1);
                    }
                    case "3" -> {
                        update("age", selectedClient - 1);
                    }
                    case "4" -> {
                        update("address", selectedClient - 1);
                    }
                    case "5" -> {
                        update("ID", selectedClient - 1);
                    }
                    case "6" -> {
                        update("job title", selectedClient - 1);
                    }
                    case "7" -> {
                        String status;
                        numberOfAccounts = clients.get(selectedClient - 1).account.size();
                        if(numberOfAccounts == 1){
                            //the client has 1 account
                            status = clients.get(selectedClient - 1).account.get(0).getStatus();
                            updateAccountStatus(status, selectedClient - 1, 0);
                        }
                        else{
                            //the client has 2 accounts
                            boolean flag = true;
                            while(flag){
                                System.out.print("Please select the account you want to update its status or press (x) to quit: ");
                                switch(s.nextLine()){
                                    case "1" -> {
                                        status = clients.get(selectedClient - 1).account.get(0).getStatus();
                                        updateAccountStatus(status, selectedClient - 1, 0);
                                    }
                                    case "2" -> {
                                        status = clients.get(selectedClient - 1).account.get(1).getStatus();
                                        updateAccountStatus(status, selectedClient - 1, 1);
                                    }
                                    case "x", "X" -> flag = false;
                                    default -> System.out.println("Invalid selection\n");
                                }
                            }
                        }
                    }
                    case "8" -> {
                        flag2  = false;
                    }
                    case "9" -> {
                        flag1 = false;
                        flag2  = false;
                    }
                    default -> {
                        System.out.println("Invalid Selection!\n");
                    }
                }
            }
        }
    }
    void updateAccountStatus(String status, int selectClient, int selectAccount){
        if(status.equals("Active")){
            System.out.println("The account status will be \"Deactive\"");
            status = "Deactive";
            clients.get(selectClient).account.get(selectAccount).setStatus(status);
        }
        else{
            System.out.println("The account status will be \"Active\"");
            status = "Active";
            clients.get(selectClient).account.get(selectAccount).setStatus(status);
        }
    }
    void update(String type, int select){
        switch(type){
            case "first name"   -> System.out.println("The old " + type + " is: "+ clients.get(select).getClientFirstName());
            case "last name"    -> System.out.println("The old " + type + " is: "+ clients.get(select).getClientLastName());
            case "age"          -> System.out.println("The old " + type + " is: "+ clients.get(select).getAge());
            case "address"      -> System.out.println("The old " + type + " is: "+ clients.get(select).getClientAddress());
            case "ID"           -> System.out.println("The old " + type + " is: "+ clients.get(select).getGovID());
            case "job title"    -> System.out.println("The old " + type + " is: "+ clients.get(select).getJobTitle());
        }
        System.out.print("Update the client " + type + ": ");
        String newItem = s.nextLine().trim();
        switch (type) {
            case "first name"   -> clients.get(select).setClientFirstName(newItem);
            case "last name"    -> clients.get(select).setClientLastName(newItem);
            case "age"          -> clients.get(select).setAge(Integer.parseInt(newItem));
            case "address"      -> clients.get(select).setClientAddress(newItem);
            case "ID"           -> clients.get(select).setGovID(newItem);
            case "job title"    -> clients.get(select).setJobTitle(newItem);
        }
        System.out.println("The client " + type + " has been updated!\n");
    }
    
    void removeClient(){
        boolean flag1 = true;
        while (flag1){
            if(clients.isEmpty()){
                System.out.println("No clients found!\n");
                return;
            }
            displayClientInfoAndAccountStatus();
            numberOfClients = clients.size();
            while(true){
                System.out.print("Please select the client you want to remove: ");
                selectedClient = onlyNumbers(s.nextLine().trim());
                if(selectedClient > 0 && selectedClient <= numberOfClients){
                    break;
                }
                else if(selectedClient == -1 || selectedClient == -2){
                    System.out.println("Spaces, special character or letters are not allowed here!\n");
                }
                else{
                    System.out.println("Invalid client!\n");
                }
            }
            clients.remove(selectedClient - 1);
            System.out.println("\nThe selected client has been removed!\n");
            System.out.println("Do you want to remove another client ? \n1. Yes\n2. No\n");
            while(true){
                switch(s.nextLine().trim()){
                    case "1" -> {
                        flag1 = true;
                    }
                    case "2" -> {
                        flag1 = false;
                    }
                    default -> {
                        System.out.println("Invalid selection!\n");
                        continue;
                    }
                }
                break;
            }
        }
    }
    void removeAccountFromClient(){
        if(clients.isEmpty()){
            System.out.println("No clients found to close accounts\n");
            return;
        }
        boolean flag1 = true;
        while(flag1){
            numberOfClients = clients.size();
            displayClientInfoWithoutAccounts();
            while(true){
                System.out.print("Select the client you want to close his/her account: ");
                selectedClient = onlyNumbers(s.nextLine().trim());
                if(selectedClient > 0 && selectedClient <= numberOfClients){
                    break;
                }
                else if(selectedClient == -1 || selectedClient == -2){
                        System.out.println("Spaces, special character or letters are not allowed here!\n");
                }
                else{
                    System.out.println("Invalid client!\n");
                }
            }
            numberOfAccounts = clients.get(selectedClient - 1).account.size();

            System.out.println("The account(s) that the selected client has: ");
            for (int i = 0; i < numberOfAccounts; i++) {
                System.out.println((i+1)+". "+clients.get(selectedClient - 1).account.get(i)+"\n");
            }
            if(numberOfAccounts == 1){
                System.out.print("Failed to close this account\nThe selected client must have at least one account, Select another client: \n");
            }
            else{
                int selectedAccount;
                while(true){
                    System.out.println("Select the account you want to close for the selected client: ");
                    selectedAccount = onlyNumbers(s.nextLine().trim());
                    if(selectedAccount > 0 && selectedAccount <= numberOfAccounts){
                        break;
                    }
                    else if(selectedAccount == -1 || selectedAccount == -2){
                            System.out.println("Spaces, special character or letters are not allowed here!\n");
                    }
                    else{
                        System.out.println("Invalid client!\n");
                    }
                }
                clients.get(selectedClient - 1).account.remove(selectedAccount - 1);
                System.out.println("The selected account for that the selected client has has been closed!\n");
                
            }
            while(true){
                System.out.println("\nDo you want to continue ?\n1. Yes\n2. No\n");
                switch(s.nextLine().trim()){
                    case "1" -> {
                        flag1 = true;
                    }
                    case "2" -> {
                        flag1 = false;
                    }
                    default -> {
                        System.out.println("Invalid selection!\n");
                    }
                }
                break;
            }
        }
    }
}
