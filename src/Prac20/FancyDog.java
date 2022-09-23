package Prac20;

public class FancyDog extends Dog {
    private String breed;

    public FancyDog() {
        super();
        this.breed = "Poodle";
    }

    public FancyDog(String name, int age, String breed) {
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
        return "A fancy dog with name of " + this.name + ", age of " + this.age + ", breed of " + this.breed;
    }

    @Override
    public void bark() {
        System.out.println("Woof! Woof! Woof!");
    }
}

