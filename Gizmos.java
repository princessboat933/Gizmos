
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Gizmos implements MouseListener{
	
	private JPanel[] panelList = new JPanel[2];
	private int current;
	private JPanel panels;
	
	public Game() {
		JFrame frame = new JFrame();
		JPanel p1 = new GamePanel();
		current = 0;
		panelList[0] = p1;
		p1.addMouseListener(this);
		        
		panels = new JPanel(new CardLayout());
		panels.add(p1, "Panel 1");

		Container pane = frame.getContentPane();
		pane.add(panels, BorderLayout.CENTER);
		            
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920, 1080);
		frame.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
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
