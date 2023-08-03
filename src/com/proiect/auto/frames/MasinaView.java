package com.proiect.auto.frames;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.proiect.auto.MasiniManager;

import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MasinaView extends JPanel {
	final String myDriver = "com.mysql.cj.jdbc.Driver";
	final String myUrl = "jdbc:mysql://localhost/pc";
	Connection conn;
	/**
	 * Create the panel.
	 */
	public MasinaView(int id) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setPreferredSize(new Dimension(734, 269));
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
		btnNewButton.setBounds(589, 180, 114, 21);
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

	}
}
