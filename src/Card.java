
public class Card {
	Suit suit; //Call Suit Enumerator
	Rank rank; //Call Rank Enumerator
	int pointVal; //Store point value of card
	String name; //Store name of card
	
	/**
	 * Card constructor - stores all attributes of current card
	 * @param suit Type of card suit (Diamond, Club, Heart, or Spades)
	 * @param rank Card number (Ace, two, etc..)
	 */
	public Card(Suit suit, Rank rank) {
		this.suit = suit; //store suit
		this.rank = rank; //store rank
		this.pointVal = rank.getRankVal(); //get point value
		this.getName(); //get name
	}
	
	/**
	 * Generates the name of the card used in the game (10D, 9H, KS, etc..)
	 */
	public void getName() {
		/*
		 * spaces in name to allow for 3 character locations in name for consistent board layout
		 * if not a letter rank, just use the point value associated for the name
		 */
		if (this.rank == Rank.Ace) {
			this.name = " A" + this.suit.toString();
		}
		else if (this.rank == Rank.Jack) {
			this.name = " J" + this.suit.toString();
		}
		else if (this.rank == Rank.Queen) {
			this.name = " Q" + this.suit.toString();
		}
		else if (this.rank == Rank.King) {
			this.name = " K" + this.suit.toString();
		}
		else if (this.rank == Rank.Ten) {
			this.name = Integer.toString(this.pointVal) + this.suit.toString();
		}
		else {
			this.name = " " + Integer.toString(this.pointVal) + this.suit.toString();
		}
	}
	/**
	 * Get actual name of the suit used for each card
	 * @return
	 */
	public String suitName() {
		if (this.suit == Suit.C) {
			return "Clubs";
		}
		else if (this.suit == Suit.D) {
			return "Diamonds";
		}
		else if (this.suit == Suit.H) {
			return "Hearts";
		}
		return "Spades";
	}
}
