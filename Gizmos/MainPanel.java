import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements MouseListener {
	BufferedImage main;
	public MainPanel() {
        try {
            main = ImageIO.read(GamePanel.class.getResource("/images/main2.png"));

        } catch (IOException e) {

            System.out.println("oh no! Exception Error!");
            return;
        }
        addMouseListener(this);
    }
	
	public void paint(Graphics g) {
		g.drawImage(main, 0, 0, getWidth(), getHeight(), null);
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
	
}