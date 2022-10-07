package Prac9;

import java.util.Scanner;

public class OnlineShop {
    /**
     * checks the given inn (here inn must be the length of name)
     * @param args the command line arguments
     */
    protected boolean isValidINN(String name, int inn){
        return name.length() == inn;
    }
    public void makePurchase(String name, int inn) throws BadINNException{
        if(!isValidINN(name, inn)){
            throw new BadINNException("Invalid INN");
        }
        System.out.println("Purchase made");
    }

    public static void main(String[] args) {
        OnlineShop shop = new OnlineShop();
        Scanner in = new Scanner(System.in);
        System.out.println("To make purchase, please");
        System.out.println("Enter your name:");
        String name = in.nextLine();
        System.out.println("Enter your INN:");
        int inn = in.nextInt();
        try{
            shop.makePurchase(name, inn);
        }catch(BadINNException e){
            System.out.println(e.getMessage());
        }
    }
}
