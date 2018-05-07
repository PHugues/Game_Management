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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import en.poo.tp.person.Admin;

public class LogAdmin extends JDialog {

	private static final long serialVersionUID = 156192708225523335L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public LogAdmin() 
	{
		setSize(new Dimension(350, 250));
		setLocationRelativeTo(null);
		setTitle("Log as admin");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.WHITE);
		
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
		
		//Code
		JPanel panCode = new JPanel();
		panCode.setBackground(Color.white);
		panCode.setPreferredSize(new Dimension(300, 60));
		JPasswordField code = new JPasswordField();
		code.setPreferredSize(new Dimension(100, 25));
		panCode.setBorder(BorderFactory.createTitledBorder(null, "Code", 0, 0, null, Color.DARK_GRAY));
		JLabel codeLabel = new JLabel("Enter a password :");
		panCode.add(codeLabel);
		panCode.add(code);
		contentPanel.add(panCode);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//Ok Button
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(id.getText().length() > 0 && code.getPassword().length > 0) //Check if the text fields aren't empty.
				{
					try
					{
						int iD = Integer.parseInt(id.getText());
						boolean isAdmin = false;
						char[] pass = code.getPassword();
						boolean passCorrect = true;
						if(PrimaryWindow.getServ().getIdList().contains(iD) == true) //If the ID does exists.
						{
							for(Admin ad : PrimaryWindow.getServ().getListAdmins())
							{
								if(ad.getId() == iD) //ID found
								{
									isAdmin = true;
									if(ad.getCode().length == pass.length) //Password length correct
									{
										for(int i = 0 ; i < pass.length ; i++) //Check character by character
										{
											Character cPass = (Character)pass[i];
											Character cCode = (Character)ad.getCode()[i];
											if(!(cPass.equals(cCode))) //If a character isn't equal, then the password is incorrect
											{
												passCorrect = false;
												JOptionPane.showMessageDialog(null, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
												break;
											}
										}
										if(passCorrect == true) //If after all verifications the password is correct.
										{
											PrimaryWindow.setAdmin(ad);
											dispose();
										}
									}
									else //Password length incorrect
									{
										JOptionPane.showMessageDialog(null, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
										break;
									}
								}
							}
							if(isAdmin == false) //If the ID entered does exist but doesn't belong to an admin.
							{
								JOptionPane.showMessageDialog(null, "The ID entered doesn't belong to an admin.", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						else //ID doesn't exist
						{
							JOptionPane.showMessageDialog(null, "This ID doesn't exist, please give an other.", "Error", JOptionPane.ERROR_MESSAGE);
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
		
		code.addKeyListener(new KeyAdapter() 
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
			panCode.setBackground(Color.DARK_GRAY);
			panCode.setBorder(BorderFactory.createTitledBorder(null, "Code", 0, 0, null, Color.WHITE));
			codeLabel.setForeground(Color.WHITE);
		}
		setVisible(true);
	}

}
