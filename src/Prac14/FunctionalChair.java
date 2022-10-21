package Prac14;

public class FunctionalChair implements Sittable {
    public int sum(int a, int b) {
        return a + b;
    }
    @Override
    public void sit() {
        System.out.println("Sit on functional chair");
    }
    @Override
    public String toString() {
        return "Functional chair";
    }
}
