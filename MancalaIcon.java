
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;

public class MancalaIcon implements Icon
{
	private MancalaDesign design;
	private int height;
	private int width;
	public MancalaIcon(MancalaDesign style, int w, int h)
	{
		design = style;
		width = w;
		height = h;
	}
	/**
	 * gets the icon width
	 * @return the icon width
	 */
	public int getIconWidth()
	{
		return width;
	}
	/**
	 * gets the height of icon
	 * @return returns icon height
	 */
	public int getIconHeight()
	{
		return height;
	}
	/**
	 * gets design of icon
	 * @return MancalaDesign of icon
	 */
	public MancalaDesign getDesign()
	{
		return design;
	}
	/**
	 * draws the icon
	 * @param c: component of icon
	 * @param g: Graphics object of icon
	 * @param x: x-corner of icon
	 * @param y: y-corner of icon
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		design.draw(g2);

