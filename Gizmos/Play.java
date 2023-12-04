/* THIS NEEDS TO BE UPDATED ONCE EVERYTHING ELSE WITHIN THE CODE WORKS*/


public class Play {

	private boolean [] turnOver;
	private int currPlayer = 0;
	
	public void revealCardInfo() {
		
	}
	public void doAbilities() {
		
	}
	public void calculateRank() {
		//get the players score
		//potentially use a for loop to order each player according to the ammount of points they have.
	}
	public void gameStatus() {
		
	}
	public void nextPlayer() {
		currPlayer++;
		if(currPlayer == 3) {
			currPlayer = 0;
		}
	}
}