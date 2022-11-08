import java.lang.reflect.Array;

public class Player {

    public String name;
    public Integer Number;
    private Array hand;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getNumber() {
        return Number;
    }
    public void setNumber(Integer number) {
        Number = number;
    }
    public Array getHand() {
        return hand;
    }
    public void setHand(Array hand) {
        this.hand = hand;
    }
}
