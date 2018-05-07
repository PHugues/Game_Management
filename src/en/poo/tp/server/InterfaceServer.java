package en.poo.tp.server;

import en.poo.tp.person.Admin;
import en.poo.tp.videogame.VideoGame;

/**
 * Interface for the server.
 * <p>
 * Apr 24, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 */
public interface InterfaceServer {
	
	/**
	 * Create a game and add it to the server.
	 * @param a	The admin who creates the game
	 * @param vg	The game created.
	 * @return True if no error, false otherwise
	 */
	public boolean createGame(Admin a, VideoGame vg);
}
