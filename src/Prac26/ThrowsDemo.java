package Prac26;

import java.util.Scanner;

public class ThrowsDemo {
    public void getKey(){
        Scanner myScanner = new Scanner( System.in );

        System.out.print("Enter Key ");
        while (true) {
            String key = myScanner.nextLine();
            try {
                printDetails(key);
                return;
            } catch (Exception e) {
                System.out.println("Invalid key: '" + e.getMessage() + "', try again");
            }
        }
    }
    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println( message ); }
    private String getDetails(String key) throws Exception {
        if(key.equals("")) {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        ThrowsDemo obj = new ThrowsDemo();
        obj.getKey();
    }
}
