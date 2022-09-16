package prac19;

public class Leg {
    private int strength;
    private String orientation;

    public Leg(int strength, String orientation) {
        this.strength = strength;
        orientation.toLowerCase();
        this.orientation = orientation;
    }
    public Leg(){
        this.strength = 10;
        this.orientation = "right";
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "strength=" + strength +
                ", orientation='" + orientation + '\'' +
                '}';
    }

    public void kick(){
        System.out.println(this.orientation + " leg kicked with strength " + this.strength);
    }
}
