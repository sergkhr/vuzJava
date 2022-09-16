package prac19;

public class Hand {
    private int fingerNumber;
    private String orientation;

    public Hand(int fingerNumber, String orientation){
        this.fingerNumber = fingerNumber;
        orientation.toLowerCase();
        this.orientation = orientation;

    }
    public Hand(){
        this.fingerNumber = 5;
        this.orientation = "right";
    }

    public void setFingerNumber(int fingerNumber){
        this.fingerNumber = fingerNumber;
    }
    public int getFingerNumber(){
        return(this.fingerNumber);
    }
    public void setOrientation(String orientation){
        this.orientation = orientation;
    }
    public String getOrientation(){
        return(this.orientation);
    }

    @Override
    public String toString() {
        return "Hand{" +
                "fingerNumber=" + fingerNumber +
                ", orientation='" + orientation + '\'' +
                '}';
    }

    public void grab(){
        System.out.println(this.orientation + " hand grabbed nothing");
    }
}
