package com.pack;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Dealer d = new Dealer();
        ArrayList<Card> l = d.getMixedDeck();

        for(int i = 0; i < l.size(); i++){
            System.out.println(l.get(i));
        }
        System.out.println("Deck's size is: " + l.size());
    }
}

// A 2 3 4 5 6 7 8 9 T J Q K

// Clubs Diamonds Hearts Spades

class Card{
    private int cardValue;
    private int cardSuit;

    private static String[] Values = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
    private static String[] Suits = {"Clubs", "Diamonds","Hearts", "Spades"};

    public Card(int cv, int cs){
        cardValue = cv % Values.length;
        cardSuit = cs % Suits.length;
    }

    @Override
    public String toString(){
        return Values[cardValue] + " " + Suits[cardSuit];
    }
}

class Dealer{
    public ArrayList<Card> getSortedDeck(){
        ArrayList<Card> l = new ArrayList<Card>();
        for(int cs = 0; cs < 4; cs++){
            for(int cv = 0; cv < 13; cv++){
                l.add(new Card(cv, cs));
            }
        }
        return l;
    }

    public ArrayList<Card> getMixedDeck(){
        ArrayList<Card> l = getSortedDeck();
        ArrayList<Card> ln = new ArrayList<Card>();

        int c = l.size();

        Random r = new Random();

        for(int i = 0; i < c; i++){
            int current = r.nextInt(l.size());
            ln.add(l.get(current));
            l.remove(current);
        }


        return ln;
    }
}