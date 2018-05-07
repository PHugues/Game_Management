package en.poo.tp.videogame;

import java.io.Serializable;

/**
 * Class representing a strategy game. It extends VideoGame.
 * <p>
 * Apr 6, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 * @see VideoGame
 */
public final class StrategyGame extends VideoGame implements Serializable {

	private static final long serialVersionUID = -6884291168487454352L;

	/**
	 * The minimal number of players.
	 * @see StrategyGame#StrategyGame(int, String, int, int, int)
	 * @see StrategyGame#getNbPlMin()
	 * @see StrategyGame#setNbPlMin(int)
	 */
	private int nbPlMin;
	
	/**
	 * The maximal number of players.
	 * @see StrategyGame#StrategyGame(int, String, int, int, int)
	 * @see StrategyGame#getNbPlMax()
	 * @see StrategyGame#setNbPlMax(int)
	 */
	private int nbPlMax;
	
	/**
	 * The maximal duration of the game.
	 * @see StrategyGame#StrategyGame(int, String, int, int, int)
	 * @see StrategyGame#getMaxDuration()
	 * @see StrategyGame#setMaxDuration(int)
	 */
	private int maxDuration;
	
	/**
	 * Empty constructor.
	 */
	public StrategyGame()
	{
		//
	}
	
	/**
	 * Constructor with parameters.
	 * @param iD	The ID of the game.
	 * @see VideoGame#iD
	 * @param name	The name of the game.
	 * @see VideoGame#name
	 * @param nbPlMin	The minimal number of players.
	 * @see StrategyGame#nbPlMin
	 * @param nbPlMax	The maximal number of players.
	 * @see StrategyGame#nbPlMax
	 * @param maxDuration	The maximal duration of the game.
	 * @see StrategyGame#maxDuration
	 */
	public StrategyGame(int iD, String name, int nbPlMin, int nbPlMax, int maxDuration)
	{
		super(iD, name);
		this.nbPlMin = nbPlMin;
		this.nbPlMax = nbPlMax;
		this.maxDuration = maxDuration;
	}

	/**
	 * Return the minimal number of players.
	 * @return The minimal number of players
	 * @see StrategyGame#nbPlMin
	 */
	public int getNbPlMin() 
	{
		return nbPlMin;
	}

	/**
	 * Update the minimal number of players.
	 * @param nbPlMin The new minimal number of players
	 * @see StrategyGame#nbPlMin
	 */
	public void setNbPlMin(int nbPlMin) 
	{
		this.nbPlMin = nbPlMin;
	}

	/**
	 * Return the maximal number of players.
	 * @return Maximal number of players
	 * @see StrategyGame#nbPlMax
	 */
	public int getNbPlMax() 
	{
		return nbPlMax;
	}

	/**
	 * Update the maximal number of players.
	 * @param nbPlMax The new maximal number of players
	 * @see StrategyGame#nbPlMax
	 */
	public void setNbPlMax(int nbPlMax) 
	{
		this.nbPlMax = nbPlMax;
	}

	/**
	 * Return the maximal duration of the game.
	 * @return The maxDuration
	 * @see StrategyGame#maxDuration
	 */
	public int getMaxDuration() 
	{
		return maxDuration;
	}

	/**
	 * Update the maximal duration of the game.
	 * @param maxDuration The new maximal duration
	 * @see StrategyGame#maxDuration
	 */
	public void setMaxDuration(int maxDuration) 
	{
		this.maxDuration = maxDuration;
	}

	/**
	 * Message generated when trying to display an instance of this class.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "[Strategy Game, " + super.toString() + "\nMinimal number of players = " + nbPlMin + ", Maximal number of players = " + nbPlMax + 
				"\nMaximal duration = " + maxDuration + "minutes]";
	}
	
	/**
	 * Make sure the game can be launched.
	 * @param nbPlayer	The number of player logged
	 * @return 	True if it can be launched, false otherwise
	 */
	public boolean canLaunch(int nbPlayer)
	{
		if(nbPlayer <= nbPlMax && nbPlayer >= nbPlMin)
		{
			return true;
		}
		return false;
	}
}
