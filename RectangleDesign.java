import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

/**
 * 
 * @author Risako
 *
 */
public class RectangleDesign implements MancalaDesign
{

	private int h;
	private int w;
	private int x;
	private int y;
	public RectangleDesign(int theX, int theY, int height, int width)
	{
		x = theX;
		y = theY;
		h = height;
		w = width;
	}

	public void draw(Graphics2D g2)
	{
		Rectangle2D.Double mancala1 = new Rectangle2D.Double(x, y, w, h);
		g2.setColor(Color.BLACK);
		g2.draw(mancala1);
		
		Rectangle2D.Double pit1 = new Rectangle2D.Double(x + w + x, y, w, w);
		g2.draw(pit1);

		Rectangle2D.Double pit2 = new Rectangle2D.Double(x + 2*w + 2*x, y, w, w);
		g2.draw(pit2);
		
		Rectangle2D.Double pit3 = new Rectangle2D.Double(x + 3*w + 3*x, y, w, w);
		g2.draw(pit3);
		
		Rectangle2D.Double pit4 = new Rectangle2D.Double(x + 4*w + 4*x, y, w, w);
		g2.draw(pit4);
		
		Rectangle2D.Double pit5 = new Rectangle2D.Double(x + 5*w + 5*x, y, w, w);
		g2.draw(pit5);
		
		Rectangle2D.Double pit6 = new Rectangle2D.Double(x + 6*w + 6*x, y, w, w);
		g2.draw(pit6);

		Rectangle2D.Double mancala2 = new Rectangle2D.Double(x + 7*w + 7*x, y, w, h);
		g2.draw(mancala2);
		
		Rectangle2D.Double pit11 = new Rectangle2D.Double(x + w + x, 250, w, w);
		g2.draw(pit11);

		Rectangle2D.Double pit12 = new Rectangle2D.Double(x + 2*w + 2*x, 250, w, w);
		g2.draw(pit12);
		
		Rectangle2D.Double pit13 = new Rectangle2D.Double(x + 3*w + 3*x, 250, w, w);
		g2.draw(pit13);
		
		Rectangle2D.Double pit14 = new Rectangle2D.Double(x + 4*w + 4*x, 250, w, w);
		g2.draw(pit14);
		
		Rectangle2D.Double pit15 = new Rectangle2D.Double(x + 5*w + 5*x, 250, w, w);
		g2.draw(pit15);
		
		Rectangle2D.Double pit16 = new Rectangle2D.Double(x + 6*w + 6*x, 250, w, w);
		g2.draw(pit16);
	}
}