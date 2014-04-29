package Brenda;

import java.util.Comparator;

public class CursoComparator implements Comparator<Curso>
{

	@Override
	public int compare(Curso o1, Curso o2)
	{
		// TODO Auto-generated method stub
		return o1.getNome().compareTo(o2.getNome());
	}
	
}
