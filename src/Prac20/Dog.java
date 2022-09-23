package Prac20;

public abstract class Dog {
    protected String name;
    protected int age;

    public Dog() {
        this.name = "Dog";
        this.age = 0;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "A dog with name of " + this.name + ", age of " + this.age;
    }

    public abstract void bark();

    public static void dogTest() {
        Dog[] dogs = new Dog[4];
        dogs[0] = new FancyDog("MeatStick", 5, "Poodle");
        dogs[1] = new FancyDog("FunnyEars", 5, "Poodle with strange ears");
        dogs[2] = new HunterDog("Alfred", 5, "Butler hound");
        dogs[3] = new HunterDog("Roberto", 5, "Hound");

        for (Dog dog : dogs) {
            System.out.println(dog.toString());
            dog.bark();
        }
    }
}
