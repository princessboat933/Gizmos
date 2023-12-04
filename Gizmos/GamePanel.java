import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//click
//tier 1: x-(35, 122) y-(29, 91)
//tier 2: 1 largest x+33
//tier 3: 2 largest x+33

/* marbles:
 * size- 35x35
 * pick1: (256, 750) - drawImage
 */

public class GamePanel extends JPanel implements MouseListener
{
    private BufferedImage bg;
    private ArrayList<HashSet<Card>> canActivate = new ArrayList<HashSet<Card>>();;
    private int turn = 0;
    private int reacted = 0;
    private String action = "";
    //arraylist of all energies
    private ArrayList<Energy> energies = new ArrayList<Energy>();
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Card> card1 = new ArrayList<Card>();
    private ArrayList<Card> card2 = new ArrayList<Card>();
    private ArrayList<Card> card3 = new ArrayList<Card>();

    public GamePanel(ArrayList<Energy> energies, ArrayList<Player> players, ArrayList<Card> cards) {
        try {
            bg = ImageIO.read(GamePanel.class.getResource("/images/gameBoardBack.JPG"));

        } catch (IOException e) {

            System.out.println("oh no! Exception Error!");
            return;
        }
        this.players = players;
        for(int i = 0; i < 4; i++) {
        	canActivate.add(new HashSet<Card>());
        }
        this.energies = energies;
        for(int i = 0; i < 36; i++) {
        	card1.add(cards.get(0));
        	cards.remove(0);
        }
        for(int i = 0; i < 36; i++) {
        	card2.add(cards.get(0));
        	cards.remove(0);
        }
        for(int i = 0; i < 36; i++) {
        	card3.add(cards.get(0));
        	cards.remove(0);
        }
        addMouseListener(this);
        players.get(turn).addList(-1);
        shuffleCard(card1);
        shuffleCard(card2);
        shuffleCard(card3);
    }
    
   
    public void setEnergyPos() //done, coordinates right
    {
        int x = 250;
        int y = 750;
        for(int i=5; i>=0; i--)
        {
            energies.get(i).setRad(35);
            energies.get(i).setLoc(x, y);
            x += 16;
            y -= 31;
        }
    }

    public void setTierCardPos(int tier) //merissa fix coordinates
    {
    	int x;
    	int y = 90;
        if(tier == 1) {
        	x = 25;
        	for(int i = 0; i < 4; i++) {
				card1.get(i).setLoc(x,y);
        		y += 60;
        		
        	}
        }
        else if(tier == 2) {
        	x = 125;
        	for(int i = 0; i < 3; i++) {
        		card2.get(i).setLoc(x,y);
        		y += 60;
        	}
        }
        else if(tier == 3) {
        	x = 225;
        	for(int i = 0; i < 2; i++) {
        		card3.get(i).setLoc(x,y);
        		y += 60;
        	}
        }
    }

       

    public void paint(Graphics g) {
        //board background
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
        g.setColor(new Color(255, 255, 255));
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
    	g.drawString(""+(turn + 1), 856, 50);
    	g.setColor(new Color(255, 255, 255));
    	g.drawRect(15, 400, 100, 100);
    	g.setColor(new Color(0, 0, 0));
    	g.fillRect(15, 400, 100, 100);
    	g.setColor(new Color(255, 255, 255));
    	g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
    	g.drawString("End Turn", 25, 450);
    	g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
    	int xx = 0;
    	for(int i = 0; i < 4; i++) {
    		if(i == 0) {
    			xx = 615;
    			g.drawString(""+players.get(i).getScore(), xx, 775);
    		}
    		else if(i == 1) {
    			xx = 900;
    			g.drawString(""+players.get(i).getScore(), xx, 775);
    		}
    		else if(i == 2) {
    			xx = 1205;
    			g.drawString(""+players.get(i).getScore(), xx, 775);
    		}
    		else if(i == 3) {
    			xx = 1480;
    			g.drawString(""+players.get(i).getScore(), xx, 775);
    		}
    	}
    	
       //marbles
         //set position for first six marbles in list
        setEnergyPos();
        for(int i=0; i<6; i++)
        {
            Energy tempDraw = energies.get(i);
            g.drawImage(tempDraw.getImg(), tempDraw.getX(), tempDraw.getY(), tempDraw.getRad(), tempDraw.getRad(), null);
        }

        //each player's marbles and cards
        for(int i=0; i<4; i++)
        {
            ArrayList<Energy> temp = players.get(i).getEnergies();
            for (int x = 0; x < temp.size(); x++) {
                g.drawImage(temp.get(x).getImg(), temp.get(x).getX(), temp.get(x).getY(), temp.get(x).getRad(), temp.get(x).getRad(), null);
            }
        }

        //Henrique version of display tier cards; merissa will check and edit if needed 
        for(int t=1; t <=3; t++) {
        	setTierCardPos(t);
        	if(t == 1) {
        		for(int i = 0; i < 4; i++) {
        			Card card = card1.get(i);
        			g.drawImage(card.getImage(), card.getX(), card.getY(), 60, 60, null);
        		}
        	}
        	else if(t == 2) {
        		for(int i = 0; i < 3; i++) {
        			Card card = card2.get(i);
        			g.drawImage(card.getImage(), card.getX(), card.getY(), 60, 60, null);
        		}
        	}
        	else if(t == 3) {
        		for(int i = 0; i < 2; i++) {
        			Card card = card3.get(i);
        			g.drawImage(card.getImage(), card.getX(), card.getY(), 60, 60, null);
        		}
        	}
        }
        for(int i=0; i<4; i++) {
            ArrayList<Card> temp = players.get(i).getCardValues();
            for (int x = 0; x < temp.size(); x++) {
            	Card card = temp.get(x);
                g.drawImage(card.getImage(), card.getX(), card.getY(), card.getRad(), card.getRad(), null);
            }
        }
        for(int i =0; i < 4; i++) {
        	for(int x = 0; x < players.get(i).getFiled().size(); x++) {
        		Card card = players.get(i).getFiled().get(x);
        		g.drawImage(card.getImage(), card.getX(), card.getY(), card.getRad(), card.getRad(), null);
        	}
        }
        //display player cards
        
    }
    public void shuffleCard(ArrayList<Card> cards) {
    	for(int i = 0; i < cards.size(); i++) {
    		int rand = (int)(Math.random() * cards.size());
    		Card oldCard = cards.get(rand);
    		cards.set(rand, cards.get(i));
    		cards.set(i, oldCard);
    	}
    }
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        int x = e.getX();
        int y = e.getY();
        //marble
        if(players.get(turn).canGo()) {
        	if(reacted == 4 && x > 130 && x < 230 && y > 635 && y < 705 && players.get(turn).canPick()) {
        		int rand = (int)(Math.random() * energies.size() - 6) + 6;
        		if(rand > 5) {
        			players.get(turn).pick(energies.get(rand));
        			reacted = 0;
        			energies.remove(rand);
        		}	
        	}
        	for(int i = 0; i < 6; i++) {
            	if ((x >= energies.get(i).getX() && x <= energies.get(i).getX() + 35) && ( y >= energies.get(i).getY() && y <= energies.get(i).getY() + 35) && (players.get(turn).getList().get(0) == -1|| reacted == 3) && players.get(turn).canPick()) {
            		reacted = 0;
                	players.get(turn).pick(energies.get(i));
                	players.get(turn).deleteList(-1);
                	if(energies.get(i).getColor().equals("red"))
						players.get(turn).addList(14);
					else if(energies.get(i).getColor().equals("yellow"))
						players.get(turn).addList(15);
					else if(energies.get(i).getColor().equals("blue"))
						players.get(turn).addList(13);
					else if(energies.get(i)	.getColor().equals("black"))
						players.get(turn).addList(16);
                	energies.remove(i);
                	repaint();
                	break;
            	}
        	}
        //card check
        	for(int i = 0; i < players.get(turn).getList().size(); i++) {
        		HashMap<Integer, ArrayList<Card>> temp = players.get(turn).getBoard();
        		if(temp != null) {
        			for(int c = 0; c < 6; c++) {
        				if(temp.containsKey(c) && !(players.get(turn).getList().get(i) == -1)) {
        					ArrayList<Card> tempHash = temp.get(c);
        					Iterator<Card> iter = tempHash.iterator();
        					while(iter.hasNext()) {
        						Card card = iter.next();
        						if(card.activates(players.get(turn).getList().get(i))) {
        							canActivate.get(turn).add(card);
        							System.out.println("test");
        						}
        					}
        				}
        			}
        		}
        	}
        }
        	if(x >= 15 && x <= 115 && y >= 400 && y <= 500 && players.get(turn).hasMoved()) {
        		players.get(turn).ungo();
        		players.get(turn).clearList();
        		turn++;
        		reacted = 0;
        		if(turn > 3) {
        			turn = 0;
        		}
        		players.get(turn).addList(-1);
        	}
        	repaint();

        }
    public void setAction(String act, Card card) {
    	action = act;
    	boolean canGo = false;
    	if(act.equals("activate")) {
    		Iterator<Card> iter =canActivate.get(turn).iterator();
    		for(int i = 0; i < canActivate.get(turn).size(); i++) {
    			Card c = iter.next();
    			if (!card.hasGone() && card.equals(c)) {
    				System.out.println("e");
    				reacted = card.reacts();
    				if(reacted == 1)
    					players.get(turn).increasePoints(1);
    				else if(reacted == 2) 
    					players.get(turn).increasePoints(2);
    				System.out.println(reacted);
    				canActivate.get(turn).remove(card);
    				card.go();
    			}
    			
    			
    		}
    	}
    	if(act.equals("build")) {
    		for(int i = 0; i < players.get(turn).getFiled().size(); i++) {
    			if (players.get(turn).getFiled().get(i).equals(card))
    				canGo = true;
    		}
    		for(int t=1; t <=3; t++) {
    			ArrayList<Card> cards;
    			if(t == 1) 
    				cards = card1;
    			else if(t == 2)
    				cards = card2;
    			else if(t == 3)
    				cards = card3;
    			else
    				cards = null;
    				for(int i = 0; i < 4; i++) {
    					if (card.equals(cards.get(i)) || canGo) {
    						String color = card.getColor();
    						int price = card.getPrice();
    						if(players.get(turn).hasEnough(color, price) && (players.get(turn).getList().get(0) == -1)) {
    							energies = players.get(turn).build(card, energies);
    							if(card.getColor().equals("red"))
    								players.get(turn).addList(4);
    							else if(card.getColor().equals("yellow"))
    								players.get(turn).addList(5);
    							else if(card.getColor().equals("blue"))
    								players.get(turn).addList(6);
    							else if(card.getColor().equals("black"))
    								players.get(turn).addList(7);
    							players.get(turn).deleteList(-1);
    							cards.remove(i);
    							repaint();
    							break;
    						}
    					}
    				}
    		}
    	}
    	if(act.equals("file") && players.get(turn).canFile()) {
        	for(int t=1; t <=3; t++) {
        		ArrayList<Card> cards;
        		if(t == 1) 
        			cards = card1;
        		else if(t == 2)
        			cards = card2;
        		else if(t == 3)
        			cards = card3;
        		else
        			cards = null;
        			for(int i = 0; i < 4; i++) {
        				if (card.equals(cards.get(i))) {
        					if(players.get(turn).getList().get(0) == -1) {
        						players.get(turn).file(card);
        						players.get(turn).addList(1);
        						players.get(turn).deleteList(-1);
        						cards.remove(i);
        						repaint();
        						break;
        					}
        				}
        			}
        		}
    	}
    	if(act.equals("fileR") && players.get(turn).canFile()) {
        	for(int t=1; t <=3; t++) {
        		ArrayList<Card> cards;
        		if(t == 1) 
        			cards = card1;
        		else if(t == 2)
        			cards = card2;
        		else if(t == 3)
        			cards = card3;
        		else
        			cards = null;
        			for(int i = cards.size() - 1; i > ((cards.size() -1) - players.get(turn).getMaxResearch()); i--) {
        				if (card.equals(cards.get(i))) {
        					if(players.get(turn).getList().get(0) == -1) {
        						players.get(turn).file(card);
        						players.get(turn).addList(1);
        						players.get(turn).deleteList(-1);
        						cards.remove(i);
        						repaint();
        						break;
        					}
        				}
        			}
        		}
    	}
    	if(act.equals("buildR")) {
    		for(int t=1; t <=3; t++) {
    			ArrayList<Card> cards;
    			if(t == 1) 
    				cards = card1;
    			else if(t == 2)
    				cards = card2;
    			else if(t == 3)
    				cards = card3;
    			else
    				cards = null;
    				for(int i = cards.size() - 1; i > ((cards.size() -1) - players.get(turn).getMaxResearch()); i--) {
    					if (card.equals(cards.get(i)) || canGo) {
    						String color = card.getColor();
    						int price = card.getPrice();
    						if(players.get(turn).hasEnough(color, price) && (players.get(turn).getList().get(0) == -1)) {
    							energies = players.get(turn).build(card, energies);
    							if(card.getColor().equals("red"))
    								players.get(turn).addList(4);
    							else if(card.getColor().equals("yellow"))
    								players.get(turn).addList(5);
    							else if(card.getColor().equals("blue"))
    								players.get(turn).addList(6);
    							else if(card.getColor().equals("black"))
    								players.get(turn).addList(7);
    							players.get(turn).deleteList(-1);
    							cards.remove(i);
    							repaint();
    							break;
    						}
    					}
    				}
    		}
    	}
    }
    public ArrayList<Card> getDeck1() {
    	return card1;
    }
    public ArrayList<Card> getDeck2() {
    	return card2;
    }
    public ArrayList<Card> getDeck3() {
    	return card3;
    }
    public int getMaxResearch() {
    	return players.get(turn).getMaxResearch();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

        }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

        }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

        }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        }
    }