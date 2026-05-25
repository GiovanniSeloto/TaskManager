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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Classes.Usuario;

public class Projeto_Cadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeProjeto;
	private JTextField textFieldDescricaoProjeto;
	private GerenciadorProjeto gProjeto = new GerenciadorProjeto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projeto_Cadastrar frame = new Projeto_Cadastrar();
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
	public Projeto_Cadastrar() {
		setTitle("CADASTRAR PROJETO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); 
		setBounds(100, 100, 544, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblDescrio = new JLabel("DESCRIÇÃO:");
		lblDescrio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblDataInicio = new JLabel("DATA INICIO:");
		lblDataInicio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblDataTermino = new JLabel("DATA TERMINO:");
		lblDataTermino.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblStatus = new JLabel("STATUS:");
		lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblGerente = new JLabel("GERENTE:");
		lblGerente.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldNomeProjeto = new JTextField();
		textFieldNomeProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldNomeProjeto.setColumns(10);
		
		textFieldDescricaoProjeto = new JTextField();
		textFieldDescricaoProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDescricaoProjeto.setColumns(10);
		
		JLabel lblDia = new JLabel("DIA:");
		lblDia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblDia_1 = new JLabel("DIA:");
		lblDia_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblDia_1_1 = new JLabel("MÊS:");
		lblDia_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblMs = new JLabel("MÊS:");
		lblMs.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblDia_1_2 = new JLabel("ANO:");
		lblDia_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblAno = new JLabel("ANO:");
		lblAno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JComboBox comboBoxDiaInicioProjeto = new JComboBox();
		comboBoxDiaInicioProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxDiaInicioProjeto, 1, 31);
		
		JComboBox comboBoxDiaTerminoProjeto = new JComboBox();
		comboBoxDiaTerminoProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxDiaTerminoProjeto, 1, 31);
		
		JComboBox comboBoxMesInicioProjeto = new JComboBox();
		comboBoxMesInicioProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxMesInicioProjeto, 1, 12);
		
		JComboBox comboBoxMesTerminoProjeto = new JComboBox();
		comboBoxMesTerminoProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxMesTerminoProjeto, 1, 12);
		
		JComboBox comboBoxAnoInicioProjeto = new JComboBox();
		comboBoxAnoInicioProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxAnoInicioProjeto, 2026, 2036);
		
		JComboBox comboBoxAnoTerminoProjeto = new JComboBox();
		comboBoxAnoTerminoProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		inserirValoresComboBox(comboBoxAnoTerminoProjeto, 2026, 2036);
		
		JComboBox comboBoxStatusProjeto = new JComboBox();
		comboBoxStatusProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxStatusProjeto.setModel(new DefaultComboBoxModel<>(StatusProjeto.values()));
		
		JComboBox comboBoxGerenteProjeto = new JComboBox();
		comboBoxGerenteProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		List<Usuario> aux = listaComUsuariosGerentes();
		for(Usuario i : aux) {
			comboBoxGerenteProjeto.addItem(i.getNomeUsuario());
		}
		
		JButton btnNewButtonSalvar = new JButton("SALVAR");
		btnNewButtonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gProjeto.Criar(
						textFieldNomeProjeto.getText(),
						textFieldDescricaoProjeto.getText(),
						Integer.parseInt(comboBoxDiaInicioProjeto.getSelectedItem().toString()),
						Integer.parseInt(comboBoxMesInicioProjeto.getSelectedItem().toString()),
						Integer.parseInt(comboBoxAnoInicioProjeto.getSelectedItem().toString()),
						Integer.parseInt(comboBoxDiaTerminoProjeto.getSelectedItem().toString()),
						Integer.parseInt(comboBoxMesTerminoProjeto.getSelectedItem().toString()),
						Integer.parseInt(comboBoxAnoTerminoProjeto.getSelectedItem().toString()),
						(StatusProjeto)comboBoxStatusProjeto.getSelectedItem(),
						retornoUsuarioNome(comboBoxGerenteProjeto.getSelectedItem().toString()));
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
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblDescrio, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldNomeProjeto, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldDescricaoProjeto, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(189)
							.addComponent(btnNewButtonSalvar, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGerente)
								.addComponent(lblStatus))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxGerenteProjeto, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxStatusProjeto, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(39, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDataTermino)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDataInicio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(47)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDia)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBoxDiaInicioProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblMs))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDia_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxDiaTerminoProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblDia_1_1)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBoxMesTerminoProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblDia_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBoxMesInicioProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(lblAno)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxAnoTerminoProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxAnoInicioProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldNomeProjeto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDescricaoProjeto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataInicio, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDia, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMs, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxAnoInicioProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxMesInicioProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxDiaInicioProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataTermino, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDia_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblDia_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboBoxMesTerminoProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBoxDiaTerminoProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblDia_1_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(comboBoxAnoTerminoProjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblGerente, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBoxStatusProjeto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxGerenteProjeto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(29)
					.addComponent(btnNewButtonSalvar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);

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
