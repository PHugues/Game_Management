package en.poo.tp.exceptions;

/**
 * Exception thrown when someone is trying to create a file that already exists.
 * <p>
 * Apr 13, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 */
public class FileExistingException extends Exception {

	private static final long serialVersionUID = 1303064285735186208L;
	
	public String toString()
	{
		return "This file already exists.\n";
	}

}
