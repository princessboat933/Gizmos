import java.awt.Color;
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
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.cyan);
		g.fillOval(256,750, 35, 35);
		int x = 256;
		int y = 750;
		
		for(int i=0; i<6; i++)
		{
			g.fillOval(x,y, 35, 35);
			x+=16;
			y-=31;
		}
		x=559;
		y=910;
		g.fillOval(559,910, 35, 35);
		g.fillOval(598,920, 35, 35);
		g.fillOval(592,958, 35, 35);
		g.fillOval(557,948, 35, 35);
		g.fillOval(517,958, 35, 35);
		g.fillOval(517,920, 35, 35);
		
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
