/**
 * File name: Stones.java
 * Class name: Stones
 * Description: Stones is a blueprint for the stones on Manacala board.
 * 				Stones implements MancalaDesign interface.
 * @author Hiep Tran
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Stones implements MancalaDesign
{
	private int x;
	private int y;
	private int h;
	private int w;
	private int [][] stones;
	/**
	 * Constructor for Stones
	 * @param x : x of each pit
	 * @param y : y of each pit
	 * @param height : height of board
	 * @param width : width of board
	 * @param stone : 2D Array that tells number of stones in each pit
	 */
	public Stones(int x, int y, int height, int width, int [][] stone)
	{
		this.x = x;
		this.y = y;
		h = height;
		w = width;
		stones = stone;
	}
	/**
	 * The draw method from MancalaDesign interface.
	 * draws stones on each pit. 
	 * @param g2: Graphics2D object
	 */
	public void draw(Graphics2D g2)
	{
		Font f = new Font("Serif", Font.BOLD, 20);
		g2.setFont(f);
		g2.setColor(Color.BLACK);
		g2.drawString(stones[0][0] + "", x+w/2, y+h/2);
		
		g2.drawString(stones[0][1] + "", x + w + x+w/2, y +w/2);
		
		g2.drawString(stones[0][2] + "", x + 2*w + 2*x+w/2, y+w/2);
		
		g2.drawString(stones[0][3] + "", x + 3*w + 3*x+w/2, y+w/2);
		
		g2.drawString(stones[0][4] + "", x + 4*w + 4*x+w/2, y+w/2);
		
		g2.drawString(stones[0][5] + "", x + 5*w + 5*x+w/2, y+w/2);
		
		g2.drawString(stones[0][6] + "", x + 6*w + 6*x+w/2, y+w/2);

		g2.drawString(stones[1][0] + "", x + 7*w + 7*x+w/2, y+h/2);
		
		g2.drawString(stones[1][1] + "", x + w + x+w/2, 4*y+w/2);

		g2.drawString(stones[1][2] + "", x + 2*w + 2*x+w/2, 4*y+w/2);
		
		g2.drawString(stones[1][3] + "", x + 3*w + 3*x+w/2, 4*y+w/2);
		
		g2.drawString(stones[1][4] + "", x + 4*w + 4*x+w/2, 4*y+w/2);
		
		g2.drawString(stones[1][5] + "", x + 5*w + 5*x+w/2, 4*y+w/2);
		
		g2.drawString(stones[1][6] + "", x + 6*w + 6*x+w/2, 4*y+w/2);
	}
}