public class Card extends Thread {
    /**
     * attributes for the card class
     */
    private int denomination;

    /**
     * @return
     */
    public synchronized int getDenomination() {
        return denomination;
    }

    /**
     * @param denomination
     */
    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    /**
     * Constructor to create a card object
     * @param value
     */
    public Card(int value){
        setDenomination(value);
    }

}
