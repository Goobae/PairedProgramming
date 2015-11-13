
public class Evaluator {

	private Hand hand;
	private int handSize;
	private boolean isHighCard = false, isPair = false, isThree = false, isFour = false, isStraight = false, isFlush = false, isFullHouse = false, isTwoPair = false, isRoyalFlush = false, isStraightFlush = false;	
	
	public Evaluator(int sizeOf)
	{
		handSize=sizeOf;
		hand= new Hand(sizeOf);
	}

	public void newHand(int sizeOf)
	{
		hand.makeHand(sizeOf);
	}
	
	public Hand getHand()
	{
		return hand;
	}
	
	public void setHand(Hand newHand)
	{
		hand = newHand;
	}
	
	public void print()
	{
		hand.printHand();
	}
	
	public void checkEverythingOut()
	{
		newHand(handSize);
		setUpBooleans(hand);
	}
	
	public void setUpBooleans(Hand check) 
	{
		checkRoyalFlush(check);
		if (!hasRoyalFlush()) {
			checkStraightFlush(check);
			if (!hasStraightFlush()) {
				checkFour(check);
				if (!hasFour()) {
					checkFullHouse(check);
					if (!hasFullHouse()) {
						checkFlush(check);
						if (!hasFlush()) {
							checkStraight(check);
							if (!hasStraight()) {
								checkThree(check);
								if (!hasThree()) {
									checkPair(check);
									if (!hasTwoPair()) {
										checkPair(check);
										if (!hasPair()) {
											isHighCard = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	
	public void checkPair(Hand check)
	{
		for(int i=1; i< check.size(); i++)
		{
			if(check.get(i).getValue()==check.get(i-1).getValue())
			{
				isPair = true;
				break;
			}
		}
	}
	
	public void checkThree(Hand check)
	{
		for(int i=2; i< check.size(); i++)
		{
			if(check.get(i).getValue()==check.get(i-1).getValue() &&
					check.get(i).getValue()==check.get(i-2).getValue())
			{
				isThree = true;
				break;
			}
		}
	}
	
	public void checkFour(Hand check)
	{
		for(int i=3; i< check.size(); i++)
		{
			if(check.get(i).getValue()==check.get(i-1).getValue() && 
					check.get(i).getValue()==check.get(i-2).getValue() &&
					check.get(i).getValue()==check.get(i-3).getValue())
			{
				isFour = true;
				break;
			}
		}
	}
	
	public void checkStraight(Hand check)
	{		
		boolean hasAce = false;
		boolean checkLow = true;
		
		if(check.get(0).getValue()==1)
		{
			hasAce = true;
		}
		
		if(hasAce)
		{
			//check for high Straight
			for(int i = check.size()-1; i>check.size()-5; i--)
			{
				if(check.get(i).getValue()==check.get(i-1).getValue()-1)
				{
					isStraight = true;
					checkLow = false;
				}
				else
				{
					isStraight = false;
					break;
				}
			}
						
			if(checkLow)
			{
				//check for low Straight
				for(int i = 1; i< check.size(); i++)
				{
					if(check.get(i).getValue()==check.get(i-1).getValue()-1)
					{
						isStraight = true;
					}
					else
					{
						isStraight = false;
						break;
					}
				}
			}
		}
		else
		{		
			for(int i = 1; i< check.size(); i++)
			{
				if(check.get(i).getValue()==check.get(i-1).getValue()-1)
				{
					isStraight = true;
				}
				else
				{
					isStraight = false;
					break;
				}
			}
		}
	}

	public void checkFlush(Hand check)
	{
		for(int i=1; i< check.size(); i++)
		{
			if(check.get(i).getSuit()==check.get(i-1).getSuit())
			{
				isFlush = true;
			}
			else
			{
				isFlush = false;
				break;
			}
		}
	}
	
	public void checkStraightFlush(Hand check)
	{
		checkStraight(check);
		checkFlush(check);
		
		if(isStraight && isFlush)
			isStraightFlush = true;
		else
			isStraightFlush = false;		
	}
	
	public void checkFullHouse(Hand check)
	{
		boolean hasTwo = false, hasThree=false;
		int cardVal = 0;
		
		for(int i=2; i< check.size(); i++)
		{
			if(check.get(i).getValue()==check.get(i-1).getValue() &&
					check.get(i).getValue()==check.get(i-2).getValue())
			{
				hasThree=true;
				cardVal=check.get(i).getValue();
				break;
			}
		}

		for(int i=1; i< check.size(); i++)
		{
			if(check.get(i).getValue()!= cardVal)
			{
				if(check.get(i).getValue()==check.get(i-1).getValue()-1)
				{
					hasTwo=true;
					break;
				}
			}
		}		
		
		if(hasTwo && hasThree)
		{
			isFullHouse = true;
		}
	}
	
	public void checkTwo(Hand check)
	{
		boolean pairs[] = {false, false};
		int counter = 0;
		for (int i = 0; i < check.size() - 1; i++)
		{
			if (check.get(i).getValue() == check.get(i + 1).getValue())
			{
				pairs[counter] = true;
				counter++;
			}
			if (counter > 1)
				break;
		}
		if (pairs[0] && pairs[1])
		{
			isTwoPair = true;
		}
	}
	
	public void checkRoyalFlush(Hand check)
	{	
		boolean hasAce = false;
		boolean hasAStraight = false;
		
		if(check.get(0).getValue()==1)
		{
			hasAce = true;
		}
		
		if(hasAce)
		{
			//check for high Straight
			for(int i = check.size()-1; i>check.size()-5; i--)
			{
				if(check.get(i).getValue()==check.get(i-1).getValue()-1)
				{
					hasAStraight = true;
				}
				else
				{
					hasAStraight = false;
					break;
				}
			}
		}	
		
		checkFlush(check);
		
		if(isFlush && hasAStraight)
			isRoyalFlush = true;
	}

	
	
	//Return Val of the test
	public boolean getHighCard(){
		return true;
	}
	public boolean hasPair()
	{
		return isPair;
	}
	public boolean hasThree()
	{
		return isThree;
	}
	public boolean hasFour()
	{
		return isFour;
	}
	public boolean hasFullHouse()
	{
		return isFullHouse;
	}
	public boolean hasTwoPair()
	{
		return isTwoPair;
	}
	public boolean hasStraight()
	{
		return isStraight;
	}
	public boolean hasFlush()
	{
		return isFlush;
	}
	public boolean hasStraightFlush()
	{
		return isStraightFlush;
	}
	public boolean hasRoyalFlush()
	{
		if(isFlush && isStraight)
		{
			return true;
		}
		else
			return false;
	}	
}
