package Interfaces;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Classes.GerenciadorProjeto;
import Classes.GerenciadorUsuarios;
import Classes.PerfilUsuarios;
import Classes.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuario_Cadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeUsuario;
	private JTextField textFieldCPFUsuario;
	private JTextField textFieldEmailUsuario;
	private JTextField textFieldCargoUsuario;
	private JTextField textFieldLoginUsuario;
	private JTextField passwordFieldSenhaUsuario;
	private GerenciadorUsuarios gUser = new GerenciadorUsuarios();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario_Cadastrar frame = new Usuario_Cadastrar();
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
	public Usuario_Cadastrar() {
		setTitle("CADASTRAR USUARIO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false); 
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("E-MAIL:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("CARGO:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_4 = new JLabel("LOGIN:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_5 = new JLabel("SENHA:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_6 = new JLabel("PERFIL:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldNomeUsuario = new JTextField();
		textFieldNomeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldNomeUsuario.setColumns(10);
		
		textFieldCPFUsuario = new JTextField();
		textFieldCPFUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldCPFUsuario.setColumns(10);
		
		textFieldEmailUsuario = new JTextField();
		textFieldEmailUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldEmailUsuario.setColumns(10);
		
		textFieldCargoUsuario = new JTextField();
		textFieldCargoUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldCargoUsuario.setColumns(10);
		
		textFieldLoginUsuario = new JTextField();
		textFieldLoginUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldLoginUsuario.setColumns(10);
		
		passwordFieldSenhaUsuario = new JTextField();
		passwordFieldSenhaUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JComboBox comboBoxPerfilUsuario = new JComboBox();
		comboBoxPerfilUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBoxPerfilUsuario.setModel(new DefaultComboBoxModel<>(PerfilUsuarios.values()));
		
		JButton btnNewButtonSalvar = new JButton("SALVAR");
		btnNewButtonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gUser.Criar(textFieldNomeUsuario.getText(), 
						textFieldCPFUsuario.getText(), 
						textFieldEmailUsuario.getText(), 
						textFieldCargoUsuario.getText(), 
						textFieldLoginUsuario.getText(), 
						passwordFieldSenhaUsuario.getText(), 
						(PerfilUsuarios)comboBoxPerfilUsuario.getSelectedItem());
				JOptionPane.showMessageDialog(null, 
						"Ação concluída com sucesso!", // Mensagem
				        "Sucesso",                      // Título da janela
				        JOptionPane.INFORMATION_MESSAGE // Ícone (i)
				);			
			}
		});
		btnNewButtonSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(28)
									.addComponent(textFieldNomeUsuario, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
									.addComponent(textFieldCPFUsuario, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(textFieldEmailUsuario, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
									.addComponent(textFieldCargoUsuario, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_4)
										.addComponent(lblNewLabel_5)
										.addComponent(lblNewLabel_6))
									.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBoxPerfilUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(passwordFieldSenhaUsuario)
											.addComponent(textFieldLoginUsuario, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(180)
							.addComponent(btnNewButtonSalvar)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldNomeUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(textFieldCPFUsuario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(textFieldEmailUsuario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3)
						.addComponent(textFieldCargoUsuario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_4)
						.addComponent(textFieldLoginUsuario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(passwordFieldSenhaUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(comboBoxPerfilUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(btnNewButtonSalvar)
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
