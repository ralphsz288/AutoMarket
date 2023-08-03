package com.proiect.auto.frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.proiect.auto.LoginManager;
import com.proiect.auto.MasiniManager;

public class MasinileMeleView extends JPanel {

	/**
	 * Create the panel.
	 */
	public MasinileMeleView(int id) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setPreferredSize(new Dimension(698, 269));
		setLayout(null);
		MasiniManager masina=new MasiniManager();
		
		JButton btnNewButton = new JButton("Vizionare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarDetailsView c=new CarDetailsView(id);
				c.setVisible(true);
			}

			private CarDetailsView newCarDetailsView() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(494, 113, 192, 21);
		add(btnNewButton);
		
		String titlu1=masina.titluCumparare(id);
		JLabel titlu = new JLabel(titlu1);
		titlu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		titlu.setBounds(223, 21, 323, 31);
		add(titlu);
		
		
		String pretLabel=masina.pretCumparare(id);
		JLabel lblNewLabel_1 = new JLabel(pretLabel);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(223, 112, 239, 21);
		add(lblNewLabel_1);
		
		String kmLabel=masina.kmCumparare(id);
		JLabel lblNewLabel_2 = new JLabel(kmLabel);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(223, 143, 282, 21);
		add(lblNewLabel_2);
		
		String cLabel=masina.combustibilCumparare(id);
		JLabel lblNewLabel_3 = new JLabel(cLabel);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(223, 180, 282, 13);
		add(lblNewLabel_3);
		
		JLabel image = new JLabel("l");
		image.setBounds(24, 50, 150, 150);
		byte[] pozaCumparare = masina.pozaCumparare(id);
		if(pozaCumparare!=null) {
			ImageIcon yup=new ImageIcon((pozaCumparare));
			yup.setImage(yup.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
			image.setIcon(yup);
		}
		add(image);
		
		JButton btnNewButton_1 = new JButton("Modificare kilometraj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = Integer.parseInt(JOptionPane.showInputDialog("Introduceti noul kilometraj"));
				masina.schimbareKilometrajMasinileMele(id, result);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(494, 149, 192, 21);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificare pret");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=Integer.parseInt(JOptionPane.showInputDialog("Introduceti noul pret"));
				masina.schimbarepretMasinileMele(id, result);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(494, 177, 192, 21);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Stergere anunt");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				masina.stergeMasinileMele(id);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(494, 203, 192, 21);
		add(btnNewButton_3);
		
		

	}

}
