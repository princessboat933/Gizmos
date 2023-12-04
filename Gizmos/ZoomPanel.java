import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

//Kolapo Worked Here 11-27-23
public class ZoomPanel extends JPanel implements MouseListener
{
    //Three different options to choose from when you make the ZoomPanel
    //Back, File, and Build are the actions once the card has been zoomed into to 
    private BufferedImage background, cardImage, activateBack, researchBack, b1, b2, b3;
	int screen = 0; //activateBack is 1, researchBack is 2
	private ArrayList<Card> cards = new ArrayList<Card>();
	
    public ZoomPanel(){
    	cardImage = null;
    	try {
			b1 = ImageIO.read(Gizmos.class.getResource("/images/zoomback.png"));
			b2 = ImageIO.read(Gizmos.class.getResource("/images/gizmosfile.png"));
			b3 = ImageIO.read(Gizmos.class.getResource("/images/zoomactivate.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public void zoom(Card c, int typeZoom)  //NEW call this method whenever a player clicks a card on the board (parameters determined by coordinates/location of click)
	//typeZoom is 1 when the player clicks on a card they alr built
	//typeZoom is 2 when the player clicks on a card under the tiers
	{
		cardImage = c.getImage();
		screen = typeZoom;
		if(typeZoom == 0)
			background = b1;
		else if(typeZoom == 1) 
			background = b2;
		else if(typeZoom == 2) 
			background = b1;
		else if(typeZoom == 3) {
			background = b3;
		}
	}
	public void zoom(ArrayList<Card> decks, int researchAmount, int typeZoom)  //NEW call this method whenever a player clicks a card on the board (parameters determined by coordinates/location of click)
	//typeZoom is 1 when the player clicks on a card they alr built
	//typeZoom is 2 when the player clicks on a card under the tiers
	{
		cards.clear();
		int first = decks.size() -1 ;
		for(int i = 0; i < researchAmount; i++) {
			if(first - i >= 0)
				cards.add(decks.get(first - i));
		}
		screen = typeZoom;
		if(typeZoom == 0)
			background = b1;
		else if(typeZoom == 1) 
			background = b2;
		else if(typeZoom == 2) 
			background = b1;
	}
	public Card getPressed(int x, int y) {
		if(y > 165 && y < 292) {
			int xx = 180;
			for (int i = 0; i < cards.size(); i++) {
				if(x > xx && x < xx + 140) {
					System.out.println(cards.get(i));
					return cards.get(i);
				}
				xx += 150;
			}
		}
		else
			return null;
		return null;
	}
	public int getScreen() {
		return screen;
	}
	public void clearCards() {
		cards.clear();
	}

    	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		
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

	public void paint(Graphics g)
	{
		
		if(screen != 2) {
			g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(cardImage, 625, 165, 281, 255, null);
		}
		else if(screen == 2) {
			g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
			int x = 180;
			for(int i = 0; i < cards.size(); i++) {
				System.out.println(i);
				g.drawImage(cards.get(i).getImage(), x, 165, 140, 127, null);
				x += 150;
			}
		}
	}
	public boolean didPress(int x, int y) {
		if(y > 165 && y < 292) {
			int xx = 180;
			for (int i = 0; i < cards.size(); i++) {
				if(x > xx && x < xx + 140) {
					return true;
				}
				xx += 150;
			}
		}
		else
			return false;
		return false;
	}
	

}



/*import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.*;

//Kolapo Worked Here 11-27-23
public class ZoomPanel extends JPanel implements MouseListener
{
    //Three different options to choose from when you make the ZoomPanel
    //Back, File, and Build are the actions once the card has been zoomed into to 
    private BufferedImage cardImage, activateBack, researchBack;
	int screen = 0; //activateBack is 1, researchBack is 2

	//we can just use default constructor

	public void zoom(BufferedImage c, int typeZoom)  //NEW call this method whenever a player clicks a card on the board (parameters determined by coordinates/location of click)
	//typeZoom is 1 when the player clicks on a card they alr built
	//typeZoom is 2 when the player clicks on a card under the tiers
	{
		cardImage = c;
		screen = typeZoom;
	}

    	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		
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

	public void paint(Graphics g)
	{
		if(screen == 1)
		{
			g.drawImage(activateBack, 0, 0, getWidth(), getHeight(), null); //background when cards are clicked 
		}

		else if (screen==2)
		{
			g.drawImage(researchBack, 0, 0, getWidth(), getHeight(), null); //background when cards are clicked 
		}
		
		g.drawImage(cardImage, getWidth()/4, getHeight()/4, 300, 300, null); //big card
		

	}
	

}