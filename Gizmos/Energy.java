import java.util.*;
import java.awt.image.BufferedImage;
public class Energy
{
    private String color;
    private BufferedImage image;
    private int x;
	private int y;
	private int radius = 35;
    
    //This is the class as if we were creating one marble at a time 

    public Energy(String c, BufferedImage img)
    {
        color = c;
        image = img;

    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setLoc(int ex, int why)
    {
         x = ex;
         y = why;
    }
    
    public BufferedImage getImg()
    {
        return image;
    }

    public String getColor()
    {
        return color; 
    }
    public int getRad() {
    	return radius;
    }
    public void setRad(int rad) {
    	radius = rad;
    }
    
}