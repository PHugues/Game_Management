package en.poo.tp.videogame;

import java.io.Serializable;

/**
 * Class representing a video game.
 * <p>
 * Apr 6, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 */
public abstract class VideoGame implements Serializable {

	private static final long serialVersionUID = -2295720496731322264L;

	/**
	 * The ID of the game.
	 * @see VideoGame#VideoGame(int, String)
	 * @see VideoGame#getiD()
	 * @see VideoGame#setiD(int)
	 */
	private int iD;
	
	/**
	 * The name of the game.
	 * @see VideoGame#VideoGame(int, String)
	 * @see VideoGame#getName()
	 * @see VideoGame#setName(String)
	 */
	private String name;
	
	/**
	 * Empty constructor.
	 */
	public VideoGame()
	{
		//
	}
	
	/**
	 * Constructor with parameters.
	 * @param iD	The ID of the game.
	 * @see VideoGame#iD
	 * @param name	The name of the game.
	 * @see VideoGame#name
	 */
	public VideoGame(int iD, String name)
	{
		this.iD = iD;
		this.name = name;
	}

	/**
	 * Return the ID of the game.
	 * @return The iD
	 * @see VideoGame#iD
	 */
	public int getiD() 
	{
		return iD;
	}

	/**
	 * Update the ID of the game.
	 * @param iD The new ID
	 * @see VideoGame#iD
	 */
	public void setiD(int iD) 
	{
		this.iD = iD;
	}

	/**
	 * Return the name of the game.
	 * @return The name
	 * @see VideoGame#name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Update the name of the game.
	 * @param name The new name.
	 * @see VideoGame#name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * Message generated when displaying an instance of this class.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "ID = " + iD + ", name = " + name;
	}
	
	/**
	 * Make sure the game can be launched.
	 * @param nbPlayer	The number of player logged
	 * @return 	True if it can be launched, false otherwise
	 */
	public abstract boolean canLaunch(int nbPlayer);
}
