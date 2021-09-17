package entities;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import services.ProfessorServices;

public class professor {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private String Nome; 
	private String Email;
	private String Nascimento;
	private Double Salary;
	private Integer Materia;
	
	public professor(String nome, String email, String nascimento, Double salary, Integer materia) {
		Nome = nome;
		Email = email;
		Nascimento = nascimento;
		Salary = salary;
		Materia = materia;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getNascimento() throws ParseException{
		return ProfessorServices.dateof(Nascimento);
	}
	public void setNascimento(String nascimento) {
		Nascimento = nascimento;
	}
	public Double getSalary() {
		return Salary;
	}
	public void setSalary(Double salary) {
		Salary = salary;
	}
	public Integer getMateria() {
		return Materia;
	}
	public void setMateria(Integer materia) {
		Materia = materia;
	}

	
	
}
