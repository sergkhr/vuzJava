package Prac21;

public class ComplicatedCandy implements Priceable{
    private int sweetness;
    private int price;
    private int weight;

    public ComplicatedCandy() {
        this.sweetness = 0;
        this.price = 0;
        this.weight = 0;
    }

    public ComplicatedCandy(int sweetness,  int weight) {
        this.sweetness = sweetness;
        this.price = sweetness * weight;
        this.weight = weight;
    }

    public int getSweetness() {
        return this.sweetness;
    }

    public void setSweetness(int sweetness) {
        this.sweetness = sweetness;
    }

    public int getPrice() {
        return this.price;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "A candy with sweetness of " + this.sweetness + ", price of " + this.price + ", weight of " + this.weight;
    }
}
