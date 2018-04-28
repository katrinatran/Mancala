import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

/**
 * 
 * @author 
 *
 */
public class RectangleStyle implements MancalaDesign
{

	private int h;
	private int w;
	public RectangleStyle()
	{
		//450;
		//width = 1000;
		h = 300;
		w = 100;
	}

	public void draw(Graphics2D g2)
	{
		Rectangle2D.Double mancala1 = new Rectangle2D.Double(20, 60, w, h);
		g2.setColor(Color.BLACK);
		g2.draw(mancala1);
		
		Rectangle2D.Double pit1 = new Rectangle2D.Double(20 + w + 20, 60, w, w);
		g2.draw(pit1);

		Rectangle2D.Double pit2 = new Rectangle2D.Double(20 + 2*w + 2*20, 60, w, w);
		g2.draw(pit2);
		
		Rectangle2D.Double pit3 = new Rectangle2D.Double(20 + 3*w + 3*20, 60, w, w);
		g2.draw(pit3);
		
		Rectangle2D.Double pit4 = new Rectangle2D.Double(20 + 4*w + 4*20, 60, w, w);
		g2.draw(pit4);
		
		Rectangle2D.Double pit5 = new Rectangle2D.Double(20 + 5*w + 5*20, 60, w, w);
		g2.draw(pit5);
		
		Rectangle2D.Double pit6 = new Rectangle2D.Double(20 + 6*w + 6*20, 60, w, w);
		g2.draw(pit6);

		Rectangle2D.Double mancala2 = new Rectangle2D.Double(20 + 7*w + 7*20, 60, w, h);
		g2.draw(mancala2);
		
		Rectangle2D.Double pit11 = new Rectangle2D.Double(20 + w + 20, 250, w, w);
		g2.draw(pit11);

		Rectangle2D.Double pit12 = new Rectangle2D.Double(20 + 2*w + 2*20, 250, w, w);
		g2.draw(pit12);
		
		Rectangle2D.Double pit13 = new Rectangle2D.Double(20 + 3*w + 3*20, 250, w, w);
		g2.draw(pit13);
		
		Rectangle2D.Double pit14 = new Rectangle2D.Double(20 + 4*w + 4*20, 250, w, w);
		g2.draw(pit14);
		
		Rectangle2D.Double pit15 = new Rectangle2D.Double(20 + 5*w + 5*20, 250, w, w);
		g2.draw(pit15);
		
		Rectangle2D.Double pit16 = new Rectangle2D.Double(20 + 6*w + 6*20, 250, w, w);
		g2.draw(pit16);
	}
}