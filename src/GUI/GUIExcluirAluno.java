package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Brenda.Programa;

public class GUIExcluirAluno extends JFrame
{

	private JPanel contentPane;
	private Programa programa;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GUIExcluirAluno(Programa p)
	{
		this.programa = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(112, 57, 324, 24);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(programa.getNomesAlunos()));

		
		addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent arg0)
			{
				// TODO Auto-generated method stub
				comboBox.setModel(new DefaultComboBoxModel(programa.getNomesAlunos()));

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
		
		
		JLabel lblAluno = new JLabel("Aluno");
		lblAluno.setBounds(30, 62, 70, 15);
		contentPane.add(lblAluno);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(319, 232, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				programa.removeAluno(comboBox.getSelectedItem().toString());
				dispose();
				
			}
		});
		btnExcluir.setBounds(190, 232, 117, 25);
		contentPane.add(btnExcluir);
	}
}
