
public class Run {

	public static void main(String[] args) {
		//Set important Variables		
		int size = 5;
		int numCycles =  10;
		Boolean printHand = true;
		
		//Variables to run
		Evaluator e = new Evaluator(size);
		float highCard = 0, pair = 0, three = 0, four = 0, fullhouse = 0, straight = 0, flush = 0, twoKind = 0, RoyalFlush = 0, StraightFlush = 0;
		
		//run the test
		for(int i = 0; i <numCycles; i++)
		{
			e.checkEverythingOut();
			if(e.hasRoyalFlush())
				RoyalFlush++;	
			else if(e.hasStraightFlush())
				StraightFlush++;
			else if(e.hasFour())
				four++;
			else if(e.hasFullHouse())
				fullhouse++;
			else if(e.hasFlush())
				flush++;
			else if(e.hasStraight())
				straight++;
			else if(e.hasThree())
				three++;
			else if(e.hasTwoPair())
				twoKind++;
			else if(e.hasPair())
				pair++;	
			else if(e.getHighCard())
				highCard++;
			if(printHand)
				e.print();
		}
		
		//print it
		System.out.print("Results: \n");
		System.out.print("High Card: " + highCard/numCycles + "\n");
		System.out.print("Pair: " + pair/numCycles + "\n");
		System.out.print("Three Kind: " + three/numCycles + "\n");
		System.out.print("Four Kind: " + four/numCycles + "\n");
		System.out.print("Full House: " + fullhouse/numCycles + "\n");
		System.out.print("Flush: " + flush/numCycles + "\n");
		System.out.print("Straight: " + straight/numCycles + "\n");
		System.out.print("Two Kind: " + twoKind/numCycles + "\n");
		System.out.print("Royal Flush: " + RoyalFlush/numCycles + "\n");			
	}
}
