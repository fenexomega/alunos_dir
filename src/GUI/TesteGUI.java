package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class TesteGUI {

	private JFrame frame;
	private Aluno alunoWindow;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteGUI window = new TesteGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TesteGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		alunoWindow = new Aluno();
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
				alunoWindow.frame.setVisible(true);
			}
		});
		
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mntmCurso.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnNewMenu.add(mntmCurso);
		
		JMenu mnExportar = new JMenu("Exportar");
		menuBar.add(mnExportar);
		
		JMenuItem mntmParaOdt = new JMenuItem("Para ODT...");
		mnExportar.add(mntmParaOdt);
		
		JMenuItem mntmParaPdf = new JMenuItem("Para PDF...");
		mntmParaPdf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnExportar.add(mntmParaPdf);
	}
}
