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

public class CreateAdmin extends JDialog {

	private static final long serialVersionUID = -5536763369002793950L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public CreateAdmin() 
	{
		setSize(new Dimension(350, 300));
		setLocationRelativeTo(null);
		setTitle("Create Administrator");
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
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//Ok Button
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(id.getText().length() > 0 && name.getText().length() > 0 && code.getPassword().length > 0)
				{
					try
					{
						if(PrimaryWindow.getServ().getIdList().contains(Integer.parseInt(id.getText())) == false) //If the ID doesn't already exists.
						{
							PrimaryWindow.getServ().getListAdmins().add(new Admin(code.getPassword(), name.getText(), Integer.parseInt(id.getText())));
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "This ID already exists, please give an other.", "Error", JOptionPane.ERROR_MESSAGE);
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
			panName.setBackground(Color.DARK_GRAY);
			panName.setBorder(BorderFactory.createTitledBorder(null, "Name", 0, 0, null, Color.WHITE));
			nameLabel.setForeground(Color.WHITE);
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
