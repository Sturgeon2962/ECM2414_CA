import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

    public int selectDiscardCard() {
        ArrayList<Card> discardCandidates = new ArrayList<>();

        for (Card card : this.hand) {
            if (card.getDenomination() != this.number) {
                discardCandidates.add(card);
            }
        }

        Collections.shuffle(discardCandidates);

        Card toDisCard = discardCandidates.get(0);

        for (int i = 0; i < hand.length; i++) {
            if (this.hand[i].equals(toDisCard)) {
                return i;
            }
        }

        return -1;
    }

    public void addCard(Card newCard) throws HandFullException {
        for (int i = 0; i < this.hand.length; i++) {
            if (this.hand[i] == null) {
                this.hand[i] = newCard;
                return;
            }
        }
        throw new HandFullException("Hand is full of cards");
    }

    public Card removeCard(int index) {
        Card temp = this.hand[index];
        this.hand[index] = null;
        return temp;
    }
}


