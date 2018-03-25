package com.Insanepiker101.JavaMDKInstaller.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.Insanepiker101.JavaMDKInstaller.frame.JavaMDKInstaller;

public class ForgeDialog extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ForgeDialog(JFrame owner) 
	{
		super(owner, "ForgeDialog", true);
		//Forge version checkbox
		JComboBox<String> jComboBox = new JComboBox<>();
		
		jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Forge version 1.12.2*"
				, "Forge version 1.11.2*", "Forge version 1.10.2*", "Forge version 1.7.10*" }));
		
		//Text area to show installation folder
		
		JTextArea jTextArea = new JTextArea();
		jTextArea.setEditable(false);
		jTextArea.setText(System.getProperty("user.home")+"/minecraft_workspace");
		
		//.. Button to chose a file path
		
		JButton path = new JButton("...");
		path.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				chooser = new JFileChooser();
				chooser.setVisible(true);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setCurrentDirectory(null);
				chooser.showOpenDialog(rootPane);
				jTextArea.setText(chooser.getSelectedFile().toString());
				
			}
		});
		
		//Close button closes the dialog without returning anything
		
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
		});
		
		//OK button closes the dialog and returns the input
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				
				try
				{
					JavaMDKInstaller.Command(System.getProperty("user.home")+"/.JavaMDKInstaller/Config/handlers/MvHandler.sh"
							, VersionDone(jComboBox), ChooserDone(chooser));
					
				}
				catch(IOException error)
				{
					error.printStackTrace();
				}
			}
		});
		
		//Add jTextArea to Center
		
		JPanel panel = new JPanel();
		panel.add(jTextArea);
		add(panel, BorderLayout.CENTER);
		
		//Add path button to Center
		panel.add(path);
		
		//Add OK button to southern border
		
		JPanel panel1 = new JPanel();
		panel1.add(ok);
		add(panel1, BorderLayout.SOUTH);
		
		//Add Close button to southern border
		
		panel1.add(close);
		
		//Add JComboBox to Top
		JPanel panel2 = new JPanel();
		panel2.add(jComboBox);
		add(panel2, BorderLayout.NORTH);
		
		
		setSize(300, 150);
		
	}
	private static JFileChooser chooser;
	
	public static String ChooserDone(JFileChooser chooser) 
	{
		return chooser.getSelectedFile().toString();
	}
	
	public static String VersionDone(JComboBox<String> box)
	{
		if(box.getSelectedItem().toString() == "Forge version 1.12.2*")
		{
			return "1.12.2";
		}
		else if(box.getSelectedItem().toString() == "Forge version 1.11.2*")
		{
			return "1.11.2";
		}
		else if(box.getSelectedItem().toString() == "Forge version 1.10.2*")
		{
			return "1.10.2";
		}
		else if(box.getSelectedItem().toString() == "Forge version 1.7.10*") 
		{
			return "1.7.10";
		}
		return "error: Out of bounds";
	}
}
