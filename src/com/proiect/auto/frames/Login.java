package com.proiect.auto.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.proiect.auto.Main;
import com.proiect.auto.LoginManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.util.HashMap;
public class Login extends JFrame {
	public int test=0;
	public JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;
	public String user;
	public String pass;
	public String username;
	public String parola;
	public String nume;
	public String prenume;
	public String telefon;
	/**
	 * Launch the application.
	 */
	public void getConn() {
		Connection conn=null;
		try {
			String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/pc";	         
			conn = DriverManager.getConnection(myUrl, "root", "");
			String query="select username, parola from user";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
		}catch (SQLException ex) {
			System.out.println("not connected");
		}
	}
	public void close() {
		WindowEvent closeWindow = new WindowEvent (this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow); 
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1009, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(270, 135, 114, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(281, 206, 114, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(405, 145, 192, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp sign= new SignUp();
				sign.setVisible(true);
				Login.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(449, 375, 121, 33);
		contentPane.add(btnNewButton);
		//Login self=this;
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user= textField.getText();
				String pass= new String(passwordField.getPassword());
				LoginManager.getInstance().login(user, pass);
				if(LoginManager.getInstance().isLoggedIn()) {
					System.out.println("Corect");
					Login.this.setVisible(false);
				}else {
					System.out.println("Gresit");
				}
			}
		});

		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(449, 320, 121, 33);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(405, 216, 192, 24);
		contentPane.add(passwordField);
	}
}
//singleton design pattern-de exemplu get connection la DriverManager
//global-public accesbil de peste tot cumva sa tin minte cin este logat+detalii user
//singleton-clasa cu o singura instanta pe rulare care este globala
//clasa usermanager care sa fie singleton si sa aibe metode ajutatoare de login

//state d p + dependency injection (semi design pattern)
//coada in 2 feluri la alegere (push pop peak) sa fie cu generics (nu conteaza ce elemente contine)