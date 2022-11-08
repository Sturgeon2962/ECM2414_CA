public class Player {

    private String name;
    private Integer Number;
    private Card[] hand;
    
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
    public Card[] getHand() {
        return hand;
    }
    public void setHand(Card[] hand) {
        this.hand = hand;
    }
}


