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
		
		JButton CircleStyle = new JButton("Circle Style");
		CircleStyle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				final MancalaDesign style = new CircleDesign();
				MancalaIcon icon = new MancalaIcon(style, 450, 1000);
				final JLabel label = new JLabel(icon);
				
				frame.add(label, BorderLayout.CENTER);
				label.repaint();
			}
		});
		JButton RectangleStyle = new JButton("Rectangle Style");
		RectangleStyle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				final MancalaDesign style = new CircleDesign();
				MancalaIcon icon = new MancalaIcon(style, 450, 1000);
				final JLabel label = new JLabel(icon);
				frame.add(label, BorderLayout.CENTER);
				label.repaint();
			}
		});

		
		frame.add(CircleStyle, BorderLayout.NORTH);
		frame.add(RectangleStyle, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	public void stateChanged(ChangeEvent e)
	{
		repaint();
	}
}
