package en.poo.tp.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import en.poo.tp.game.Game;

public class ListGames extends JFrame {

	private static final long serialVersionUID = -3305870896867185327L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the frame.
	 */
	public ListGames() 
	{
		setSize(new Dimension(550, 450));
		setLocationRelativeTo(null);
		setTitle("List Games");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.WHITE);
		
		//Games
		JTextPane textPane = new JTextPane();
		JScrollPane scrollTextPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollTextPane.setPreferredSize(new Dimension(450, 400));
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

		getContentPane().add(contentPanel, BorderLayout.CENTER);
	
		if(PrimaryWindow.getTheme() == "Dark")
		{
			contentPanel.setBackground(Color.DARK_GRAY);			
			textPane.setBackground(Color.DARK_GRAY);
			textPane.setForeground(Color.WHITE);
		}
		setVisible(true);
	}

}
