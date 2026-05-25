package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Equipe;
import Classes.GerenciadorEquipes;
import Classes.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Equipe_Alterar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeEquipeAlterar;
	private JTextField textFieldDescricaoEquipeAlterar;
	private GerenciadorEquipes gEquipe = new GerenciadorEquipes();
	private List<Usuario> usuariosSelecionados = new ArrayList<Usuario>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equipe_Alterar frame = new Equipe_Alterar();
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
	public Equipe_Alterar() {
		setTitle("ALTERAR EQUIPE");
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
		
		textFieldNomeEquipeAlterar = new JTextField();
		textFieldNomeEquipeAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldNomeEquipeAlterar.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DESCRIÇÃO:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldDescricaoEquipeAlterar = new JTextField();
		textFieldDescricaoEquipeAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDescricaoEquipeAlterar.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("MEMBROS:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton btnNewButtonAlterarMembros = new JButton("SELECIONAR");
		btnNewButtonAlterarMembros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuariosSelecionados = criarCaixaSelecaoMembros();
			}
		});
		btnNewButtonAlterarMembros.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				
		JComboBox comboBoxAlterarEquipe = new JComboBox();
		comboBoxAlterarEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipe aux = solicitarEquipeNome((String) comboBoxAlterarEquipe.getSelectedItem());
				textFieldNomeEquipeAlterar.setText(aux.getNomeEquipe());
				textFieldDescricaoEquipeAlterar.setText(aux.getDescricao());
			}
		});
		comboBoxAlterarEquipe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		solicitarTodasEquipes(comboBoxAlterarEquipe);
		
		JButton btnNewButtonAlterar = new JButton("ALTERAR");
		btnNewButtonAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipe aux = solicitarEquipeNome((String) comboBoxAlterarEquipe.getSelectedItem());
				Equipe auxNovo = new Equipe(
						textFieldNomeEquipeAlterar.getText(),
						textFieldDescricaoEquipeAlterar.getText(),
						usuariosSelecionados
				);
				gEquipe.Alterar(aux, auxNovo);
				JOptionPane.showMessageDialog(null, 
						"Ação concluída com sucesso!", // Mensagem
				        "Sucesso",                      // Título da janela
				        JOptionPane.INFORMATION_MESSAGE // Ícone (i)
				);
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
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEquipe, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(comboBoxAlterarEquipe, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
									.addComponent(textFieldNomeEquipeAlterar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButtonAlterarMembros, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldDescricaoEquipeAlterar, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButtonAlterar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(170))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblEquipe, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBoxAlterarEquipe, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(106)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNomeEquipeAlterar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDescricaoEquipeAlterar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButtonAlterarMembros, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(btnNewButtonAlterar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);

	}
	
	private List<Usuario> criarCaixaSelecaoMembros() {
		List<Usuario> usuariosSelecionados = new ArrayList<Usuario>();
		
		JFrame frame = new JFrame("SELECIONAR MEMBROS");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 5, 5));
		
		List<Usuario> auxUser = gEquipe.retornoTodosUsuarios();
		List<JCheckBox> auxOpcoes = new ArrayList<JCheckBox>();
		
		for(int i=0; i<auxUser.size(); i++) {
			auxOpcoes.add(new JCheckBox(auxUser.get(i).getNomeUsuario()));
		}
		
		for(int i=0; i<auxUser.size(); i++) {
			frame.getContentPane().add(auxOpcoes.get(i));
		}
		
		frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Ação personalizada: Perguntar se o usuário quer mesmo sair
                int opcao = JOptionPane.showConfirmDialog(frame, 
                        "Deseja realmente fechar a janela?", 
                        "Confirmação", 
                        JOptionPane.YES_NO_OPTION);

                if (opcao == JOptionPane.YES_OPTION) {
                    
                	for(int i=0; i<auxOpcoes.size(); i++) {
                		if(auxOpcoes.get(i).isSelected()) {
                			usuariosSelecionados.add(gEquipe.retornoUsuarioNome(auxOpcoes.get(i).getText()));
                		}
                	}
                	// Encerra a aplicação ou libera os recursos
                    frame.dispose(); // ou System.exit(0);
                }
            }
        });
		
		frame.pack();
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        return usuariosSelecionados;
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
}
