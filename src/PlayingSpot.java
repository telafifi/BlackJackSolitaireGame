
public class PlayingSpot {
	int cardNumber; //Spot number on the table
	Card heldCard; //The card placed on the spot
	int pointVal; //point value of the card
	
	/**
	 * Constructor, builds spot and assigns a position number and places an empty card in it
	 * @param cardNumber
	 */
	public PlayingSpot(int cardNumber) {
		this.heldCard = null; //place empty card
		this.cardNumber = cardNumber; //assign number to spot
	}
	
	/**
	 * Places the current card played in the spot
	 * @param playedCard current card played
	 */
	public void PlaceCard(Card playedCard) {
		this.heldCard = playedCard; //assign current card
		this.pointVal = playedCard.pointVal; //assign card's public variable
	}
	
	
}
