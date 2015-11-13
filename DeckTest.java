import static org.junit.Assert.*;

import org.junit.Test;


public class DeckTest {

	@Test
	public void test() {
		testConstructor();
		testShuffle();
	}
	public void testConstructor()
	{
		Deck deck = new Deck();
		assertEquals(deck.size(), 52);
	}
	public void testShuffle()
	{
		Deck deck = new Deck();
		
		for (int i = 0 ; i < deck.size()-2; i++)
		{
			if(deck.getCard(i).getSuit()==deck.getCard(i+1).getSuit() &&
					deck.getCard(i).getSuit()==deck.getCard(i+2).getSuit())
			{
				if(deck.getCard(i).getValue() == deck.getCard(i+1).getValue()+1 &&
						deck.getCard(i).getValue() == deck.getCard(i+2).getValue()+2)
					fail("Shuffle Failed");
			}
		}
	}
}
