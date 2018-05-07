package en.poo.tp.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import en.poo.tp.exceptions.FileExistingException;
import en.poo.tp.server.Server;


/**
 * Class allowing the user to load and save his server.
 * <p>
 * Apr 13, 2018
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */
public final class In_Out  {

	/**
	 * The location of the storage of the files.
	 */
	private static String location = "Data/";
	
	/**
	 * The file on which the datas are recorded.
	 */
	private static File file;
	
	/**
	 * Save the server on the file.
	 * @param s	The server to save
	 */
	public static void save(Server s, String name)
	{
		file = new File(location + name);
		try
		{
			FileOutputStream outFileStream = new FileOutputStream(file);
			ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);
			outObjectStream.writeObject(s);
			outObjectStream.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Can't load this file", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Load a server from a file.
	 * @return	The server loaded.
	 */
	public static Server load(String name)
	{
		file = new File(location + name);
		Server s = null;
		try
		{
			FileInputStream inFileStream = new FileInputStream(file);;
			ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);
			s = (Server) inObjectStream.readObject();
			inObjectStream.close();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "Can't load this file", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * Create a file to save the data in it.
	 * @param s	The server to save
	 * @param name	The name of the server and of the file
	 * @throws FileExistingException	Exception throw if the file already exists
	 */
	public static void create(Server s, String name) throws FileExistingException
	{
		file = new File(location + name);
		if(file.exists())
		{
			throw new FileExistingException();
		}
		else
		{
			save(s, name);
		}
	}
}
