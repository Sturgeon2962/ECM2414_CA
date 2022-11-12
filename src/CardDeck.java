import java.util.ArrayList;

public class CardDeck {
    ArrayList<Card> cards;    

    /**
     * Creates new empty deck.
     */
    public CardDeck(){
        cards = new ArrayList<>(); 
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
}
