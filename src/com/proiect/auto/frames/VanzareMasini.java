package com.proiect.auto.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.proiect.auto.LoginManager;
import com.proiect.auto.Main;
import com.proiect.auto.MasiniManager;
import com.proiect.auto.masini.MasinaNormala;
import com.proiect.auto.masini.Masini;

import com.proiect.auto.masini.Tir;
import com.proiect.auto.masini.Van;

//import ro.itschool.pixels.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.awt.Color;

public class VanzareMasini extends JFrame {

	public JPanel contentPane;
	public JTextField marca;
	public JTextField kilometraj;
	public JTextField an;
	public JTextField model;
	public JTextField pret;
	public JTextField culoare;
	public JTextField putere;
	public JLabel lblNewLabel_8;
	public String path;
	public int id_curent;
	public int nrPoze=0;
	public String proprietar=LoginManager.getInstance().getUsername();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VanzareMasini frame = new VanzareMasini();
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
	public VanzareMasini() {
		// 982,623
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 990, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Marca:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(71, 108, 53, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Model:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(71, 157, 53, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("An:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(71, 208, 35, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Kilometraj:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(71, 262, 79, 13);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Pret (EURO):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(71, 315, 97, 13);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Culoare:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(71, 362, 65, 13);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Combustibil:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(71, 414, 97, 13);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Putere:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(71, 454, 65, 13);
		contentPane.add(lblNewLabel_7);

		marca = new JTextField();
		marca.setBounds(178, 107, 96, 19);
		contentPane.add(marca);
		marca.setColumns(10);

		kilometraj = new JTextField();
		kilometraj.setBounds(178, 261, 96, 19);
		contentPane.add(kilometraj);
		kilometraj.setColumns(10);

		an = new JTextField();
		an.setBounds(178, 207, 96, 19);
		contentPane.add(an);
		an.setColumns(10);

		model = new JTextField();
		model.setBounds(178, 156, 96, 19);
		contentPane.add(model);
		model.setColumns(10);

		pret = new JTextField();
		pret.setBounds(178, 314, 96, 19);
		contentPane.add(pret);
		pret.setColumns(10);

		culoare = new JTextField();
		culoare.setBounds(178, 361, 96, 19);
		contentPane.add(culoare);
		culoare.setColumns(10);

		putere = new JTextField();
		putere.setBounds(178, 453, 96, 19);
		contentPane.add(putere);
		putere.setColumns(10);
		
		JComboBox combustibil = new JComboBox();
		combustibil.setBounds(178, 412, 96, 21);
		contentPane.add(combustibil);
		combustibil.addItem("Diesel");
		combustibil.addItem("Benzina");
		combustibil.addItem("Hibrid");
		combustibil.addItem("Electric");
		combustibil.addItem("Benzina + GPL");
		

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}

		});
		comboBox.setBounds(178, 492, 96, 21);
		contentPane.add(comboBox);
		comboBox.addItem("Choose");
		comboBox.addItem("Sedan");
		comboBox.addItem("SUV");
		comboBox.addItem("Masina mica");
		comboBox.addItem("Cabrio");
		comboBox.addItem("Coupe");
		comboBox.addItem("Tir");
		comboBox.addItem("Van");
		MasiniManager masina = new MasiniManager();
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marca2 = marca.getText();
				String model2 = model.getText();
				int pret2 = Integer.parseInt(pret.getText());
				String culoare2 = culoare.getText();
				String combustibil2 = combustibil.getSelectedItem().toString();
				int putere2 = Integer.parseInt(putere.getText());
				int an2 = Integer.parseInt(an.getText());
				int kilometraj2 = Integer.parseInt(kilometraj.getText());
				// MasiniManager masina=new MasiniManager();
				id_curent = masina.getId();
				if (comboBox.getSelectedItem().toString().equals("Tir")) {
					int volum = 0;
					int locuri = 2;
					String tip = "Tir";
					int result = Integer.parseInt(JOptionPane.showInputDialog("Introduceti tonajul"));
					masina.adaugaMasina(masina.getId() + 1, marca2, model2, an2, kilometraj2, pret2, culoare2,
							combustibil2, putere2, tip, volum, locuri, result,proprietar);
					JOptionPane.showMessageDialog(null, "Tir adaugat cu succes!");
				} else if (comboBox.getSelectedItem().toString().equals("Van")) {
					double result = Double.parseDouble(JOptionPane.showInputDialog("Introduceti volumul"));
					int result2 = Integer.parseInt(JOptionPane.showInputDialog("Introduceti numarul de locuri"));
					masina.adaugaMasina(masina.getId() + 1, marca2, model2, an2, kilometraj2, pret2, culoare2,
							combustibil2, putere2, "Van", result, result2, 0,proprietar);
					JOptionPane.showMessageDialog(null, "Van adaugat cu succes!");
					System.out.println(masina.getId());
				} else {
					int result = Integer.parseInt(JOptionPane.showInputDialog("Introduceti numarul de locuri"));
					if (comboBox.getSelectedItem().toString().equals("Cabrio")) {
						masina.adaugaMasina(masina.getId() + 1, marca2, model2, an2, kilometraj2, pret2, culoare2,
								combustibil2, putere2, "Cabrio", 0, result, 0,proprietar);
					}
					if (comboBox.getSelectedItem().toString().equals("Coupe")) {
						masina.adaugaMasina(masina.getId() + 1, marca2, model2, an2, kilometraj2, pret2, culoare2,
								combustibil2, putere2, "Coupe", 0, result, 0,proprietar);
					}
					if (comboBox.getSelectedItem().toString().equals("Masina mica")) {
						masina.adaugaMasina(masina.getId() + 1, marca2, model2, an2, kilometraj2, pret2, culoare2,
								combustibil2, putere2, "Masina mica", 0, result, 0,proprietar);
					}
					if (comboBox.getSelectedItem().toString().equals("SUV")) {
						masina.adaugaMasina(masina.getId() + 1, marca2, model2, an2, kilometraj2, pret2, culoare2,
								combustibil2, putere2, "SUV", 0, result, 0,proprietar);
					}
					if (comboBox.getSelectedItem().toString().equals("Sedan")) {
						masina.adaugaMasina(masina.getId() + 1, marca2, model2, an2, kilometraj2, pret2, culoare2,
								combustibil2, putere2, "Sedan", 0, result, 0,proprietar);
					}

					JOptionPane.showMessageDialog(null, "Masina adaugata cu succes");
					VanzareMasini.this.setVisible(false);
				}

			}
		});
		btnNewButton.setBounds(435, 541, 85, 21);
		contentPane.add(btnNewButton);

		lblNewLabel_8 = new JLabel("Vanzare masina");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_8.setBounds(355, 23, 235, 29);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Tip:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(71, 494, 65, 19);
		contentPane.add(lblNewLabel_9);

		JPanel panel = new JPanel();
		panel.setBounds(804, 59, 120, 600);
		panel.setBackground(new java.awt.Color(255, 0, 0));
		contentPane.add(panel);
		int idinc = masina.getId() + 1;
		JButton button1 = new JButton("attach photo");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nrPoze+=1;
				JFileChooser file = new JFileChooser();
				int result = file.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION &&nrPoze<=5) {
					ImageIcon yup = new ImageIcon(file.getSelectedFile().getAbsolutePath());
					yup.setImage(yup.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
					JLabel label = new JLabel();
					label.setIcon(yup);
					panel.add(label);
					panel.revalidate();
					panel.repaint();
					path = file.getSelectedFile().getAbsolutePath();
					try {
						InputStream is = new FileInputStream(new File(path));
						masina.adaugaPoza(masina.getIdPoza() + 1, is, idinc);
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					}

				}else {
					JOptionPane.showMessageDialog(null, "Numar maxim de poze!");
				}
			}
		});
		button1.setBounds(652, 116, 106, 21);
		contentPane.add(button1);
		

	}
} 
//max 5 poze
//utilizator field masini