package en.poo.tp.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import en.poo.tp.files.In_Out;
import en.poo.tp.game.Game;
import en.poo.tp.person.Admin;
import en.poo.tp.person.Player;
import en.poo.tp.server.Server;

/**
 * Primary window of the program.
 * <p>
 * Apr 13, 2018
 * @author Pierre Hugues - L2 Computer Science G11
 * @version 1.0
 */
public class PrimaryWindow extends JFrame {

	private static final long serialVersionUID = -5941869260787167789L;
	private JPanel contentPane;

	/**
	 * Server loaded by the user.
	 * @see Server
	 * @see PrimaryWindow#getServ()
	 * @see PrimaryWindow#setServ(Server)
	 */
	private static Server serv = null;

	/**
	 * The admin logged.
	 * @see Admin
	 * @see PrimaryWindow#getAdmin()
	 * @see PrimaryWindow#setAdmin(Admin)
	 */
	private static Admin admin = null;

	/**
	 * The player logged.
	 * @see Player
	 * @see PrimaryWindow#getPlayer()
	 * @see PrimaryWindow#setPlayer(Player)
	 */
	private static Player player = null;

	/**
	 * Theme used in the application.
	 * @see PrimaryWindow#getTheme()
	 * @see PrimaryWindow#setTheme(String)
	 */
	private static String theme = "Dark";

	/**
	 * Name of the file loaded.
	 * @see PrimaryWindow#getFileName()
	 * @see PrimaryWindow#setFileName(String)
	 */
	private static String fileName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					PrimaryWindow frame = new PrimaryWindow();
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrimaryWindow() 
	{
		setTitle("Game Management");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		//Menu Bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		//File menu
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		//New file (file menu)
		JMenuItem mntmNew = new JMenuItem("New...");
		mnFile.add(mntmNew);

		//Load file (file menu)
		JMenuItem mntmLoad = new JMenuItem("Load...");
		mnFile.add(mntmLoad);

		//Save file (save file)
		JMenuItem mntmSave = new JMenuItem("Save...");
		mnFile.add(mntmSave);

		//Connect menu
		JMenu mnConnect = new JMenu("Connect");
		menuBar.add(mnConnect);
		mnConnect.setEnabled(false);

		//Register menu (connect menu)
		JMenu mnRegister = new JMenu("Register");
		mnConnect.add(mnRegister);

		//Register admin (connect - register menu)
		JMenuItem mntmAdmin_1 = new JMenuItem("Admin");
		mnRegister.add(mntmAdmin_1);

		//Register player (connect - register menu)
		JMenuItem mntmPlayer_1 = new JMenuItem("Player");
		mnRegister.add(mntmPlayer_1);

		//Generate some players (connect - register menu)
		JMenuItem mntmGeneratePlayers = new JMenuItem("Generate Players");
		mnRegister.add(mntmGeneratePlayers);

		//Login menu (connect menu)
		JMenu mnLogin = new JMenu("Login");
		mnConnect.add(mnLogin);

		//Log as admin (connect - login menu)
		JMenuItem mntmAdmin = new JMenuItem("Admin");
		mnLogin.add(mntmAdmin);

		//Log as player (connect - login menu)
		JMenuItem mntmPlayer = new JMenuItem("Player");
		mnLogin.add(mntmPlayer);

		//Admin menu
		JMenu mnAdmin = new JMenu("Admin");
		menuBar.add(mnAdmin);
		mnAdmin.setEnabled(false);

		//Create game (admin menu)
		JMenu mnNewMenu = new JMenu("Create game...");
		mnAdmin.add(mnNewMenu);

		//Create FPS (admin - create menu)
		JMenuItem mntmFps = new JMenuItem("FPS");
		mnNewMenu.add(mntmFps);

		//Create strategy game (admin - create menu)
		JMenuItem mntmStrategyGame = new JMenuItem("Strategy Game");
		mnNewMenu.add(mntmStrategyGame);

		//Create card game (admin - create menu)
		JMenuItem mntmCardGame = new JMenuItem("Card Game");
		mnNewMenu.add(mntmCardGame);

		//Start next game in line (admin menu)
		JMenuItem mntmLaunchGame = new JMenuItem("Launch game");
		mnAdmin.add(mntmLaunchGame);

		//Delete a game (admin menu)
		JMenuItem mntmDeleteGame = new JMenuItem("Delete game");
		mnAdmin.add(mntmDeleteGame);

		//Delete account (admin menu)
		JMenuItem mntmDeleteAccount = new JMenuItem("Delete account");
		mnAdmin.add(mntmDeleteAccount);

		//Player menu
		JMenu mnPlayer = new JMenu("Player");
		mnPlayer.setEnabled(false);
		menuBar.add(mnPlayer);

		//Join a game (player menu)
		JMenuItem mntmJoinGame = new JMenuItem("Join game");
		mnPlayer.add(mntmJoinGame);

		//Leave a game (player menu)
		JMenuItem mntmLeaveGame = new JMenuItem("Leave game");
		mnPlayer.add(mntmLeaveGame);

		//Delete account (player menu)
		JMenuItem mntmDeleteAccount_1 = new JMenuItem("Delete account");
		mnPlayer.add(mntmDeleteAccount_1);

		//Listing menu
		JMenu mnListing = new JMenu("Listing");
		menuBar.add(mnListing);
		mnListing.setEnabled(false);

		//List players by games played (listing menu)
		JMenuItem mntmPlayersByGames = new JMenuItem("Players by games played");
		mnListing.add(mntmPlayersByGames);

		//List admins by games created and played (listing menu)
		JMenuItem mntmAdminsByGames = new JMenuItem("Admins by games created");
		mnListing.add(mntmAdminsByGames);
		
		//List all the games on the server (listing menu)
		JMenuItem mntmGames = new JMenuItem("Games");
		mnListing.add(mntmGames);

		//Settings menu
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);

		//Theme choice (settings menu)
		JMenu mnTheme = new JMenu("Theme");
		mnSettings.add(mnTheme);

		//Dark theme (settings - theme menu)
		JRadioButtonMenuItem rdbtnmntmDark = new JRadioButtonMenuItem("Dark");
		rdbtnmntmDark.setSelected(true);
		mnTheme.add(rdbtnmntmDark);

		//Light theme (settings - theme menu)
		JRadioButtonMenuItem rdbtnmntmLight = new JRadioButtonMenuItem("Light");
		mnTheme.add(rdbtnmntmLight);

		//Content
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTextPane txtPane = new JTextPane();
		txtPane.setForeground(Color.WHITE);
		txtPane.setEditable(false);
		txtPane.setBackground(Color.DARK_GRAY);
		txtPane.setText("You need to load a file to get started.");
		contentPane.add(txtPane, BorderLayout.NORTH);

		//Action listeners

		//Create data
		mntmNew.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CreateServ createServ = new CreateServ();
				createServ.addWindowListener(new WindowAdapter() 
				{
					@Override
					public void windowClosed(WindowEvent arg0) 
					{
						if(serv != null)
						{
							txtPane.setText("You are now free to register or log in.");
							mnConnect.setEnabled(true);
							mnListing.setEnabled(true);
						}
					}
				});
			}
		});

		//Load data
		mntmLoad.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser fc = new JFileChooser("Data/");
				int ret = fc.showOpenDialog(getParent());
				if(ret == JFileChooser.APPROVE_OPTION)
				{
					serv = In_Out.load(fc.getSelectedFile().getName());
					if(serv != null)
					{
						txtPane.setText("You are now free to register or log in.");
						mnConnect.setEnabled(true);
						mnListing.setEnabled(true);
						fileName = fc.getSelectedFile().getName();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Can't load this file", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		//Save data
		mntmSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser fc = new JFileChooser("Data/");
				int ret = fc.showOpenDialog(getParent());
				if(ret == JFileChooser.APPROVE_OPTION)
				{
					if(serv != null)
					{
						In_Out.save(serv, fc.getSelectedFile().getName());
						JOptionPane.showMessageDialog(null, "Datas saved !", "", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Nothing to save.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		//Create Player
		mntmPlayer_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new CreatePlayer();
			}
		});

		//Create Admin
		mntmAdmin_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new CreateAdmin();
			}
		});

		//Generate some players
		mntmGeneratePlayers.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, serv.generatePlayers() + " players have successfully been created.", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		//Log as admin
		mntmAdmin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LogAdmin la = new LogAdmin();
				la.addWindowListener(new WindowAdapter() 
				{
					@Override
					public void windowClosed(WindowEvent arg0) 
					{
						if(admin != null)
						{
							JOptionPane.showMessageDialog(null, "Welcome " + admin.getName(), "Welcome", JOptionPane.INFORMATION_MESSAGE);
							mnAdmin.setEnabled(true);
							txtPane.setText("Admin " + admin.getName() + " :\n- Number of games created and played : " + admin.getNbGamesCreaPlay());
							mnPlayer.setEnabled(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "An error has occured, please try again.", "Errorr", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
			}
		});

		//Delete admin account
		mntmDeleteAccount.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int option =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account ?", "", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION)
				{
					serv.getListAdmins().remove(admin);
					List<Game> delete = new ArrayList<Game>();
					for(Game ga: serv.getListGames())
					{
						if(ga.getAdmin().equals(admin))
						{
							delete.add(ga);
						}
					}
					for(Game g : delete)
					{
						serv.getListGames().remove(g);
					}
					delete = null;
					serv.getIdList().remove((Integer)admin.getId());
					admin = null;
					mnAdmin.setEnabled(false);
					txtPane.setText("You are now free to register or log in.");
				}
			}
		});

		//Create FPS
		mntmFps.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new CreateFPS();
			}
		});

		//Create CardGame
		mntmCardGame.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new CreateCardGame();
			}
		});

		//Create StrategyGame
		mntmStrategyGame.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new CreateStrategyGame();
			}
		});

		//Launch next game
		mntmLaunchGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(serv.getListGames().isEmpty() == false)
				{
					Game ga = serv.getListGames().get(0);
					if(ga.launchGame() == true)
					{
						JOptionPane.showMessageDialog(null, "Starting game :\n" + ga, "Starting game", JOptionPane.INFORMATION_MESSAGE);
						ga.updateData();
						serv.getListGames().remove(0);
						ga = null;
						txtPane.setText("Admin " + admin.getName() + " :\n- Number of games created and played : " + admin.getNbGamesCreaPlay());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Not enough players, the game has been cancelled.", "Error", JOptionPane.ERROR_MESSAGE);
						serv.getListGames().remove(0);
						ga = null;
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No game planned.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		//Delete a game
		mntmDeleteGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(serv.getListGames().isEmpty() == false)
				{
					new DeleteGame(admin);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No game to delete !", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		//Delete player account
		mntmDeleteAccount_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int option =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account ?", "", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION)
				{
					serv.getListPlayers().remove(player);
					serv.getIdList().remove((Integer)player.getId());
					//List<Game> delete = new ArrayList<Game>();
					for(Game ga : serv.getListGames())
					{
						if(ga.getListPlayer().contains(player))
						{
							ga.removePlayer(player);
						}
					}
					player = null;
					mnPlayer.setEnabled(false);
					txtPane.setText("You are now free to register or log in.");
				}
			}
		});

		//Log as player
		mntmPlayer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LogPlayer lp = new LogPlayer();
				lp.addWindowListener(new WindowAdapter() 
				{
					@Override
					public void windowClosed(WindowEvent arg0) 
					{
						if(player != null)
						{
							JOptionPane.showMessageDialog(null, "Welcome " + player.getName(), "Welcome", JOptionPane.INFORMATION_MESSAGE);
							mnPlayer.setEnabled(true);
							txtPane.setText("Player " + player.getName() + " :\n- Number of games played : " + player.getNbGamesPlayed()
							+ "\n- Registered to a game : " + player.isRegisGame());
							txtPane.setVisible(true);
							mnAdmin.setEnabled(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "An error has occured, please try again.", "Errorr", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
			}
		});

		//Join a game (player)
		mntmJoinGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(serv.getListGames().isEmpty() == false)
				{
					if(player.isRegisGame() == false)
					{
						JoinGame jg = new JoinGame(player);
						jg.addWindowListener(new WindowAdapter()
						{
							public void windowClosed(WindowEvent arg0)
							{
								txtPane.setText("Player " + player.getName() + " :\n- Number of games played : " + player.getNbGamesPlayed()
								+ "\n- Registered to a game : " + player.isRegisGame());
							}
						});
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You are already logged to a game.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No game to join !", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		//Leave a game (player)
		mntmLeaveGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(player.isRegisGame() == false)
				{
					JOptionPane.showMessageDialog(null, "You are not connected to a game.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					int option =JOptionPane.showConfirmDialog(null, "Do you really wish to leave the game ? ?", "", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION)
					{
						player.setRegisGame(false);
						for(Game ga : serv.getListGames())
						{
							if(ga.getListPlayer().contains(player))
							{
								ga.removePlayer(player);
							}
						}
						txtPane.setText("Player " + player.getName() + " :\n- Number of games played : " + player.getNbGamesPlayed()
						+ "\n- Registered to a game : " + player.isRegisGame());
					}
				}
			}
		});

		//List Admins by the number of games created and played
		mntmAdminsByGames.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0 ; i < serv.getListAdmins().size() ; i++) //Sort the admins by the number of games created and played.
				{
					for(int j = i ; j < serv.getListAdmins().size() ; j++)
					{
						if(serv.getListAdmins().get(j).getNbGamesCreaPlay() > serv.getListAdmins().get(i).getNbGamesCreaPlay())
						{
							Admin temp = serv.getListAdmins().get(i);
							serv.getListAdmins().set(i, serv.getListAdmins().get(j));
							serv.getListAdmins().set(j, temp);
						}
					}
				}
				String message = "";
				for(Admin ad : serv.getListAdmins()) //Display the admins sorted.
				{
					message += ad.toString();
				}
				if(message != "")
				{
					JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No admins on this server.", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		//List Players by the number of games played
		mntmPlayersByGames.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0 ; i < serv.getListPlayers().size() ; i++) //Sort the players by the number of games played.
				{
					for(int j = i ; j < serv.getListPlayers().size() ; j++)
					{
						if(serv.getListPlayers().get(j).getNbGamesPlayed() > serv.getListPlayers().get(i).getNbGamesPlayed())
						{
							Player temp = serv.getListPlayers().get(i);
							serv.getListPlayers().set(i, serv.getListPlayers().get(j));
							serv.getListPlayers().set(j, temp);
						}
					}
				}
				String message = "";
				for(Player pl : serv.getListPlayers()) //Display the players sorted.
				{
					message += pl.toString();
				}
				if(message != "")
				{
					JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No players on this server.", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		//List all games on the server
		mntmGames.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(serv.getListGames().isEmpty() == false)
				{
					new ListGames();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No games on the server !", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		//Set Dark Theme
		rdbtnmntmDark.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				rdbtnmntmDark.setSelected(true);
				rdbtnmntmLight.setSelected(false);
				contentPane.setBackground(Color.DARK_GRAY);
				txtPane.setForeground(Color.WHITE);
				txtPane.setBackground(Color.DARK_GRAY);
				setBackground(Color.DARK_GRAY);
				setTheme("Dark");
			}
		});

		//Set Light Theme
		rdbtnmntmLight.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				rdbtnmntmDark.setSelected(false);
				rdbtnmntmLight.setSelected(true);
				contentPane.setBackground(Color.WHITE);
				txtPane.setForeground(Color.DARK_GRAY);
				txtPane.setBackground(Color.WHITE);
				setBackground(Color.WHITE);
				setTheme("Light");
			}
		});

		//Closing window
		addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				int option = JOptionPane.showConfirmDialog(null, "Do you wish to save your datas before leaving ? Any datas not saved will be lost forever !", "", JOptionPane.YES_NO_CANCEL_OPTION);
				if(option == JOptionPane.YES_OPTION)
				{
					if(serv != null)
					{
						In_Out.save(serv, fileName);
						System.exit(0);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Nothing to save.", "Warning", JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					}
				}
				else if(option == JOptionPane.NO_OPTION)
				{
					System.exit(0);
				}
			}
		});


	}

	/**
	 * Return the server loaded.
	 * @return The server
	 */
	public static Server getServ() 
	{
		return serv;
	}

	/**
	 * Update the server loaded.
	 * @param serv The new server
	 */
	public static void setServ(Server serv) 
	{
		PrimaryWindow.serv = serv;
	}

	/**
	 * Return the theme used in the application.
	 * @return The theme
	 */
	public static String getTheme() 
	{
		return theme;
	}

	/**
	 * Update the theme used in the application.
	 * @param theme The new theme
	 */
	public static void setTheme(String theme) 
	{
		PrimaryWindow.theme = theme;
	}

	/**
	 * Return the name of the file loaded.
	 * @return The fileName
	 */
	public static String getFileName() 
	{
		return fileName;
	}

	/**
	 * Update the name of the file loaded.
	 * @param fileName The new name of the file loaded
	 */
	public static void setFileName(String fileName) 
	{
		PrimaryWindow.fileName = fileName;
	}

	/**
	 * @return the admin
	 */
	public static Admin getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public static void setAdmin(Admin admin) {
		PrimaryWindow.admin = admin;
	}

	/**
	 * @return the player
	 */
	public static Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public static void setPlayer(Player player) {
		PrimaryWindow.player = player;
	}
}
