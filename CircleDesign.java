import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

/**
 * 
 * @author Katrina Tran
 *
 */
public class CircleDesign implements MancalaDesign
{

	private int h;
	private int w;
	public CircleDesign()
	{
		//450;
		//width = 1000;
		h = 300;
		w = 100;
	}

	public void draw(Graphics2D g2)
	{
		Ellipse2D.Double mancala1 = new Ellipse2D.Double(20, 60, w, h);
		g2.setColor(Color.BLACK);
		g2.draw(mancala1);
		
		Ellipse2D.Double pit1 = new Ellipse2D.Double(20 + w + 20, 60, w, w);
		g2.draw(pit1);

		Ellipse2D.Double pit2 = new Ellipse2D.Double(20 + 2*w + 2*20, 60, w, w);
		g2.draw(pit2);
		
		Ellipse2D.Double pit3 = new Ellipse2D.Double(20 + 3*w + 3*20, 60, w, w);
		g2.draw(pit3);
		
		Ellipse2D.Double pit4 = new Ellipse2D.Double(20 + 4*w + 4*20, 60, w, w);
		g2.draw(pit4);
		
		Ellipse2D.Double pit5 = new Ellipse2D.Double(20 + 5*w + 5*20, 60, w, w);
		g2.draw(pit5);
		
		Ellipse2D.Double pit6 = new Ellipse2D.Double(20 + 6*w + 6*20, 60, w, w);
		g2.draw(pit6);

		Ellipse2D.Double mancala2 = new Ellipse2D.Double(20 + 7*w + 7*20, 60, w, h);
		g2.draw(mancala2);
		
		Ellipse2D.Double pit11 = new Ellipse2D.Double(20 + w + 20, 250, w, w);
		g2.draw(pit11);

		Ellipse2D.Double pit12 = new Ellipse2D.Double(20 + 2*w + 2*20, 250, w, w);
		g2.draw(pit12);
		
		Ellipse2D.Double pit13 = new Ellipse2D.Double(20 + 3*w + 3*20, 250, w, w);
		g2.draw(pit13);
		
		Ellipse2D.Double pit14 = new Ellipse2D.Double(20 + 4*w + 4*20, 250, w, w);
		g2.draw(pit14);
		
		Ellipse2D.Double pit15 = new Ellipse2D.Double(20 + 5*w + 5*20, 250, w, w);
		g2.draw(pit15);
		
		Ellipse2D.Double pit16 = new Ellipse2D.Double(20 + 6*w + 6*20, 250, w, w);
		g2.draw(pit16);
	}
}