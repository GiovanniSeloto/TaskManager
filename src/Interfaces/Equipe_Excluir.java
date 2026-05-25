package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Equipe;
import Classes.GerenciadorEquipes;
import Classes.GerenciadorUsuarios;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Equipe_Excluir extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GerenciadorEquipes gEquipe = new GerenciadorEquipes();
	private JTextField textFieldNomeExcluirEquipe;
	private JTextField textFieldDescricaoExcluirEquipe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equipe_Excluir frame = new Equipe_Excluir();
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
	public Equipe_Excluir() {
		setTitle("EXCLUIR EQUIPE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEquipe = new JLabel("EQUIPE:");
		lblEquipe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldNomeExcluirEquipe = new JTextField();
		textFieldNomeExcluirEquipe.setEditable(false);
		textFieldNomeExcluirEquipe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldNomeExcluirEquipe.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DESCRIÇÃO:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldDescricaoExcluirEquipe = new JTextField();
		textFieldDescricaoExcluirEquipe.setEditable(false);
		textFieldDescricaoExcluirEquipe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDescricaoExcluirEquipe.setColumns(10);
		
		JComboBox comboBoxExcluirEquipe = new JComboBox();
		comboBoxExcluirEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipe aux = solicitarEquipeNome((String) comboBoxExcluirEquipe.getSelectedItem());
				textFieldNomeExcluirEquipe.setText(aux.getNomeEquipe());
				textFieldDescricaoExcluirEquipe.setText(aux.getDescricao());
			}
		});
		comboBoxExcluirEquipe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		solicitarTodasEquipes(comboBoxExcluirEquipe);
				
		JButton btnNewButtonExcluir = new JButton("EXCLUIR");
		btnNewButtonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarUsuario(comboBoxExcluirEquipe.getSelectedItem().toString());
				
			}
		});
		btnNewButtonExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEquipe, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(comboBoxExcluirEquipe, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addGap(63)
									.addComponent(textFieldNomeExcluirEquipe, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textFieldDescricaoExcluirEquipe, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(184)
							.addComponent(btnNewButtonExcluir, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEquipe, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBoxExcluirEquipe, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(106)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldNomeExcluirEquipe, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldDescricaoExcluirEquipe, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(btnNewButtonExcluir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private Equipe solicitarEquipeNome(String nome) {
		return gEquipe.retornoEquipeNome(nome);
	}
	
	private void solicitarTodasEquipes(JComboBox jComBox){
		List<Equipe> aux = gEquipe.retornoTodasEquipes();
		jComBox.addItem(null);
		for(Equipe u : aux)
			jComBox.addItem(u.getNomeEquipe());
	}
	
	private void deletarUsuario(String equipeDeletar) {
		gEquipe.Deletar(equipeDeletar);		
	}
}
