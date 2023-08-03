package com.proiect.auto;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.proiect.auto.frames.FavoriteView;
import com.proiect.auto.frames.MasinileMeleView;

public class MasiniManager {
	private int id;
	private String marca;
	private int kilometraj;
	private int an;
	private String model;
	private int pret;
	private String culoare;
	private String combustibil;
	private int putere;
	private int tonaj;
	private double volum;
	private int locuri;
	final String myDriver = "com.mysql.cj.jdbc.Driver";
	final String myUrl = "jdbc:mysql://localhost/pc";
	Connection conn;

	public MasiniManager() {
		try {
			
			conn = DriverManager.getConnection(myUrl, "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adaugaMasina(int id, String marca, String model, int an, int kilometraj, int pret, String culoare,
			String combustibil, int putere, String tip, double volum, int locuri, int tonaj,String proprietar) {
		String query = "INSERT INTO masini VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement st = conn.prepareStatement(query)) {
			st.setInt(1, id);
			st.setString(2, marca);
			st.setString(3, model);
			st.setInt(4, an);
			st.setInt(5, kilometraj);
			st.setInt(6, pret);
			st.setString(7, culoare);
			st.setString(8, combustibil);
			st.setInt(9, putere);
			st.setString(10, tip);
			st.setDouble(11, volum);
			st.setInt(12, locuri);
			st.setInt(13, tonaj);
			st.setString(14, proprietar);
			st.executeUpdate();

		} catch (SQLException e2) {
		}
	}

	public void adaugaPoza(int id_poza, InputStream poza, int id_masina) {
		String query = "INSERT INTO poze VALUES (?,?,?)";
		try (PreparedStatement st = conn.prepareStatement(query)) {
			st.setInt(1, id_poza);
			st.setBlob(2, poza);
			st.setInt(3, id_masina);
			st.executeUpdate();
		} catch (SQLException e2) {
		}
	}

	public int getId() {
		String query = "SELECT MAX(id) FROM masini";
		try (PreparedStatement st = conn.prepareStatement(query)) {
			ResultSet rs = st.executeQuery(query);
			int id = 0;
			if (rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			return id;
		}
	}

	public int getIdPoza() {
		String query = "SELECT MAX(id) FROM poze";
		try (PreparedStatement st = conn.prepareStatement(query)) {
			ResultSet rs = st.executeQuery(query);
			int id = 0;
			if (rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			return id;
		}
	}
	
	public void comboMarca(JComboBox box) {
		String query="select distinct marca from masini order by marca asc";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				String name=rs.getString("marca");
				box.addItem(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void comboModel(JComboBox box,String marca) {
		String query="select distinct model from masini where marca='"+marca+"' order by model asc";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				String name=rs.getString("model");
				box.addItem(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String titluCumparare(int id) {
		String result="";
		String query="select marca,model from masini where id='" + id + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				String r1=rs.getString("marca");
				String r2=rs.getString("model");
				r1=r1+" "+r2;
				result=r1;
				//System.out.println(result);
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public String pretCumparare(int id3) {
		String result="Pret(Euro): ";
		String query="select pret from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				int i=rs.getInt("pret");
				String s= Integer.toString(i);
				result=result + s;
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getPret(int id3) {
		String query="select pret from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				int result=rs.getInt("pret");
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public String kmCumparare(int id3) {
		String result="Kilometraj: ";
		String query="select km from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				int i=rs.getInt("km");
				String s= Integer.toString(i);
				result=result + s;
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String combustibilCumparare(int id3) {
		String result="Combustibil: ";
		String query="select combustibil from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				String s= rs.getString("combustibil");
				result=result + s;
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String anCumparare(int id3) {
		String result="An: ";
		String query="select an from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				int i=rs.getInt("an");
				String s= Integer.toString(i);
				result=result + s;
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String culoareCumparare(int id3) {
		String result="Culoare: ";
		String query="select culoare from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				String s= rs.getString("culoare");
				result=result + s;
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String putereCumparare(int id3) {
		String result="Putere: ";
		String query="select putere from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				int i=rs.getInt("putere");
				String s= Integer.toString(i);
				result=result + s + "hp";
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String tipCumparare(int id3) {
		String result="Caroserie: ";
		String query="select tip from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				String s= rs.getString("tip");
				result=result + s;
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String volumCumparare(int id3) {
		String result="Volum: ";
		String query="select volum from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				int i=rs.getInt("volum");
				String s= Integer.toString(i);
				result=result + s;
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String locuriCumparare(int id3) {
		String result="Locuri: ";
		String query="select locuri from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				int i=rs.getInt("locuri");
				String s= Integer.toString(i);
				result=result + s;
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String tonajCumparare(int id3) {
		String result="Tonaj: ";
		String query="select tonaj from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				int i=rs.getInt("tonaj");
				String s= Integer.toString(i);
				result=result + s;
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

	

	public byte[] pozaCumparare(int id2) {
		String query="select * from poze where id_masina='" + id2 + "' limit 1";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				InputStream result=rs.getBinaryStream("poza");
				return result.readAllBytes();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void pozeAfisare(int id2,JPanel panel) {
		String query="select * from poze where id_masina='" + id2 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				InputStream result=rs.getBinaryStream("poza");
				ImageIcon yup=new ImageIcon(result.readAllBytes());
				yup.setImage(yup.getImage().getScaledInstance(500,400,java.awt.Image.SCALE_SMOOTH));
				JLabel image=new JLabel("");
				image.setBounds(24,50,500,400);
				image.setIcon(yup);
				panel.add(image);
				//return result.readAllBytes();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return null;
	}
	
	public String getProprietar(int id3) {
		String query="select proprietar from masini where id='" + id3 + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				String result=rs.getString("proprietar");
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String numeProprietar(int id) {
		String result="";
		String query="select * from user where username='" + this.getProprietar(id) + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				String r1=rs.getString("prenume");
				String r2=rs.getString("nume");
				r1=r1+" "+r2;
				result=result+r1;
				//System.out.println(result);
				return result;
				//return result.readAllBytes();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String telefonProprietar(int id) {
		String result="0";
		String query="select * from user where username='" + this.getProprietar(id) + "'";
		try (PreparedStatement st = conn.prepareStatement(query)){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				int r1=rs.getInt("telefon");
				String r=Integer.toString(r1);
				result=result+r;
				return result;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void adaugaFavorite(String user,int id) {
		String query = "INSERT INTO favorite VALUES (?,?)";
		try (PreparedStatement st = conn.prepareStatement(query)) {
			st.setString(1, user);
			st.setInt(2, id);
			st.executeUpdate();
		} catch (SQLException e2) {
		}
	}
	
	public void stergeFavorite(String user,int id) {
		String query="DELETE FROM favorite where user='"+user+"' and id='"+id+"'";
		try (PreparedStatement st = conn.prepareStatement(query)) {
			st.executeUpdate();
		} catch (SQLException e2) {
		}
	}
	
	public void afisareFavorite(String user,JPanel panel) {
		String query="Select distinct id from favorite where user= '"+user+"'";
		try (PreparedStatement st = conn.prepareStatement(query)) {
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				panel.add(new FavoriteView(rs.getInt("id")));
				panel.revalidate();
				panel.repaint();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void afisareMasinileMele(String user,JPanel panel) {
		String query="Select * from masini where proprietar= '"+user+"'";
		try (PreparedStatement st = conn.prepareStatement(query)) {
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				panel.add(new MasinileMeleView(rs.getInt("id")));
				panel.revalidate();
				panel.repaint();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void stergeMasinileMele(int id) {
		String query="DELETE FROM masini where id='"+id+"'";
		try (PreparedStatement st = conn.prepareStatement(query)) {
			st.executeUpdate();
		} catch (SQLException e2) {
		}
	}
	
	public void schimbareKilometrajMasinileMele(int id,int km) {
		String query = "update masini set km='"+km+"' where id='"+id+"'";
		Statement stmt=null;
		try {
			stmt=(Statement) conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void schimbarepretMasinileMele(int id,int pret) {
		String query = "update masini set pret='"+pret+"' where id='"+id+"'";
		Statement stmt=null;
		try {
			stmt=(Statement) conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
