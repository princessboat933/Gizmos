import java.awt.Color;

import javax.swing.JFrame;
public class MainWindow extends JFrame
{
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;
	
	public MainWindow(String s)
	{
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		add(new GamePanel());
		//setBackground(Color.white);
		setVisible(true);
	}
}
