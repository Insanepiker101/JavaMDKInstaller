package com.Insanepiker101.JavaMDKInstaller;

import java.awt.EventQueue;
import javax.swing.JFrame;
import com.Insanepiker101.JavaMDKInstaller.frame.JavaMDKInstaller;

public class Main
{
	
	public static void main(String[] args) 
	{
        
			try 
			{
			    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
			    {
			        if ("Nimbus".equals(info.getName())) 
			        {
			            javax.swing.UIManager.setLookAndFeel(info.getClassName());
			            break;
			        }
			    }
			} catch (ClassNotFoundException ex) {
			    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (InstantiationException ex) {
			    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (IllegalAccessException ex) {
			    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}
		
		
        /* Create and display the form */
        EventQueue.invokeLater(() -> 
        {
            JavaMDKInstaller frame = new JavaMDKInstaller();
            frame.setAlwaysOnTop(true);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }         
}
