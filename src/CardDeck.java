import java.io.IOException;
import java.util.ArrayList;

public class CardDeck implements EndGameEventListener {
    ArrayList<Card> cards;
    private BasicWrite output;
    private String deckName;

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public BasicWrite getOutputFile() {
        return output;
    }

    public void setOutputFile(BasicWrite outputFile) {
        this.output = outputFile;
    }

    /**
     * Creates new empty deck.
     * 
     * @param int of the decks number
     * @throws IOException
     */
    public CardDeck(int deckNum) throws IOException{
        cards = new ArrayList<>(); 
        setOutputFile(new BasicWrite("deck"+deckNum+".txt"));
        setDeckName("deck"+deckNum);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    
    /**
     * Adds given card to the bottom of the deck.
     * 
     * @param card to add to the deck
     */
    public void addCard(Card card){
        cards.add(card);
    }

    /**
     * Removes and returns the top card of the deck.
     * 
     * @return Card that is on top of the deck
     */
    public Card removeCard(){
        return cards.remove(0);
    }

    @Override
    public void eventOccured(EndGameEvent event) throws IOException {
        String contents = "";
        for (Card card : cards) {
            contents = contents + " " + card.getDenomination();
        }
        output.writeToFile(deckName + " contents:" + contents);
    }
}
