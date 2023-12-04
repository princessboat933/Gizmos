
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
	private int x;
	private int y;
	private boolean hasGone = false;
	private boolean[] triggerAbilities = new boolean[37];
	private boolean[] reactAbilities = new boolean[9];
	private int price;
	private int type; 
	private int rad = 60;
	//NEW 
	/* 0 = upgrade
	   1 = converter
	   2 = file
	   3 = pick
	   4 = build
	*/
	
	public Card(BufferedImage image, int type, int tier, String color, int price, int trigInd, int reactInd) {
		this.image = image;
		this.tier = tier;
		this.color = color;
		this.price = price;
		this.type = type;
		points = price;
		for(int i = 0; i < triggerAbilities.length; i++) {
			triggerAbilities[i] = false;
		}
		for(int i = 0; i < reactAbilities.length; i++) {
			reactAbilities[i] = false;
		}
		triggerAbilities[trigInd] = true;
		reactAbilities[reactInd] = true;
	}

	public Card(BufferedImage image, int type, int tier, String color, int price, int trigInd1, int trigInd2, int reactInd) {
		this.image = image;
		this.tier = tier;
		this.color = color;
		this.price = price;
		points = price;
		this.type = type;
		for(int i = 0; i < triggerAbilities.length; i++) {
			triggerAbilities[i] = false;
		}
		for(int i = 0; i < reactAbilities.length; i++) {
			reactAbilities[i] = false;
		}
		triggerAbilities[trigInd1] = true;
		triggerAbilities[trigInd2] = true;
		reactAbilities[reactInd] = true;
	}
	public boolean hasGone() {
		return hasGone;
	}
	public void go() {
		hasGone = true;
	}
	public void ungo() {
		hasGone = false;
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
	public int getType() //NEW
	{
		return type;
	}
	public int getPoints() {
		return points;
	}
	public int getPrice() {
		return price;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getRad() {
		return rad;
	}
	public void setRad(int rad) {
		this.rad = rad;
	}
	public void setLoc(int ex, int why)
	{
		x = ex;
		y = why;
	}
	public boolean activates(int ind) {
		if(triggerAbilities[ind] == true)
			return true;
		return false;
	}
	public int reacts() {
		System.out.println(reactAbilities);
		if(reactAbilities[1])
			return 1;
		if(reactAbilities[2])
			return 2;
		if(reactAbilities[4])
			return 4;
		if(reactAbilities[3])
			return 3;
		return 0;
	}
}