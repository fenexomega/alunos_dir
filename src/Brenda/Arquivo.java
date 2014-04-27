package Brenda;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Arquivo
{
	
	public static void GravarArquivo(ArrayList<Aluno> alunos, ArrayList<Curso> cursos)
	{	
		try
		{
			FileOutputStream f_out = new FileOutputStream("dados.ser");
			ObjectOutputStream o_out = new ObjectOutputStream(f_out);
			o_out.writeObject(alunos);
			o_out.writeObject(cursos);
			o_out.close();
			f_out.close();

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@SuppressWarnings("unchecked")
	public static void LerArquivo(ArrayList<Aluno> alunos, ArrayList<Curso> cursos)
	{
		try
		{
			FileInputStream f_In = new FileInputStream("dados.ser");
			ObjectInputStream o_In = new ObjectInputStream(f_In);
			alunos = (ArrayList<Aluno>) o_In.readObject();
			cursos = (ArrayList<Curso>) o_In.readObject();
			o_In.close();
			f_In.close();

		} catch (IOException | ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Erro");
			e.printStackTrace();
		}	
	}
	
}

class ArquivoTest
{
	public static void main(String[] args)
	{
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Arquivo a = new Arquivo();
		
		alunos.add(new Aluno("José"));
		alunos.add(new Aluno("Geremias"));
		alunos.add(new Aluno("Jonas"));
		alunos.add(new Aluno("Aragão"));

		cursos.add(new Curso("Culinária","Professor","14:30"));
		
		alunos.get(0).adicionarCurso(cursos.get(0));
		alunos.get(1).adicionarCurso(cursos.get(0));
		alunos.get(2).adicionarCurso(cursos.get(0));
		alunos.get(3).adicionarCurso(cursos.get(0));

		
		a.GravarArquivo(alunos, cursos);
		
		
		a.LerArquivo(alunos, cursos);
		
		for(Aluno al: cursos.get(0).getAlunos())
			System.out.println(al.getNome());
		
	}
}
