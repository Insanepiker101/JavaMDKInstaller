package com.Insanepiker101.JavaMDKInstaller.frame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;

import com.Insanepiker101.JavaMDKInstaller.dialog.ForgeDialog;

public class JavaMDKInstaller extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8356543468218602851L;

	public JavaMDKInstaller()
	{
		InitComponents();
	}
	
	private void InitComponents() 
	{                
		this.setTitle("JavaMDKInstaller");
		
		
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();

		
		jTextArea1.setEditable(false);
		jTextArea1.setColumns(20);
		jScrollPane1.setViewportView(jTextArea1);

		jMenu1.setText("File");

		jMenu3.setText("New");

		jMenuItem1.setText("Mod Project");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem1);

		jMenu1.add(jMenu3);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE).addComponent(jScrollPane1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
	}

	public static final String Command(String command, String arg1, String arg2) throws IOException
	{
		if(arg1!=null && arg2!=null)
		{
			final ProcessBuilder builder = new ProcessBuilder(command, arg1, arg2);
			
			stuff(builder);
		}
		else if(arg1==null && arg2==null)
		{
			final ProcessBuilder builder = new ProcessBuilder(command);
			
			stuff(builder);
		}
		else if(arg1==null && arg2!=null)
		{
			return "Error:Command:-1";
		}
		else if(arg1!=null && arg2==null)
		{
			final ProcessBuilder builder = new ProcessBuilder(command, arg1);
			
			stuff(builder);
		}
		else
		{
			return "Error:Command:1";
		}
		
		return "Error:command";
	} 
	
	public static void stuff(ProcessBuilder builder) throws IOException
	{
		builder.redirectErrorStream(true);
		Process process = builder.start();
		InputStream is = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while ((line = reader.readLine()) != null)
		{
			jTextArea1.append(line+" "+"\n");
		}
		
	}
	
	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) 
    {                                           
        if(dialog == null) //first time 
        {
        	dialog = new ForgeDialog(JavaMDKInstaller.this);
        	dialog.setVisible(true);
        }
        else
        {
        	dialog.setVisible(true);
        }
        
    }
	
	
	// Variables declaration - do not modify
		private ForgeDialog dialog;
	    private javax.swing.JMenu jMenu1;
	    private javax.swing.JMenu jMenu2;
	    private javax.swing.JMenu jMenu3;
	    private javax.swing.JMenuBar jMenuBar1;
	    private javax.swing.JMenuItem jMenuItem1;
	    private static javax.swing.JScrollPane jScrollPane1;
	    public static javax.swing.JTextArea jTextArea1;
	    // End of variables declaration   
	
}
