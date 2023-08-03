package com.proiect.auto.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.proiect.auto.MasiniManager;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Cumparare extends JFrame {
	public String marcaSelectata;
	private JPanel contentPane;
	private JTextField pret1;
	private JTextField pret2;
	private JTextField an1;
	private JTextField an2;
	private JTextField km1;
	private JTextField km2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cumparare frame = new Cumparare();
					frame.setVisible(true);
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cumparare() {
		MasiniManager manager = new MasiniManager();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1186, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);

		JComboBox comboBoxCaroserie = new JComboBox();
		comboBoxCaroserie.setBounds(86, 53, 106, 21);
		contentPane.add(comboBoxCaroserie);
		comboBoxCaroserie.addItem("Caroserie");
		comboBoxCaroserie.addItem("Cabrio");
		comboBoxCaroserie.addItem("Coupe");
		comboBoxCaroserie.addItem("Masina Mica");
		comboBoxCaroserie.addItem("Sedan");
		comboBoxCaroserie.addItem("SUV");
		comboBoxCaroserie.addItem("Van");
		comboBoxCaroserie.addItem("Tir");

		JComboBox comboBoxModel = new JComboBox();
		comboBoxModel.setBounds(431, 53, 116, 21);
		contentPane.add(comboBoxModel);
		comboBoxModel.addItem("Model");

		JComboBox comboBoxMarca = new JComboBox();
		comboBoxMarca.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (!comboBoxMarca.getSelectedItem().toString().equals("Marca")) {
						for (int i = comboBoxModel.getItemCount() - 1; i >= 0; i--) {
							comboBoxModel.removeItemAt(i);
						}
						comboBoxModel.addItem("Model");
						marcaSelectata = comboBoxMarca.getSelectedItem().toString();
						manager.comboModel(comboBoxModel, marcaSelectata);

					}

				}

			}

		});

		comboBoxMarca.setBounds(241, 53, 116, 21);
		contentPane.add(comboBoxMarca);
		comboBoxMarca.addItem("Marca");
		manager.comboMarca(comboBoxMarca);
		System.out.println(marcaSelectata);
		JLabel lblNewLabel = new JLabel("Pret de la:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(582, 55, 70, 13);
		contentPane.add(lblNewLabel);

		pret1 = new JTextField();
		pret1.setBounds(662, 54, 96, 19);
		contentPane.add(pret1);
		pret1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Pret pana la:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(811, 55, 86, 13);
		contentPane.add(lblNewLabel_1);

		pret2 = new JTextField();
		pret2.setBounds(905, 54, 106, 19);
		contentPane.add(pret2);
		pret2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Anul de la:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(86, 118, 73, 18);
		contentPane.add(lblNewLabel_2);

		an1 = new JTextField();
		an1.setBounds(157, 120, 70, 19);
		contentPane.add(an1);
		an1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Anul pana la:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(241, 118, 96, 18);
		contentPane.add(lblNewLabel_3);

		an2 = new JTextField();
		an2.setText("");
		an2.setBounds(328, 120, 70, 19);
		contentPane.add(an2);
		an2.setColumns(10);

		JComboBox comboBoxCombustibil = new JComboBox();
		comboBoxCombustibil.setBounds(431, 116, 116, 21);
		contentPane.add(comboBoxCombustibil);
		comboBoxCombustibil.addItem("Combustibil");
		comboBoxCombustibil.addItem("Diesel");
		comboBoxCombustibil.addItem("Benzina");
		comboBoxCombustibil.addItem("Hibrid");
		comboBoxCombustibil.addItem("Electric");
		comboBoxCombustibil.addItem("Benzina + GPL");

		JLabel lblNewLabel_4 = new JLabel("Km de la:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(592, 118, 70, 13);
		contentPane.add(lblNewLabel_4);

		km1 = new JTextField();
		km1.setBounds(662, 117, 96, 19);
		contentPane.add(km1);
		km1.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Km pana la:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(811, 118, 86, 13);
		contentPane.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 197, 951, 440);
		contentPane.add(scrollPane);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		scrollPane.setViewportView(panel);

		km2 = new JTextField();
		km2.setBounds(896, 117, 96, 19);
		contentPane.add(km2);
		km2.setColumns(10);
//		JPanel p = new JPanel();
//		p.setBounds(510, 303, 228, 128);
		JButton btnNewButton = new JButton("Filtrare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasiniManager masina = new MasiniManager();
				final String myDriver = "com.mysql.cj.jdbc.Driver";
				final String myUrl = "jdbc:mysql://localhost/pc";
				Connection conn = null;
				try {
					conn = DriverManager.getConnection(myUrl, "root", "");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				;
				String query = "";
				if (!comboBoxCaroserie.getSelectedItem().toString().equals("Caroserie")) {
					if (query.isEmpty()) {
						query = "SELECT * FROM MASINI WHERE tip = '" + comboBoxCaroserie.getSelectedItem().toString()
								+ "' ";
					}
				}
				if (!comboBoxMarca.getSelectedItem().toString().equals("Marca")) {
					if (query.isEmpty()) {
						query = "SELECT * FROM MASINI WHERE marca = '" + comboBoxMarca.getSelectedItem().toString()
								+ "' ";
					} else {
						query = query + "AND marca = '" + comboBoxMarca.getSelectedItem().toString() + "' ";
					}
				}
				if (!comboBoxModel.getSelectedItem().toString().equals("Model")) {
					query = query + "AND model = '" + comboBoxModel.getSelectedItem().toString() + "' ";
				}

				if (!pret1.getText().isEmpty()) {
					if (query.isEmpty()) {
						query = "SELECT * FROM MASINI WHERE pret > '" + pret1.getText() + "' ";
					} else {
						query = query + "AND pret > '" + pret1.getText() + "' ";
					}
				}

				if (!pret2.getText().isEmpty()) {
					if (query.isEmpty()) {
						query = "SELECT * FROM MASINI WHERE pret < '" + pret2.getText() + "' ";
					} else {
						query = query + "AND pret < '" + pret2.getText() + "' ";
					}
				}

				if (!an1.getText().isEmpty()) {
					if (query.isEmpty()) {
						query = "SELECT * FROM MASINI WHERE an > '" + an1.getText() + "' ";
					} else {
						query = query + "AND an > '" + an1.getText() + "' ";
					}
				}

				if (!an2.getText().isEmpty()) {
					if (query.isEmpty()) {
						query = "SELECT * FROM MASINI WHERE an < '" + an2.getText() + "' ";
					} else {
						query = query + "AND an < '" + an2.getText() + "' ";
					}
				}

				if (!comboBoxCombustibil.getSelectedItem().toString().equals("Combustibil")) {
					if (query.isEmpty()) {
						query = "SELECT * FROM MASINI WHERE combustibil = '"
								+ comboBoxCombustibil.getSelectedItem().toString() + "' ";
					} else {
						query = query + "AND combustibil = '" + comboBoxCombustibil.getSelectedItem().toString() + "' ";
					}
				}

				if (!km1.getText().isEmpty()) {
					if (query.isEmpty()) {
						query = "SELECT * FROM MASINI WHERE km > '" + km1.getText() + "' ";
					} else {
						query = query + "AND km > '" + km1.getText() + "' ";
					}
				}

				if (!km2.getText().isEmpty()) {
					if (query.isEmpty()) {
						query = "SELECT * FROM MASINI WHERE km < '" + km2.getText() + "' ";
					} else {
						query = query + "AND km < '" + km2.getText() + "' ";
					}
				}if (query.length()<1) {
					query="SELECT * FROM MASINI";
				}

				try (PreparedStatement st = conn.prepareStatement(query)) {
					ResultSet rs = st.executeQuery(query);
					panel.removeAll();
					while (rs.next()) {
						System.out.print(rs.getString("id"));
						System.out.print(" ");
						System.out.print(rs.getString("marca"));
						System.out.print(" ");
						System.out.print(rs.getString("model"));
						System.out.print(" ");
						System.out.print(rs.getString("an"));
						System.out.print(" ");
						System.out.print(rs.getString("km"));
						System.out.print(" ");
						System.out.print(rs.getString("pret"));
						System.out.print(" ");
						System.out.print(rs.getString("id"));
						System.out.print(" ");
						System.out.print(rs.getString("culoare"));
						System.out.print(" ");
						System.out.print(rs.getString("combustibil"));
						System.out.print(" ");
						System.out.print(rs.getString("putere"));
						System.out.print(" ");
						System.out.print(rs.getString("tip"));
						System.out.println("");
//						JPanel p = new JPanel();
//						p.setBounds(510, 303, 228, 128);
//						p.add(new MasinaView(rs.getInt("id")));
						System.out.println();
						panel.add(new MasinaView(rs.getInt("id")));
						scrollPane.validate();
						panel.validate();
						//panel.repaint();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(931, 169, 106, 28);
		contentPane.add(btnNewButton);

		

//		JPanel p = new JPanel();
//		p.setBounds(510, 303, 228, 128);
//		for (int i = 0; i < 3; i++) {
//
//			p.add(new MasinaView(i));
//		}
//		contentPane.add(p);

	}
}
