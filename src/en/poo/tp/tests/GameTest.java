package en.poo.tp.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import en.poo.tp.game.Game;
import en.poo.tp.person.Admin;
import en.poo.tp.videogame.CardGame;
import en.poo.tp.videogame.FPS;
import en.poo.tp.videogame.StrategyGame;

/**
 * JUnit class to 
 * <p>
 * Apr 24, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 */
class GameTest {

	@Test
	void testLaunchGame() 
	{
		Game game = new Game(new CardGame(), new Admin());
		assert(game.launchGame());
		
		game = new Game(new StrategyGame(), new Admin());
		assert(game.launchGame());
		
		game = new Game(new FPS(), new Admin());
		assert(game.launchGame());
		
		game = new Game();
		assertFalse(game.launchGame());
	}

}
