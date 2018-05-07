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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import en.poo.tp.exceptions.FileExistingException;
import en.poo.tp.files.In_Out;
import en.poo.tp.server.Server;

public class CreateServ extends JDialog {

	private static final long serialVersionUID = -6635743377543513823L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public CreateServ() 
	{
		setSize(new Dimension(300, 150));
		setLocationRelativeTo(null);
		setTitle("Create Server");
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
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//Ok button
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(name.getText().length() > 0)
				{
					try 
					{
						In_Out.create(new Server(), name.getText());
						PrimaryWindow.setServ(In_Out.load(name.getText()));
						PrimaryWindow.setFileName(name.getText());
						dispose();
						if(PrimaryWindow.getServ() != null)
						{
							JOptionPane.showMessageDialog(null, "Server successfully created and loaded.", "Information", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "An error has occured, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						setVisible(false);
					} 
					catch (FileExistingException e) 
					{
						JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You must fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		//Cancel Button
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
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
		
		if(PrimaryWindow.getTheme() == "Dark")
		{
			contentPanel.setBackground(Color.DARK_GRAY);
			buttonPane.setBackground(Color.DARK_GRAY);
			panName.setBackground(Color.DARK_GRAY);
			panName.setForeground(Color.WHITE);
			nameLabel.setForeground(Color.WHITE);
			panName.setBorder(BorderFactory.createTitledBorder(null, "Name", 0, 0, null, Color.WHITE));
		}
		
		setVisible(true);
	}
}
