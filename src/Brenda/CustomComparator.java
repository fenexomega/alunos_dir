package Brenda;

import java.util.Comparator;

public class CustomComparator implements Comparator<Aluno>
{

	@Override
	public int compare(Aluno o1, Aluno o2)
	{
		return o1.getNome().compareTo(o2.getNome());
	}
	
}
