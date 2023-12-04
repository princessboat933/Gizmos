// just for switching between panels

import java.awt.*;
import java.util.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.imageio.ImageIO.*;


public class Gizmos implements MouseListener{

    private JPanel[] panelList = new JPanel[3];
    private int current;
    private JPanel panels;
    private ArrayList<Energy> allEnergy = new ArrayList<Energy>();
    private ArrayList<Player> allPlayer = new ArrayList<Player>();
    private ArrayList<Card> allCards = new ArrayList<Card>();;
    private GamePanel game;
    private ZoomPanel zoom;
    private Card zoomed = null;
    private boolean hasntRes = true;

    public Gizmos(ArrayList<Card> all) {
    	for(int i = 0; i < all.size(); i++) {
    		allCards.add(all.get(i));
    	}
        for(int i = 0; i < 4; i++) {
        	allPlayer.add( new Player(i));
        }
        for (int x = 0; x < 4; x++) {
             for(int i = 0; i < 13; i++) {
                if(x == 0) {
                    try {
						allEnergy.add(new Energy("red", ImageIO.read(Gizmos.class.getResource("/images/redEnergy.png"))));
					} catch (IOException e) {
						e.printStackTrace();
					}
                }
                else if(x == 1) {
                    try {
						allEnergy.add(new Energy("yellow", ImageIO.read(Gizmos.class.getResource("/images/yellowEnergy.png"))));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                else if(x == 2) {
                    try {
						allEnergy.add(new Energy("blue", ImageIO.read(Gizmos.class.getResource("/images/blueEnergy.png"))));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                else if(x == 3) {
                    try {
						allEnergy.add(new Energy("black", ImageIO.read(Gizmos.class.getResource("/images/blackEnergy.png"))));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
             }
        }

        JFrame frame = new JFrame();
        shuffleEnergies(allEnergy);
        JPanel game = new GamePanel(allEnergy, allPlayer, all);
        JPanel main = new MainPanel();
        JPanel zoom = new ZoomPanel();
        this.zoom = (ZoomPanel) zoom;
        this.game = (GamePanel) game;
        current = 0;
        panelList[0] = main;
        panelList[1] = game;
        panelList[2] = zoom;
        game.addMouseListener(this);
        main.addMouseListener(this);
        zoom.addMouseListener(this);

        panels = new JPanel(new CardLayout());
        panels.add(main, "Main");
        panels.add(game, "Game");
        panels.add(zoom, "Zoom");

        Container pane = frame.getContentPane();
        pane.add(panels, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 960);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x + " " + y);
        //changes from main menu
        if (current == 0 && x > 614 && x < 918 && y > 410 && y < 510) {
        	CardLayout cl = (CardLayout)(panels.getLayout());
            cl.show(panels, "Game");
            current = 1;
        }
   
        if (current == 1) {
        	//creates decks for each research type
        	ArrayList<Card> c1 = game.getDeck1();
        	ArrayList<Card> c2 = game.getDeck2();
        	ArrayList<Card> c3 = game.getDeck3();
        	if(x > 30 && x < 100 && y > 22 && y < 80) {
        		zoom.zoom(c1, game.getMaxResearch(), 2);
				//zoomed = c;
				CardLayout cl = (CardLayout)(panels.getLayout());
				cl.show(panels, "Zoom");
				current = 2;
        	}
        	else if(x > 125 && x < 200 && y > 22 && y < 80) {
        		zoom.zoom(c2, game.getMaxResearch(), 2);
				//zoomed = c;
				CardLayout cl = (CardLayout)(panels.getLayout());
				cl.show(panels, "Zoom");
				current = 2;
        	}
        	else if(x > 225 && x < 300 && y > 22 && y < 80) {
        		zoom.zoom(c3, game.getMaxResearch(), 2);
				//zoomed = c;
				CardLayout cl = (CardLayout)(panels.getLayout());
				cl.show(panels, "Zoom");
				current = 2;
        	}
        	//for the selection in the 4 x 3 x 2 cards
        	for(int i = 0; i < allCards.size(); i++) {
        		Card c = allCards.get(i);
        		if(x > c.getX() && x < c.getX() + c.getRad() && y > c.getY() && y < c.getY() + c.getRad()) {
        			if(x < 335) {
        				zoom.zoom(c, 0);
        				zoomed = c;
        				CardLayout cl = (CardLayout)(panels.getLayout());
        				cl.show(panels, "Zoom");
        				current = 2;
        			}
        			else if((x > 820 && x < 880) || (x > 1420 && x < 1480)) {
        				zoom.zoom(c, 1);
        				zoomed = c;
        				CardLayout cl = (CardLayout)(panels.getLayout());
        				cl.show(panels, "Zoom");
        				current = 2;
        			}
        			else {
        				zoom.zoom(c, 3);
        				zoomed = c;
        				CardLayout cl = (CardLayout)(panels.getLayout());
        				cl.show(panels, "Zoom");
        				current = 2;
        			}
        		}
        	}
        }
        //inside the zoom panel
        if (current == 2) {
        	//back button
        	if(x > 432 && x < 627 && y > 484 && y < 545 && hasntRes) {
        		CardLayout cl = (CardLayout)(panels.getLayout());
        		cl.show(panels, "Game");
                current = 1;
        	}
        	//build button
        	else if (x > 935 && x < 1131 && y > 483 && y < 544 && zoom.getScreen() < 2) {
        		CardLayout cl = (CardLayout)(panels.getLayout());
        		cl.show(panels, "Game");
                current = 1;
                game.setAction("build", zoomed);
        	}
        	else if (x > 830 && x < 1050 && y > 483 && y < 544 && zoom.getScreen() == 3) {
        		CardLayout cl = (CardLayout)(panels.getLayout());
        		cl.show(panels, "Game");
                current = 1;
                game.setAction("activate", zoomed);
        	}
        	//file button
        	else if (x > 680 && x < 880 && y > 483 && y < 544 && zoom.getScreen() == 0) {
        		CardLayout cl = (CardLayout)(panels.getLayout());
        		cl.show(panels, "Game");
                current = 1;
                game.setAction("file", zoomed);
        	}
        	//researching
        	else if(zoom.getScreen() == 2) {
        		//sets the card chosen to which you click
        		if(zoom.didPress(x, y) && hasntRes) {
        			zoomed = zoom.getPressed(x, y);
        			zoom.clearCards();
        			hasntRes = false;
        		}
        		else if(!hasntRes) {
        			//back
        			if(x > 432 && x < 627 && y > 484 && y < 545) {
        				zoom.clearCards();
        				zoom.repaint();
                		CardLayout cl = (CardLayout)(panels.getLayout());
                		cl.show(panels, "Game");
                        current = 1;
                        hasntRes = true;
                	}
        			//build (not done)
                	else if (x > 935 && x < 1131 && y > 483 && y < 544) {
                		CardLayout cl = (CardLayout)(panels.getLayout());
                		cl.show(panels, "Game");
                        current = 1;
                        game.setAction("buildR", zoomed);
                        hasntRes = true;
                        zoom.clearCards();
                		zoom.repaint();
                	}
        			//file
                	else if (x > 680 && x < 880 && y > 483 && y < 544) {
                		game.setAction("fileR", zoomed);
                		CardLayout cl = (CardLayout)(panels.getLayout());
                		cl.show(panels, "Game");
                        current = 1;
                        hasntRes = true;
                        zoom.clearCards();
                		zoom.repaint();
                	}
        		}
        	}
        }
    }

    //shuffles the energies
    public void shuffleEnergies(ArrayList<Energy> energies) {
    	for(int i = 0; i < energies.size(); i++) {
    		int rand = (int)(Math.random() * energies.size());
    		Energy oldCard = energies.get(rand);
    		energies.set(rand, energies.get(i));
    		energies.set(i, oldCard);
    	}
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