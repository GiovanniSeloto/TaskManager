package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PainelLogin;
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.pack();
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
	public Login() {
		setTitle("GERENCIADOR DE PROJETOS E EQUIPES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		PainelLogin = new JPanel();
		PainelLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PainelLogin);
		
		JLabel lblNewLabel = new JLabel("LOGIN:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldLogin = new JTextField();
		textFieldLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldLogin.setColumns(10);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton btnConectar = new JButton("CONECTAR");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarLoginSenha(textFieldLogin.getText(), passwordFieldSenha.getText())) {
					Sistema_Principal.main(null);
					dispose();
				}
			}
		});
		btnConectar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GroupLayout gl_painelLogin = new GroupLayout(PainelLogin);
		gl_painelLogin.setHorizontalGroup(
			gl_painelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelLogin.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_painelLogin.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelLogin.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldLogin, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
						.addComponent(passwordFieldSenha, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_painelLogin.createSequentialGroup()
					.addContainerGap(177, Short.MAX_VALUE)
					.addComponent(btnConectar)
					.addGap(171))
		);
		gl_painelLogin.setVerticalGroup(
			gl_painelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelLogin.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_painelLogin.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(textFieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_painelLogin.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(btnConectar)
					.addGap(52))
		);
		PainelLogin.setLayout(gl_painelLogin);

	}
	
	public boolean validarLoginSenha(String login, String senha) {
		boolean validacao = true;
		//CRIAR SISTEMA DE VALIDAÇÃO - TO DO
		return validacao;
	}
}
