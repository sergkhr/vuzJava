package Prac14;

public class Client {
    public Sittable chair;

    public void setChair(Sittable chair) {
        this.chair = chair;
    }
    public void sit() {
        chair.sit();
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.setChair(new FunctionalChair());
        client.sit();
        System.out.println("summing 1 and 2");
        System.out.println(((FunctionalChair) client.chair).sum(1, 2));
        client.setChair(new VictorianChair(100));
        client.sit();
        client.setChair(new MagicChair());
        client.sit();
    }
}
