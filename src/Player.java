public class Player extends Thread{

    private String playerName;
    private int Number;
    private Card[] hand;
    private CardDeck leftDeck;
    private CardDeck RightDeck;
    
    public Player (int Number){
        setName("player"+Number);
        setNumber(Number);
        setHand(new Card[4]);
    }
    
    public void setRightDeck(CardDeck rightDeck) {
        RightDeck = rightDeck;
    }
    public void setLeftDeck(CardDeck leftDeck) {
        this.leftDeck = leftDeck;
    }
    public CardDeck getLeftDeck() {
        return leftDeck;
    }
    public CardDeck getRightDeck() {
        return RightDeck;
    }
    public String getplayerName() {
        return playerName;
    }
    public void setplayerName(String name) {
        this.playerName = name;
    }
    public int getNumber() {
        return Number;
    }
    public void setNumber(int number) {
        Number = number;
    }
    public Card[] getHand() {
        return hand;
    }
    public void setHand(Card[] hand) {
        this.hand = hand;
    }
}


