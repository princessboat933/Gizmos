import java.util.*;
public class Player {
	
	private Energy hashmap;
	private Card <cardType, Set<Card>> cards;  //This needs changing in order to declare it
	private int score;
	private int tier3Count;
	private int maxEnergy;
	private int maxFile;
	private int maxResearch;
	
	public int getScore() {
		return score;
	}
	public int getMaxEnergy() {
		return maxEnergy;
	}
	public int getMaxFile() {
		return maxFile;
	}
	public int getMaxResearch() {
		return maxResearch;
	}
	public int getTier3Count() {
		return tier3Count;
	}
	public boolean isTurn() {
		boolean turn = false;
		if(turn != true) {
			turn = true;
		}
		return turn;
	}
	public int getNumCards() {
		//This needs to be updated once the cards become made
	}
	public boolean hasBuild() {
		boolean build = false;
		if(build != true) {
			build = true;
		}
		return build;
	}
}
