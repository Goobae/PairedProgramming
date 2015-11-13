import static org.junit.Assert.*;

import org.junit.Test;


public class CardTest {
	
	@Test
	public void test() {
		
		if (!testConstructor())
		{
			fail("constructor failed");
		}
		testGettersAndSetters();
		
	}
	public boolean testConstructor()
	{
		Card c = new Card();
		if (!(c.getSuit() == ""))
		{
			return false;
		}
		if (!(c.getValue() == 0))
		{
			return false;
		}
		
		
		Card c2 = new Card(1, "HEARTS");
		if (!(c2.getSuit() == "HEARTS"))
		{
			return false;
		}
		if (!(c2.getValue() == 1))
		{
			return false;
		}
		return true;
	}
	public void testGettersAndSetters()
	{
		Card c = new Card();
		//c.setIndex(0);
		//assertEquals(0, c.getIndex());
		c.setSuit("HEARTS");
		assertEquals("HEARTS", c.getSuit());
		c.setValue(1);
		assertEquals(1, c.getValue());
	}
}
