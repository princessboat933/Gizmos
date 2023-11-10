
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;


public class Card {
	
	private BufferedImage image;
	private int tier;
	private String color;
	private int points;
	private int price;
	
	public Card(int tier, String color, int points, int price) {
		
		this.tier = tier;
		this.color = color;
		this.points = points;
		this.price = price;
		
	}
	
	public BufferedImage getImage() {
		return image;
	}
	public int getTier() {
		return tier;
	}
	public String getColor() {
		return color;
	}
	public int getPoints() {
		return points;
	}
	public int getPrice() {
		return price;
	}
	
}
