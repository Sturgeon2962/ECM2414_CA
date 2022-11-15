import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Player extends Thread implements EndGameEventListener{

    private String playerName;
    private int number;
    private Card[] hand;
    private CardDeck leftDeck;
    private CardDeck rightDeck;
    private BasicWrite output;

    /**
     * Creates a new player with the given number used to specify:
     * <ul>
     * <li>player name</li>
     * <li>player number</li>
     * <li>player output file</li>
     * </ul>
     * Also creates an empty hand.
     * 
     * @param number the player number
     */
    public Player (int number) throws IOException {
        setplayerName("player "+number);
        setNumber(number);
        setHand(new Card[4]);
        setOutput(new BasicWrite("player"+number+".txt"));
    }

    public BasicWrite getOutput() {
        return output;
    }
    public void setOutput(BasicWrite output) {
        this.output = output;
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

    /**
     * Chooses a random card which if not of the target denomination to discard.
     * 
     * @return int conatining the index of the chosen card
     */
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

    /**
     * Adds a card to the free position in the players hand.
     * 
     * @param newCard the Card to be added to hand
     * @throws HandFullException if the player's hand already contains 4 cards
     */
    public void addCard(Card newCard) throws HandFullException {
        for (int i = 0; i < this.hand.length; i++) {
            if (this.hand[i] == null) {
                this.hand[i] = newCard;
                return;
            }
        }
        throw new HandFullException("Hand is full of cards");
    }

    /**
     * Removes and returns the card at the given index.
     * 
     * @param index of the card to be removed
     * @return the Card that has been removed
     */
    public Card removeCard(int index) {
        Card temp = this.hand[index];
        this.hand[index] = null;
        return temp;
    }

    /**
     * Checks if the player has won i.e. all cards in hand are equal in denomination.
     * 
     * @return true if player has won, false otherwise
     */
    public boolean checkWin(){
        boolean win = true;
        if (hand[0] == null) {
            return false;
        }
        int firstCard = hand[0].getDenomination();
        for(Card card : hand){
            if(card == null || card.getDenomination() != firstCard){
                win = false;
                break;
            }
        }
        return win;
    }

    @Override
    public void eventOccured(EndGameEvent event) throws IOException{
        output.writeToFile("");
        if (CardGame.getWinner().equals(playerName)) {
            output.writeToFile(playerName + " wins");
        } else {
            output.writeToFile(CardGame.getWinner() + " has informed " + playerName + " that " + CardGame.getWinner() + " has won");
        }
        output.writeToFile(playerName + " exits");
        output.writeToFile(playerName + " final hand: " + hand[0].getDenomination() + " " + hand[1].getDenomination() + " " + hand[2].getDenomination() + " " + hand[3].getDenomination());
    }

    @Override
    public void run(){
        try {
            output.writeToFile(playerName + " initial hand " + hand[0].getDenomination() + " " + hand[1].getDenomination() + " " + hand[2].getDenomination() + " " + hand[3].getDenomination());
        } catch (IOException e) {
            System.out.println("IO error occurred");
        }
        for (;;) {
            if (CardGame.getWinner() != null) {
                break;
            }
            if(checkWin()){
                System.out.println(playerName + " wins!");
                CardGame.setWinner(playerName);
                EndGameEvent gameOverEvent = new EndGameEvent(this, playerName);
                try {
                    for(EndGameEventListener listener : CardGame.players) {
                        listener.eventOccured(gameOverEvent);
                    }
                    for(EndGameEventListener listener : CardGame.decks) {
                        listener.eventOccured(gameOverEvent);
                    }
                } catch (IOException e) {
                    System.out.println("IO error has occured");
                }
            } else {
                synchronized(this){
                    if (CardGame.getWinner() != null) {
                        break;
                    }
                    if (leftDeck.getCards().size() < 1) {
                        continue;
                    }
                    Card cardToRemove = removeCard(selectDiscardCard());
                    rightDeck.addCard(cardToRemove);
                    Card newCard = leftDeck.removeCard();
                    try {
                        addCard(newCard);
                    } catch (HandFullException e) {
                        System.out.println("Player hand full");
                    }
                    try {
                        output.writeToFile("");
                        output.writeToFile(playerName + " draws a " + newCard.getDenomination() + " from " + leftDeck.getDeckName());
                        output.writeToFile(playerName + " discards a " + cardToRemove.getDenomination() + " to " + rightDeck.getDeckName());
                        output.writeToFile(playerName + " current hand is " + hand[0].getDenomination() + " " + hand[1].getDenomination() + " " + hand[2].getDenomination() + " " + hand[3].getDenomination());
                    } catch (IOException e) {
                        System.out.println("IO error occurred");
                    }
                }
            }
        }
    }
}
