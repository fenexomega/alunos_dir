package Brenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Curso implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8241832097727327880L;
	
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private String nome;
	private String professor;
	private String horario;
	
	
	public boolean adicionarAluno(Aluno a)
	{
		if(alunos.size() >= 30)
			return false;
		
		alunos.add(a);
		System.out.println("Aluno adicionado com sucesso!");
		Collections.sort(alunos, new CustomComparator());
		return true;
	}
	
	public boolean removerAluno(Aluno a)
	{
		if(!alunos.remove(a))
			return false;
		
		System.out.println("Aluno removido com sucesso!");
		return true;
	}
	
	public void apagarRegistros()
	{
		for(Aluno c : alunos)
		{
			c.removerCurso(this);
		}
		alunos = new ArrayList<Aluno>();
		
	}
		
	public ArrayList<Aluno> getAlunos()
	{
		return alunos;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public int quantidadeInscritos()
	{
		return alunos.size();
	}
	
	public Curso( String nome, String professor,
			String horario)
	{
		this.nome = nome;
		this.professor = professor;
		this.horario = horario;
	}

	public String getProfessor()
	{
		return professor;
	}

	public void setProfessor(String professor)
	{
		this.professor = professor;
	}

	public String getHorario()
	{
		return horario;
	}

	public void setHorario(String horario)
	{
		this.horario = horario;
	}
	
	
}
