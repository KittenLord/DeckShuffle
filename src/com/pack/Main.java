package com.pack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        List<Card> deck = dealer.getSortedDeck();
    }
}

// A 2 3 4 5 6 7 8 9 T J Q K

// Clubs Diamonds Hearts Spades

class Card implements Comparable{
    private int cardValue;
    private int cardSuit;

    public final static String[] Values = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
    public final static String[] Suits = {"Clubs", "Diamonds","Hearts", "Spades"};

    public Card(int cv, int cs){
        cardValue = cv % Values.length;
        cardSuit = cs % Suits.length;
    }

    @Override
    public String toString(){
        return Values[cardValue] + " " + Suits[cardSuit];
    }

    @Override
    public int compareTo(Object o) { // Comparing isnt really needed here actually, but added it anyways
        Card anotherCard = (Card)o;
        Card thisCard = this;

        return (thisCard.cardSuit - anotherCard.cardSuit) * 20 + (thisCard.cardValue - anotherCard.cardValue);
    }
}

class Dealer{
    public List<Card> getSortedDeck(){
        ArrayList<Card> l = new ArrayList<Card>();
        for(int cs = 0; cs < Card.Suits.length; cs++){
            for(int cv = 0; cv < Card.Values.length; cv++){
                l.add(new Card(cv, cs));
            }
        }
        return l;
    }

    public List<Card> getMixedDeck(){
        List<Card> l = getSortedDeck();

        Collections.shuffle(l);

        return l;
    }
}