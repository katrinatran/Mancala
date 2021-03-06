/**
 * File name: MancalaTest.java
 * Class name: MancalaTest
 * Description: The client class with main method where all the implementation happens
 * @author Risako Namamoto, Hiep Tran, Katrina Tran
*/
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaTest
{
	public static void main(String [] args)
	{
		/**
		 * Adding a field to keep track of how many undo times
		 */
		JTextField undoTimes = new JTextField();
		
		Model model = new Model();
		
		Font f = new Font("Serif", Font.BOLD, 20);
		
		/*
		 * ask the player to choose how many stones to start then update the model
		 */
		JButton three = new JButton("Three stones");
		three.setFont(f);
		three.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				model.setStones(3);
			}
		});
		
		JButton four = new JButton("Four stones");
		four.setFont(f);
		four.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				model.setStones(4);
			}
		});
			
		//board sizes
		int x = 20;
		int y = 60;
    	int p1top = 60;
    	int p1bottom = 160;
    	int p2top = 240;
    	int p2bottom = 340;
		
		JFrame frame = new JFrame("Choosing Style of Mancala Board");
		frame.setLayout(new BorderLayout());
		
		// frame 2 for the mancala board
		JFrame f2 = new JFrame();
		f2.setSize(1000, 500);
		f2.setLocation(0, 200);		
	
		//stones frame
		final MancalaDesign stones = new Stones(x, y, 280, 100, model.getStones());
		MancalaIcon s = new MancalaIcon(stones, 450, 1000);
		JLabel label2 = new JLabel(s);

		// to start the game
		JFrame f3 = new JFrame();	
		f3.setLocation(0, 100);
		f3.setSize(140, 80);
		
		
		//circle button
		JButton CircleStyle = new JButton("Circle Style");
		CircleStyle.setFont(f);
		CircleStyle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				//set stones and start game button
				JButton startGame = new JButton("Start Game");
				startGame.setFont(f);
				startGame.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						// draw the stones
						f2.add(label2, BorderLayout.CENTER);
						f3.dispose();
						f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						f2.setVisible(true);
					}
				});
				f3.add(startGame, BorderLayout.SOUTH);
				f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f3.setVisible(true);
				
				final MancalaDesign style = new CircleDesign(x, y, 280, 100);
				MancalaIcon icon = new MancalaIcon(style, 450, 1000);
				
				/**
				 * Add the mancala onto the label
				 */
				final JLabel label = new JLabel(icon);
				label.addMouseListener(new MouseAdapter()
				{
			         public void mouseClicked(MouseEvent e) 
			         {
			        	 int xp = e.getX();
			        	 int yp = e.getY();
			        	 int pitNum = -1;
			        	 
			        	 /*
			        	  * check mouseListener postion for the first player
			        	  */
			        	 if(model.getPlayer() == 0)
			        	 {
			        		 if ((yp >= p1top) && (yp <= p1bottom))
			        		 {
			        			 if ((xp >= 140) && (xp <= 240))
			        			 {
			        				 pitNum = 1;
			        			 }
			        			 else if ((xp >= 260) && (xp <= 360))
			        			 {
			        				 pitNum = 2;
			        			 }
			        			 else if ((xp >= 380) && (xp <= 480))
			        			 {
			        				 pitNum = 3;
			        			 }
			        			 else if ((xp >= 500) && (xp <= 600))
			        			 {
			        				 pitNum = 4;
			        			 }
			        			 else if ((xp >= 620) && (xp <= 720))
			        			 {
			        				 pitNum = 5;
			        			 }
			        			 else if ((xp >= 740) && (xp <= 840))
			        			 {
			        				 pitNum = 6;
			        			 }
			        			 if (model.getPlayer() == 0 && pitNum != -1)
			        			 {
			        				 model.move(pitNum);
			        				 /*
			        				  * After moving the stones, check if anyone wins yet then display a window for the winner
			        				  */
			        				 if(model.checkWinner() != -1)
			        				 {
			        					 JFrame done = new JFrame("Game Over");
			        					 done.setLocation(400, 400);
			        					 done.setSize(200, 100);
			        					 JTextField doneSMG = new JTextField();
			        					 doneSMG.setFont(f);
			        					 doneSMG.setText("PLAYER " + (model.checkWinner()+1) + " WINS");
			        					 done.add(doneSMG);
			        					 
			        					 done.setVisible(true);
			        					 done.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        				 }
			        			 }
			        		 }
			        	 }
			        	 else
			        	 {
			        		 /*
			        		  * check mouseListener position for the second player
			        		  */
			        		 if ((yp >= p2top) && (yp <= p2bottom))
			        		 {
			        			 if ((xp >= 140) && (xp <= 240))
			        			 {
			        				 pitNum = 1;
			        			 }
			        			 else if ((xp >= 260) && (xp <= 360))
			        			 {
			        				 pitNum = 2;
			        			 }
			        			 else if ((xp >= 380) && (xp <= 480))
			        			 {
			        				 pitNum = 3;
			        			 }
			        			 else if ((xp >= 500) && (xp <= 600))
			        			 {
			        				 pitNum = 4;
			        			 }
			        			 else if ((xp >= 620) && (xp <= 720))
			        			 {
			        				 pitNum = 5;
			        			 }
			        			 else if ((xp >= 740) && (xp <= 840))
			        			 {
			        				 pitNum = 6;
			        			 }
			        			 if (model.getPlayer() == 1 && pitNum != -1)
			        			 {
			        				 model.move(pitNum);
			        				 if(model.checkWinner() != -1)
			        				 {
			        					 JFrame done = new JFrame("Game Over");
			        					 done.setLocation(400, 400);
			        					 done.setSize(200, 100);
			        					 JTextField doneSMG = new JTextField();
			        					 doneSMG.setFont(f);
			        					 doneSMG.setText("PLAYER " + (model.checkWinner()+1) + " WINS");
			        					 done.add(doneSMG);
			        					 
			        					 done.setVisible(true);
			        					 done.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        				 }
			        			 }
			        		 }
			        	 }
			         }                
			    });
				/**
				 * Adding an undo button
				 */				
				JButton undo = new JButton("UNDO");
				undo.setFont(f);
				undo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						/*
						 * Allow each user to undo at most 3 times
						 */
						if(model.getPlayer() ==1 && model.getNumUndoUser1() < 3
								|| model.getPlayer() ==0 && model.getNumUndoUser2() < 3)
						{
							model.getPrevMancala();
						}
					}
				});
				
				JPanel undoP = new JPanel();
				undoP.setLayout(new GridLayout(0,2));
				undoP.add(undo);
				undoP.add(undoTimes);
				
				
				f2.add(undoP, BorderLayout.SOUTH);
				f2.add(label, BorderLayout.CENTER);
				frame.dispose();
				f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f2.setVisible(true);
			}
		});
		
		/**
		 * Rectangle portion
		 * is similar to the circle design except for calling the rectangle methods
		 */
		JButton RectangleStyle = new JButton("Rectangle Style");
		RectangleStyle.setFont(f);
		RectangleStyle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				//set stones and start game button
				JButton startGame = new JButton("Start Game");
				startGame.setFont(f);
				startGame.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						// draw the stones
						f2.add(label2, BorderLayout.CENTER);
						f3.dispose();
						f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						f2.setVisible(true);
					}
				});
				f3.add(startGame, BorderLayout.SOUTH);
				f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f3.setVisible(true);
				
				final MancalaDesign style = new RectangleDesign(x, y, 280, 100);
				MancalaIcon icon = new MancalaIcon(style, 450, 1000);
				final JLabel label = new JLabel(icon);
				label.addMouseListener(new MouseAdapter()
				{
			         public void mouseClicked(MouseEvent e) 
			         {
			        	 int xp = e.getX();
			        	 int yp = e.getY();
			        	 int pitNum = -1;
			        	 
			        	 if(model.getPlayer() == 0)
			        	 {
			        		 if ((yp >= p1top) && (yp <= p1bottom))
			        		 {
			        			 if ((xp >= 140) && (xp <= 240))
			        			 {
			        				 pitNum = 1;
			        			 }
			        			 else if ((xp >= 260) && (xp <= 360))
			        			 {
			        				 pitNum = 2;
			        			 }
			        			 else if ((xp >= 380) && (xp <= 480))
			        			 {
			        				 pitNum = 3;
			        			 }
			        			 else if ((xp >= 500) && (xp <= 600))
			        			 {
			        				 pitNum = 4;
			        			 }
			        			 else if ((xp >= 620) && (xp <= 720))
			        			 {
			        				 pitNum = 5;
			        			 }
			        			 else if ((xp >= 740) && (xp <= 840))
			        			 {
			        				 pitNum = 6;
			        			 }
			        			 if (pitNum != -1)
			        			 {
			        				 model.move(pitNum);
			        				 if(model.checkWinner() != -1)
			        				 {
			        					 JFrame done = new JFrame("Game Over");
			        					 done.setLocation(400, 400);
			        					 done.setSize(200, 100);
			        					 JTextField doneSMG = new JTextField();
			        					 doneSMG.setFont(f);
			        					 doneSMG.setText("PLAYER " + (model.checkWinner()+1) + " WINS");
			        					 done.add(doneSMG);
			        					 
			        					 done.setVisible(true);
			        					 done.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        				 }
			        			 }
			        		 }
			        	 }
			        	 else
			        	 {
			        		 if ((yp >= p2top) && (yp <= p2bottom))
			        		 {
			        			 if ((xp >= 140) && (xp <= 240))
			        			 {
			        				 pitNum = 1;
			        			 }
			        			 else if ((xp >= 260) && (xp <= 360))
			        			 {
			        				 pitNum = 2;
			        			 }
			        			 else if ((xp >= 380) && (xp <= 480))
			        			 {
			        				 pitNum = 3;
			        			 }
			        			 else if ((xp >= 500) && (xp <= 600))
			        			 {
			        				 pitNum = 4;
			        			 }
			        			 else if ((xp >= 620) && (xp <= 720))
			        			 {
			        				 pitNum = 5;
			        			 }
			        			 else if ((xp >= 740) && (xp <= 840))
			        			 {
			        				 pitNum = 6;
			        			 }
			        			 if (pitNum != -1)
			        			 {
			        				 model.move(pitNum);
			        				 if(model.checkWinner() != -1)
			        				 {
			        					 JFrame done = new JFrame("Game Over");
			        					 done.setLocation(400, 400);
			        					 done.setSize(200, 100);
			        					 JTextField doneSMG = new JTextField();
			        					 doneSMG.setFont(f);
			        					 doneSMG.setText("PLAYER " + (model.checkWinner()+1) + " WINS");
			        					 done.add(doneSMG);
			        					 
			        					 done.setVisible(true);
			        					 done.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        				 }
			        			 }
			        		 }
			        	 }
			         }                
			    });
				
				/**
				 * Adding an undo button
				 */				
				JButton undo = new JButton("UNDO");
				undo.setFont(f);
				undo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(model.getPlayer() ==1 && model.getNumUndoUser1() < 3
								|| model.getPlayer() ==0 && model.getNumUndoUser2() < 3)
						{
							model.getPrevMancala();
						}
					}
				});
				JPanel undoP = new JPanel();
				undoP.setLayout(new GridLayout(0,2));
				undoP.add(undo);
				undoP.add(undoTimes);
				
				f2.add(undoP, BorderLayout.SOUTH);
				f2.add(label, BorderLayout.CENTER);
				frame.dispose();
				label.repaint();
				f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f2.setVisible(true);
			}
		});
		
		/**
		 * the model class notifies the views by changeListener
		 * it will repaint the board and update the undo text
		 */
		ChangeListener c = new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				undoTimes.setFont(f);
				f2.repaint();
				if(model.getPlayer()==1 && model.getNumUndoUser1() < 3)
					undoTimes.setText("Player " + (model.getPlayer()+1) + " has used " + model.getNumUndoUser1() + " times of undo out of 3");
				else if(model.getPlayer()==0 && model.getNumUndoUser2() < 3)
					undoTimes.setText("Player " + (model.getPlayer()+1) + " has used " + model.getNumUndoUser2() + " times of undo out of 3");
				else
					undoTimes.setText("Player " + (model.getPlayer()+1) + " can't undo any more");
			}
		};
		
		model.addChangeListener(c);
		
		/**
		 * Adding the panels and frame together
		 */
		JPanel p1 = new JPanel(new GridLayout(1, 5));
		three.setSize(150, 100);
		p1.add(three);
		four.setSize(150, 100);
		p1.add(four);
		frame.add(p1, BorderLayout.NORTH);
		
		JTextArea text = new JTextArea();
		text.setFont(f);
		text.setText("Choose the number of stones then choose the board style");
		text.setSize(300, 150);
		frame.add(text, BorderLayout.CENTER);
		
		JPanel p2 = new JPanel(new GridLayout(1, 5));
		CircleStyle.setSize(150, 100);
		RectangleStyle.setSize(150, 100);
		p2.add(CircleStyle);
		p2.add(RectangleStyle);
		frame.add(p2, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}