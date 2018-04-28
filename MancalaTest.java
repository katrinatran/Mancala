import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaTest implements ChangeListener
{
	public static void main(String [] args)
	{
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		
		// frame 2 for the mancala board
		JFrame f2 = new JFrame();
		f2.setSize(1000,500);
		f2.setLocation(0,100);
		
		JButton CircleStyle = new JButton("Circle Style");
		CircleStyle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				final MancalaDesign style = new CircleDesign(20,60,300,100);
				MancalaIcon icon = new MancalaIcon(style, 450, 1000);
				final JLabel label = new JLabel(icon);
				
				f2.add(label, BorderLayout.CENTER);
				/*
				 * after added to the frame, make sure the other button does not function anymore
				 */
				label.repaint();
			}
		});
		JButton RectangleStyle = new JButton("Rectangle Style");
		RectangleStyle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				// *********************** need to design a rectangle design
				final MancalaDesign style = new CircleDesign(10,30,300,100);
				MancalaIcon icon = new MancalaIcon(style, 450, 1000);
				final JLabel label = new JLabel(icon);
				
				f2.add(label, BorderLayout.CENTER);
				label.repaint();
			}
		});

		
		frame.add(CircleStyle, BorderLayout.NORTH);
		frame.add(RectangleStyle, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setVisible(true);
		
	}
	public void stateChanged(ChangeEvent e)
	{
		//repaint();
	}
}
