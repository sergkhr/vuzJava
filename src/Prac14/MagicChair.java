package Prac14;

public class MagicChair implements Sittable {
    public void doMagic() {
        System.out.println("Magic chair does magic");
    }
    @Override
    public void sit() {
        System.out.println("Sit on magic chair");
    }
    @Override
    public String toString() {
        return "Magic chair";
    }
}
