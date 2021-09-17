package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class MateriaServices {
	static Connection conn =DB.getConnection(); 
	static PreparedStatement pst=null;
	static Statement st = null;
	static ResultSet rs = null;
	
	public static void Get() throws SQLException {
		st = conn.createStatement();
		rs=st.executeQuery("select * from materias");
		
		while (rs.next()) {
			System.out.println(rs.getInt("Id") + "," + rs.getString("Nome"));
		}
	}
	
	public static void Post(String Materia) throws SQLException {
		pst= conn.prepareStatement(
				"INSERT INTO materias (Nome) "
				+ "VALUES (?)"
		);
		pst.setString(1, Materia);
		pst.executeUpdate();		
	}
	

	public static void Update(Integer Id, String Novo) throws SQLException {
		pst= conn.prepareStatement(
				"UPDATE materias" 
				+ " SET Nome = ?" 
				+ " WHERE"
				+ "(Id = ?)"
		);				
		pst.setString(1, Novo);
		pst.setInt(2, Id);
		pst.executeUpdate();
	}
	
	public static void Delete(Integer id) throws SQLException {
		pst= conn.prepareStatement(
				"DELETE FROM materias  "
				+"WHERE Id = ?"
		);

		pst.setInt(1, id);
		pst.executeUpdate();
	}
	
	public static void Close() {
		DB.closeStatement(pst);
		DB.closeStatement(st);
		DB.closeResultSet(rs);
		DB.closeConnection();
	}
	
}
