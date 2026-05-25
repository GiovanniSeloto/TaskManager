package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Equipe;
import Classes.GerenciadorProjeto;
import Classes.Projeto;

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

public class Projeto_Excluir extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GerenciadorProjeto gProjeto = new GerenciadorProjeto();
	private JTextField textFieldNomeProjetoExcluir;
	private JTextField textFieldDescricaoProjetoExcluir;
	private JTextField textFieldDataInicioDiaProjetoExcluir;
	private JTextField textFieldDataInicioMesProjetoExcluir;
	private JTextField textFieldDataInicioAnoProjetoExcluir;
	private JTextField textFieldDataTerminoDiaProjetoExcluir;
	private JTextField textFieldDataTerminoMesProjetoExcluir;
	private JTextField textFieldDataTerminoAnoProjetoExcluir;
	private JTextField textFieldStatusProjetoExcluir;
	private JTextField textFieldGerenteProjetoExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projeto_Excluir frame = new Projeto_Excluir();
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
	public Projeto_Excluir() {
		setResizable(false);
		setTitle("EXCLUIR PROJETO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblProjeto = new JLabel("PROJETO:");
		lblProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblProjeto_1 = new JLabel("NOME:");
		lblProjeto_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldNomeProjetoExcluir = new JTextField();
		textFieldNomeProjetoExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldNomeProjetoExcluir.setEditable(false);
		textFieldNomeProjetoExcluir.setColumns(10);
		
		JLabel lblProjeto_1_1 = new JLabel("DESCRIÇÃO:");
		lblProjeto_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldDescricaoProjetoExcluir = new JTextField();
		textFieldDescricaoProjetoExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDescricaoProjetoExcluir.setEditable(false);
		textFieldDescricaoProjetoExcluir.setColumns(10);
		
		JLabel lblProjeto_1_1_1 = new JLabel("DATA INICIO:");
		lblProjeto_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblDia = new JLabel("DIA:");
		lblDia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblMs = new JLabel("MÊS:");
		lblMs.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblAno = new JLabel("ANO:");
		lblAno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		textFieldDataInicioDiaProjetoExcluir = new JTextField();
		textFieldDataInicioDiaProjetoExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDataInicioDiaProjetoExcluir.setEditable(false);
		textFieldDataInicioDiaProjetoExcluir.setColumns(10);
		
		textFieldDataInicioMesProjetoExcluir = new JTextField();
		textFieldDataInicioMesProjetoExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDataInicioMesProjetoExcluir.setEditable(false);
		textFieldDataInicioMesProjetoExcluir.setColumns(10);
		
		textFieldDataInicioAnoProjetoExcluir = new JTextField();
		textFieldDataInicioAnoProjetoExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDataInicioAnoProjetoExcluir.setEditable(false);
		textFieldDataInicioAnoProjetoExcluir.setColumns(10);
		
		JLabel lblProjeto_1_1_1_1 = new JLabel("DATA TÉRMINO:");
		lblProjeto_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblDia_1 = new JLabel("DIA:");
		lblDia_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		textFieldDataTerminoDiaProjetoExcluir = new JTextField();
		textFieldDataTerminoDiaProjetoExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDataTerminoDiaProjetoExcluir.setEditable(false);
		textFieldDataTerminoDiaProjetoExcluir.setColumns(10);
		
		JLabel lblMs_1 = new JLabel("MÊS:");
		lblMs_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		textFieldDataTerminoMesProjetoExcluir = new JTextField();
		textFieldDataTerminoMesProjetoExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDataTerminoMesProjetoExcluir.setEditable(false);
		textFieldDataTerminoMesProjetoExcluir.setColumns(10);
		
		JLabel lblAno_1 = new JLabel("ANO:");
		lblAno_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		textFieldDataTerminoAnoProjetoExcluir = new JTextField();
		textFieldDataTerminoAnoProjetoExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDataTerminoAnoProjetoExcluir.setEditable(false);
		textFieldDataTerminoAnoProjetoExcluir.setColumns(10);
		
		JLabel lblProjeto_1_2 = new JLabel("STATUS:");
		lblProjeto_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblProjeto_1_3 = new JLabel("GERENTE:");
		lblProjeto_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textFieldStatusProjetoExcluir = new JTextField();
		textFieldStatusProjetoExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldStatusProjetoExcluir.setEditable(false);
		textFieldStatusProjetoExcluir.setColumns(10);
		
		textFieldGerenteProjetoExcluir = new JTextField();
		textFieldGerenteProjetoExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldGerenteProjetoExcluir.setEditable(false);
		textFieldGerenteProjetoExcluir.setColumns(10);
		
		JComboBox comboBoxExcluirProjeto = new JComboBox();
		JButton btnNewButtonExcluir = new JButton("EXCLUIR");
		btnNewButtonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarProjeto(comboBoxExcluirProjeto.getSelectedItem().toString());
				dispose();
			}
		});
		btnNewButtonExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				
		comboBoxExcluirProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto aux = solicitarProjetoNome((String) comboBoxExcluirProjeto.getSelectedItem());
				textFieldNomeProjetoExcluir.setText(aux.getNomeProjeto());
				textFieldDescricaoProjetoExcluir.setText(aux.getDescricao());
				textFieldDataInicioDiaProjetoExcluir.setText(String.valueOf(aux.getDataInicio_dia()));
				textFieldDataInicioMesProjetoExcluir.setText(String.valueOf(aux.getDataInicio_mes()));
				textFieldDataInicioAnoProjetoExcluir.setText(String.valueOf(aux.getDataInicio_ano()));
				textFieldDataTerminoDiaProjetoExcluir.setText(String.valueOf(aux.getDataTerminoPrevista_dia()));
				textFieldDataTerminoMesProjetoExcluir.setText(String.valueOf(aux.getDataTerminoPrevista_mes()));
				textFieldDataTerminoAnoProjetoExcluir.setText(String.valueOf(aux.getDataTerminoPrevista_ano()));
				textFieldStatusProjetoExcluir.setText(aux.getStatus().toString());
				textFieldGerenteProjetoExcluir.setText(aux.getGerenteResponsavel().getNomeUsuario());
			}
		});
		comboBoxExcluirProjeto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		solicitarTodosProjetos(comboBoxExcluirProjeto);
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblProjeto, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
											.addGap(30))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblProjeto_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblProjeto_1_1))
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBoxExcluirProjeto, 0, 296, Short.MAX_VALUE)
										.addComponent(textFieldNomeProjetoExcluir, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldDescricaoProjetoExcluir, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblProjeto_1_1_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(lblDia, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldDataInicioDiaProjetoExcluir, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(9)
									.addComponent(lblMs, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldDataInicioMesProjetoExcluir, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldDataInicioAnoProjetoExcluir, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblProjeto_1_1_1_1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblDia_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(textFieldDataTerminoDiaProjetoExcluir, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(9)
									.addComponent(lblMs_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textFieldDataTerminoMesProjetoExcluir, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblAno_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(textFieldDataTerminoAnoProjetoExcluir, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblProjeto_1_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
									.addComponent(textFieldStatusProjetoExcluir, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblProjeto_1_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
									.addComponent(textFieldGerenteProjetoExcluir, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButtonExcluir, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(161))))
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
							.addComponent(comboBoxExcluirProjeto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldNomeProjetoExcluir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldDescricaoProjetoExcluir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblProjeto_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblProjeto_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldDataInicioDiaProjetoExcluir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMs, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDia, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProjeto_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldDataInicioMesProjetoExcluir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldDataInicioAnoProjetoExcluir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(lblDia_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addComponent(textFieldDataTerminoDiaProjetoExcluir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(4)
									.addComponent(lblMs_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addComponent(textFieldDataTerminoMesProjetoExcluir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(4)
									.addComponent(lblAno_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addComponent(textFieldDataTerminoAnoProjetoExcluir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(lblProjeto_1_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblProjeto_1_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldStatusProjetoExcluir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldGerenteProjetoExcluir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProjeto_1_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(btnNewButtonExcluir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);

	}

	private void solicitarTodosProjetos(JComboBox comboBoxExcluirProjeto) {
		List<Projeto> aux = gProjeto.retornarTodosProjetos();
		comboBoxExcluirProjeto.addItem(null);
		for(Projeto u : aux)
			comboBoxExcluirProjeto.addItem(u.getNomeProjeto());
	}
	private void deletarProjeto(String projeto) {
		gProjeto.Deletar(projeto);
	}
	private Projeto solicitarProjetoNome(String nome) {
		return gProjeto.retornoProjetoNome(nome);
	}
}
