package en.poo.tp.person;

import java.io.Serializable;

/**
 * Class representing a person.
 * <p>
 * Apr 17, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 */
public abstract class Person implements Serializable {
	
	private static final long serialVersionUID = -3236497226306146222L;
	
	/**
	 * The name of the person.
	 * @see Person#Person(String, int)
	 * @see Person#getName()
	 * @see Person#setName(String)
	 */
	protected String name;
	
	/**
	 * The ID of the person.
	 * @see Person#Person(String, int)
	 * @see Person#getId()
	 * @see Person#setId(int)
	 */
	protected int ID;
	
	/**
	 * Empty constructor.
	 */
	public Person()
	{
		super();
	}
	
	/**
	 * Constructor with parameters.
	 * @param name	The name of the person.
	 * @param iD	The ID of the person.
	 */
	public Person(String name, int iD)
	{
		this.name = name;
		this.ID = iD;
	}

	/**
	 * Return the name of the person.
	 * @return The name
	 * @see Person#name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Update the name of the person.
	 * @param name The new name
	 * @see Person#name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * Return the ID of the person.
	 * @return The ID
	 * @see Person#ID
	 */
	public int getId() 
	{
		return ID;
	}

	/**
	 * Update the ID of the person.
	 * @param id the id to set
	 * @see Person#ID
	 */
	public void setId(int id) 
	{
		ID = id;
	}

}
