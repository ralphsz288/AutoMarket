package com.proiect.auto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import com.proiect.auto.frames.Cumparare;
import com.proiect.auto.frames.Favorite;
import com.proiect.auto.frames.Home;
import com.proiect.auto.frames.Login;
import com.proiect.auto.frames.MasinileMele;
import com.proiect.auto.frames.VanzareMasini;

//import ro.itschool.pixels.Image;
//import ro.itschool.pixels.ui.ImageComponent;
 
public class Main {
	
	public static void main(String[] args) {
		MasiniManager masini2=new MasiniManager();
		int ok=0;
		final String path="C:\\Users\\User\\Downloads\\backround3.jpg";
		JFrame window= new JFrame("Dealership");
        try {
            window.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(path)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
           window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1000,500);
		//window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//window.setUndecorated(true);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu masini= new JMenu("Masini");
		//JMenu inchiriere= new JMenu("Inchiriere"); 
		//JMenu piese= new JMenu("Piese");
		JMenu optiuni=new JMenu("Optiuni");
		JMenu autentificare=new JMenu("login");
		JMenuItem log=new JMenuItem("login");
		JMenuItem cumparare= new JMenuItem("Cumparare");
		JMenuItem vanzare= new JMenuItem("Vanzare");
		JMenuItem favorite=new JMenuItem("Favorite");
		JMenuItem masiniPersonale=new JMenuItem("Masinile mele");
		
		masiniPersonale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MasinileMele f=new MasinileMele(LoginManager.getInstance().getUsername());
				f.setVisible(true);
	 	
				
			}
			
		});
		
		favorite.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Favorite f=new Favorite(LoginManager.getInstance().getUsername());
				f.setVisible(true);
		
				
			}
			
		});
		
		log.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login login=new Login();
				login.setVisible(true);
				System.out.println(LoginManager.getInstance());
				
			}
			
		});
		vanzare.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(LoginManager.getInstance().isLoggedIn()) {
					VanzareMasini vanzare= new VanzareMasini();
					vanzare.setVisible(true);	
				}else {
					JOptionPane.showMessageDialog(null, "Nu sunteti logat");
				}
				
			}
			 
		});
		
		
		cumparare.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cumparare c= new Cumparare();
				c.setVisible(true);				
			}
			 
		});
		menuBar.add(masini);
		menuBar.add(optiuni);
		menuBar.add(autentificare);
		autentificare.add(log);
		masini.add(cumparare);
		masini.add(vanzare);
		optiuni.add(favorite);
		optiuni.add(masiniPersonale);
		window.setJMenuBar(menuBar);
		window.setVisible(true);
		
	
	}

}
