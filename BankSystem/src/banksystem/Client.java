package banksystem;

import java.util.ArrayList;

public class Client {
    private String clientFirstName;
    private String clientLastName;
    private int age;
    private String clientAddress;
    private String govID;
    private String jobTitle;
    private String userName;
    private String passWord;
    public static int serial = 410000000;
    ArrayList <Account> account = new ArrayList<>(2);

    public Client(String clientFirstName, 
            String clientLastName, 
            int age, 
            String clientAddress, 
            String govID, 
            String jobTitle, 
            String passWord, 
            String userName) {
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.age = age;
        this.clientAddress = clientAddress;
        this.govID = govID;
        this.jobTitle = jobTitle;
        this.passWord = passWord;
        this.userName = userName;
        serial++;
    }
    public int getSerial(){
        return serial;
    }
    public String getGovID() {
        return govID;
    }

    public void setGovID(String govID) {
        this.govID = govID;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    

    @Override
    public String toString() {
        return "Client Name: " + clientFirstName +" "+ clientLastName + 
               "\nAge :" + age + 
               "\nAddress: " + clientAddress + 
               "\nGovement ID: " + govID +
               "\nJob Title: " + jobTitle + "\n"+
               "\nAccount(s) information: "+
               "\n-----------------------";
    }
    public void display(){
        System.out.println("Client Name: " + clientFirstName +" "+ clientLastName + 
               "\nAge :" + age + 
               "\nAddress: " + clientAddress + 
               "\nGovement ID: " + govID +
               "\nJob Title: " + jobTitle + "\n");
    }
}
