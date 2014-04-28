package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import Brenda.Programa;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUIPrincipal {

	private JFrame frame;
	private AlunoGUI alunoWindow;
	private CursoGUI cursoWindow;
	public Programa programa;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPrincipal window = new GUIPrincipal();
					window.frame.setVisible(true);
					System.out.println(window.programa.getCursos().size());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		programa = new Programa();
		alunoWindow = new AlunoGUI(programa);
		cursoWindow = new CursoGUI(programa);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Brenda");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 448, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Adicionar");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAluno = new JMenuItem("Aluno");
		mntmAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmAluno);
		mntmAluno.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				alunoWindow.Update();
				alunoWindow.frame.setVisible(true);
			}
		});
		
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mntmCurso.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmCurso.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				cursoWindow.frame.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmCurso);
		
		JMenu mnExportar = new JMenu("Exportar");
		menuBar.add(mnExportar);
		
		JMenuItem mntmParaOdt = new JMenuItem("Para ODT...");
		mnExportar.add(mntmParaOdt);
		
		JMenuItem mntmParaPdf = new JMenuItem("Para PDF...");
		mntmParaPdf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnExportar.add(mntmParaPdf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 35, 356, 207);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Curso tal", 30},{"Curso tal", 30}
			},
			new String[] {
				"Nome Curso", "Integrantes"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(128);
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
	}
}
