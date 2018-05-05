import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Model 
{
	private ArrayList<ChangeListener> listeners;
	private int[][] mancala;
	private int[][] tempMancala;
	private int winner;
	private int user;
	private boolean freeTurn;
	private boolean undo;
	
	// set the initial num stones
	public void setStones(int num)
	{
		mancala[0][0] = mancala[1][0] = 0;
		for(int i =0; i<2; i++)
		{
			for(int j=1; j <7; j++)
			{
				mancala[i][j] = num;
			}
		}
		tempMancala = Arrays.copyOf(mancala, mancala.length);
	}
	
	// stones is the initial number of stones
	public Model()
	{
		listeners = new ArrayList<ChangeListener>();
		mancala = new int[2][7];
		
		// initialize the mancala
		mancala[0][0] = mancala[1][0] = 0;
		for(int i = 0; i < 2; i++)
		{
			for(int j = 1; j < 7; j++)
			{
				mancala[i][j] = 0;
			}
		}
		tempMancala = Arrays.copyOf(mancala, mancala.length);
		user = 0;
		freeTurn = false;
		undo = false;
	}
	
	public void addChangeListener(ChangeListener l)
	{
		listeners.add(l);
	}
	
	// user 1 or user 2
	public void move(int pitNum)
	{
		//set temp
		tempMancala = Arrays.copyOf(mancala, mancala.length);
		undo = true;
		
		// pitNum goes from 1 to 6
		int numStones = mancala[user][pitNum];
		
		if(user == 0)
		{
			mancala[user][pitNum] = 0;
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
					freeTurn = true;
				}
				else
				{
					freeTurn = false;
				}
				
				// check if the last stone was in an empty pit
				if(i != 0 && mancala[user][i] == 1)
				{
					mancala[user][0] += mancala[user + 1][i] + 1;
					mancala[user + 1][i] = mancala[user][i] = 0;
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
						mancala[user][i]++;
						numStones--;
					}
					// reset the value of index back to his pits
					i = 6;
					
					for(int j = 1; j <= 6 && 0 < numStones; j++, numStones--)
					{
						mancala[user + 1][j]++;
					}
					
					// check to get a free turn
					if(numStones == 0 && i == 0)
					{
						freeTurn = true;
					}
					else
					{
						freeTurn = false;
					}
					
					// check if the last stone was in an empty pit
					if(numStones == 0 && i!= 0 && mancala[user][i] == 1)
					{
						mancala[user][0] += mancala[user+1][i] + 1;
						mancala[user+1][i] = mancala[user][i] = 0;
					}
					
				}
			}
		}
		
		//since not user 0; goes to this else = user 1
		else
		{
			mancala[user][pitNum] = 0;
			int i = pitNum;
			
			if(numStones <= (6 - pitNum))
			{
				while(0 < numStones) 
				{
					i++;
					mancala[user][i]++;
					numStones--;
				}
					
				// check if the last stone was in an empty pit
				if(mancala[user][i] == 1)
				{
					mancala[user][0] += mancala[user-1][i] + 1;
					mancala[user-1][i] = mancala[user][i] = 0;
				}
				freeTurn = false;
			}
			else
			{
				while(numStones > 0)
				{
					while(i < 6 && numStones > 0)
					{
						i++;
						mancala[user][i]++;
						numStones--;
					}
					
					// check if the last stone was in an empty pit
					if(numStones == 0 && mancala[user][i] == 1)
					{
						mancala[user][0] += mancala[user-1][i] + 1;
						mancala[user-1][i] = mancala[user][i] = 0;
					}
					
					// move and add one to his mancala
					if(numStones > 0)
					{
						mancala[user][0]++;
						numStones--;
					}
					
					// check for a free turn
					if(numStones == 0 && i == 0)
					{
						freeTurn = true;
					}
					else
					{
						freeTurn = false;
					}
					
					// add to the opponent's pits
					for(int j = 6; j > 0 && numStones > 0; j--, numStones--)
					{
						mancala[user-1][j]++;
					}
					
					i = 0;
				}
			}
		}
		
		ChangeEvent e = new ChangeEvent(this);
		for(ChangeListener s: listeners)
			s.stateChanged(e);
		
		if (sideEmpty() != -1)
		{
			int sum = 0;
			if (sideEmpty() == 1)
			{
				for (int i = 1; i < 7; i++)
				{
					sum = sum + mancala[0][i];
				}
				mancala[0][0] = mancala[0][0] + sum;
			}
			if (sideEmpty() == 0)
			{
				for (int i = 1; i < 7; i++)
				{
					sum = sum + mancala[1][i];
				}
				mancala[1][0] = mancala[1][0] + sum;
			}
		}
	}
	
	public int sideEmpty()
	{
		//if return 0, user 0 side is empty
		//if return 1, user 1 side is empty
		//if return -1, none are empty
		boolean empty0 = true;
		boolean empty1 = true;
		for (int i = 1; i < 7; i++)
		{
			if ((mancala[0][i] != 0))
			{
				empty0 = false;
			}
			if ((mancala[0][i] != 0))
			{
				empty1 = false;
			}
		}
		if (empty1 && !empty0)
		{
			return 1;
		}
		else if(!empty1 && empty0)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
	
	public int[][] getStones()
	{
		return mancala;
	}
	
	public int winner()
	{
		for(int i =0; i <7; i++)
		{
			if(mancala[0][i] == 0)
				winner = 1;
		}
		
		for(int i =0; i <7; i++)
		{
			if(mancala[1][i] == 0)
				winner = 0;
		}
		
		return winner;
	}
	
	// either player 0 or player 1
	public void setPlayer(int p)
	{
		user = p;
	}
	
	public int getPlayer()
	{
		if (!freeTurn)
		{
			if (user == 0)
			{
				user = 1;
			}
			else
			{
				user = 0;
			}
		}
		return user;
	}
	
	public void undoMove()
	{
		if (undo)
		{
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 7; j++)
				{
					mancala[i][j] = tempMancala[i][j];
				}
			}
		}
		ChangeEvent e = new ChangeEvent(this);
		for(ChangeListener s: listeners)
			s.stateChanged(e);
	}
}