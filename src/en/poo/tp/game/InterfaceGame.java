package en.poo.tp.game;

import en.poo.tp.person.Admin;
import en.poo.tp.person.Player;

/**
 * Interface for the game.
 * <p>
 * Apr 24, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 */
public interface InterfaceGame {

	/**
	 * Update the data of the players and the admin.
	 * @see Admin#increaseNbGames()
	 * @see Player#increaseNbGames()
	 */
	public void updateData();
	
	/**
	 * Launch the game.
	 * @return True if the game can launch the game, false otherwise.
	 */
	public boolean launchGame();
}
