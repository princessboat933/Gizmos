import java.util.*;
public class GizmosRunner
{
    public static void main(String args[])
    {
        //Heres how to run the game. Potentially add new things in case new stuff happens 
        //INITIALIZE CARD IMAGES rat work on disss
        ArrayList<Card> allCards = new ArrayList<Card>();
        //left top to bottom right
        try {
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/1.png")), 4, 1, "Black", 1, 4, 1));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/2.png")), 4, 1, "Black", 1, 6, 3));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/3.png")), 2, 1, "Black", 1, 1, 3));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/4.png")), 4, 1, "Blue", 1, 7, 1));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/5.png")), 4, 1, "Blue", 1, 5, 3));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/6.png")), 2, 1, "Blue", 1, 1, 3));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/7.png")), 4, 1, "Red", 1, 5, 1));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/8.png")), 4, 1, "Red", 1, 7, 3));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/9.png")), 2, 1, "Red", 1, 1, 3));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/10.png")), 4, 1, "Yellow", 1, 6, 1));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/11.png")), 4, 1, "Yellow", 1, 4, 3));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/12.png")), 2, 1, "Yellow", 1, 1, 3));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/13.png")), 3, 1, "Red", 1, 13, 4));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/14.png")), 3, 1, "Red", 1, 15, 4));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/15.png")), 3, 1, "Yellow", 1, 16, 4));
			allCards.add(new Card(ImageIO.read(Gizmos.class.getResource("/images/16.png")), 3, 1, "Yellow", 1, 14, 4));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        allCards.add(new Card(BufferedImage image, int type, 1, "Red", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Red", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Yellow", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Yellow", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Blue", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Blue", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Blue", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Blue", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Black", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Black", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Black", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Black", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Red", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Red", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Yellow", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Yellow", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Blue", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Blue", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Black", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 1, "Black", 1, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Black", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Blue", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Yellow", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Red", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Black", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Blue", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Yellow", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Red", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Black", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Blue", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Yellow", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Red", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Black", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Blue", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Yellow", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Red", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Black", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Blue", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Yellow", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Red", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Black", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Blue", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Yellow", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Red", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Black", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Blue", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Yellow", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Red", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Black", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Blue", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Yellow", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Red", 2, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Black", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Blue", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Yellow", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 2, "Red", 3, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Black", 5, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Blue", 5, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Red", 4, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Yellow", 4, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Black", 4, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Blue", 4, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Red", 4, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Yellow", 4, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Black", 5, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Blue", 7, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Red", 5, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Yellow", 5, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Black", 5, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Blue", 6, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Red", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Yellow", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Black", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Red", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Red", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Yellow", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Red", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Red", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Blue", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Yellow", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Yellow", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Yellow", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Blue", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Blue", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Blue", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Black", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Black", int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, "Black", int price, int trigInd, int reactInd));
        //these are the cards that are weird
        allCards.add(new Card(BufferedImage image, int type, 3, String color, int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, String color, int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, String color, int price, int trigInd, int reactInd));
        allCards.add(new Card(BufferedImage image, int type, 3, String color, int price, int trigInd, int reactInd));

        Gizmos game = new Gizmos();

       
    }

    
}