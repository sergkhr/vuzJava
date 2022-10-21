package Prac14;

public class VictorianChair implements Sittable {
    private int age;
    public VictorianChair(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    @Override
    public void sit() {
        System.out.println("Sit on Victorian chair");
    }
    @Override
    public String toString() {
        return "Victorian chair, age: " + age;
    }
}
