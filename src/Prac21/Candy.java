package Prac21;

public class Candy implements Priceable {
    private String name;
    private int price;

    public Candy() {
        this.name = "Candy";
        this.price = 0;
    }

    public Candy(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "A candy with name of " + this.name + ", price of " + this.price;
    }
}
