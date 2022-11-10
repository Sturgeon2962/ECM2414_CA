public class Card {
    /**
     * attributes for the card class
     */
    private int denomination;

    public synchronized int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    /**
     * Constructor to create a card object
     * @param value Integer for the value of the card
     */
    public Card(int value){
        setDenomination(value);
    }

}
