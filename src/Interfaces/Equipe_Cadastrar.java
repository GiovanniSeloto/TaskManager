package Interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import Classes.GerenciadorEquipes;
import Classes.Usuario;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Equipe_Cadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeEquipe;
	private JTextField textFieldDescricaoEquipe;
	private GerenciadorEquipes gEquipe = new GerenciadorEquipes();
	private List<Usuario> usuariosSelecionados = new ArrayList<Usuario>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equipe_Cadastrar frame = new Equipe_Cadastrar();
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
	public Equipe_Cadastrar() {
		setTitle("CADASTRAR EQUIPE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblDescrio = new JLabel("DESCRIÇÃO:");
		lblDescrio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldNomeEquipe = new JTextField();
		textFieldNomeEquipe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldNomeEquipe.setColumns(10);
		
		textFieldDescricaoEquipe = new JTextField();
		textFieldDescricaoEquipe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDescricaoEquipe.setColumns(10);
		
		JLabel lblMembros = new JLabel("MEMBROS:");
		lblMembros.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("SELECIONAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuariosSelecionados = criarCaixaSelecaoMembros();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton btnNewButtonSalvarEquipe = new JButton("SALVAR");
		btnNewButtonSalvarEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gEquipe.Criar(
						textFieldNomeEquipe.getText(),
						textFieldDescricaoEquipe.getText(),
						usuariosSelecionados
						);
				JOptionPane.showMessageDialog(null, 
						"Ação concluída com sucesso!", // Mensagem
				        "Sucesso",                      // Título da janela
				        JOptionPane.INFORMATION_MESSAGE // Ícone (i)
				);
			}
		});
		btnNewButtonSalvarEquipe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMembros))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldNomeEquipe, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDescricaoEquipe, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(btnNewButtonSalvarEquipe, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(190))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(textFieldNomeEquipe, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDescricaoEquipe, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(lblMembros, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
					.addComponent(btnNewButtonSalvarEquipe, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {textFieldNomeEquipe, textFieldDescricaoEquipe});
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
}
