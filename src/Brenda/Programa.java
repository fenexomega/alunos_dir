package Brenda;


import java.util.ArrayList;
import java.util.Collections;

public class Programa
{
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private ArrayList<Curso> cursos = new ArrayList<Curso>();

	public Programa()
	{
		Arquivo.LerArquivo(alunos, cursos);
	}
	
	public void removeAluno(Aluno a)
	{
		for(Curso c: cursos)
			c.removerAluno(a);
		
		alunos.remove(a);
		Arquivo.GravarArquivo(alunos, cursos);
		
	}
	
	public void adicionaAluno(Aluno a)
	{
		alunos.add(a);
		Collections.sort(alunos, new CustomComparator());
		Arquivo.GravarArquivo(alunos, cursos);

	}
	
	public void adicionaCurso(Curso c)
	{
		cursos.add(c);
		Arquivo.GravarArquivo(alunos, cursos);
	}
	
	public ArrayList<Aluno> getAlunos()
	{
		return alunos;
	}
	public ArrayList<Curso> getCursos()
	{
		return cursos;
	}
	
}

class programaTest
{
	public static void main(String[] args)
	{
		Programa p = new Programa();
		
		p.adicionaCurso(new Curso("Jardinagem","dsad","horatal"));
		
		p.adicionaAluno(new Aluno("Geremias",p.getCursos().get(0),null,null));
		p.adicionaAluno(new Aluno("José",p.getCursos().get(0),null,null));
		p.adicionaAluno(new Aluno("Carlos",p.getCursos().get(0),null,null));
		p.adicionaAluno(new Aluno("Zezé",p.getCursos().get(0),null,null));
		p.adicionaAluno(new Aluno("Aragão",p.getCursos().get(0),null,null));
		
		
		for(Aluno al: p.getAlunos())
			System.out.println(al.getNome());
	}
}
