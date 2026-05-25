package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.GerenciadorProjeto;
import Classes.GerenciadorUsuarios;
import Classes.PerfilUsuarios;
import Classes.Projeto;
import Classes.StatusProjeto;
import Classes.Usuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class Projeto_Alterar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GerenciadorProjeto gProjeto = new GerenciadorProjeto();
	private JTextField textFieldAlterarNomeProjeto;
	private JTextField textFieldAlterarDescricaoProjeto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projeto_Alterar frame = new Projeto_Alterar();
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
	public Projeto_Alterar() {
		setTitle("ALTERAR PROJETO:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); 
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblProjeto = new JLabel("PROJETO:");
		lblProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JComboBox comboBoxAlterarProjeto = new JComboBox();
		comboBoxAlterarProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		solicitarTodosProjetos(comboBoxAlterarProjeto);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldAlterarNomeProjeto = new JTextField();
		textFieldAlterarNomeProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldAlterarNomeProjeto.setColumns(10);
		
		JLabel lblDescrio = new JLabel("DESCRIÇÃO:");
		lblDescrio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldAlterarDescricaoProjeto = new JTextField();
		textFieldAlterarDescricaoProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldAlterarDescricaoProjeto.setColumns(10);
		
		JLabel lblDataInicio = new JLabel("DATA INICIO:");
		lblDataInicio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblDia = new JLabel("DIA:");
		lblDia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JComboBox comboBoxAlterarDiaInicioProjeto = new JComboBox();
		comboBoxAlterarDiaInicioProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxAlterarDiaInicioProjeto, 1, 31);
		
		JLabel lblMs = new JLabel("MÊS:");
		lblMs.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JComboBox comboBoxAlterarMesInicioProjeto = new JComboBox();
		comboBoxAlterarMesInicioProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxAlterarMesInicioProjeto, 1, 12);
		
		JLabel lblAno = new JLabel("ANO:");
		lblAno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JComboBox comboBoxAlterarAnoInicioProjeto = new JComboBox();
		comboBoxAlterarAnoInicioProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxAlterarAnoInicioProjeto, 2026, 2036);
				
		JLabel lblDataTermino = new JLabel("DATA TERMINO:");
		lblDataTermino.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblDia_1 = new JLabel("DIA:");
		lblDia_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JComboBox comboBoxAlterarDiaTerminoProjeto = new JComboBox();
		comboBoxAlterarDiaTerminoProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxAlterarDiaTerminoProjeto, 1, 31);
		
		JLabel lblDia_1_1 = new JLabel("MÊS:");
		lblDia_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JComboBox comboBoxAlterarMesTerminoProjeto = new JComboBox();
		comboBoxAlterarMesTerminoProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxAlterarMesTerminoProjeto, 1, 12);
		
		JLabel lblDia_1_2 = new JLabel("ANO:");
		lblDia_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JComboBox comboBoxAlterarAnoTerminoProjeto = new JComboBox();
		comboBoxAlterarAnoTerminoProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxAlterarAnoTerminoProjeto, 2026, 2036);
		
		JLabel lblStatus = new JLabel("STATUS:");
		lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JComboBox comboBoxAlterarStatusProjeto = new JComboBox();
		comboBoxAlterarStatusProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblGerente = new JLabel("GERENTE:");
		lblGerente.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JComboBox comboBoxAlterarGerenteProjeto = new JComboBox();
		comboBoxAlterarGerenteProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				
		comboBoxAlterarProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto aux = solicitarProjetoNome((String) comboBoxAlterarProjeto.getSelectedItem());
				textFieldAlterarNomeProjeto.setText(aux.getNomeProjeto());
				textFieldAlterarDescricaoProjeto.setText(aux.getDescricao());
				comboBoxAlterarStatusProjeto.setModel(new DefaultComboBoxModel<>(StatusProjeto.values()));
				List<Usuario> auxGerentes = listaComUsuariosGerentes();
				for(Usuario i : auxGerentes) {
					comboBoxAlterarGerenteProjeto.addItem(i.getNomeUsuario());
				}
				comboBoxAlterarStatusProjeto.setSelectedItem(aux.getStatus());
				comboBoxAlterarGerenteProjeto.setSelectedItem(aux.getGerenteResponsavel().getNomeUsuario());
			}
		});
		
		JButton btnNewButtonAlterar = new JButton("ALTERAR");
		btnNewButtonAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto aux = solicitarProjetoNome((String) comboBoxAlterarProjeto.getSelectedItem());
				Projeto novo = new Projeto(
						textFieldAlterarNomeProjeto.getText(),
						textFieldAlterarDescricaoProjeto.getText(),
						Integer.parseInt(comboBoxAlterarDiaInicioProjeto.getSelectedItem().toString()),
						Integer.parseInt(comboBoxAlterarMesInicioProjeto.getSelectedItem().toString()),
						Integer.parseInt(comboBoxAlterarAnoInicioProjeto.getSelectedItem().toString()),
						Integer.parseInt(comboBoxAlterarDiaTerminoProjeto.getSelectedItem().toString()),
						Integer.parseInt(comboBoxAlterarMesTerminoProjeto.getSelectedItem().toString()),
						Integer.parseInt(comboBoxAlterarAnoTerminoProjeto.getSelectedItem().toString()),
						(StatusProjeto)comboBoxAlterarStatusProjeto.getSelectedItem(),
						retornoUsuarioNome(comboBoxAlterarGerenteProjeto.getSelectedItem().toString())
				);
				gProjeto.Alterar(aux, novo);
			}
		});
		btnNewButtonAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblProjeto, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addGap(53)
									.addComponent(comboBoxAlterarProjeto, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addGap(79)
									.addComponent(textFieldAlterarNomeProjeto, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textFieldAlterarDescricaoProjeto, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDataInicio, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(47)
									.addComponent(lblDia, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(comboBoxAlterarDiaInicioProjeto, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblMs, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBoxAlterarMesInicioProjeto, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxAlterarAnoInicioProjeto, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(comboBoxAlterarStatusProjeto, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblGerente, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBoxAlterarGerenteProjeto, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDataTermino, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblDia_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(comboBoxAlterarDiaTerminoProjeto, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblDia_1_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBoxAlterarMesTerminoProjeto, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblDia_1_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxAlterarAnoTerminoProjeto, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(171)
							.addComponent(btnNewButtonAlterar, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblProjeto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBoxAlterarProjeto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldAlterarNomeProjeto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldAlterarDescricaoProjeto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxAlterarAnoInicioProjeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataInicio, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblDia, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBoxAlterarDiaInicioProjeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblMs, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBoxAlterarMesInicioProjeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDataTermino, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDia_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(comboBoxAlterarDiaTerminoProjeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblDia_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBoxAlterarMesTerminoProjeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDia_1_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(comboBoxAlterarAnoTerminoProjeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxAlterarStatusProjeto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGerente, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBoxAlterarGerenteProjeto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(btnNewButtonAlterar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);

	}
	
	private void solicitarTodosProjetos(JComboBox comboBoxExcluirProjeto) {
		List<Projeto> aux = gProjeto.retornarTodosProjetos();
		comboBoxExcluirProjeto.addItem(null);
		for(Projeto u : aux)
			comboBoxExcluirProjeto.addItem(u.getNomeProjeto());
	}
	private Projeto solicitarProjetoNome(String nome) {
		return gProjeto.retornoProjetoNome(nome);
	}
	private void inserirValoresComboBox(JComboBox jcBox, int valor_inicial, int valor_limite) {
		for(int i=valor_inicial; i<=valor_limite; i++) {
			jcBox.addItem(String.valueOf(i));
		}
	}
	private List<Usuario> listaComUsuariosGerentes() {
    	return gProjeto.retornarUsuariosGerente();		
    }
	private Usuario retornoUsuarioNome(String nome) {
    	return GerenciadorUsuarios.retornoUsuarioNome(nome);
    }

}
