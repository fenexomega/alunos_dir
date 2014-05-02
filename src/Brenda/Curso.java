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
		if(alunos.size() >= 50)
			return false;
		
		alunos.add(a);
		System.out.println("Aluno adicionado com sucesso!");
		Collections.sort(alunos, new AlunoComparator());
		return true;
	}
	
	public void removerAluno(Aluno a)
	{
		
		for(Aluno az: alunos)
		{
			if(az.getNome().equals(a.getNome()))
			{
				alunos.remove(az);
				break;
			}
		}

		System.out.println(a.getNome() + " Excluído com sucesso");
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

	public Curso(String nome)
	{
		this.nome = nome;
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
