package en.poo.tp.videogame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import en.poo.tp.person.Player;

/**
 * Class representing a FPS. It extends VideoGame.
 * <p>
 * Apr 6, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 * @see VideoGame
 */
public final class FPS extends VideoGame implements Serializable {

	private static final long serialVersionUID = 7033691813421213734L;

	/**
	 * The difficulty of the game.
	 * @see FPS#FPS(int, String, Difficulty, int, int, boolean, int)
	 * @see FPS#getDifficulty()
	 * @see FPS#setDifficulty(Difficulty)
	 * @see Difficulty
	 */
	private Difficulty difficulty;
	
	/**
	 * The minimal number of players.
	 * @see FPS#FPS(int, String, Difficulty, int, int, boolean, int)
	 * @see FPS#getNbPlMin()
	 * @see FPS#setNbPlMin(int)
	 */
	private int nbPlMin;
	
	/**
	 * The maximal number of players.
	 * @see FPS#FPS(int, String, Difficulty, int, int, boolean, int )
	 * @see FPS#getNbPlMax()
	 * @see FPS#setNbPlMax(int)
	 */
	private int nbPlMax;
	
	/**
	 * The list of all players on the first team if there is any.
	 * @see FPS#FPS(int, String, Difficulty, int, int, boolean, int)
	 * @see Player
	 */
	private List<Player> team1;
	
	/**
	 * The list of all players on the second team if there is any.
	 * @see FPS#FPS(int, String, Difficulty, int, int, boolean, int)
	 * @see Player
	 */
	private List<Player> team2;
	
	/**
	 * The maximal duration of the game.
	 * @see FPS#FPS(int, String, Difficulty, int, int, boolean, int)
	 * @see FPS#getMaxDuration()
	 * @see FPS#setMaxDuration(int)
	 */
	private int maxDuration;
	
	/**
	 * Empty constructor.
	 */
	public FPS()
	{
		super();
	}
	
	/**
	 * Constructor with parameters.
	 * @param iD	The ID of the game.
	 * @see VideoGame#iD
	 * @param name	The name of the game.
	 * @see VideoGame#name
	 * @param difficulty	The difficulty of the game.
	 * @see FPS#difficulty
	 * @param nbPlMin	The minimal number of players.
	 * @see FPS#nbPlMin
	 * @param nbPlMax	The maximal number of players.
	 * @see FPS#nbPlMax
	 * @param team	If there are teams on this game.
	 * @see FPS#team1
	 * @see FPS#team2
	 * @param maxDuration	The maximal duration of the game
	 * @see FPS#maxDuration
	 * @see Player
	 */
	public FPS(int iD, String name, Difficulty difficulty, int nbPlMin, int nbPlMax, boolean team, int maxDuration)
	{
		super(iD, name);
		this.difficulty = difficulty;
		this.nbPlMin = nbPlMin;
		this.nbPlMax = nbPlMax;
		this.setMaxDuration(maxDuration);
		if(team == true)
		{
			this.team1 = new ArrayList<Player>();
			this.team2 = new ArrayList<Player>();
		}
	}
	
	/**
	 * Add a player to a game.
	 * @param number	The number of his team.
	 * @param p	The player to add.
	 * @see FPS#team1
	 * @see FPS#team2
	 * @see Player
	 */
	public void addPlayer(int number, Player p)
	{
		if(number == 1)
		{
			this.team1.add(p);
		}
		else
		{
			this.team2.add(p);
		}
	}

	/**
	 * Return the difficulty of the game.
	 * @return The difficulty
	 * @see FPS#difficulty
	 */
	public Difficulty getDifficulty() 
	{
		return difficulty;
	}

	/**
	 * Update the difficulty of the game.
	 * @param difficulty The new difficulty
	 * @see FPS#difficulty
	 */
	public void setDifficulty(Difficulty difficulty) 
	{
		this.difficulty = difficulty;
	}

	/**
	 * Return the minimal number of players.
	 * @return Minimal number of players
	 * @see FPS#nbPlMin
	 */
	public int getNbPlMin() {
		return nbPlMin;
	}

	/**
	 * Update the minimal number of players.
	 * @param nbPlMin The new minimal number of players
	 * @see FPS#nbPlMin
	 */
	public void setNbPlMin(int nbPlMin) 
	{
		this.nbPlMin = nbPlMin;
	}

	/**
	 * Return the maximal number of players.
	 * @return Maximal number of players.
	 * @see FPS#nbPlMax
	 */
	public int getNbPlMax() {
		return nbPlMax;
	}

	/**
	 * Update the maximal number of players.
	 * @param nbPlMax The new maximal number of players
	 * @see FPS#nbPlMax
	 */
	public void setNbPlMax(int nbPlMax) 
	{
		this.nbPlMax = nbPlMax;
	}

	/**
	 * Return the max duration of the game.
	 * @return The maxDuration
	 * @see FPS#maxDuration
	 */
	public int getMaxDuration() 
	{
		return maxDuration;
	}

	/**
	 * Update the max duration of the game.
	 * @param maxDuration The new max duration
	 * @see FPS#maxDuration
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
		String str = "[FPS, " + super.toString() + ", difficulty = " + difficulty.toString() +
				"\nMinimal number of players = " + nbPlMin + ", Maximal number of players = " + nbPlMax +
				"\nMaximal duration = " + maxDuration + "minutes";
		if(team1 != null)
		{
			str += "\nTeam1";
			for(Player pl : team1)
			{
				str += pl.getName();
			}
			str += "\nTeam2";
			for(Player pl : team2)
			{
				str += pl.getName();
			}
		}
		return str;
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
