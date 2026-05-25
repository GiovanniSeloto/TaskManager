package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.BancoDadosUsuario;
import Classes.GerenciadorUsuarios;
import Classes.PerfilUsuarios;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import Classes.Usuario;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Usuario_Excluir extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GerenciadorUsuarios gUser = new GerenciadorUsuarios();
	private JTextField textFieldNomeUsuarioDeletar;
	private JTextField textFieldCPFUsuarioDeletar;
	private JTextField textFieldEmailUsuarioDeletar;
	private JTextField textFieldCargoUsuarioDeletar;
	private JTextField textFieldLoginUsuarioDeletar;
	private JTextField textFieldSenhaUsuarioDeletar;
	private JTextField textFieldPerfilUsuarioDeletar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario_Excluir frame = new Usuario_Excluir();
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
	public Usuario_Excluir() {
		setTitle("EXCLUIR USUARIO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JComboBox comboBoxExcluirUsuario = new JComboBox();
		comboBoxExcluirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario aux = solicitarUsuarioNome((String) comboBoxExcluirUsuario.getSelectedItem());
				textFieldNomeUsuarioDeletar.setText(aux.getNomeUsuario());
				textFieldCPFUsuarioDeletar.setText(aux.getCPFUsuario());
				textFieldEmailUsuarioDeletar.setText(aux.getEmailUsuario());
				textFieldCargoUsuarioDeletar.setText(aux.getCargoUsuario());
				textFieldLoginUsuarioDeletar.setText(aux.getLoginUsuario());
				textFieldSenhaUsuarioDeletar.setText(aux.getSenhaUsuario());
				textFieldPerfilUsuarioDeletar.setText(aux.getPerfil().name());
			}
		});
		comboBoxExcluirUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		solicitarTodosUsuarios(comboBoxExcluirUsuario);
		
		JButton btnNewButtonExcluir = new JButton("EXCLUIR");
		btnNewButtonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarUsuario(comboBoxExcluirUsuario.getSelectedItem().toString());
			}
		});
		btnNewButtonExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldNomeUsuarioDeletar = new JTextField();
		textFieldNomeUsuarioDeletar.setEditable(false);
		textFieldNomeUsuarioDeletar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldNomeUsuarioDeletar.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldCPFUsuarioDeletar = new JTextField();
		textFieldCPFUsuarioDeletar.setEditable(false);
		textFieldCPFUsuarioDeletar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldCPFUsuarioDeletar.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("E-MAIL:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldEmailUsuarioDeletar = new JTextField();
		textFieldEmailUsuarioDeletar.setEditable(false);
		textFieldEmailUsuarioDeletar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldEmailUsuarioDeletar.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CARGO:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldCargoUsuarioDeletar = new JTextField();
		textFieldCargoUsuarioDeletar.setEditable(false);
		textFieldCargoUsuarioDeletar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldCargoUsuarioDeletar.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("LOGIN:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldLoginUsuarioDeletar = new JTextField();
		textFieldLoginUsuarioDeletar.setEditable(false);
		textFieldLoginUsuarioDeletar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldLoginUsuarioDeletar.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("SENHA:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldSenhaUsuarioDeletar = new JTextField();
		textFieldSenhaUsuarioDeletar.setEditable(false);
		textFieldSenhaUsuarioDeletar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_6 = new JLabel("PERFIL:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldPerfilUsuarioDeletar = new JTextField();
		textFieldPerfilUsuarioDeletar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldPerfilUsuarioDeletar.setEditable(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblUsuario)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxExcluirUsuario, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(textFieldNomeUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(50)
									.addComponent(textFieldCPFUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textFieldEmailUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addGap(17)
									.addComponent(textFieldCargoUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(textFieldLoginUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(20)
									.addComponent(textFieldSenhaUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
									.addComponent(textFieldPerfilUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(163)
							.addComponent(btnNewButtonExcluir)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxExcluirUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldNomeUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldCPFUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldEmailUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldCargoUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldLoginUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldSenhaUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPerfilUsuarioDeletar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addComponent(btnNewButtonExcluir)
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
	
	private void deletarUsuario(String usuarioDeletar) {
		gUser.Deletar(usuarioDeletar);		
	}
}
