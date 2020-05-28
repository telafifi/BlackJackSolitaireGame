
public class Deck {
	Card[] myDeck = new Card[52]; //Stores the 52 cards included in a deck
	int cardLocation; //stores current card number used in game - used to draw the next card from the deck
	
	/**
	 * Constructor - Builds the deck of cards with 4 suits and 13 ranks per suit
	 */
	public Deck() {
		this.cardLocation = 0; //Initialize card location - draw first card
		Suit suits[] = Suit.values(); //get array of suits
		Rank ranks[] = Rank.values(); //get array of ranks
		int cardNumber = 0;
		//Go through each suit and add all ranks associated to the deck
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				myDeck[cardNumber] = new Card(suits[i],ranks[j]); 
				cardNumber++;
			}
		}
	}
	
	/**
	 * Shuffle the deck using a random number generator
	 */
	public void Shuffle() {
		int[] randomOrder = RandomOrderGenerator.getRandomOrder(52); //create an array of random numbers from 1-52
		Card[] shuffledDeck = new Card[52];
		for (int i = 0; i < shuffledDeck.length; i++) {
			int val = randomOrder[i] - 1; //get the value within of the array (subtract 1 for 0 indexing)
			shuffledDeck[i] = this.myDeck[val]; //store random card in ith position
		}
		this.myDeck = shuffledDeck; //store shuffled deck in public myDeck array
	}
	
	/**
	 * Deal the next card in the game
	 * @return the next card for drawn
	 */
	public Card Deal() {
		Card currentCard = this.myDeck[this.cardLocation]; //grab the next card to use
		this.cardLocation++; //increment cardLocation variable for use for the next Deal()
		return currentCard; //return card for play
	}
	

}
