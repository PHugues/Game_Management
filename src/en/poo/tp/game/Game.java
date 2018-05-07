package en.poo.tp.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import en.poo.tp.person.Admin;
import en.poo.tp.person.Player;
import en.poo.tp.videogame.VideoGame;

/**
 * Class representing a game.
 * <p>
 * Apr 6, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 * @see InterfaceGame
 */
public class Game implements Serializable, InterfaceGame {

	private static final long serialVersionUID = 975205405431743354L;

	/**
	 * Month on which the game must begin.
	 * @see Game#getBeginDate()
	 * @see Game#setDate(int, int)
	 */
	private int month;
	
	/**
	 * Day on which the game must begin.
	 * @see Game#getBeginDate()
	 * @see Game#setDate(int, int )
	 */
	private int day;
	
	/**
	 * The video game played during the game.
	 * @see Game#Game(VideoGame, Admin)
	 * @see Game#getVideoGame()
	 * @see Game#setVideoGame(VideoGame)
	 */
	private VideoGame videoGame;
	
	/**
	 * The number of player in the game.
	 * @see Game#Game(VideoGame, Admin)
	 * @see Game#getNbPlayer()
	 * @see Game#setNbPlayer(int)
	 */
	private int nbPlayer;
	
	/**
	 * The admin who is handling the game.
	 * @see Game#Game(VideoGame, Admin)
	 * @see Game#getAdmin()
	 * @see Game#setAdmin(Admin)
	 * @see Admin
	 */
	private Admin admin;
	
	/**
	 * The list of all players in the game.
	 * @see Game#Game(VideoGame, Admin)
	 * @see Game#getListPlayer()
	 * @see Player
	 */
	private List<Player> listPlayer;
	
	/**
	 * Empty constructor.
	 */
	public Game()
	{
		//
	}
	
	/**
	 * Constructor with parameters.
	 * @param videoGame	The video game to play.
	 * @see Game#videoGame
	 * @see VideoGame
	 * @param admin	The admin handling the game.
	 * @see Game#admin
	 * @see Admin
	 */
	public Game(VideoGame videoGame, Admin admin)
	{
		this.videoGame = videoGame;
		this.nbPlayer = 0;
		this.admin = admin;
		this.listPlayer  = new ArrayList<Player>();
	}

	/**
	 * Set the date on which the game is meant to start.
	 * @see Game#month
	 * @see Game#day
	 */
	public void setDate(int month, int day) 
	{
		this.month = month;
		this.day = day;
	}
	
	/**
	 * Return the date on which the game is meant to start.
	 * @return The beginDate
	 * @see Game#month
	 * @see Game#day
	 */
	public String getBeginDate() 
	{
		return month + "/" + day;
	}

	/**
	 * Return video game played.
	 * @return The videoGame
	 * @see Game#videoGame
	 * @see VideoGame
	 */
	public VideoGame getVideoGame() 
	{
		return videoGame;
	}

	/**
	 * Update the video game played.
	 * @param videoGame The new video game
	 * @see Game#videoGame
	 * @see VideoGame
	 */
	public void setVideoGame(VideoGame videoGame) 
	{
		this.videoGame = videoGame;
	}

	/**
	 * Return the number of players.
	 * @return the nbPlayer
	 * @see Game#nbPlayer
	 */
	public int getNbPlayer() 
	{
		return nbPlayer;
	}

	/**
	 * Update the number of player.
	 * @param nbPlayer The new number of players.
	 * @see Game#nbPlayer
	 */
	public void setNbPlayer(int nbPlayer) 
	{
		this.nbPlayer = nbPlayer;
	}

	/**
	 * Return the administrator.
	 * @return The admin
	 * @see Game#admin
	 * @see Admin
	 */
	public Admin getAdmin() 
	{
		return admin;
	}

	/**
	 * Update the administrator.
	 * @param admin The new admin
	 * @see Game#admin
	 * @see Admin
	 */
	public void setAdmin(Admin admin) 
	{
		this.admin = admin;
	}

	/**
	 * @return the listPlayer
	 */
	public List<Player> getListPlayer() 
	{
		return listPlayer;
	}

	/**
	 * Message generated when trying to display an instance of this class.
	 */
	@Override
	public String toString() 
	{
		String str = "\nDate : " + getBeginDate() + "\n";
		str += "Video Game : " + videoGame.toString() + "\n";
		str += "Admin : " + admin.toString() + "\n";
		str += "Nb players : " + nbPlayer;
		return str;
	}
	
	/**
	 * Update the data of the players and the admin.
	 * @see Admin#increaseNbGames()
	 * @see Player#increaseNbGames()
	 */
	@Override
	public void updateData()
	{
		admin.increaseNbGames();
		for(Player pl : listPlayer)
		{
			pl.increaseNbGames();
			pl.setRegisGame(false);
		}
	}
	
	/**
	 * Launch the game.
	 * @return True if the game can launch the game, false otherwise.
	 */
	public boolean launchGame()
	{
		return(videoGame.canLaunch(nbPlayer));
	}
	
	/**
	 * Add a player to the list of players logged to the game.
	 * @param pl	The player logged.
	 * @return	True if joined successfully, false otherwise
	 * @see Game#listPlayer
	 * @see Player
	 */
	public boolean addPlayer(Player pl)
	{
		if(this.listPlayer.add(pl) == true)
		{
			this.nbPlayer++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Remove a player from the list of players logged to the game.
	 * @param pl	The player logged.
	 * @return	True if removed successfully, false otherwise
	 * @see Game#listPlayer
	 * @see Player
	 */
	public boolean removePlayer(Player pl)
	{
		if(this.listPlayer.contains(pl) == true)
		{
			this.listPlayer.remove(pl);
			this.nbPlayer--;
			return true;
		}
		else
		{
			return false;
		}
	}
}
