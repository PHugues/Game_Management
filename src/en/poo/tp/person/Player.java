package en.poo.tp.person;

import en.poo.tp.windows.PrimaryWindow;

/**
 * Class representing a player. It extends Person.
 * <p>
 * Apr 6, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 * @see Person
 */
public final class Player extends Person implements InterfacePerson {

	private static final long serialVersionUID = -4361620466334395965L;

	/**
	 * The number of games played by the player.
	 * @see Player#Player(int, String)
	 * @see Player#getNbGamesPlayed()
	 * @see Player#setNbGamesPlayed(int)
	 */
	private int nbGamesPlayed;
	
	/**
	 * If the player is registered to a game.
	 * @see Player#Player(int, String)
	 * @see Player#isRegisGame()
	 * @see Player#setRegisGame(boolean)
	 */
	private boolean regisGame;
	
	/**
	 * Empty constructor.
	 */
	public Player()
	{
		//
	}
	
	/**
	 * Constructor with parameters.
	 * @param iD	The ID of the player.
	 * @see Person#ID
	 * @param name	The name of the player.
	 * @see Person#name
	 * @see Player#nbGamesPlayed
	 */
	public Player(int iD, String name)
	{
		super(name, iD);
		this.nbGamesPlayed = 0;
		this.regisGame = false;
		PrimaryWindow.getServ().getIdList().add(iD);
	}

	/**
	 * Return the number of games played by the player.
	 * @return The number of games played
	 * @see Player#nbGamesPlayed
	 */
	public int getNbGamesPlayed() 
	{
		return nbGamesPlayed;
	}

	/**
	 * Update the number of games played by the player.
	 * @param nbGamesPlayed The new number of games played.
	 * @see Player#nbGamesPlayed
	 */
	public void setNbGamesPlayed(int nbGamesPlayed) 
	{
		this.nbGamesPlayed = nbGamesPlayed;
	}

	/**
	 * Return true if the player is already registered to a game.
	 * @return the regisGame
	 * @see Player#regisGame
	 */
	public boolean isRegisGame() 
	{
		return regisGame;
	}

	/**
	 * Update the registration of the player.
	 * @param regisGame The new registration of the player
	 * @see Player#regisGame
	 */
	public void setRegisGame(boolean regisGame) 
	{
		this.regisGame = regisGame;
	}

	/**
	 * Message generated when displaying an instance of this class.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Player [nbGamesPlayed=" + nbGamesPlayed + ", regisGame=" + regisGame + ", name=" + name + ", ID=" + ID + "]\n";
	}
	
	/**
	 * Increase the number of games played by 1.
	 * @see Player#nbGamesPlayed
	 */
	@Override
	public void increaseNbGames()
	{
		this.nbGamesPlayed++;
	}	

}
