
public class PlayingTable {
	PlayingSpot[] tableLayout = new PlayingSpot[20]; //creates the playing table using 20 spots, 16 playing and 4 discard
	
	/**
	 * Constructor, create the 20 playing spots
	 */
	public PlayingTable() {
		for (int i = 0; i < this.tableLayout.length; i++) {
			this.tableLayout[i] = new PlayingSpot(i+1); //assign a playing spot a number between 1 and 20
		}
	}
	
	/**
	 * Show the current state of the playing table
	 */
	public void DisplayTable() {
		String spaces = "      "; //used to create distance between the spots for ease of user viewing
		String[] tableValues = new String[20]; //store the current values of the spots
		for (int i = 0; i < this.tableLayout.length; i++) {
			if (this.tableLayout[i].heldCard == null) { //if no card has been placed, show the spot number
				if (this.tableLayout[i].cardNumber < 10) {
					tableValues[i] = "  " + Integer.toString(this.tableLayout[i].cardNumber); //add two spaces for single digits
				}
				else {
					tableValues[i] = " " + Integer.toString(this.tableLayout[i].cardNumber); //add one space for double digits
				}
			}
			else {
				tableValues[i] = this.tableLayout[i].heldCard.name; //show card name if a card has been placed
			}
		}
		System.out.println("Playing Table:");
		for (int i = 0; i < 16; i++) { //display playing spots
			System.out.print(tableValues[i]);
			System.out.print(spaces);
			if (i == 4 || i == 9 || i == 12) {
				System.out.println(); //separate lines in game per rules
				if (i != 4) {
					System.out.print(spaces + "   "); //fourth and fifth rows have 3 spots instead of 5
				}
			}
		}
		System.out.println();
		System.out.println("Discard Pile:");
		for (int i = 16; i < 20; i++) { //displace discard 
			System.out.print(tableValues[i]);
			System.out.print(spaces);
		}
		System.out.println();
	}
	/**
	 * Add a card to a position and return true if successfully added
	 * @param location assigned position
	 * @param cardPlaced card to be placed
	 * @return
	 */
	public boolean AssignCardToSpot(int location, Card cardPlaced) {
		if (this.tableLayout[location - 1].heldCard == null) {
			this.tableLayout[location - 1].PlaceCard(cardPlaced); //place a card if no card currently resides in the spot
			return true;
		}
		return false; //otherwise return false to prompt user to enter a different location
	}
	/**
	 * Score the rows/columns individually
	 * @param cardsInLine row/column to score
	 * @return
	 */
	public int ScoreLine(PlayingSpot[] cardsInLine) {
		int score = 0;
		boolean isAceIncluded = false; //check if an ace is included in the line
		for (int i = 0; i < cardsInLine.length; i++) {
			if (cardsInLine[i].heldCard != null) {
				score += cardsInLine[i].heldCard.pointVal; //add point value of card
				if (cardsInLine[i].heldCard.rank == Rank.Ace) {
					isAceIncluded = true; //if ace is included then make true
				}
			}
			else {
				return 0; //if line is not fully populated then score = 0
			}
		}
		if (isAceIncluded && (score + 10 <= 21)) {
			score += 10; //if an ace is included and the score + 10 is <= 21 then ace counts as 11 instead of 1
		}
		//Below is the provided algorithm for scoring points
		if (score <= 16) {
			return 1;
		}
		else if (score > 21) {
			return 0;
		}
		
		if (score == 21) {
			if (cardsInLine.length == 2) {
				return 10; //blackjack
			}
			else {
				return 7;
			}
		}
		return score - 15;
	}

	/**
	 * Score all rows and columns
	 * @return total score on table
	 */
	public int TableScore() {
		//define rows and columns in game
		PlayingSpot[] row1 = { tableLayout[0] ,tableLayout[1] ,tableLayout[2] ,tableLayout[3] ,tableLayout[4] };
		PlayingSpot[] row2 = { tableLayout[5] ,tableLayout[6] ,tableLayout[7] ,tableLayout[8] ,tableLayout[9] };
		PlayingSpot[] row3 = { tableLayout[10] ,tableLayout[11] ,tableLayout[12] };
		PlayingSpot[] row4 = { tableLayout[13] ,tableLayout[14] ,tableLayout[15] };
		PlayingSpot[] column1 = { tableLayout[0] ,tableLayout[5] };
		PlayingSpot[] column2 = { tableLayout[1] ,tableLayout[6] ,tableLayout[10] ,tableLayout[13] };
		PlayingSpot[] column3 = { tableLayout[2] ,tableLayout[7] ,tableLayout[11] ,tableLayout[14] };
		PlayingSpot[] column4 = { tableLayout[3] ,tableLayout[8] ,tableLayout[12] ,tableLayout[15] };
		PlayingSpot[] column5 = { tableLayout[4] ,tableLayout[9] };
		//sum up the score for all rows and columns
		int totalScore = this.ScoreLine(row1) + this.ScoreLine(row2) + this.ScoreLine(row3) + this.ScoreLine(row4)
		+ this.ScoreLine(column1) + this.ScoreLine(column2) + this.ScoreLine(column3) + this.ScoreLine(column4) + this.ScoreLine(column5);
		return totalScore;
	}
	/**
	 * Check if game is finished by checking if all playing spots are full
	 * @return true if game is finished
	 */
	public boolean IsGameFinished() {
		for (int i = 0; i < 16; i++) {
			if (this.tableLayout[i].heldCard == null) { 
				return false; //if a spot has not been filled then the game is not finished
			}
		}
		return true;
	}


}
