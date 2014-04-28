package Brenda;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Programa
{
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private ArrayList<Curso> cursos = new ArrayList<Curso>();

	public Programa()
	{
		File f1 = new File("alunos.ser");
		File f2 = new File("cursos.ser");
		if(f1.exists() && f2.exists())
		{
			alunos = Arquivo.LerArquivoAlunos();
			cursos = Arquivo.LerArquivoCursos();
		}
		else
			Arquivo.GravarArquivo(alunos, cursos);
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
		for(Curso c1 : cursos)
		{
			if(c1.getNome() == c.getNome())
			{
				System.out.println("Curso com o mesmo Nome! Inválido");
				return;
			}
		}
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
	
	public Aluno getAlunoByIndex(int i)
	{
		return alunos.get(i);
	}
	
	public Curso getCursoByIndex(int i)
	{
		return cursos.get(i);
	}
	
	public Curso getCursoByName(String name)
	{
		
		for(Curso c1 : cursos)
		{
			if(c1.getNome() == name)
			{
				return c1;
			}
		}
		return null;
	}
	
	public String [] getCursesNames()
	{
		String[] vetor = new String[cursos.size()];
		for(int i = 0, k = 0; i < cursos.size(); ++i)
		{
			if(cursos.get(i).quantidadeInscritos() < 30)
			{
				vetor[k] = cursos.get(i).getNome();
				k++;
			}
			
		}
		
		return vetor;
	}
	
	public void GravarDados()
	{
		Arquivo.GravarArquivo(alunos, cursos);
	}
}

class programaTest
{
	public static void main(String[] args)
	{
		Programa p = new Programa();
		
		p.adicionaCurso(new Curso("Jardinagem","dsad","horatal"));
		p.adicionaCurso(new Curso("Vadiagem","dsad","horatal"));
		p.adicionaCurso(new Curso("Culinaria","dsad","horatal"));
		
		
		
		
		for(Aluno al: p.getAlunos())
			System.out.println(al.getNome());
	}
}
