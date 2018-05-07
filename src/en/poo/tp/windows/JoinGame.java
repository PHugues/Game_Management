package en.poo.tp.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import en.poo.tp.game.Game;
import en.poo.tp.person.Player;
import javax.swing.ScrollPaneConstants;

public class JoinGame extends JFrame {

	private static final long serialVersionUID = 8654653590175571454L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the frame.
	 */
	public JoinGame(Player pl) 
	{
		setSize(new Dimension(550, 450));
		setLocationRelativeTo(null);
		setTitle("Join Game");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.WHITE);

		//ID
		JPanel panID = new JPanel();
		panID.setBackground(Color.white);
		panID.setPreferredSize(new Dimension(320, 80));
		panID.setBorder(BorderFactory.createTitledBorder(null, "ID", 0, 0, null, Color.DARK_GRAY));
		contentPanel.add(panID);
		JLabel idLabel = new JLabel("Enter the ID of the game you wish to join :");
		panID.add(idLabel);
		JTextField id = new JTextField();
		panID.add(id);
		id.setPreferredSize(new Dimension(100, 25));
		
		//Games
		JTextPane textPane = new JTextPane();
		JScrollPane scrollTextPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollTextPane.setPreferredSize(new Dimension(450, 250));
		textPane.setBackground(Color.white);
		textPane.setForeground(Color.DARK_GRAY);
		
		String games = "";
		int i = 1;
		for(Game g : PrimaryWindow.getServ().getListGames())
		{
			games += "---------------------------------------------------------\n";
			games += i + "-\n" + g.toString() + "\n";
			i++;
		}
		textPane.setText(games);
		contentPanel.add(scrollTextPane);
		
		//Buttons
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//Ok Button
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(id.getText().length() > 0)
				{
					try
					{
						int value = Integer.parseInt(id.getText());
						if(PrimaryWindow.getServ().joinGame(pl, PrimaryWindow.getServ().getListGames().get(value-1)) == true)
						{
							JOptionPane.showMessageDialog(null, "Game successfully joined.", "", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "You can't join this game.", "Error", JOptionPane.ERROR_MESSAGE);
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
		
		if(PrimaryWindow.getTheme() == "Dark")
		{
			contentPanel.setBackground(Color.DARK_GRAY);
			buttonPane.setBackground(Color.DARK_GRAY);
			panID.setBackground(Color.DARK_GRAY);
			panID.setBorder(BorderFactory.createTitledBorder(null, "ID", 0, 0, null, Color.WHITE));
			idLabel.setForeground(Color.WHITE);
			textPane.setBackground(Color.DARK_GRAY);
			textPane.setForeground(Color.WHITE);
		}
		setVisible(true);
	}

}
