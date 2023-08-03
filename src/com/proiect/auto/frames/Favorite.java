package com.proiect.auto.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.proiect.auto.MasiniManager;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Favorite extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Favorite frame = new Favorite(String user);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Favorite(String user) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 79, 726, 289);
		contentPane.add(scrollPane);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		scrollPane.setViewportView(panel);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasiniManager masina=new MasiniManager();
				panel.removeAll();
				masina.afisareFavorite(user, panel);
				
			}
		});
		btnNewButton.setBounds(706, 57, 85, 21);
		contentPane.add(btnNewButton);
		panel.removeAll();
		MasiniManager masina = new MasiniManager();
//		final String myDriver = "com.mysql.cj.jdbc.Driver";
//		final String myUrl = "jdbc:mysql://localhost/pc";
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(myUrl, "root", "");
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		String query="Select distinct id from favorite where user= '"+user+"'";
//		try (PreparedStatement st = conn.prepareStatement(query)) {
//			ResultSet rs = st.executeQuery(query);
//			while (rs.next()) {
//				panel.add(new FavoriteView(rs.getInt("id")));
//				scrollPane.validate();
//				panel.revalidate();
//				panel.repaint();
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
		masina.afisareFavorite(user, panel);
		
	}
}
