import java.util.Scanner;
public class BlackjackSolitaire {

	/**
	 * Constructor
	 */
	public BlackjackSolitaire() {
		
	}
	/**
	 * method to play blackjack solitaire
	 */
	void play() {
		Scanner userInputScanner = new Scanner(System.in); //instantiate scanner to read user input
		Deck myDeck = new Deck(); //instantiate deck
		myDeck.Shuffle(); //shuffle deck
		PlayingTable myTable = new PlayingTable(); //instantiate playing table
		System.out.println("Beginning game of Blackjack Solitaire");
		
		while (!myTable.IsGameFinished()) { //keep playing until all cards have been filled
			myTable.DisplayTable(); //show current state of table
			Card currentCard = myDeck.Deal(); //deal next card
			System.out.println("The current playing card is the " + currentCard.rank.toString() + " of " + currentCard.suitName()
				+ " (" + currentCard.name + ")"); //show current card in play
			System.out.println("Input a number corresponding to a location on the board to place the card and then press Enter");
			int location = userInputScanner.nextInt(); //read playing spot number placed in by user
			while (!myTable.AssignCardToSpot(location, currentCard)) { //try assigning card to spot
				System.out.println("The location entered is already filled, please choose another spot to place card");
				location = userInputScanner.nextInt(); //if spot is full ask user to input a different number
			}
			System.out.print("\n\n\n"); //Leave space between rounds
			//Display current score
			System.out.println("Card has been placed! Your current score is " + Integer.toString(myTable.TableScore()));
			
		}
		myTable.DisplayTable(); //show final state of the table
		System.out.println("Game is complete! Final score is " + Integer.toString(myTable.TableScore())); //show final score
		userInputScanner.close();
	}
}
