import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class EvaluatorTest {

	
	int sizeOfHand = 5;
	Evaluator eval = new Evaluator(sizeOfHand);
	@Test
	public void test() {
		testPair();
		test3Kind();
		test4Kind();
		testHouse();
		testStraight();
		testFlush();
		testRoyalFlush();
	}

	private void testRoyalFlush() {
		boolean testBool = false;
		Hand hand = new Hand(5);
		ArrayList<Card> temphand = new ArrayList<Card>(5);
		Card c1 = new Card(1, "DIAMONDS");
		temphand.set(0, c1);
		Card c2 = new Card(10, "DIAMONDS");
		temphand.set(1, c2);
		Card c3 = new Card(11, "DIAMONDS");
		temphand.set(2, c3);
		Card c4 = new Card(12, "DIAMONDS");
		temphand.set(3, c4);
		Card c5 = new Card(13, "DIAMONDS");
		temphand.set(4, c5);
		hand.changeHand(temphand);
		hand.sort();
		Evaluator e = new Evaluator(5);
		e.checkRoyalFlush(hand);
		if (e.hasRoyalFlush())
		{
			testBool = true;
		}
		Card d1 = new Card(1, "HEARTS");
		temphand.set(0, d1);
		Card d2 = new Card(2, "DIAMONDS");
		temphand.set(1, d2);
		Card d3 = new Card(3, "SPADES");
		temphand.set(2, d3);
		Card d4 = new Card(4, "CLUBS");
		temphand.set(3, d4);
		Card d5 = new Card(5, "DIAMONDS");
		temphand.set(4, d5);
		hand.changeHand(temphand);
		hand.sort();
		e.checkRoyalFlush(hand);
		if (e.hasRoyalFlush())
		{
			testBool = false;
		}
		if (!testBool)
		{
			fail("checkRoyalFlush has failed");
		}
	}
	
	private void testFlush() {
		// TODO Auto-generated method stub
		boolean testBool = false;
		Hand hand = new Hand(5);
		ArrayList<Card> temphand = new ArrayList<Card>(5);
		Card c1 = new Card(1, "DIAMONDS");
		temphand.set(0, c1);
		Card c2 = new Card(2, "DIAMONDS");
		temphand.set(1, c2);
		Card c3 = new Card(3, "DIAMONDS");
		temphand.set(2, c3);
		Card c4 = new Card(4, "DIAMONDS");
		temphand.set(3, c4);
		Card c5 = new Card(5, "DIAMONDS");
		temphand.set(4, c5);
		hand.changeHand(temphand);
		hand.sort();
		Evaluator e = new Evaluator(5);
		e.checkFlush(hand);
		if (e.hasFlush())
		{
			testBool = true;
		}
		Card d1 = new Card(1, "HEARTS");
		temphand.set(0, d1);
		Card d2 = new Card(2, "DIAMONDS");
		temphand.set(1, d2);
		Card d3 = new Card(3, "SPADES");
		temphand.set(2, d3);
		Card d4 = new Card(4, "CLUBS");
		temphand.set(3, d4);
		Card d5 = new Card(5, "DIAMONDS");
		temphand.set(4, d5);
		hand.changeHand(temphand);
		hand.sort();
		e.checkFlush(hand);
		if (e.hasFlush())
		{
			testBool = false;
		}
		if (!testBool)
		{
			fail("checkFlush has failed");
		}
	}


	private void testStraight() {
		// TODO Auto-generated method stub
		boolean testBool = false;
		Hand hand = new Hand(5);
		ArrayList<Card> temphand = new ArrayList<Card>(5);
		Card c1 = new Card(1, "HEARTS");
		temphand.set(0, c1);
		Card c2 = new Card(2, "DIAMONDS");
		temphand.set(1, c2);
		Card c3 = new Card(3, "DIAMONDS");
		temphand.set(2, c3);
		Card c4 = new Card(4, "DIAMONDS");
		temphand.set(3, c4);
		Card c5 = new Card(5, "DIAMONDS");
		temphand.set(4, c5);
		hand.changeHand(temphand);
		hand.sort();
		Evaluator e = new Evaluator(5);
		e.checkStraight(hand);
		if (e.hasStraight())
		{
			testBool = true;
		}
		Card d1 = new Card(1, "HEARTS");
		temphand.set(0, d1);
		Card d2 = new Card(2, "DIAMONDS");
		temphand.set(1, d2);
		Card d3 = new Card(3, "DIAMONDS");
		temphand.set(2, d3);
		Card d4 = new Card(2, "CLUBS");
		temphand.set(3, d4);
		Card d5 = new Card(6, "DIAMONDS");
		temphand.set(4, d5);
		hand.changeHand(temphand);
		hand.sort();
		e.checkStraight(hand);
		if (e.hasStraight())
		{
			testBool = false;
		}
		if (!testBool)
		{
			fail("checkStraight has failed");
		}
		
	}

	private void testHouse() {
		// TODO Auto-generated method stub
		boolean testBool = false;
		Hand hand = new Hand(5);
		ArrayList<Card> temphand = new ArrayList<Card>(5);
		Card c1 = new Card(1, "HEARTS");
		temphand.set(0, c1);
		Card c2 = new Card(1, "DIAMONDS");
		temphand.set(1, c2);
		Card c3 = new Card(2, "DIAMONDS");
		temphand.set(2, c3);
		Card c4 = new Card(2, "DIAMONDS");
		temphand.set(3, c4);
		Card c5 = new Card(2, "DIAMONDS");
		temphand.set(4, c5);
		hand.changeHand(temphand);
		hand.sort();
		Evaluator e = new Evaluator(5);
		e.checkFullHouse(hand);
		if (e.hasFullHouse())
		{
			testBool = true;
		}
		Card d1 = new Card(1, "HEARTS");
		temphand.set(0, d1);
		Card d2 = new Card(2, "DIAMONDS");
		temphand.set(1, d2);
		Card d3 = new Card(3, "DIAMONDS");
		temphand.set(2, d3);
		Card d4 = new Card(4, "DIAMONDS");
		temphand.set(3, d4);
		Card d5 = new Card(5, "DIAMONDS");
		temphand.set(4, d5);
		hand.changeHand(temphand);
		hand.sort();
		e.checkFullHouse(hand);
		if (e.hasFullHouse())
		{
			testBool = false;
		}
		if (!testBool)
		{
			fail("checkFullHouse has failed");
		}
	}

	private void test4Kind() {
		// TODO Auto-generated method stub
		boolean testBool = false;
		Hand hand = new Hand(5);
		ArrayList<Card> temphand = new ArrayList<Card>(5);
		Card c1 = new Card(1, "HEARTS");
		temphand.set(0, c1);
		Card c2 = new Card(2, "DIAMONDS");
		temphand.set(1, c2);
		Card c3 = new Card(2, "DIAMONDS");
		temphand.set(2, c3);
		Card c4 = new Card(2, "DIAMONDS");
		temphand.set(3, c4);
		Card c5 = new Card(2, "DIAMONDS");
		temphand.set(4, c5);
		hand.changeHand(temphand);
		hand.sort();
		Evaluator e = new Evaluator(5);
		e.checkFour(hand);
		if (e.hasFour())
		{
			testBool = true;
		}
		Card d1 = new Card(1, "HEARTS");
		temphand.set(0, d1);
		Card d2 = new Card(2, "DIAMONDS");
		temphand.set(1, d2);
		Card d3 = new Card(3, "DIAMONDS");
		temphand.set(2, d3);
		Card d4 = new Card(4, "DIAMONDS");
		temphand.set(3, d4);
		Card d5 = new Card(5, "DIAMONDS");
		temphand.set(4, d5);
		hand.changeHand(temphand);
		hand.sort();
		e.checkFour(hand);
		if (e.hasFour())
		{
			testBool = false;
		}
		if (!testBool)
		{
			fail("checkFour has failed");
		}
	}

	private void test3Kind() {
		// TODO Auto-generated method stub
		boolean testBool = false;
		Hand hand = new Hand(5);
		ArrayList<Card> temphand = new ArrayList<Card>(5);
		Card c1 = new Card(1, "HEARTS");
		temphand.set(0, c1);
		Card c2 = new Card(2, "DIAMONDS");
		temphand.set(1, c2);
		Card c3 = new Card(2, "DIAMONDS");
		temphand.set(2, c3);
		Card c4 = new Card(2, "DIAMONDS");
		temphand.set(3, c4);
		Card c5 = new Card(5, "DIAMONDS");
		temphand.set(4, c5);
		hand.changeHand(temphand);
		hand.sort();
		Evaluator e = new Evaluator(5);
		e.checkThree(hand);
		if (e.hasThree())
		{
			testBool = true;
		}
		Card d1 = new Card(1, "HEARTS");
		temphand.set(0, d1);
		Card d2 = new Card(2, "DIAMONDS");
		temphand.set(1, d2);
		Card d3 = new Card(3, "DIAMONDS");
		temphand.set(2, d3);
		Card d4 = new Card(4, "DIAMONDS");
		temphand.set(3, d4);
		Card d5 = new Card(5, "DIAMONDS");
		temphand.set(4, d5);
		hand.changeHand(temphand);
		hand.sort();
		e.checkThree(hand);
		if (e.hasThree())
		{
			testBool = false;
		}
		if (!testBool)
		{
			fail("checkThree has failed");
		}
	
	}

	private void testPair() {
		// TODO Auto-generated method stub
		boolean testBool = false;
		Hand hand = new Hand(5);
		ArrayList<Card> temphand = new ArrayList<Card>(5);
		Card c1 = new Card(2, "HEARTS");
		temphand.set(0, c1);
		Card c2 = new Card(2, "DIAMONDS");
		temphand.set(1, c2);
		Card c3 = new Card(3, "DIAMONDS");
		temphand.set(2, c3);
		Card c4 = new Card(4, "DIAMONDS");
		temphand.set(3, c4);
		Card c5 = new Card(5, "DIAMONDS");
		temphand.set(4, c5);
		hand.changeHand(temphand);
		hand.sort();
		Evaluator e = new Evaluator(5);
		e.checkPair(hand);
		if (e.hasPair())
		{
			testBool = true;
		}
		Card d1 = new Card(1, "HEARTS");
		temphand.set(0, d1);
		Card d2 = new Card(2, "DIAMONDS");
		temphand.set(1, d2);
		Card d3 = new Card(3, "DIAMONDS");
		temphand.set(2, d3);
		Card d4 = new Card(4, "DIAMONDS");
		temphand.set(3, d4);
		Card d5 = new Card(5, "DIAMONDS");
		temphand.set(4, d5);
		hand.changeHand(temphand);
		hand.sort();
		e.check2Pair(hand);
		if (e.hasPair())
		{
			testBool = false;
		}
		if (!testBool)
		{
			fail("checkPair has failed");
		}
	}

	
	
}
