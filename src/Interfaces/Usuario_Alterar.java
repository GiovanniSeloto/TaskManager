package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.GerenciadorUsuarios;
import Classes.PerfilUsuarios;
import Classes.Usuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Usuario_Alterar extends JFrame {

	private static final long serialVersionUID = 1L;
	private GerenciadorUsuarios gUser = new GerenciadorUsuarios();
	private JPanel contentPane;
	private JTextField textFieldNomeUsuarioAlterar;
	private JTextField textFieldCPFUsuarioAlterar;
	private JTextField textFieldEmailUsuarioAlterar;
	private JTextField textFieldCargoUsuarioAlterar;
	private JTextField textFieldLoginUsuarioAlterar;
	private JTextField textFieldSenhaUsuarioAlterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario_Alterar frame = new Usuario_Alterar();
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
	public Usuario_Alterar() {
		setTitle("ALTERAR USUARIO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 478, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JComboBox comboBoxPerfilUsuario = new JComboBox();
		comboBoxPerfilUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBoxPerfilUsuario.setModel(new DefaultComboBoxModel<>(PerfilUsuarios.values()));
		
		JComboBox comboBoxAlterarUsuario = new JComboBox();
		comboBoxAlterarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario aux = solicitarUsuarioNome((String) comboBoxAlterarUsuario.getSelectedItem());
				textFieldNomeUsuarioAlterar.setText(aux.getNomeUsuario());
				textFieldCPFUsuarioAlterar.setText(aux.getCPFUsuario());
				textFieldEmailUsuarioAlterar.setText(aux.getEmailUsuario());
				textFieldCargoUsuarioAlterar.setText(aux.getCargoUsuario());
				textFieldLoginUsuarioAlterar.setText(aux.getLoginUsuario());
				textFieldSenhaUsuarioAlterar.setText(aux.getSenhaUsuario());
				//comboBoxPerfilUsuario.setSelectedItem(aux.getPerfil().name());
			}
		});
		comboBoxAlterarUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		solicitarTodosUsuarios(comboBoxAlterarUsuario);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldNomeUsuarioAlterar = new JTextField();
		textFieldNomeUsuarioAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldNomeUsuarioAlterar.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldCPFUsuarioAlterar = new JTextField();
		textFieldCPFUsuarioAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldCPFUsuarioAlterar.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("E-MAIL:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldEmailUsuarioAlterar = new JTextField();
		textFieldEmailUsuarioAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldEmailUsuarioAlterar.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CARGO:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldCargoUsuarioAlterar = new JTextField();
		textFieldCargoUsuarioAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldCargoUsuarioAlterar.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("LOGIN:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldLoginUsuarioAlterar = new JTextField();
		textFieldLoginUsuarioAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldLoginUsuarioAlterar.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("SENHA:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldSenhaUsuarioAlterar = new JTextField();
		textFieldSenhaUsuarioAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_6 = new JLabel("PERFIL:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton btnNewButtonAlterar = new JButton("ALTERAR");
		btnNewButtonAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario aux = solicitarUsuarioNome((String) comboBoxAlterarUsuario.getSelectedItem());
				Usuario auxNovo = new Usuario(
						textFieldNomeUsuarioAlterar.getText(), 
						textFieldCPFUsuarioAlterar.getText(), 
						textFieldEmailUsuarioAlterar.getText(), 
						textFieldCargoUsuarioAlterar.getText(), 
						textFieldLoginUsuarioAlterar.getText(), 
						textFieldSenhaUsuarioAlterar.getText(), 
						(PerfilUsuarios)comboBoxPerfilUsuario.getSelectedItem()
				);
				gUser.Alterar(aux, auxNovo);
			}
		});
		btnNewButtonAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(comboBoxAlterarUsuario, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(textFieldNomeUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(textFieldCPFUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textFieldEmailUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(textFieldCargoUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(textFieldLoginUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldSenhaUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(77)
									.addComponent(btnNewButtonAlterar))
								.addComponent(comboBoxPerfilUsuario, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBoxAlterarUsuario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(113)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldNomeUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldCPFUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldEmailUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldCargoUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldLoginUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldSenhaUsuarioAlterar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxPerfilUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(btnNewButtonAlterar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);

	}
	
	private void solicitarTodosUsuarios(JComboBox jComBox){
		List<Usuario> aux = gUser.retornoTodosUsuarios();
		jComBox.addItem(null);
		for(Usuario u : aux)
			jComBox.addItem(u.getNomeUsuario());
	}
	
	private Usuario solicitarUsuarioNome(String nome) {
		return gUser.retornoUsuarioNome(nome);
	}
}
