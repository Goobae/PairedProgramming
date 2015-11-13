import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck{
	
	int cardsLeft;
	
	private ArrayList<Card> deck_array;
	public Deck()
	{
		getNewDeck();
		shuffle();
	}
	private void getNewDeck()
	{
		deck_array = new ArrayList<Card>(52);
		String suit = "HEARTS";
		int value = 1;
		for (int i = 0; i < 52; i++)
		{
			if (i == 13)
			{
				suit = "DIAMONDS";
				value = 1;
			}
			else if (i == 26)
			{
				suit = "SPADES";
				value = 1;
			}
			else if (i == 39)
			{
				suit = "CLUBS";
				value = 1;
			}
			Card newCard = new Card(value, suit);
			deck_array.add(newCard);
			value++;
		}
		cardsLeft = deck_array.size();
	}
	
	public int topofDeck()
	{
		return cardsLeft;
	}
	
	public void cardPulled()
	{
		if(cardsLeft<5)
		{
			shuffle();
		}
		cardsLeft--;	
	}
	int size()
	{
		return deck_array.size();
	}
	
	Card getCard(int position)
	{
		Card c;
		c = deck_array.get(position);
		return c;
	}
	public void shuffle()
	{
		//Getting Random Number
		int j = 0;
		long millis = System.currentTimeMillis();
		Random rnd = new Random();
		rnd.setSeed(millis);
		
		//Shuffle it
		for(int i = 0; 0 < deck_array.size(); i++)
		{
			if(i == 51)
			{
				break;
			}
			j=rnd.nextInt(51);
			Collections.swap(deck_array, i, j);
		}
		
		//Deck is full
		cardsLeft=deck_array.size();
	}
}
