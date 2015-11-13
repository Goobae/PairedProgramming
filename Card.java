
public class Card {
	/*
	 * Value represents which card it corresponds to. 
	 * 1 = ace
	 * 2 = 2
	 * 3 = 3
	 * ..............
	 * 11 = Jack
	 * 12 = Queen
	 * 13 = King
	 * */
	int value;
	String suit;
	public Card()
	{
		value = 0;
		suit = "";
	}
	public Card(int value, String suit)
	{
		this.setValue(value);
		this.setSuit(suit);
	}
	//Getters and Setters
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	//Print Card
	public void printCard(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.value);
		String cardVal = sb.toString();
		
		if(this.value == 1){
			cardVal="A";
		}
		else if(this.value == 11){
			cardVal="J";
		}
		else if(this.value == 12){
			cardVal="Q";
		}
		else if(this.value == 13)
		{
			cardVal="K";
		}
		
		System.out.print(cardVal + " of " + this.suit + "\n");
	}
}
