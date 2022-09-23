package Prac20;

public class HunterDog extends Dog {
    private String breed;

    public HunterDog() {
        super();
        this.breed = "Hound";
    }

    public HunterDog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "A hunter dog with name of " + this.name + ", age of " + this.age + ", breed of " + this.breed;
    }

    @Override
    public void bark() {
        System.out.println("Bark! Bark! Bark!");
    }
}

