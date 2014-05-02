package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Brenda.Programa;
import Brenda.Curso;
import java.awt.Window.Type;

public class GUICurso
{

	public JFrame frame;
	private JTextField textField;
	private Programa programa;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GUICurso(Programa programa)
	{
		this.programa = programa;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNomeDoCurso = new JLabel("Nome do Curso");
		lblNomeDoCurso.setBounds(12, 63, 128, 15);
		frame.getContentPane().add(lblNomeDoCurso);
		
		textField = new JTextField();
		textField.setBounds(145, 61, 291, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				programa.adicionaCurso(new Curso(textField.getText()));
				
				textField.setText("");
				frame.dispose();
			}
		});
		btnCadastrar.setBounds(182, 232, 117, 25);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				frame.dispose();
			}
		});
		btnCancelar.setBounds(319, 232, 117, 25);
		frame.getContentPane().add(btnCancelar);
	}
}
