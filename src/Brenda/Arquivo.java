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
			FileOutputStream f_out = new FileOutputStream("cursos.ser");
			ObjectOutputStream o_out = new ObjectOutputStream(f_out);
			o_out.writeObject(cursos);
			o_out.close();
			f_out.close();
			
			f_out = new FileOutputStream("alunos.ser");
			 o_out = new ObjectOutputStream(f_out);
			o_out.writeObject(alunos);
			o_out.close();
			f_out.close();

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static ArrayList<Curso> LerArquivoCursos()
	{
		ArrayList<Curso> cursos = null;
		try
		{
			FileInputStream f_In = new FileInputStream("cursos.ser");
			ObjectInputStream o_In = new ObjectInputStream(f_In);
			cursos = (ArrayList<Curso>) o_In.readObject();
			o_In.close();
			f_In.close();
			return cursos;

		} catch (IOException | ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Erro");
			e.printStackTrace();
		}
		return cursos;	
		
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Aluno> LerArquivoAlunos()
	{
		ArrayList<Aluno> alunos = null;
		try
		{
			FileInputStream f_In = new FileInputStream("alunos.ser");
			ObjectInputStream o_In = new ObjectInputStream(f_In);
			alunos = (ArrayList<Aluno>) o_In.readObject();
			o_In.close();
			f_In.close();
			System.out.println(alunos.size());
			return alunos;

		} catch (IOException | ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Erro");
			e.printStackTrace();
		}
		return alunos;
	}
	
}

class ArquivoTest
{
	public static void main(String[] args)
	{
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		ArrayList<Curso> cursos = new ArrayList<Curso>();

		alunos = Arquivo.LerArquivoAlunos();
		cursos = Arquivo.LerArquivoCursos();
				
		
	
		System.out.println(cursos.size());

		
		alunos.get(0).adicionarCurso(cursos.get(0));
		alunos.get(1).adicionarCurso(cursos.get(0));
		alunos.get(2).adicionarCurso(cursos.get(0));
		alunos.get(3).adicionarCurso(cursos.get(0));

		
		
		Arquivo.GravarArquivo(alunos, cursos);
		
		
		for(Aluno al: cursos.get(0).getAlunos())
			System.out.println(al.getNome());
		
	}
}


