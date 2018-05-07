package en.poo.tp.person;

import en.poo.tp.windows.PrimaryWindow;

/**
 * Class representing an administrator. It extends Person.
 * <p>
 * Apr 6, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 * @see Person
 */
public final class Admin extends Person implements InterfacePerson {
	
	private static final long serialVersionUID = -3990583390116431278L;

	/**
	 * The code of the administrator.
	 * @see Admin#Admin(char[], String, int)
	 * @see Admin#getCode()
	 * @see Admin#setCode(char[])
	 */
	private char[] code;
	
	/**
	 * The number of games created by the administrator that have been played.
	 * @see Admin#Admin(char[], String, int)
	 * @see Admin#getNbGamesCreaPlay()
	 * @see Admin#setNbGamesCreaPlay(int)
	 */
	private int nbGamesCreaPlay;
	
	/**
	 * Empty Constructor.
	 */
	public Admin()
	{
		super();
	}
	
	/**
	 * Constructor with parameters.
	 * @param code	The code of the administrator
	 * @see Admin#code
	 * @see Admin#nbGamesCreaPlay
	 * @param name	The name of the administrator
	 * @see Person#name
	 * @param iD	The iD of the administrator
	 * @see Person#ID
	 */
	public Admin(char[] code, String name, int iD)
	{
		super(name, iD);
		this.code = code;
		this.nbGamesCreaPlay = 0;
		PrimaryWindow.getServ().getIdList().add(iD);
	}

	/**
	 * Return the code of the administrator.
	 * @return The code
	 * @see Admin#code
	 */
	public char[] getCode() 
	{
		return code;
	}

	/**
	 * Update the code of the administrator.
	 * @param code The new code
	 * @see Admin#code
	 */
	public void setCode(char[] code) 
	{
		this.code = code;
	}

	/**
	 * Return the number of games created which have been played.
	 * @return The number of games created and played.
	 * @see Admin#nbGamesCreaPlay
	 */
	public int getNbGamesCreaPlay() 
	{
		return nbGamesCreaPlay;
	}

	/**
	 * Update the number of games created which have been played.
	 * @param nbGamesCreaPlay The new number of games created and played.
	 * @see Admin#nbGamesCreaPlay
	 */
	public void setNbGamesCreaPlay(int nbGamesCreaPlay) {
		this.nbGamesCreaPlay = nbGamesCreaPlay;
	}

	/**
	 * Message generated when displaying an instance of this class.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "[name = " + name + "]";
	}
	
	/**
	 * Increase the number of games created and played by 1.
	 * @see Admin#nbGamesCreaPlay
	 */
	@Override
	public void increaseNbGames()
	{
		this.nbGamesCreaPlay++;
	}
	
}
