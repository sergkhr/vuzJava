package Prac21;

public interface Priceable {
    int getPrice();
    public static void priceTest(){
        Candy candy = new Candy("Candy", 10);
        System.out.println(candy.toString());
        System.out.println(candy.getPrice());
        ComplicatedCandy complicatedCandy = new ComplicatedCandy(10, 10);
        System.out.println(complicatedCandy.toString());
        System.out.println(complicatedCandy.getPrice());
    }
}
