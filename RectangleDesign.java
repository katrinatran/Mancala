/**
 * File name: RectangleDesign.java
 * Class name: RectangleDesign
 * Description: RectangleDesign is a blueprint for a rectangle Mancala board.
 * 				RectangleDesign implements MancalaDesign interface.
 * @author Risako Numamoto
 */	
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class RectangleDesign implements MancalaDesign
{
	private int h;
	private int w;
	private int x;
	private int y;
	/**
	 * Constructor for RectangleDesign
	 * @param theX : x of each pit
	 * @param theY : y of each pit
	 * @param height : height of board
	 * @param width : width of board
	 */
	public RectangleDesign(int theX, int theY, int height, int width)
	{
		x = theX;
		y = theY;
		h = height;
		w = width;
	}
	/**
	 * The draw method from MancalaDesign interface.
	 * draws rectangle pits with varied colors.
	 * @param g2: Graphics2D
	 * @return none
	 */
	public void draw(Graphics2D g2)
	{
		Font f = new Font("Serif", Font.BOLD, 36);
		g2.setFont(f);
		Rectangle2D.Double mancala1 = new Rectangle2D.Double(x, y, w, h);
		g2.setColor(Color.BLACK);
		g2.draw(mancala1);
		
		g2.setColor(Color.YELLOW);
		Rectangle2D.Double pit1 = new Rectangle2D.Double(x + w + x, y, w, w);
		g2.draw(pit1);
		g2.drawString("A1", 30+x + w + x, y-10);

		g2.setColor(Color.PINK);
		Rectangle2D.Double pit2 = new Rectangle2D.Double(x + 2*w + 2*x, y, w, w);
		g2.draw(pit2);
		g2.drawString("A2", 30+x + 2*w + 2*x, y-10);
		
		g2.setColor(Color.RED);
		Rectangle2D.Double pit3 = new Rectangle2D.Double(x + 3*w + 3*x, y, w, w);
		g2.draw(pit3);
		g2.drawString("A3", 30+x + 3*w + 3*x, y-10);
		
		g2.setColor(Color.BLUE);
		Rectangle2D.Double pit4 = new Rectangle2D.Double(x + 4*w + 4*x, y, w, w);
		g2.draw(pit4);
		g2.drawString("A4", 30+x + 4*w + 4*x, y-10);
		
		g2.setColor(Color.cyan);
		Rectangle2D.Double pit5 = new Rectangle2D.Double(x + 5*w + 5*x, y, w, w);
		g2.draw(pit5);
		g2.drawString("A5", 30+x + 5*w + 5*x, y-10);
		
		g2.setColor(Color.GREEN);
		Rectangle2D.Double pit6 = new Rectangle2D.Double(x + 6*w + 6*x, y, w, w);
		g2.draw(pit6);
		g2.drawString("A6", 30+x + 6*w + 6*x, y-10);

		g2.setColor(Color.BLACK);
		Rectangle2D.Double mancala2 = new Rectangle2D.Double(x + 7*w + 7*x, y, w, h);
		g2.draw(mancala2);
		
		g2.setColor(Color.GREEN);
		Rectangle2D.Double pit11 = new Rectangle2D.Double(x + w + x, 4*y, w, w);
		g2.draw(pit11);
		g2.drawString("B1", 30+x + w + x, y*6+15);

		g2.setColor(Color.cyan);
		Rectangle2D.Double pit12 = new Rectangle2D.Double(x + 2*w + 2*x, 4*y, w, w);
		g2.draw(pit12);
		g2.drawString("B2", 30+x + 2*w + 2*x, y*6+15);
	
		g2.setColor(Color.BLUE);
		Rectangle2D.Double pit13 = new Rectangle2D.Double(x + 3*w + 3*x, 4*y, w, w);
		g2.draw(pit13);
		g2.drawString("B3", 30+x + 3*w + 3*x, y*6+15);
		
		g2.setColor(Color.RED);
		Rectangle2D.Double pit14 = new Rectangle2D.Double(x + 4*w + 4*x, 4*y, w, w);
		g2.draw(pit14);
		g2.drawString("B4", 30+x +4*w + 4*x, y*6+15);
		
		g2.setColor(Color.PINK);
		Rectangle2D.Double pit15 = new Rectangle2D.Double(x + 5*w + 5*x, 4*y, w, w);
		g2.draw(pit15);
		g2.drawString("B5", 30+x + 5*w + 5*x, y*6+15);
		
		g2.setColor(Color.YELLOW);
		Rectangle2D.Double pit16 = new Rectangle2D.Double(x + 6*w + 6*x, 4*y, w, w);
		g2.draw(pit16);
		g2.drawString("B6", 30+x + 6*w + 6*x, y*6+15);
	}
}