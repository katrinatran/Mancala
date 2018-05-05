/**
 * File name: Model.java
 * Class name: Model
 * Description: Model controls move of the players and stones
 */
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Model 
{
	private ArrayList<ChangeListener> listeners;
	private int[][] mancala;
	private int winner;
	private int user;
	private int[][] tempMancala;
	private int prevUser;
	private int numUndoUser1;
	private int numUndoUser2;
	
	// set the initial num stones
	/**
	 * set stones on each pits
	 * @param num: the number of stone user chooses
	 */
	public void setStones(int num)
	{
		mancala[0][0] = mancala[1][0] = 0;
		tempMancala[0][0] = tempMancala[1][0] = 0;
		
		for(int i =0; i<2; i++)
		{
			for(int j=1; j <7; j++)
			{
				tempMancala[i][j] = mancala[i][j] = num;
			}
		}
	}
	
	// stones is the initial number of stones
	/**
	 * Constructor for Model
	 */
	public Model()
	{
		listeners = new ArrayList<ChangeListener>();
		mancala = new int[2][7];
		tempMancala = new int[2][7];
			
		// initialize the mancala
		mancala[0][0] = mancala[1][0] = 0;
		tempMancala[0][0] = tempMancala[1][0] = 0;
			
		for(int i =0; i<2; i++)
		{
			for(int j=1; j <7; j++)
			{
				tempMancala[i][j] = mancala[i][j] = 0;
			}
		}
		prevUser = user = 0;
		numUndoUser1 = numUndoUser2 = 0;
	}
	/**
	 * adds ChangeKistener
	 * @param l: ChangeListener
	 */
	public void addChangeListener(ChangeListener l)
	{
		listeners.add(l);
	}
	
	// user 1 or user 2
	/**
	 * moves the stones
	 * @param pitNum: int
	 */
	public void move(int pitNum)
	{
		// pitNum goes from 1 to 6
		int numStones = mancala[user][pitNum];
		
		/**
		 * Store the manala to a temp mancala
		 */
		for(int i =0; i<2; i++)
		{
			for(int j=0; j <7; j++)
			{
				tempMancala[i][j] = mancala[i][j];
			}
		}
		prevUser = user;
		
		if(user == 0)
		{
			
			mancala[0][pitNum] = 0;
			int i = pitNum;
			if(numStones <= pitNum)
			{
				while(0 < numStones)
				{
					i--;
					mancala[user][i]++;
					numStones--;
				}
				
				// check to get a free turn
				if(i == 0)
				{
					user = 0;
				}
				else
				{
					user = 1;
				}
				
				// check if the last stone was in an empty pit
				if(i != 0 && mancala[0][i] == 1)
				{
					mancala[0][0] += mancala[1][i] + 1;
					mancala[1][i] = mancala[0][i] = 0;
				}
			}
			//numStones > pitNum
			else
			{
				while(numStones > 0)
				{
					while(0 < i && numStones > 0) 
					{
						i--;
						mancala[0][i]++;
						numStones--;
					}
					
					// check if the last stone was in an empty pit
					if(numStones == 0 && i!= 0 && mancala[0][i] == 1)
					{
						mancala[0][0] += mancala[1][i] + 1;
						mancala[1][i] = mancala[0][i] = 0;
					}
					
					// reset the value of index back to his pits
					i = 6;
					
					for(int j = 1; j <= 6 && 0 < numStones; j++)
					{
						mancala[1][j]++;
						numStones--;
					}
					
					// check to get a free turn
					if(numStones == 0 && i == 0)
					{
						user = 0;
					}
					else
					{
						user = 1;
					}
					
				}
			}
		}
		
		// User 1
		else
		{
			mancala[1][pitNum] = 0;
			int i = pitNum;
			if(numStones <= (6 - pitNum))
			{
				while(0 < numStones) 
				{
					i++;
					mancala[1][i]++;
					numStones--;
				}
					
				// check if the last stone was in an empty pit
				if(mancala[user][i] == 1)
				{
					mancala[user][0] += mancala[user-1][i] + 1;
					mancala[user-1][i] = mancala[user][i] = 0;
				}
				
				// change the turn to user 0
				user = 0;
				
			}
			else
			{
				while(numStones > 0)
				{
					while(i < 6 && numStones > 0)
					{
						i++;
						mancala[1][i]++;
						numStones--;
					}
						
					// check if the last stone was in an empty pit
					if(numStones == 0 && mancala[1][i] == 1)
					{
						mancala[1][0] += mancala[0][i] + 1;
						mancala[0][i] = mancala[1][i] = 0;
					}
						
						
					// move and add one to his mancala
					if(numStones > 0)
					{
						i = 0;
						mancala[1][0]++;
						numStones--;
					}
						
					// check for a free turn
					if(numStones == 0 && i == 0)
					{
						user = 1;
					}
					else
					{
						user = 0;
					}
					
					// add to the opponent's pits
					for(int j = 6; j > 0 && numStones > 0; j--)
					{
						mancala[0][j]++;
						numStones--;
					}
						
				}
			}
		}
		
		ChangeEvent e = new ChangeEvent(this);
		for(ChangeListener s: listeners)
			s.stateChanged(e);
	}
	
	/**
	 * gets stones
	 * @return int 2D array
	 */
	public int[][] getStones()
	{
		return mancala;
	}
	
	/**
	 * Checks which user wins
	 * @return int
	 */
	public int checkWinner()
	{
		/**
		 * assume user 0 wins
		 *  check if the user 0 has all 0's
		 *  if not, assume and assign the winner is user 1
		 *  check if the user 1 has all 0's
		 *  if not, return nobody wins
		 */
		winner = 1;
		boolean done = true;
		for(int i =1; i <7; i++)
		{
			if(mancala[0][i] != 0)
			{
				winner = 0;
				done = false;
			}
		}
		
		if(!done)
		{
			for(int i =1; i <7; i++)
			{
				if(mancala[1][i] != 0)
					winner = -1;
			}
		}
		
		return winner;
	}
	
	// either player 0 or player 1
	/**
	 * accessor for player
	 * @param p: int
	 */
	public void setPlayer(int p)
	{
		user = p;
	}
	/**
	 * getter for player
	 * @return user: int
	 */
	public int getPlayer()
	{
		return user;
	}
	
	/**
	 * getter for previous user
	 * @return previousUser: int
	 */
	public int getPrevUser()
	{
		return prevUser;
	}
	
	/**
	 * get the board infomation before user undoes
	 */
	public void getPrevMancala()
	{
		for(int i =0; i<2; i++)
		{
			for(int j=0; j <7; j++)
			{
				mancala[i][j] = tempMancala[i][j];
			}
		}
		
		user = prevUser;
		
		if(user ==0)
			numUndoUser1++;
		else
			numUndoUser2++;
		
		ChangeEvent e = new ChangeEvent(this);
		for(ChangeListener s: listeners)
			s.stateChanged(e);
	}
	
	/**
	 * get the number of undo
	 * @return numUndoUser1: int
	 */
	public int getNumUndoUser1()
	{
			return numUndoUser1;
	}
	/**
	 * get the number of undo
	 * @return numUndoUser2: int
	 */
	public int getNumUndoUser2()
	{
			return numUndoUser2;
	}
}