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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import en.poo.tp.game.Game;
import en.poo.tp.videogame.Difficulty;
import en.poo.tp.videogame.FPS;

public class CreateFPS extends JDialog {

	private static final long serialVersionUID = -7213389966172921572L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public CreateFPS() 
	{
		setSize(new Dimension(600, 410));
		setLocationRelativeTo(null);
		setTitle("Create FPS");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.WHITE);
		
		//Name
		JPanel panName = new JPanel();
		panName.setBackground(Color.white);
		panName.setPreferredSize(new Dimension(250, 60));
		JTextField name = new JTextField();
		name.setPreferredSize(new Dimension(100, 25));
		panName.setBorder(BorderFactory.createTitledBorder(null, "Name", 0, 0, null, Color.DARK_GRAY));
		JLabel nameLabel = new JLabel("Enter a name :");
		panName.add(nameLabel);
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
		
		//Difficulty
		JPanel panDifficulty = new JPanel();
		panDifficulty.setBackground(Color.white);
		panDifficulty.setPreferredSize(new Dimension(250, 60));
		panDifficulty.setBorder(BorderFactory.createTitledBorder(null, "Difficulty", 0, 0, null, Color.DARK_GRAY));
		contentPanel.add(panDifficulty);
		JLabel difficultyLabel = new JLabel("Enter a difficulty : ");
		panDifficulty.add(difficultyLabel);		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox difficulty = new JComboBox(Difficulty.values());
		panDifficulty.add(difficulty);
		difficulty.setPreferredSize(new Dimension(100, 25));
		
		//Team
		JPanel panTeam = new JPanel();
		panTeam.setBackground(Color.white);
		panTeam.setPreferredSize(new Dimension(300, 60));
		panTeam.setBorder(BorderFactory.createTitledBorder(null, "Team", 0, 0, null, Color.DARK_GRAY));
		contentPanel.add(panTeam);
		JLabel teamLabel = new JLabel("It is played in teams ?");
		panTeam.add(teamLabel);
		JRadioButton rdbtnYes = new JRadioButton("yes");
		rdbtnYes.setBackground(Color.WHITE);
		rdbtnYes.setForeground(Color.DARK_GRAY);
		panTeam.add(rdbtnYes);		
		JRadioButton rdbtnNo = new JRadioButton("no");
		rdbtnNo.setSelected(true);
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setForeground(Color.DARK_GRAY);
		panTeam.add(rdbtnNo);
		
		rdbtnYes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				rdbtnNo.setSelected(false);
			}
			
		});
		
		rdbtnNo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				rdbtnYes.setSelected(false);
			}
			
		});
		
		//NbMinPlayer
		JPanel panNbMin = new JPanel();
		panNbMin.setBackground(Color.WHITE);
		panNbMin.setPreferredSize(new Dimension(400, 60));
		panNbMin.setBorder(BorderFactory.createTitledBorder(null, "Minimal number of players", 0, 0, null, Color.DARK_GRAY));
		contentPanel.add(panNbMin);
		JLabel nbMinLabel = new JLabel("Enter the minimal number of players (integer) :");
		panNbMin.add(nbMinLabel);
		JTextField nbMin = new JTextField();
		panNbMin.add(nbMin);
		nbMin.setPreferredSize(new Dimension(40, 25));
		
		//NbMaxPlayer
		JPanel panNbMax = new JPanel();
		panNbMax.setBackground(Color.WHITE);
		panNbMax.setPreferredSize(new Dimension(400, 60));
		panNbMax.setBorder(BorderFactory.createTitledBorder(null, "Maximal number of players", 0, 0, null, Color.DARK_GRAY));
		contentPanel.add(panNbMax);
		JLabel nbMaxLabel = new JLabel("Enter the maximal number of players (integer) :");
		panNbMax.add(nbMaxLabel);
		JTextField nbMax = new JTextField();
		panNbMax.add(nbMax);
		nbMax.setPreferredSize(new Dimension(40, 25));
		
		//MaxDuration
		JPanel panMaxDuration = new JPanel();
		panMaxDuration.setBackground(Color.WHITE);
		panMaxDuration.setPreferredSize(new Dimension(500, 60));
		panMaxDuration.setBorder(BorderFactory.createTitledBorder(null, "Maximal duration", 0, 0, null, Color.DARK_GRAY));
		contentPanel.add(panMaxDuration);
		JLabel maxDurationLabel = new JLabel("Enter the maximal duration of the game (integer) :");
		panMaxDuration.add(maxDurationLabel);
		JTextField maxDuration = new JTextField();
		panMaxDuration.add(maxDuration);
		JLabel minLabel = new JLabel("minutes");
		panMaxDuration.add(minLabel);
		maxDuration.setPreferredSize(new Dimension(40, 25));
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//Ok Button
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(name.getText().length() > 0 && id.getText().length() > 0 && difficulty.getSelectedItem() != null && nbMin.getText().length() > 0
						&& nbMax.getText().length() > 0 && maxDuration.getText().length() > 0) //Check if all the fields are filled
				{
					try
					{
						Difficulty diff = (Difficulty) difficulty.getSelectedItem();
						boolean team = false;
						if(rdbtnYes.isSelected()) //If yes is selected for the team
						{
							team = true;
						}
						FPS game = new FPS(Integer.parseInt(id.getText()), name.getText(), diff, Integer.parseInt(nbMin.getText()),
								Integer.parseInt(nbMax.getText()), team, Integer.parseInt(maxDuration.getText()));
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
						else //Game unsuccessfully created
						{
							JOptionPane.showMessageDialog(null, "Game unsuccessfully created, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "An error has occured, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else //All the fields are not filled
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
		
		difficulty.addKeyListener(new KeyAdapter() 
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
		
		nbMin.addKeyListener(new KeyAdapter() 
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
		
		nbMax.addKeyListener(new KeyAdapter() 
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
		
		rdbtnNo.addKeyListener(new KeyAdapter() 
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
		
		rdbtnYes.addKeyListener(new KeyAdapter() 
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
		
		maxDuration.addKeyListener(new KeyAdapter() 
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
			panDifficulty.setBackground(Color.DARK_GRAY);
			panDifficulty.setBorder(BorderFactory.createTitledBorder(null, "Difficulty", 0, 0, null, Color.WHITE));
			difficultyLabel.setForeground(Color.WHITE);
			panTeam.setBackground(Color.DARK_GRAY);
			panTeam.setBorder(BorderFactory.createTitledBorder(null, "Team", 0, 0, null, Color.WHITE));
			teamLabel.setForeground(Color.WHITE);
			rdbtnYes.setForeground(Color.WHITE);
			rdbtnNo.setForeground(Color.WHITE);
			rdbtnYes.setBackground(Color.DARK_GRAY);
			rdbtnNo.setBackground(Color.DARK_GRAY);
			panNbMax.setBackground(Color.DARK_GRAY);
			panNbMax.setBorder(BorderFactory.createTitledBorder(null, "Maximal number of players", 0, 0, null, Color.WHITE));
			nbMaxLabel.setForeground(Color.WHITE);
			panNbMin.setBackground(Color.DARK_GRAY);
			panNbMin.setBorder(BorderFactory.createTitledBorder(null, "Minimal number of players", 0, 0, null, Color.WHITE));
			nbMinLabel.setForeground(Color.WHITE);
			panMaxDuration.setBackground(Color.DARK_GRAY);
			panMaxDuration.setBorder(BorderFactory.createTitledBorder(null, "Maximal duration", 0, 0, null, Color.WHITE));
			maxDurationLabel.setForeground(Color.WHITE);
			minLabel.setForeground(Color.WHITE);

		}
		setVisible(true);
	}

}
