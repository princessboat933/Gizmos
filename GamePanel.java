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
	BufferedImage bg;
	public GamePanel()
	{
		try {
			bg = ImageIO.read(GamePanel.class.getResource("/image/gameBoardBack.JPG"));
			
		} catch (IOException e) {
		
			System.out.println("oh no! Exception Error!");
			return;
		}
		
		addMouseListener(this);
	}
	
	public void paint(Graphics g)
	{
		//board background 
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.cyan);
		int x = 250;
		int y = 750;
		
		//marbles
		for(int i=0; i<6; i++)
		{
			g.fillOval(x,y, 35, 35);
			x+=16;
			y-=31;
		}
		
		
		x = 515;
		
		y = 906;
		for(int j=0; j<4; j++) 
		{	
			int temp = x;
			y=906;
			for(int i=0; i<3; i++)
			{
				
					g.fillOval(x,y, 35, 35);
					g.fillOval(x,y+40, 35, 35);
					
					
					x+=40;
					if(i==0)
					{
						y-=10;
					}
					else if(i==1)
					{
						y+=10;
					}
					
			}
			
			if(j==1)
			x=temp+370;
			
			else
			{
				x=temp+345;
			}
		}
		
		
	
		//tier cards: size 83x83
		x=35;
		y=119;
		for(int i=0; i<4; i++)
		{
			g.fillRect(x, y, 83, 83);
			y+=90;
		}
		x=155;
		y=119;
		for(int i=0; i<3; i++)
		{
			g.fillRect(x, y, 83, 83);
			y+=90;
		}
		x=274;
		y=119;
		for(int i=0; i<2; i++)
		{
			g.fillRect(x, y, 83, 83);
			y+=90;
		}
		
		//player cards
		//loops through each player's cards
		x=427;
		y=58;
		for(int p=0; p<2; p++)
		{
			for(int i=0; i<6; i++)
			{
				
				if(i==2)
				{
					y+=20;
				}
				if(i==5)
				{
					x+=80;
					y-=30;
				}
				for(int j=0; j<15; j++)
				{
					
					g.drawRect(x, y, 83, 83);
					y+=20;
				}
				x+=105;
				y=58;
				
			}
			
			x+=30;	
		}
		x=427;
		y=455;
		for(int p=0; p<2; p++)
		{
			for(int i=0; i<6; i++)
			{
				
				if(i==2)
				{
					y+=20;
				}
				if(i==5)
				{
					x+=80;
					y-=30;
				}
				for(int j=0; j<15; j++)
				{
					
					g.drawRect(x, y, 83, 83);
					y+=20;
				}
				x+=105;
				y=455;
				
			}
			
			x+=30;	
		}
		
		
		//scores
		//loop through all the players 
		x=763;
		y=991;
		for(int i=0; i<4; i++)
		{
			
			g.setFont(new Font("SansSerif", Font.BOLD, 20));
			g.drawString("0", x, y);
			if(i==1)
			{
				x+=370;
			}
			else
			x+=350;
		}
		
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		System.out.println(x + " " + y);
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
