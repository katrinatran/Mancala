/**
 * File name: CircleDesign.java
 * Class name: CircleDesign
 * Description: CircleDesign is a blueprint for a circle Mancala board.
 * 				CircleDesign implements MancalaDesign interface.
 * @author Katrina Tran, Risako Numamoto
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class CircleDesign implements MancalaDesign
{
	private int x;
	private int y;
	private int h;
	private int w;
	/**
	 * Constructor for CircleDesign
	 * @param x : x of each pit
	 * @param y : y of each pit
	 * @param height : height of board
	 * @param width : width of board
	 */
	public CircleDesign(int x, int y, int height, int width)
	{
		this.x = x;
		this.y = y;
		h = height;
		w = width;
	}
	/**
	 * The draw method from MancalaDesign interface.
	 * draws circle pits with 2 colors.
	 * @param g2: Graphics2D
	 * @return none
	 */
	public void draw(Graphics2D g2)
	{
		Font f = new Font("Serif", Font.BOLD, 36);
		g2.setFont(f);
		Ellipse2D.Double mancala1 = new Ellipse2D.Double(x, y, w, h);
		g2.setColor(Color.BLUE);
		g2.draw(mancala1);
		
		Ellipse2D.Double pit1 = new Ellipse2D.Double(x + w + x, y, w, w);
		g2.draw(pit1);
		g2.drawString("A1", 30+x + w + x, y-10);

		Ellipse2D.Double pit2 = new Ellipse2D.Double(x + 2*w + 2*x, y, w, w);
		g2.draw(pit2);
		g2.drawString("A2", 30+x + 2*w + 2*x, y-10);
		
		Ellipse2D.Double pit3 = new Ellipse2D.Double(x + 3*w + 3*x, y, w, w);
		g2.draw(pit3);
		g2.drawString("A3", 30+x + 3*w + 3*x, y-10);
		
		Ellipse2D.Double pit4 = new Ellipse2D.Double(x + 4*w + 4*x, y, w, w);
		g2.draw(pit4);
		g2.drawString("A4", 30+x + 4*w + 4*x, y-10);
		
		Ellipse2D.Double pit5 = new Ellipse2D.Double(x + 5*w + 5*x, y, w, w);
		g2.draw(pit5);
		g2.drawString("A5", 30+x + 5*w + 5*x, y-10);
		
		Ellipse2D.Double pit6 = new Ellipse2D.Double(x + 6*w + 6*x, y, w, w);
		g2.draw(pit6);
		g2.drawString("A6", 30+x + 6*w + 6*x, y-10);

		g2.setColor(Color.RED);
		Ellipse2D.Double mancala2 = new Ellipse2D.Double(x + 7*w + 7*x, y, w, h);
		g2.draw(mancala2);
		
		Ellipse2D.Double pit11 = new Ellipse2D.Double(x + w + x, 4*y, w, w);
		g2.draw(pit11);
		g2.drawString("B1", 30+x + w + x, y*6+15);

		Ellipse2D.Double pit12 = new Ellipse2D.Double(x + 2*w + 2*x, 4*y, w, w);
		g2.draw(pit12);
		g2.drawString("B2", 30+x + 2*w + 2*x, y*6+15);
		
		Ellipse2D.Double pit13 = new Ellipse2D.Double(x + 3*w + 3*x, 4*y, w, w);
		g2.draw(pit13);
		g2.drawString("B3", 30+x + 3*w + 3*x, y*6+15);
		
		Ellipse2D.Double pit14 = new Ellipse2D.Double(x + 4*w + 4*x, 4*y, w, w);
		g2.draw(pit14);
		g2.drawString("B4", 30+x +4*w + 4*x, y*6+15);
		
		Ellipse2D.Double pit15 = new Ellipse2D.Double(x + 5*w + 5*x, 4*y, w, w);
		g2.draw(pit15);
		g2.drawString("B5", 30+x + 5*w + 5*x, y*6+15);
		
		Ellipse2D.Double pit16 = new Ellipse2D.Double(x + 6*w + 6*x, 4*y, w, w);
		g2.draw(pit16);
		g2.drawString("B6", 30+x + 6*w + 6*x, y*6+15);
	}
}