package en.poo.tp.tests;

import org.junit.jupiter.api.Test;

import en.poo.tp.person.Admin;

/**
 * JUnit class to verify we can create an admin.
 * <p>
 * Apr 24, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 * @see Admin
 */
class AdminTest {

	@Test
	void testAdmin() 
	{
		Admin admin = new Admin();
		assert(admin != null);
	}

}
