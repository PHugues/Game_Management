package en.poo.tp.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import en.poo.tp.person.Admin;
import en.poo.tp.server.Server;
import en.poo.tp.videogame.CardGame;
import en.poo.tp.videogame.FPS;
import en.poo.tp.videogame.StrategyGame;
import en.poo.tp.videogame.VideoGame;
import en.poo.tp.windows.PrimaryWindow;

/**
 * JUnit class to verify the Server methods.
 * <p>
 * Apr 24, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 */
class ServerTest {

	/**
	 * Test method for {@link en.poo.tp.server.Server#generatePlayers()}.
	 */
	@Test
	void testGeneratePlayers() 
	{
		Server serv = new Server();
		new PrimaryWindow();
		PrimaryWindow.setServ(serv);;
		assertEquals(10, serv.generatePlayers());
	}

	/**
	 * Test method for {@link en.poo.tp.server.Server#createGame(en.poo.tp.person.Admin, en.poo.tp.videogame.VideoGame)}.
	 */
	@Test
	void testCreateGame() 
	{
		Server serv = new Server();
		Admin ad;
		VideoGame vg;
		ad = null;
			vg = new CardGame();
			assert (serv.createGame(ad, vg)) != null;
			vg = new FPS();
			assert (serv.createGame(ad, vg)) != null;
			vg = new StrategyGame();
			assert (serv.createGame(ad, vg)) != null;
		ad = new Admin();
			vg = new CardGame();
			assert (serv.createGame(ad, vg)) != null;
			vg = new FPS();
			assert (serv.createGame(ad, vg)) != null;
			vg = new StrategyGame();
			assert (serv.createGame(ad, vg)) != null;
		vg = null;
			ad = new Admin();
			assert (serv.createGame(ad, vg)) != null;
	}

}
