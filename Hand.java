import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	Deck deck = new Deck();
	ArrayList<Card> hand = new ArrayList<Card>();
	
	Hand(int sizeOf)
	{
		makeHand(sizeOf);
	}
		
	public void sort()
	{
		//Go through the hand
		for(int i=1; i<hand.size(); i++)
		{
			//Check to see if the previous cards value is larger than the current
			if(hand.get(i).getValue()<hand.get(i-1).getValue())
			{
				//swap the cards if previous is larger than the current
				Collections.swap(hand, i-1, i);
				
				//go back to beginning of the hand to keep swapping cards
				i=0;
			}
		}
	}
	
	public ArrayList<Card> makeHand(int size)
	{		
		hand.clear();
		
		for(int i = 0; i<size; i++)
		{
			hand.add(deck.getCard(deck.topofDeck()-1-i));
			deck.cardPulled();
		}
		
		sort();
		
		return hand;
	}
	
	public void printHand()
	{
		for(int i=0; i<hand.size(); i++)
		{
			hand.get(i).printCard();
		}
		System.out.print("\n");
	}
	
	public void changeHand(ArrayList <Card> hand)
	{
		this.hand=hand;
	}
	
	public int size() {
		return hand.size();
	}


	public Card get(int i) {
		return hand.get(i);
	}
}
