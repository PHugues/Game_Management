package en.poo.tp.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import en.poo.tp.game.Game;
import en.poo.tp.person.Admin;
import en.poo.tp.person.Player;
import en.poo.tp.videogame.VideoGame;

/**
 * Class representing a server.
 * <p>
 * Apr 13, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 */
public final class Server implements Serializable {

	private static final long serialVersionUID = 3448946578151037839L;

	/**
	 * List of all games on the server.
	 * @see Game
	 * @see Server#Server()
	 * @see Server#getListGames()
	 * @see Server#setListGames(List)
	 */
	private List<Game> listGames;

	/**
	 * List of all players on the server.
	 * @see Player
	 * @see Server#Server()
	 * @see Server#getListPlayers()
	 * @see Server#setListPlayers(List)
	 */
	private List<Player> listPlayers;

	/**
	 * List of all admins on the server.
	 * @see Admin
	 * @see Server#Server()
	 * @see Server#getListAdmins()
	 * @see Server#setListAdmins(List)
	 */
	private List<Admin> listAdmins;

	/**
	 * List of all IDs ever created. It is used to check if an ID entered doesn't already exist.
	 * @see Server#getIdList()
	 * @see Server#setIdList(List)
	 */
	private List<Integer> idList;
	
	/**
	 * Constructor that sets all the lists to null.
	 */
	public Server()
	{
		this.listAdmins = new ArrayList<Admin>();
		this.listGames = new ArrayList<Game>();
		this.listPlayers = new ArrayList<Player>();
		idList = new ArrayList<Integer>();
	}

	/**
	 * Return the list of games.
	 * @return The listGames
	 * @see Server#listGames
	 * @see Game
	 */
	public List<Game> getListGames() 
	{
		return listGames;
	}

	/**
	 * Update the list of games.
	 * @param listGames The new list of games
	 * @see Game
	 * @see Server#listGames
	 */
	public void setListGames(List<Game> listGames) 
	{
		this.listGames = listGames;
	}

	/**
	 * Return the list of players.
	 * @return The listPlayers
	 * @see Player
	 * @see Server#listPlayers
	 */
	public List<Player> getListPlayers() 
	{
		return listPlayers;
	}

	/**
	 * Update the list of players.
	 * @param listPlayers The new list of players
	 * @see Player
	 * @see Server#listPlayers
	 */
	public void setListPlayers(List<Player> listPlayers) 
	{
		this.listPlayers = listPlayers;
	}

	/**
	 * Return the list of admins.
	 * @return The listAdmins
	 * @see Admin
	 * @see Server#listAdmins
	 */
	public List<Admin> getListAdmins() 
	{
		return listAdmins;
	}

	/**
	 * Update the list of admins.
	 * @param listAdmins The new list of admins
	 * @see Admin
	 * @see Server#listAdmins
	 */
	public void setListAdmins(List<Admin> listAdmins) 
	{
		this.listAdmins = listAdmins;
	}
	
	/**
	 * Return the list of all IDs.
	 * @return The idList
	 * @see Server#idList
	 */
	public List<Integer> getIdList() 
	{
		return this.idList;
	}

	/**
	 * Update the list of all IDs.
	 * @param idList The new lsit of ID
	 * @see Server#idList
	 */
	public void setIdList(List<Integer> idList) 
	{
		this.idList = idList;
	}

	/**
	 * Generate 10 players.
	 * @see Player
	 * @see Server#listPlayers
	 */
	public int generatePlayers() 
	{
		int compt = 0;
		for(int i = 0 ; i < 10 ; i++)
		{
			if(this.idList.contains(i) == false)
			{
				this.listPlayers.add(new Player(i, "Bot" + i));
				compt++;
			}
		}
		return compt;
	}
	
	/**
	 * Create a game and add it to the server.
	 * @param a	The admin who creates the game
	 * @param vg	The game created.
	 * @return The game created
	 */
	public Game createGame(Admin a, VideoGame vg)
	{
		if(a != null && vg != null)
		{
			Game g = new Game(vg, a);
			this.listGames.add(g);
			return g;
		}
		return null;
	}
	
	/**
	 * Allow a plyer to join the game
	 * @param pl	The player who joins
	 * @param g		The game joined
	 * @return	True if successfully joined, false otherwise
	 */
	public boolean joinGame(Player pl, Game g)
	{
		if(pl != null && g != null)
		{
			pl.setRegisGame(true);
			g.addPlayer(pl);
			return true;
		}
		return false;
	}
}

