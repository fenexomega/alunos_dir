package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class Aluno
{

	public JFrame frame;
	private JTextField txtDsad;


	/**
	 * Create the application.
	 */
	public Aluno()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtDsad = new JTextField();
		txtDsad.setText("");
		txtDsad.setBounds(101, 46, 294, 19);
		frame.getContentPane().add(txtDsad);
		txtDsad.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(33, 48, 70, 15);
		frame.getContentPane().add(lblNome);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(101, 101, 294, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblCurso = new JLabel("Curso 1");
		lblCurso.setBounds(33, 101, 70, 15);
		frame.getContentPane().add(lblCurso);
		
		JLabel lblCurso_1 = new JLabel("Curso 2");
		lblCurso_1.setBounds(33, 137, 70, 15);
		frame.getContentPane().add(lblCurso_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(101, 137, 294, 24);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblCurso_2 = new JLabel("Curso 3");
		lblCurso_2.setBounds(33, 178, 70, 15);
		frame.getContentPane().add(lblCurso_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(101, 178, 294, 24);
		frame.getContentPane().add(comboBox_2);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(184, 232, 117, 25);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				txtDsad.setText("");
				frame.dispose();
			}
		});
		btnCancelar.setBounds(319, 232, 117, 25);
		frame.getContentPane().add(btnCancelar);
	}
}
