package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import entities.professor;

public class ProfessorServices {
	static Connection conn =DB.getConnection();; 
	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement pst =null;
	
	public static Date dateof(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return new java.sql.Date(sdf.parse(data).getTime());
	}
	
	public static void Get() throws SQLException {

		st = conn.createStatement();

		rs=st.executeQuery("select * from professores");
		
		while (rs.next()) {
			System.out.println(rs.getInt("Id") 
					+ ", " + rs.getString("Nome")
					+", " + rs.getString("Email")
					+", " + rs.getDate("Nascimento")
					+", " + rs.getDouble("Salario")
					+", Materia: " + rs.getInt("Materia"));
		}
	}
	public static void Post(professor Prof) throws SQLException, ParseException {
		conn=DB.getConnection();
		pst = conn.prepareStatement(
				"INSERT INTO professores " 
				+ " (Nome, Email, Nascimento, Salario, Materia)"
				+ "VALUES (?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS
		);
		pst.setString(1, Prof.getNome());
		pst.setString(2, Prof.getEmail());
		pst.setDate(3, Prof.getNascimento());
		pst.setDouble(4, Prof.getSalary());
		pst.setInt(5, Prof.getMateria());
		pst.executeUpdate();	
	}
	
	/*Parametros:
	 ID de quem sera atualizado, Oq sera atualizado e o novo valor*/
	public static void Update(Integer Id, String Atualizacao, String Novo) throws SQLException, ParseException {
		
		pst= conn.prepareStatement(
				"UPDATE professores " 
				+ " SET " + Atualizacao + "= ?"
				+ " WHERE"
				+ "(Id = ?)"
		);				
		
		pst.setInt(2, Id);

		if (Atualizacao=="Nascimento") {
			pst.setDate(1, ProfessorServices.dateof(Novo));				
		}else if (Atualizacao == "Nome" || Atualizacao == "Email") {				
			pst.setString(1, Novo);			
		}else if (Atualizacao == "Salario") {				
			pst.setDouble(1,Double.parseDouble(Novo));
		}else if (Atualizacao == "Materia") {				
			pst.setInt(1,Integer.parseInt(Novo));
		}
		
		pst.executeUpdate();
	}
	public static void Delete(Integer id) throws SQLException {
		pst= conn.prepareStatement(
				"DELETE FROM professores  "
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


	







