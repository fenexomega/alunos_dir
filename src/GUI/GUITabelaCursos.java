package GUI;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Brenda.Programa;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;

public class GUITabelaCursos
{

	public JFrame frmTabelaDeCursos;
	private JTable table;
	private Programa programa;
	private String[][] alunos;
	private JComboBox comboBox;

	/**
	 * Create the application.
	 */
	public GUITabelaCursos(Programa programa)
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
		frmTabelaDeCursos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTabelaDeCursos.getContentPane().setLayout(new BorderLayout(0, 0));
		
		frmTabelaDeCursos.addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent arg0)
			{
				// TODO Auto-generated method stub
				comboBox.setModel(new DefaultComboBoxModel(programa.getCursesNames()));
				alunos = programa.getTabelaAlunos(programa.getCursoByIndex(comboBox.getSelectedIndex()));
				table.setModel(new DefaultTableModel(
						alunos,
						new String[] {
							"#", "ALUNO"
						}
					));
				table.getColumnModel().getColumn(0).setPreferredWidth(20);
				table.getColumnModel().getColumn(0).setMinWidth(20);
				table.getColumnModel().getColumn(0).setMaxWidth(20);

			}
			
			@Override
			public void componentResized(ComponentEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentMoved(ComponentEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(programa.getCursesNames()));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				alunos = programa.getTabelaAlunos(programa.getCursoByIndex(comboBox.getSelectedIndex()));
				table.setModel(new DefaultTableModel(
						alunos,
						new String[] {
							"#", "ALUNO"
						}
					));
				table.getColumnModel().getColumn(0).setPreferredWidth(20);
				table.getColumnModel().getColumn(0).setMinWidth(20);
				table.getColumnModel().getColumn(0).setMaxWidth(20);
				
			}
		});
		frmTabelaDeCursos.getContentPane().add(comboBox, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmTabelaDeCursos.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "ALUNO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.getColumnModel().getColumn(0).setMaxWidth(20);
		scrollPane.setViewportView(table);
				
	}

}
