package blackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {

    private  String Name;
    private  int Score= 0 , Number_of_Cards =0 ;
    private Card [] cards = new Card[11];
    private  Boolean get_black_jack = false , lost = false ;
    Player(String name )
    {
        for(int i = 0; i< 11 ; i++)
        {
            cards[i]= new Card();
        }
        this.Name = name;
    }
    public  void add(Card c)
    {
        cards[Number_of_Cards++]=c;
        Score+=c.getValue();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getNumber_of_Cards() {
        return Number_of_Cards;
    }

    public void setNumber_of_Cards(int number_of_Cards) {
        Number_of_Cards = number_of_Cards;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public Boolean getGet_black_jack() {
        return get_black_jack;
    }

    public void setGet_black_jack(Boolean get_black_jack) {
        this.get_black_jack = get_black_jack;
    }

    public Boolean getLost() {
        return lost;
    }

    public void setLost(Boolean lost) {
        this.lost = lost;
    }
}
