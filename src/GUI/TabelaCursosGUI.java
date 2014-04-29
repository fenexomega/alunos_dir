package GUI;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Brenda.Arquivo;
import Brenda.Programa;

import javax.swing.JToggleButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class TabelaCursosGUI
{

	public JFrame frmTabelaDeCursos;
	private JTable table;
	private Programa programa;
	private String[][] alunos;
	private JComboBox comboBox;

	/**
	 * Create the application.
	 */
	public TabelaCursosGUI(Programa programa)
	{
		this.programa = programa;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmTabelaDeCursos = new JFrame();
		frmTabelaDeCursos.setTitle("Tabela de Cursos");
		frmTabelaDeCursos.setBounds(100, 100, 450, 448);
		frmTabelaDeCursos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTabelaDeCursos.getContentPane().setLayout(new BorderLayout(0, 0));
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(programa.getCursesNames()));
		frmTabelaDeCursos.getContentPane().add(comboBox, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmTabelaDeCursos.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			alunos,
			new String[] {
				"ALUNO"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				alunos = programa.getTabelaAlunos(programa.getCursoByIndex(comboBox.getSelectedIndex()));
				table.setModel(new DefaultTableModel(
						alunos,
						new String[] {
							"ALUNO"
						}
					));
				
				
			}
		});
		frmTabelaDeCursos.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}

}
