package InputManipulation;

public class InputManipulations {
    public static int onlyNumbers(String s){
        int c = 0;
        if(s.length() == 0){
            return -2;
        }
        char [] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if(!(str[i] >= 48 && str[i] <= 57)){
                c++;
                break;
            }
        }
        if(c != 0){
            return -1;
        }
        else{
            return Integer.parseInt(String.valueOf(str));
        }
    }
    public static String onlyStringNumbers(String s){
        int c = 0;
        if(s.length() == 0){
            return " ";
        }
        char [] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if(!(str[i] >= 48 && str[i] <= 57)){
                c++;
                break;
            }
        }
        if(c != 0){
            return "";
        }
        else{
            return String.valueOf(str);
        }
    }
    public static double onlyNumbersDouble(String s){
        int c = 0;
        char [] str = s.toCharArray();
        if(str.length == 0){
            return -2;
        }
        for (int i = 0; i < str.length; i++) {
            if(!(str[i] >= 48 && str[i] <= 57)){
                c++;
                break;
            }
        }
        if(c != 0){
            return -1;
        }
        else{
            return Integer.parseInt(String.valueOf(str));
        }
    }
    
    public static String numbersAndLetters(String s){
        int c = 0;
        char [] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if(!((str[i] >= 65 && str[i] <= 90)|| 
                (str[i] >= 97 && str[i] <= 122)|| 
                (str[i] >= 48 && str[i] <= 57) ||
                     str[i] == 32)){
                c++;
                break;
            }
        }
        if(c != 0){
            return "";
        }
        else{
            return String.valueOf(str);
        }
    }
    
    public static String onlyLetters(String s){
        int c = 0;
        char [] str = s.toCharArray();
        if(str.length == 0){
            return " ";
        }
        for (int i = 0; i < str.length; i++) {
            if(!((str[i] >= 65 && str[i] <= 90)|| 
                (str[i] >= 97 && str[i] <= 122)|| 
                     str[i] == 32)){
                c++;
                break;
            }
        }
        if(c != 0){
            return "";
        }
        else{
            return String.valueOf(str);
        }
    }
    public static String lettersNumbersAndCharacters(String s){
        int c = 0;
        if(s.length() == 0){
            return " ";
        }
        char [] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if(!(str[i] >= 32 || str[i] <= 126)){
                c++;
                break;
            }
        }
        if(c != 0){
            return "";
        }
        else{
            return String.valueOf(str);
        }
    }
    public static String numbersAndLettersWithoutSpaces(String s){
        int c = 0;
        char [] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if(!((str[i] >= 65 && str[i] <= 90)|| 
                (str[i] >= 97 && str[i] <= 122)|| 
                (str[i] >= 48 && str[i] <= 57))){
                c++;
                break;
            }
        }
        if(c != 0){
            return "";
        }
        else{
            return String.valueOf(str);
        }
    }
    /*public static String passwordSpecific(String s){
        int upperCase = 0;
        int lowerCase = 0;
        int specialChar = 0;
        char [] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if(!(str[i] >= 65 && str[i] <= 90)){
                upperCase++;
                break;
            }
            if(!(str[i] >= 97 && str[i] <= 122)){
                lowerCase++;
                break;
            }
            if(!(str[i] >= 65 && str[i] <= 90) || 
                  (str[i] >= 65 && str[i] <= 90) || 
                    (str[i] >= 65 && str[i] <= 90) || ){
                upperCase++;
                break;
            }
        }
        if(c != 0){
            return "";
        }
        else{
            return String.valueOf(str);
        }
    }*/
}
