package en.poo.tp.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import en.poo.tp.game.Game;
import en.poo.tp.videogame.CardGame;

public class CreateCardGame extends JDialog {

	private static final long serialVersionUID = 2603591901354334412L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public CreateCardGame()
{
		setSize(new Dimension(600, 300));
		setLocationRelativeTo(null);
		setTitle("Create Card Game");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.WHITE);
		
		//Name
		JPanel panName = new JPanel();
		panName.setBackground(Color.white);
		panName.setPreferredSize(new Dimension(250, 60));
		panName.setBorder(BorderFactory.createTitledBorder(null, "Name", 0, 0, null, Color.DARK_GRAY));
		JLabel nameLabel = new JLabel("Enter a name :");
		panName.add(nameLabel);
		JTextField name = new JTextField();
		name.setPreferredSize(new Dimension(100, 25));
		panName.add(name);
		contentPanel.add(panName);
		
		//ID
		JPanel panID = new JPanel();
		panID.setBackground(Color.white);
		panID.setPreferredSize(new Dimension(300, 60));
		panID.setBorder(BorderFactory.createTitledBorder(null, "ID", 0, 0, null, Color.DARK_GRAY));
		contentPanel.add(panID);
		JLabel idLabel = new JLabel("Enter an ID (integer) :");
		panID.add(idLabel);
		JTextField id = new JTextField();
		panID.add(id);
		id.setPreferredSize(new Dimension(100, 25));
		
		//GameType
		JPanel panGameType = new JPanel();
		panGameType.setBackground(Color.white);
		panGameType.setPreferredSize(new Dimension(400, 60));
		panGameType.setBorder(BorderFactory.createTitledBorder(null, "Game type", 0, 0, null, Color.DARK_GRAY));
		contentPanel.add(panGameType);
		JLabel gameTypeLabel = new JLabel("Enter the type of game : ");
		panGameType.add(gameTypeLabel);		
		JTextField gameType = new JTextField();
		panGameType.add(gameType);
		gameType.setPreferredSize(new Dimension(200, 25));
		
		//Required number of players
		JPanel panReqNb = new JPanel();
		panReqNb.setBackground(Color.WHITE);
		panReqNb.setPreferredSize(new Dimension(400, 60));
		panReqNb.setBorder(BorderFactory.createTitledBorder(null, "Number of players", 0, 0, null, Color.DARK_GRAY));
		contentPanel.add(panReqNb);
		JLabel reqNbLabel = new JLabel("Enter the number of players required (integer) :");
		panReqNb.add(reqNbLabel);
		JTextField reqNb = new JTextField();
		panReqNb.add(reqNb);
		reqNb.setPreferredSize(new Dimension(40, 25));
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//Ok Button
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(id.getText().length() > 0 && name.getText().length() > 0 && gameType.getText().length() > 0 && reqNb.getText().length() > 0)
				{
					try
					{
						CardGame game = new CardGame(Integer.parseInt(id.getText()), name.getText(), gameType.getText(), Integer.parseInt(reqNb.getText()));
						Game ga = PrimaryWindow.getServ().createGame(PrimaryWindow.getAdmin(), game);
						if(ga != null)
						{
							CreateBeginDate crDate = new CreateBeginDate(ga);
							crDate.addWindowListener(new WindowAdapter()
							{
								@Override
								public void windowClosed(WindowEvent arg0)
								{
									JOptionPane.showMessageDialog(null, "Game created !", "", JOptionPane.INFORMATION_MESSAGE);
									dispose();
								}
							});
						}
						else
						{
							JOptionPane.showMessageDialog(null, "An error has occured, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "An error has occured, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You must fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		//Cancel Button
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				dispose();
			}
		});
		buttonPane.add(cancelButton);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		name.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					cancelButton.doClick();
				}
			}
		});
		
		id.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					cancelButton.doClick();
				}
			}
		});
		
		gameType.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					cancelButton.doClick();
				}
			}
		});
		
		reqNb.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					cancelButton.doClick();
				}
			}
		});
		
		if(PrimaryWindow.getTheme() == "Dark")
		{
			contentPanel.setBackground(Color.DARK_GRAY);
			buttonPane.setBackground(Color.DARK_GRAY);
			panName.setBackground(Color.DARK_GRAY);
			panName.setBorder(BorderFactory.createTitledBorder(null, "Name", 0, 0, null, Color.WHITE));
			nameLabel.setForeground(Color.WHITE);
			panID.setBackground(Color.DARK_GRAY);
			panID.setBorder(BorderFactory.createTitledBorder(null, "ID", 0, 0, null, Color.WHITE));
			idLabel.setForeground(Color.WHITE);
			panGameType.setBackground(Color.DARK_GRAY);
			panGameType.setBorder(BorderFactory.createTitledBorder(null, "Game type", 0, 0, null, Color.WHITE));
			gameTypeLabel.setForeground(Color.WHITE);
			panReqNb.setBackground(Color.DARK_GRAY);
			panReqNb.setBorder(BorderFactory.createTitledBorder(null, "Number of players", 0, 0, null, Color.WHITE));
			reqNbLabel.setForeground(Color.WHITE);
		}
		setVisible(true);
	}

}
