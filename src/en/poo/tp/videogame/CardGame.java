package en.poo.tp.videogame;

import java.io.Serializable;

/**
 * Class representing a card game. It extends VideoGame.
 * <p>
 * Apr 6, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 * @see VideoGame
 */
public final class CardGame extends VideoGame implements Serializable {

	private static final long serialVersionUID = -6220411181158283296L;

	/**
	 * The type of card game it is (tarot, poker...).
	 * @see CardGame#CardGame(int, String, String, int)
	 * @see CardGame#getGameType()
	 */
	private String gameType;
	
	/**
	 * The number of players required to start the game.
	 * @see CardGame#CardGame(int, String, String, int)
	 * @see CardGame#getReqPlNu()
	 * @see CardGame#setReqPlNu(int)
	 */
	private int ReqPlNu;
	
	/**
	 * Empty Constructor.
	 */
	public CardGame()
	{
		super();
	}
	
	/**
	 * Constructor with parameters.
	 * @param iD	The ID of the game.
	 * @see VideoGame#iD
	 * @param name	The name of the game.
	 * @see VideoGame#name
	 * @param gameType	The type of card game.
	 * @see CardGame#gameType
	 * @param ReqPlNu	The number of required players.
	 * @see CardGame#ReqPlNu
	 */
	public CardGame(int iD, String name, String gameType, int ReqPlNu)
	{
		super(iD, name);
		this.gameType = gameType;
		this.ReqPlNu = ReqPlNu;
	}

	/**
	 * Return the type of card game.
	 * @return The gameType
	 * @see CardGame#gameType
	 */
	public String getGameType() 
	{
		return gameType;
	}

	/**
	 * Return the number of player required to start the game.
	 * @return The number of players required
	 * @see CardGame#ReqPlNu
	 */
	public int getReqPlNu() 
	{
		return ReqPlNu;
	}

	/**
	 * Update the number of player required to start the game.
	 * @param reqPlNu The new number of players required
	 * @see CardGame#ReqPlNu
	 */
	public void setReqPlNu(int reqPlNu) 
	{
		ReqPlNu = reqPlNu;
	}

	/**
	 * Message generated when displaying an instance of this class.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "[Card Game, " + super.toString()  + ", type of game = " + gameType + "]";
	}
	
	/**
	 * Make sure the game can be launched.
	 * @param nbPlayer	The number of player logged
	 * @return 	True if it can be launched, false otherwise
	 */
	public boolean canLaunch(int nbPlayer)
	{
		if(nbPlayer == ReqPlNu)
		{
			return true;
		}
		return false;
	}
}
