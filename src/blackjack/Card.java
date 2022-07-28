package blackjack;

public class Card {
   private  int Suit , Rank , Value;
    public int getSuit() {
        return Suit;
    }

    public void setSuit(int suit) {
        Suit = suit;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public int getValue() {

        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }
    Card(){
        Suit= 0;
        Rank=0;
        Value=0;
    }
    Card(Card i ){
        Suit = i.getSuit();
       Rank = i.getRank();
       Value =i.getValue();
    }
    private int num_of_card=0,score=0;
    private Card[] cards = new Card[52];
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNum_of_card() {
        return num_of_card;
    }

    public void setNum_of_card(int num_of_card) {
        this.num_of_card = num_of_card;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}
