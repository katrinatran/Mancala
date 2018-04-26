package sample;

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
	private int x;
	private int y;
	private int h;
	private int w;
	public CircleDesign(int x, int y, int height, int width)
	{
		/* 
		 * x=20, y=60, h=300, w=100
		 */
		this.x = x;
		this.y = y;
		h = height;
		w = width;
	}

	public void draw(Graphics2D g2)
	{
		Ellipse2D.Double mancala1 = new Ellipse2D.Double(x, y, w, h);
		g2.setColor(Color.BLACK);
		g2.draw(mancala1);
		
		Ellipse2D.Double pit1 = new Ellipse2D.Double(x + w + x, y, w, w);
		g2.draw(pit1);

		Ellipse2D.Double pit2 = new Ellipse2D.Double(x + 2*w + 2*x, y, w, w);
		g2.draw(pit2);
		
		Ellipse2D.Double pit3 = new Ellipse2D.Double(x + 3*w + 3*x, y, w, w);
		g2.draw(pit3);
		
		Ellipse2D.Double pit4 = new Ellipse2D.Double(x + 4*w + 4*x, y, w, w);
		g2.draw(pit4);
		
		Ellipse2D.Double pit5 = new Ellipse2D.Double(x + 5*w + 5*x, y, w, w);
		g2.draw(pit5);
		
		Ellipse2D.Double pit6 = new Ellipse2D.Double(x + 6*w + 6*x, y, w, w);
		g2.draw(pit6);

		Ellipse2D.Double mancala2 = new Ellipse2D.Double(x + 7*w + 7*x, y, w, h);
		g2.draw(mancala2);
		
		Ellipse2D.Double pit11 = new Ellipse2D.Double(x + w + x, 4*y, w, w);
		g2.draw(pit11);

		Ellipse2D.Double pit12 = new Ellipse2D.Double(x + 2*w + 2*x, 4*y, w, w);
		g2.draw(pit12);
		
		Ellipse2D.Double pit13 = new Ellipse2D.Double(x + 3*w + 3*x, 4*y, w, w);
		g2.draw(pit13);
		
		Ellipse2D.Double pit14 = new Ellipse2D.Double(x + 4*w + 4*x, 4*y, w, w);
		g2.draw(pit14);
		
		Ellipse2D.Double pit15 = new Ellipse2D.Double(x + 5*w + 5*x, 4*y, w, w);
		g2.draw(pit15);
		
		Ellipse2D.Double pit16 = new Ellipse2D.Double(x + 6*w + 6*x, 4*y, w, w);
		g2.draw(pit16);
	}
}
