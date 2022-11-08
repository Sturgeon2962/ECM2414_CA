public class Player extends Thread{

    private String playerName;
    private int number;
    private Card[] hand;
    private CardDeck leftDeck;
    private CardDeck rightDeck;
    private String outputFile;
 
    public Player (int number){
        setName("player"+number);
        setNumber(number);
        setHand(new Card[4]);
        setOutputFile("player"+number+".txt");
    }
        
    public String getOutputFile() {
        return outputFile;
    }
    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }
    public void setRightDeck(CardDeck rightDeck) {
        this.rightDeck = rightDeck;
    }
    public void setLeftDeck(CardDeck leftDeck) {
        this.leftDeck = leftDeck;
    }
    public CardDeck getLeftDeck() {
        return leftDeck;
    }
    public CardDeck getRightDeck() {
        return rightDeck;
    }
    public String getplayerName() {
        return playerName;
    }
    public void setplayerName(String name) {
        this.playerName = name;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public Card[] getHand() {
        return hand;
    }
    public void setHand(Card[] hand) {
        this.hand = hand;
    }
}


