package com.proiect.auto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginManager {
	
	private static LoginManager instance;
	private  String username;
	private  String password;
	private  String nume;
	private  String prenume;
	private  int telefon;
	final String myDriver = "com.mysql.cj.jdbc.Driver";
    final String myUrl = "jdbc:mysql://localhost/pc";	
    Connection conn;
	private LoginManager() {	
		try {
			conn = DriverManager.getConnection(myUrl, "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static LoginManager getInstance() {
		if (instance==null) {
			instance= new LoginManager();
		}
		return instance;
	}
	
	public void signUp(String username,String password,String nume,String prenume,int telefon) {
		String query = "INSERT INTO user VALUES (?,?,?,?,?)";
		try(PreparedStatement st = conn.prepareStatement(query)){
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, prenume);
			st.setString(4, nume);
			st.setInt(5, telefon);
			st.executeUpdate();
			this.username=username;
			this.password=password;
			this.nume=nume;
			this.prenume=prenume;
			this.telefon=telefon;
		}catch(SQLException e) {}
	}
	
	public void login(String username,String password) {
		String query="select username, parola,nume,prenume,telefon from user where username= ? ";
		//PreparedStatement st=null;
		try(PreparedStatement st = conn.prepareStatement(query)) {
			
			st.setString(1, username);
			ResultSet rs= st.executeQuery();
			if(! rs.next()) {
				return;
			}
			String parola= rs.getString("parola");
			if(password.equals(parola)) {
				this.username=username;
				this.password=password;
				this.nume=rs.getString("nume");
				this.prenume=rs.getString("prenume");
				this.telefon=rs.getInt("telefon");
			}
		} catch (SQLException e) {
			return;
		}
	}
	
	public boolean isLoggedIn() {
		return this.username!=null;
	}
	
	public String getUsername() {
		return this.username;
	}
}
