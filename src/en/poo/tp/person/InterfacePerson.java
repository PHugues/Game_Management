package en.poo.tp.person;

/**
 * Interface for the players and the admins.
 * <p>
 * Apr 24, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 */
public interface InterfacePerson {

	/**
	 * Increase the number of games played or created and played by 1.
	 * @see Player#increaseNbGames()
	 * @see Admin#increaseNbGames()
	 */
	public void increaseNbGames();
}
