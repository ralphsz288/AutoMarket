package com.proiect.auto.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.proiect.auto.LoginManager;
import com.proiect.auto.MasiniManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class CarDetailsView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//CarDetailsView frame = new CarDetailsView(id);
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
	public CarDetailsView(int id) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1186, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MasiniManager masina=new MasiniManager();
		
		String titlu1=masina.titluCumparare(id);
		JLabel titlu = new JLabel(titlu1);
		titlu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		titlu.setBounds(15, 10, 312, 47);
		contentPane.add(titlu);
		
		String anLabel=masina.anCumparare(id);
		JLabel an = new JLabel(anLabel);
		an.setFont(new Font("Tahoma", Font.PLAIN, 15));
		an.setBounds(10, 67, 207, 22);
		contentPane.add(an);
		
		String kmLabel=masina.kmCumparare(id);
		JLabel km = new JLabel(kmLabel);
		km.setFont(new Font("Tahoma", Font.PLAIN, 15));
		km.setBounds(10, 108, 207, 22);
		contentPane.add(km);
		
		String pretLabel=masina.pretCumparare(id);
		JLabel pret = new JLabel(pretLabel);
		pret.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pret.setBounds(10, 156, 207, 22);
		contentPane.add(pret);
		
		String culoareLabel=masina.culoareCumparare(id);
		JLabel culoare = new JLabel(culoareLabel);
		culoare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		culoare.setBounds(10, 206, 207, 22);
		contentPane.add(culoare);
		
		String cLabel=masina.combustibilCumparare(id);
		JLabel combustibil = new JLabel(cLabel);
		combustibil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		combustibil.setBounds(10, 253, 207, 22);
		contentPane.add(combustibil);
		
		String putereLabel=masina.putereCumparare(id);
		JLabel putere = new JLabel(putereLabel);
		putere.setFont(new Font("Tahoma", Font.PLAIN, 15));
		putere.setBounds(10, 305, 207, 22);
		contentPane.add(putere);
		
		String tipLabel=masina.tipCumparare(id);
		JLabel tip = new JLabel(tipLabel);
		tip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tip.setBounds(10, 358, 207, 22);
		contentPane.add(tip);
		
		JLabel volum = new JLabel(masina.volumCumparare(id));
		volum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		volum.setBounds(10, 417, 207, 22);
		contentPane.add(volum);
		
		JLabel locuri = new JLabel(masina.locuriCumparare(id));
		locuri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locuri.setBounds(10, 476, 207, 22);
		contentPane.add(locuri);
		
		JLabel tonaj = new JLabel(masina.tonajCumparare(id));
		tonaj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tonaj.setBounds(10, 529, 207, 22);
		contentPane.add(tonaj);
		
		JLabel dateProprietar = new JLabel("Proprietar:"+masina.numeProprietar(id));
		dateProprietar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateProprietar.setBounds(938, 67, 207, 22);
		contentPane.add(dateProprietar);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(332, 156, 565, 330);
		contentPane.add(scrollPane);
		JPanel panel = new JPanel();
		panel.setBounds(321, 156, 563, 328);
		panel.setLayout(new GridLayout(0,1)); 
		scrollPane.setViewportView(panel);
		masina.pozeAfisare(id, panel);
		
		JButton btnNewButton = new JButton("Calcul rate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=Integer.parseInt(JOptionPane.showInputDialog("Introduceti numarul de luni:"));
				double result2=masina.getPret(id)/result;
				JOptionPane.showMessageDialog(null, "Rata lunara calculata este " + result2+ " euro ("+result+" luni)");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(332, 555, 169, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Adauga la favorite");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String l=LoginManager.getInstance().getUsername();
				masina.adaugaFavorite(l, id);
				JOptionPane.showMessageDialog(null, "Masina "+masina.titluCumparare(id)+ " a fost adaugata la favorite");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(728, 557, 169, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Numar de telefon:"+masina.telefonProprietar(id));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(938, 112, 234, 15);
		contentPane.add(lblNewLabel);
	}
}
