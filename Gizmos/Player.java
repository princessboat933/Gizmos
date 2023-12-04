import java.util.*;
public class Player {
	
	private HashMap<String, ArrayList<Energy>> energyAcquired = new HashMap<String, ArrayList<Energy>>();
	private HashMap<Integer, ArrayList<Card>> cards = new HashMap<Integer, ArrayList<Card>>();  //key is card type and list of those cards
	//This needs changing in order to declare it   
	private int whenTurn;
	private int score;
	private int tier3Count;
	private int maxEnergy = 5;
	private int maxFile = 1;
	private int maxResearch = 3;
	private int energyCount = 0; //the number of total marbles the player has (NEW)
	private int cardCount = 0; // number of total card the player has (NEW)
	private int dashX;
	private int ogDashX;
	private int[] dashY = new int[6]; 
	private int ogFileX;
	private int fileX; 
	private int fileY;
	private ArrayList<Card> filed = new ArrayList<Card>();
	private ArrayList<Integer> canDo = new ArrayList<Integer>();
	private int ogEnergyY = 688;
	private int ogEnergyX;
	private int energyX;
	

/*	public Player(int num) //sets the coordinate of the dashboard for the player based on player number so that the cards will be painted right
	{
		if(num==1)
		{
			dashX = 349;
			dashY = 42;

			fileX = 820;
			fileY = 60;

			ogEnergyX
		}

		else if(num==2)
		{
			dashX = 952;
			dashY = 42;

			fileX = 1420;
			fileY = 10;

			ogEnergyX
		}
		else if(num==3)
		{
			dashX = 349;
			dashY = 350;

			fileX = 820;
			fileY = 325;

			ogEnergyX
		}
		else
		{
			dashX = 952;
			dashY = 350;

			fileX = 1420;
			fileY = 325;

			ogEnergyX
		}
	}*/
	 public Player(int turn) {
		whenTurn = turn;
		if(turn == 0) {
			energyX = 400;
			for(int i = 0; i < 6; i++) {
				dashY[i] = 45;
			}
			dashX = 350;
			ogDashX = dashX;
			fileX = 820;
			fileY = 60;
		}
		else if(turn == 1) {
			energyX = 680;
			for(int i = 0; i < 6; i++) {
				dashY[i] = 45;
			}
			dashX = 950;
			ogDashX = dashX;
			fileX = 1420;
			fileY = 10;
		}
		else if(turn == 2) {
			energyX = 980;
			for(int i = 0; i < 6; i++) {
				dashY[i] = 355;
			}
			dashX = 350;
			ogDashX = dashX;
			fileX = 820;
			fileY = 325;
		}
		else if(turn == 3) {
			energyX = 1265;
			for(int i = 0; i < 6; i++) {
				dashY[i] = 355;
			}
			dashX = 950;
			ogDashX = dashX;
			fileX = 1420;
			fileY = 325;
		}
		dashY[2] += 17;
		ogEnergyX = energyX;
	}
	public int getScore() {
		return score;
	}
	public void increasePoints(int inc) {
		score += inc;
	}
	public HashMap<Integer, ArrayList<Card>> getBoard() {
		return cards;
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
	public boolean canGo() {
		if(canDo.size() > 0)
			return true;
		return false;
	}
	public void addList(int toDo) {
		canDo.add(toDo);
	}
	public void ungo() {
		for(int i = 0; i < canDo.size(); i++) {
    		for(int c = 0; c < 6; c++) {
    			if(cards.containsKey(c)) {
    				ArrayList<Card> tempArray = cards.get(c);
    				Iterator<Card> iter = tempArray.iterator();
    				while(iter.hasNext()) {
    					Card card = iter.next();
    						card.ungo();
    					}
    				}
    			}
    		}
    }
	
	public void deleteList(int undo) {
		for(int i = 0; i < canDo.size(); i++) {
			if(canDo.get(i) == undo) {
				canDo.remove(i);
			}
		}
	}

	public ArrayList<Integer> getList() {
		return canDo;
	}

	public void clearList() {
		canDo.clear();
	}

	public boolean hasMoved() {
		if (canDo.size() == 0)
			return true;
		if (canDo.get(0) == -1)
			return false;
		return true;
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
		return cardCount;
	}

	public boolean hasBuild() {
		boolean build = false;
		if(build != true) {
			build = true;
		}
		return build;
	}
	
	public boolean canPick() {
		if(energyCount == maxEnergy) {
			return false;
		}
		return true;
		
	}
	public boolean canFile() {
		if(filed.size() >= maxFile)
			return false;
		return true;
		
	}	
	public ArrayList<Card> getFiled() {
		return filed;
	}
	
	public void pick(Energy energy) {
		if (energyAcquired.containsKey(energy.getColor())) {
			ArrayList<Energy> temp = energyAcquired.get(energy.getColor());
			temp.add(energy);
			energyAcquired.put(energy.getColor(), temp);
		}
		else {
			ArrayList<Energy> temp = new ArrayList<Energy>();
			temp.add(energy);
			energyAcquired.put(energy.getColor(), temp);
		}
		changePos();
		energyCount++; //increments whenever a new energy is added
	}

	public int getEnergyCount() {
		return energyCount;
	}
	
	public ArrayList<Energy> build(Card card, ArrayList<Energy> energies) //merissa version; sets the cards into correct location; assumes player has all energies needed
	{
		cardCount++;
		energyCount-=card.getPrice();
		if (cards.containsKey(card.getType())) 
		{
			ArrayList<Card> temp = cards.get(card.getType());
			int x = temp.get(temp.size()-1).getX();
			int y = temp.get(temp.size()-1).getY() + 20;
			card.setLoc(x,y);
			temp.add(card);
			cards.put(card.getType(), temp);
		}
		else 
		{
			ArrayList<Card> temp = new ArrayList<Card>();
			int x = dashX+83*card.getType();
			int y = dashY[card.getType()];
			card.setLoc(x,y);
			temp.add(card);
			cards.put(card.getType(), temp);
		}

		for(int i = 0; i < filed.size(); i++) {
			if(filed.get(i).equals(card)) {
				filed.remove(i);
			}
		}
		energies = removeEnergy(card, energies);
		score += card.getPoints();
		return energies;
	}
	public ArrayList<Energy> removeEnergy(Card card, ArrayList<Energy> energies) {
		ArrayList<Energy> gonnaDie = energyAcquired.get(card.getColor());
		Iterator<Energy> iter = gonnaDie.iterator();
		for(int i = 0; i < card.getPrice(); i++) {
			Energy en = iter.next();
			gonnaDie.remove(en);
			int rand = (int) (Math.random() * energies.size());
			while(rand < 6) {
				rand++;
				rand++;
				rand++;
			}
			energies.add(rand, en);
			iter = gonnaDie.iterator();
		}
		return energies;
	}
	/*
	public ArrayList<Energy> build(Card card, ArrayList<Energy> energies) {
		if (cardsAcquired.containsKey(card.getType())) {
			HashSet<Card> temp = cardsAcquired.get(card.getType());
			temp.add(card);
			cardsAcquired.put(card.getType(), temp);
		}
		else {
			HashSet<Card> temp = new HashSet<Card>();//hello
			temp.add(card);
			cardsAcquired.put(card.getType(), temp);
		}
		for(int i = 0; i < filed.size(); i++) {
			if(filed.get(i).equals(card)) {
				filed.remove(i);
			}
		}
		energies = removeEnergy(card, energies);
		changePos(card);
		return energies;
	}

	public void changePos(Card card) {
		cardX = ogX;
		int type = card.getType();
		cardX = cardX + (80 * type);
		card.setLoc(cardX, cardY[type]);
		cardY[type] += 10;
	}
	*/
	public ArrayList<Energy> getEnergies() //COMPLETE, needs DEBUG/CHECK; MERISSA VERSION
	{
		ArrayList<Energy> values = new ArrayList<Energy>();
		String key ="";
		if(energyAcquired.size() != 0) {
			for(int i = 0; i < 4; i++) {
				if(i == 0)
					key = "red";
				else if(i == 1)
					key = "yellow";
				else if(i == 2)
					key = "black";
				else if(i == 3)
					key = "blue";
				if(energyAcquired.containsKey(key)) {
					for(int x = 0; x < energyAcquired.get(key).size(); x++) {
						values.add(energyAcquired.get(key).get(x));
					}
				}
			}
		}
		return values;
	}

	public ArrayList<Card> getCards(int type) //DONE; MERISSA VERSION; needs DEBUG/CHECK
	{
		ArrayList<Card> c = cards.get(type);
		return c; 
	}
	
    public ArrayList<Card> getCardValues() //Henrique version INCOMPLETE 
	{
		ArrayList<Card> values = new ArrayList<Card>();
		String key = "";
		if(cards.size() != 0) {
			for(int i = 0; i < 6; i++) {
				if(cards.containsKey(i)) {
					for(int x = 0; x < cards.get(i).size(); x++) {
						values.add(cards.get(i).get(x));
					}
				}
			}
		}
		return values;
	}
	public void file(Card card) {
		filed.add(card);
		changeFilePos();
	}
	public void changeFilePos() {
		for(int i = 0; i < filed.size(); i++) {
			Card c = filed.get(i);
			c.setLoc(fileX, fileY + (45*i));
		}
	}

	public void changePos() {
		int x = ogEnergyX; //energy holder place for the player
		int y = ogEnergyY;
		ArrayList<Energy> temp = new ArrayList<Energy>();
		String key = null;
		int count = 0;
		for(int i = 0; i < 4; i++) {
			if(i == 0)
				key = "red";
			else if(i == 1)
				key = "yellow";
			else if(i == 2)
				key = "black";
			else if(i == 3)
				key = "blue";
			if(energyAcquired.containsKey(key)) {
				temp = energyAcquired.get(key);
				Iterator<Energy> iter = temp.iterator();
				while(iter.hasNext()) {
					count++;
					Energy energy = iter.next();
					/*           
					 12345
					 67891
					 23456
			        */
					if(x> ogEnergyX + 100)
						x = ogEnergyX;
					if(count == 6)
						y += 25;
					if(count == 11)
						y += 25;
					if(count == 16)
						y += 25;
					//iii
					energy.setLoc(x, y);
					x += 25;
				}
			}
		}
	}
	public boolean hasEnough(String color, int price) {
		if(energyAcquired.containsKey(color)) {
			if(energyAcquired.get(color).size() >= price) {
				return true;
			}
		}
		return false;
	}
}