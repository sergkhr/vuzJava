package prac19;

public class Head {
    private int eyeCount;
    private int intelligence;

    public Head(){
        this.eyeCount = 2;
        this.intelligence = 10;
    }
    public Head(int eyeCount, int intelligence){
        this.eyeCount = eyeCount;
        this.intelligence = intelligence;
    }

    public int getEyeCount() {
        return eyeCount;
    }

    public void setEyeCount(int eyeCount) {
        this.eyeCount = eyeCount;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        return "Head{" +
                "eyeCount=" + eyeCount +
                ", intelligence=" + intelligence +
                '}';
    }

    public void think(){
        System.out.println("some thoughts for " + this.intelligence + " intelligence");
    }
}
