package com.proiect.auto.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.proiect.auto.LoginManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField utilizator;
	private JTextField parola;
	private JTextField prenume;
	private JTextField nume;
	private JTextField telefon;
	private JButton btnNewButton;

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1119, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(442, 22, 137, 48);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Prenume:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(83, 242, 83, 27);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nume:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(83, 290, 83, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nr. de telefon:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(83, 341, 98, 13);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Nume de utilizator:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(85, 168, 128, 13);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Parola:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(83, 204, 72, 13);
		contentPane.add(lblNewLabel_5);

		utilizator = new JTextField();
		utilizator.setBounds(223, 167, 115, 19);
		contentPane.add(utilizator);
		utilizator.setColumns(10);

		parola = new JTextField();
		parola.setBounds(223, 203, 115, 19);
		contentPane.add(parola);
		parola.setColumns(10);

		prenume = new JTextField();
		prenume.setBounds(223, 248, 115, 19);
		contentPane.add(prenume);
		prenume.setColumns(10);

		nume = new JTextField();
		nume.setBounds(223, 293, 115, 19);
		contentPane.add(nume);
		nume.setColumns(10);

		telefon = new JTextField();
		telefon.setBounds(223, 340, 115, 19);
		contentPane.add(telefon);
		telefon.setColumns(10);

		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = utilizator.getText();
				String pass = parola.getText();
				String prenum = prenume.getText();
				String num = nume.getText();
				int tel = Integer.parseInt(telefon.getText());
				LoginManager.getInstance().signUp(user, pass, num, prenum, tel);
				if(LoginManager.getInstance().isLoggedIn()) {
					JOptionPane.showMessageDialog(null, "Cont creat cu succes!");
					SignUp.this.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Date gresite!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(472, 425, 85, 21);
		contentPane.add(btnNewButton);
	}

}
