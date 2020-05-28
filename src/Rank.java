/**
 * Enumerator to store the various card ranks in a deck and their associated point values 
 * @author tarek
 *
 */
public enum Rank {
	Ace(1),
	Two(2),
	Three(3),
	Four(4),
	Five(5),
	Six(6),
	Seven(7),
	Eight(8),
	Nine(9),
	Ten(10),
	Jack(10),
	Queen(10),
	King(10);
	
	private int rankVal; //point value in the game
	/**
	 * Constructor to associate each rank with a point value
	 * @param rankVal point value of card
	 */
	Rank(int rankVal){
		this.rankVal = rankVal;
	}
	/**
	 * Return the point value of the card
	 * @return
	 */
	public int getRankVal() {
		return this.rankVal;
	}
}
