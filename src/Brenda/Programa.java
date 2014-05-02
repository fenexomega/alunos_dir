package Brenda;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import javax.security.auth.callback.TextOutputCallback;

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
	
	
	public String[] getNomesAlunos()
	{
		String[] nomes = new String[alunos.size()];
		for(int i = 0; i < alunos.size(); ++i)
		{
			nomes[i] = alunos.get(i).getNome();
		}
		return nomes;
	}
	
	public void removeAluno(String nome)
	{
		Aluno a = getAlunoByName(nome);
				
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
	
	public Aluno getAlunoByName(String name)
	{
		
		for(Aluno c1 : alunos)
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
	
	public void GravarTexto(String path, Curso c)
	{
		try
		{
			FileWriter f = new FileWriter(path);
			f.write(returnHTMLShit(c.getNome()) + "\n");
			f.write("<h3>" + c.getNome() + "</h3>");
			f.write("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"ta1\"><colgroup><col width=\"342\"/><col width=\"278\"/></colgroup>");
			f.write("<tr class=\"ro1\"><td style=\"text-align:left;width:7.833cm; \" class=\"ce1\"><p>ALUNO</p></td><td style=\"text-align:left;width:6.354cm; \" class=\"ce1\"><p>FREQUENCIA</p></td></tr>");
			for(Aluno a : c.getAlunos())
			{
				f.write("<tr class=\"ro1\">");
				f.write("<td style=\"text-align:left;width:7.833cm; \" class=\"ce1\"><p>" + a.getNome().toUpperCase() + " </p></td><td style=\"text-align:left;width:6.354cm; \" class=\"ce1\"><p></p></td></tr>");

			}
			f.write("</body></html>");
			f.flush();
			f.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private String returnHTMLShit(String nomeCurso)
	{
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1 plus MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/xhtml-math11-f.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><!--This file was converted to xhtml by LibreOffice - see http://cgit.freedesktop.org/libreoffice/core/tree/filter/source/xslt for the code.--><head profile=\"http://dublincore.org/documents/dcmi-terms/\"><meta http-equiv=\"Content-Type\" content=\"application/xhtml+xml; charset=utf-8\"/><title xml:lang=\"en-US\">" + nomeCurso  + "</title><meta name=\"DCTERMS.title\" content=\"\" xml:lang=\"en-US\"/><meta name=\"DCTERMS.language\" content=\"en-US\" scheme=\"DCTERMS.RFC4646\"/><meta name=\"DCTERMS.source\" content=\"http://xml.openoffice.org/odf2xhtml\"/><meta name=\"DCTERMS.creator\" content=\"Jordy \"/><meta name=\"DCTERMS.issued\" content=\"2014-05-01T20:22:02.867137036\" scheme=\"DCTERMS.W3CDTF\"/><meta name=\"DCTERMS.provenance\" content=\"\" xml:lang=\"en-US\"/><meta name=\"DCTERMS.subject\" content=\",\" xml:lang=\"en-US\"/><link rel=\"schema.DC\" href=\"http://purl.org/dc/elements/1.1/\" hreflang=\"en\"/><link rel=\"schema.DCTERMS\" href=\"http://purl.org/dc/terms/\" hreflang=\"en\"/><link rel=\"schema.DCTYPE\" href=\"http://purl.org/dc/dcmitype/\" hreflang=\"en\"/><link rel=\"schema.DCAM\" href=\"http://purl.org/dc/dcam/\" hreflang=\"en\"/><style type=\"text/css\">@page {  }table { border-collapse:collapse; border-spacing:0; empty-cells:show }td, th { vertical-align:top; font-size:10pt;}h1, h2, h3, h4, h5, h6 { clear:both }ol, ul { margin:0; padding:0;}li { list-style: none; margin:0; padding:0;}<!-- \"li span.odfLiEnd\" - IE 7 issue-->li span. { clear: both; line-height:0; width:0; height:0; margin:0; padding:0; }span.footnodeNumber { padding-right:1em; }span.annotation_style_by_filter { font-size:95%; font-family:Arial; background-color:#fff000;  margin:0; border:0; padding:0;  }* { margin:0;}.ta1 { writing-mode:lr-tb; }.ce1 { font-family:Liberation Sans; border-width:0,0021cm; border-style:solid; border-color:#000000; text-align:center ! important; margin-left:0cm; font-weight:bold; }.ce2 { font-family:Liberation Sans; border-width:0,0021cm; border-style:solid; border-color:#000000; }.co1 { width:7.833cm; }.co2 { width:6.354cm; }.ro1 { height:0.427cm; }<!-- ODF styles with no properties representable as CSS -->{ }</style></head><body dir=\"ltr\" style=\"writing-mode:lr-tb; \">";
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
			objetos[i][0] =  Integer.toString(i + 1);
			objetos[i][1] =  alunos.get(i).getNome();
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
		
		p.GravarTexto("/home/jordy/Área de Trabalho/teste.html", new Curso("Aeho"));
	}
}
