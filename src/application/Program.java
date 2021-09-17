package application;

import java.sql.SQLException;
import java.text.ParseException;

import db.DbException;
import entities.professor;
import services.MateriaServices;
import services.ProfessorServices;

public class Program {

	public static void main(String[] args) {

		try {
		System.out.println("------------- Estado Inicial do banco de dados ------------- ");
		System.out.println("MATERIAS: ");
		MateriaServices.Get();
		System.out.println("PROFESSORES: ");
		ProfessorServices.Get();
		
		System.out.println("------------- Adicionando Linhas para ------------- ");
		System.out.println("MATERIAS: ");
		MateriaServices.Post("Fisica");
		MateriaServices.Post("Teste");
		MateriaServices.Get();
		System.out.println("PROFESSORES: ");
		ProfessorServices.Post(new professor("Geraldo", "GM0ta@gmail.com", "29/07/1980",5000.00, 6));
		ProfessorServices.Post(new professor("teste", "teste@gmail.com", "10/10/1980",5000.00, 6));
		ProfessorServices.Get();
		
		System.out.println("------------- Deletando Linhas para ------------- ");
		System.out.println("MATERIAS: ");
		MateriaServices.Delete(7);
		MateriaServices.Get();
		System.out.println("PROFESSORES: ");
		ProfessorServices.Delete(8);
		ProfessorServices.Get();
		
		System.out.println("------------- Atualizando Linhas para ------------- ");
		System.out.println("MATERIAS: ");
		MateriaServices.Update(2,"Biologia");
		MateriaServices.Get();
		System.out.println("PROFESSORES: ");
		ProfessorServices.Update(7,"Email","Gerald0@gmail.com");
		ProfessorServices.Get();
		

		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}catch (ParseException e) {
			throw new DbException(e.getMessage());
		}finally {
			MateriaServices.Close();
			ProfessorServices.Close();
		}

	}

}
