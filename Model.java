import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Model 
{
	private ArrayList<ChangeListener> listeners;
	private int[][] mancala;
	private int winner;
	private int user;
	private boolean freeTurn;
	
	// stones is the initial number of stones
	public Model(int stones)
	{
		listeners = new ArrayList<ChangeListener>();
		mancala = new int[2][7];
		
		// initialize the mancala
		mancala[0][0] = mancala[1][0] = 0;
		for(int i =0; i<2; i++)
		{
			for(int j=1; j <7; j++)
			{
				mancala[i][j] = stones;
			}
		}
		user = 0;
		freeTurn = false;
	}
	
	public void addChangeListener(ChangeListener l)
	{
		listeners.add(l);
	}
	
	// user 1 or user 2
	public void move(int pitNum)
	{
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
					
					// reset the value of index back to his pits
					i = 7;
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
					mancala[user][0] += mancala[user-1][i];
					mancala[user-1][i] = 0;
				}
			}
			else
			{
				while(numStones > 0)
				{
					while(i<=6 && numStones >0)
					{
						i++;
						mancala[user][i]++;
						numStones--;
					}
					
					// check if the last stone was in an empty pit
					if(numStones == 0 && mancala[user][i] == 1)
					{
						mancala[user][0] += mancala[user-1][i];
						mancala[user-1][i] = 0;
					}
					
					// move and add one to his mancala
					if(numStones >0)
					{
						mancala[user][0]++;
						pitNum = 0;
						numStones--;
					}
					
					// check for a free turn
					if(numStones ==0 && pitNum == 0)
						user = 1;
					else
						user = 0;
					
					// add to the opponent's pits
					for(int j=6; j>0 && numStones>0; j--, numStones--)
						mancala[user-1][j]++;
					
					i = 0;
				}
			}
		}
		
		ChangeEvent e = new ChangeEvent(this);
		for(ChangeListener s: listeners)
			s.stateChanged(e);
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
}