package en.poo.tp.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import en.poo.tp.game.Game;

public class CreateBeginDate extends JDialog {

	private static final long serialVersionUID = 1315005948321928482L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public CreateBeginDate(Game g) 
	{
		setSize(new Dimension(350, 220));
		setLocationRelativeTo(null);
		setTitle("Create Begin Date");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.WHITE);
		
		//Month
		JPanel panMonth = new JPanel();
		panMonth.setBackground(Color.white);
		panMonth.setPreferredSize(new Dimension(300, 60));
		JTextField month = new JTextField();
		month.setPreferredSize(new Dimension(100, 25));
		panMonth.setBorder(BorderFactory.createTitledBorder(null, "Month", 0, 0, null, Color.DARK_GRAY));
		JLabel monthLabel = new JLabel("Enter a month (integer) :");
		panMonth.add(monthLabel);
		panMonth.add(month);
		contentPanel.add(panMonth);
		
		//Day
		JPanel dayID = new JPanel();
		dayID.setBackground(Color.white);
		dayID.setPreferredSize(new Dimension(300, 60));
		dayID.setBorder(BorderFactory.createTitledBorder(null, "Day", 0, 0, null, Color.DARK_GRAY));
		contentPanel.add(dayID);
		JLabel dayLabel = new JLabel("Enter a day (integer) :");
		dayID.add(dayLabel);
		JTextField day = new JTextField();
		dayID.add(day);
		day.setPreferredSize(new Dimension(100, 25));
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//Ok Button
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(day.getText().length() > 0 && month.getText().length() > 0)
				{
					try
					{
						g.setDate(Integer.parseInt(month.getText()), Integer.parseInt(day.getText()));
						dispose();
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "An error has occcured please try again.", "Error", JOptionPane.ERROR_MESSAGE);
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
		
		if(PrimaryWindow.getTheme() == "Dark")
		{
			contentPanel.setBackground(Color.DARK_GRAY);
			buttonPane.setBackground(Color.DARK_GRAY);
			panMonth.setBackground(Color.DARK_GRAY);
			panMonth.setBorder(BorderFactory.createTitledBorder(null, "Month", 0, 0, null, Color.WHITE));
			monthLabel.setForeground(Color.WHITE);
			dayID.setBackground(Color.DARK_GRAY);
			dayID.setBorder(BorderFactory.createTitledBorder(null, "Day", 0, 0, null, Color.WHITE));
			dayLabel.setForeground(Color.WHITE);
		}
		setVisible(true);
	}

}
