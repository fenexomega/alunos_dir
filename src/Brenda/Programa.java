package Brenda;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

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
		Collections.sort(alunos, new AlunoComparator());
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
		c.setNome(c.getNome().toUpperCase());
		cursos.add(c);
		Arquivo.GravarArquivo(alunos, cursos);
		organizarCursos();
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
			if(cursos.get(i).quantidadeInscritos() < 50)
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
	
	public String[][] getTabelaCursos()
	{
		String[][] objetos = new String[cursos.size()][2];
		for(int i = 0; i < cursos.size(); ++i)
		{
			objetos[i][0] =  cursos.get(i).getNome();
			objetos[i][1] =  Integer.toString(cursos.get(i).quantidadeInscritos());
		}
		return objetos;
	}
	
	public String[][] getTabelaAlunos(Curso c)
	{
		ArrayList<Aluno> alunos = c.getAlunos();
		String[][] objetos = new String[alunos.size()][2];
		for(int i = 0; i < alunos.size(); ++i)
		{
			objetos[i][0] =  alunos.get(i).getNome();
			objetos[i][1] =  null;
		}
		return objetos;
	}
	
	private void organizarCursos()
	{
		for(Curso c : cursos)
			c.setNome(c.getNome().toUpperCase());
		Collections.sort(cursos, new CursoComparator());
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
