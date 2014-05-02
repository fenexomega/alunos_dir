package Brenda;

import java.io.Serializable;
import java.util.ArrayList;

public class Aluno implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4621477279751052041L;
	private String nome;
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	
	public Aluno(String nome)
	{
		this.nome = nome;
	}
	
	public Aluno(String nome, Curso c1, Curso c2, Curso c3)
	{
		this.nome = nome;
		adicionarCurso(c1);
		if(!(c2 == null))
		adicionarCurso(c2);
		if(!(c3 == null))
		adicionarCurso(c3);
	}

	public boolean adicionarCurso(Curso c)
	{
		if(cursos.size() >= 3)
			return false;
		if(c.quantidadeInscritos() >= 50)
			return false;
		
		cursos.add(c);
		c.adicionarAluno(this);
		
		return true;
	}
	
	public boolean removerCurso(Curso c)
	{
		if(!cursos.remove(c))
			return false;
		
		c.removerAluno(this);
		
		return true;
	}
	
	public ArrayList<Curso> getCursos()
	{
		return cursos;
	}
	
	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
}

class AlunoTest
{
	public static void listarCursos(ArrayList<Curso> c)
	{
		if(c.size() == 0)
			System.out.println("<None>");
		for(Curso cr : c)
		{
			System.out.println("Nome: " + cr.getNome());
			
		}
			
	}
	
	public static void main(String[] args)
	{
		Aluno a = new Aluno("Josué");
		Curso c = new Curso("Culinária", "José","14:30");
		a.adicionarCurso(c);
		System.out.println(a.getNome() == "Josué");
		System.out.println(a.getCursos().get(0) == c);
		System.out.println("O aluno " + a.getNome() + " está cadastrado em: ");
		listarCursos(a.getCursos());
		
		System.out.println("Listar alunos: ");
		for(Aluno as : c.getAlunos())
			System.out.println(as.getNome());
		
		System.out.println("Apagando cursos de " + a.getNome());
		a.removerCurso(c);
		System.out.println("O aluno " + a.getNome() + " está cadastrado em: ");
		listarCursos(a.getCursos());
		
		System.out.println("Listar alunos: ");
		for(Aluno as : c.getAlunos())
			System.out.println(as.getNome());
	}
}
