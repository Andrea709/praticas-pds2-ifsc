package ex09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ConexaoBanco extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConexaoBanco frame = new ConexaoBanco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConexaoBanco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 207);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(223, 252, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(120, 72, 204, 25);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setBounds(120, 25, 204, 25);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Gentium Book Basic", Font.PLAIN, 20));
		lblNome.setBounds(20, 74, 90, 17);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setFont(new Font("Gentium Book Basic", Font.PLAIN, 20));
		lblCpf.setBounds(20, 18, 77, 34);
		contentPane.add(lblCpf);

		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String cpf = txtCpf.getText();

				Statement st;
				Connection conexao;
				try {
					conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "aluno");
					st = conexao.createStatement();
					st.executeUpdate("INSERT INTO pessoa VALUES (" + cpf + ", " + nome + ")");
					
					System.out.println("Deu tudo certo :D");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnConectar.setBackground(new Color(255, 244, 244));
		btnConectar.setFont(new Font("Gentium Book Basic", Font.PLAIN, 20));
		btnConectar.setBounds(109, 123, 144, 34);
		contentPane.add(btnConectar);
	}
}
