package prac19;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private List<Head> heads;
    private List<Leg> legs;
    private List<Hand> hands;
    private int health;

    public Human(){
        this.heads = new ArrayList<>();
        this.heads.add(new Head());
        this.legs = new ArrayList<>();
        this.legs.add(new Leg(10, "right"));
        this.legs.add(new Leg(10, "left"));
        this.hands = new ArrayList<>();
        this.hands.add(new Hand(5, "right"));
        this.hands.add(new Hand(5, "left"));
        this.health = 100;
    }
    public Human(List<Head> heads, List<Leg> legs, List<Hand> hands, int health){
        this.heads = new ArrayList<>(heads);
        this.legs = new ArrayList<>(legs);
        this.hands = new ArrayList<>(hands);
        this.health = health;
    }

    public Head cutHead(){
        if(heads.size() > 0) return(heads.remove(0));
        return(null);
    }
    public boolean cutHead(Head head){
        return(heads.remove(head));
    }
    public void addHead(Head head){
        this.heads.add(head);
    }

    public Hand cutHand(){
        if(hands.size() > 0) return(hands.remove(0));
        return(null);
    }
    public boolean cutHand(Hand hand){
        return(hands.remove(hand));
    }
    public void addHand(Hand hand){
        this.hands.add(hand);
    }

    public Leg cutLeg(){
        if(legs.size() > 0) return(legs.remove(0));
        return(null);
    }
    public boolean cutLeg(Leg leg){
        return(legs.remove(leg));
    }
    public void addLeg(Leg leg){
        this.legs.add(leg);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Human{\n" +
                " heads=" + heads +
                ",\n legs=" + legs +
                ",\n hands=" + hands +
                ",\n health=" + health +
                "\n}";
    }

    public void fight(){
        for(Hand hand : hands){
            hand.grab();
        }
        for(Leg leg : legs){
            leg.kick();
        }
        this.health -= 10;
    }

    public static void humanTest(){
        Human human = new Human();
        System.out.println(human.toString());
        System.out.println();
        human.fight();
        System.out.println();
        Hand thirdHand = new Hand(3, "middle");
        human.addHand(thirdHand);
        human.cutHead();
        System.out.println(human);
    }
}
