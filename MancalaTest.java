package sample;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaTest
{
	public static void main(String [] args)
	{
		// ask the player how many stones in each pit
		Model model = new Model(3);
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		
		// frame 2 for the mancala board
		JFrame f2 = new JFrame();
		f2.setSize(1000,500);
		f2.setLocation(0,200);
		
		// to start the game
		JFrame f3 = new JFrame();	
		f3.setLocation(0,100);
		
		// circle button
		JButton CircleStyle = new JButton("Circle Style");
		CircleStyle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				// set stones and start game button
				JButton startGame = new JButton("Start Game");
				startGame.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						// draw the stones
						final MancalaDesign stones = new Stones(20,60,280,100);
						MancalaIcon s = new MancalaIcon(stones, 450, 1000);
						JLabel label2 = new JLabel(s);
						f2.add(label2, BorderLayout.CENTER);
						f3.dispose();
						f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						f2.setVisible(true);
					}
				});
				f3.add(startGame, BorderLayout.SOUTH);
				f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f3.setVisible(true);
				
				//*********************************
				final MancalaDesign style = new CircleDesign(20,60,280,100);
				MancalaIcon icon = new MancalaIcon(style, 450, 1000);
				final JLabel label = new JLabel(icon);
				
				
				f2.add(label, BorderLayout.CENTER);
				frame.dispose();
				f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f2.setVisible(true);
				
			}
		});
		
		// Rectangle button
		JButton RectangleStyle = new JButton("Rectangle Style");
		RectangleStyle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				// set stones and start game button
				JButton startGame = new JButton("Start Game");
				startGame.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						// draw the stones
						final MancalaDesign stones = new Stones(20,60,280,100);
						MancalaIcon s = new MancalaIcon(stones, 450, 1000);
						JLabel label2 = new JLabel(s);
						f2.add(label2, BorderLayout.CENTER);
						f3.dispose();
						f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						f2.setVisible(true);
					}
				});
				f3.add(startGame, BorderLayout.SOUTH);
				f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f3.setVisible(true);
				
				//********
				
				final MancalaDesign style = new RectangleDesign(20, 60, 280, 100);
				MancalaIcon icon = new MancalaIcon(style, 450, 1000);
				final JLabel label = new JLabel(icon);

				f2.add(label, BorderLayout.CENTER);
				frame.dispose();
				f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f2.setVisible(true);
			}
		});
	
		
	
		ChangeListener c = new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				//repaint() output the result on the screen of each pit
			}
		};
		
		model.addChangeListener(c);
		
		//frame.add(startGame, BorderLayout.SOUTH);
		frame.add(CircleStyle, BorderLayout.NORTH);
		frame.add(RectangleStyle, BorderLayout.CENTER);
		frame.setSize(140, 108);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
	
}
