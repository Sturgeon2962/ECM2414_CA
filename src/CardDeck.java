import java.util.ArrayList;

public class CardDeck {
    ArrayList<Card> cards;    

    public CardDeck(){
        cards = new ArrayList<>(); 
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    public void addCard(Card card){
        cards.add(card);
    }

    public Card removeCard(){
        Card temp = cards.get(0);
        cards.remove(0);
        return temp;
    }
}
