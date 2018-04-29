package sample;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Stones implements MancalaDesign
{
	private int x;
	private int y;
	private int h;
	private int w;
	public Stones(int x, int y, int height, int width)
	{
		/* 
		 * x=20, y=60, h=300, w=100
		 */
		this.x = x;
		this.y = y;
		h = height;
		w = width;
	}

	// add an extra parameter type int[][] mancala to determine the number of each pit
	public void draw(Graphics2D g2)
	{
		g2.setColor(Color.BLACK);
		g2.drawString("10", x+w/2, y+h/2);
		
		g2.drawString("10", x + w + x+w/2, y +w/2);
		
		g2.drawString("10", x + 2*w + 2*x+w/2, y+w/2);
		
		g2.drawString("10", x + 3*w + 3*x+w/2, y+w/2);
		
		g2.drawString("10", x + 4*w + 4*x+w/2, y+w/2);
		
		g2.drawString("10", x + 5*w + 5*x+w/2, y+w/2);
		
		g2.drawString("10", x + 6*w + 6*x+w/2, y+w/2);

		g2.drawString("10", x + 7*w + 7*x+w/2, y+h/2);
		
		g2.drawString("10", x + w + x+w/2, 4*y+w/2);

		g2.drawString("10", x + 2*w + 2*x+w/2, 4*y+w/2);
		
		g2.drawString("10", x + 3*w + 3*x+w/2, 4*y+w/2);
		
		g2.drawString("10", x + 4*w + 4*x+w/2, 4*y+w/2);
		
		g2.drawString("10", x + 5*w + 5*x+w/2, 4*y+w/2);
		
		g2.drawString("10", x + 6*w + 6*x+w/2, 4*y+w/2);
	}


}
