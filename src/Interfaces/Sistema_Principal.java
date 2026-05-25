package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sistema_Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PainelPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema_Principal frame = new Sistema_Principal();
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
	public Sistema_Principal() {
		setTitle("GERENCIADOR DE PROJETOS E EQUIPES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("PROJETOS");
		mnNewMenu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("CADASTRAR");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto_Cadastrar.main(null);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("ALTERAR");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto_Alterar.main(null);
			}
		});
		mntmNewMenuItem_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("EXCLUIR");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto_Excluir.main(null);
			}
		});
		mntmNewMenuItem_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_2_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("ABRIR");
		mntmNewMenuItem_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("USUARIOS");
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("CADASTRAR");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario_Cadastrar.main(null);
			}
		});
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ALTERAR");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario_Alterar.main(null);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("EXCLUIR");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario_Excluir.main(null);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("EQUIPES");
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("CADASTRAR");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipe_Cadastrar.main(null);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("ALTERAR");
		mntmNewMenuItem_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipe_Alterar.main(null);
			}
		});
		mntmNewMenuItem_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_2.add(mntmNewMenuItem_1_2);
		
		JMenuItem mntmNewMenuItem_2_2 = new JMenuItem("EXCLUIR");
		mntmNewMenuItem_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipe_Excluir.main(null);
			}
		});
		mntmNewMenuItem_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_2.add(mntmNewMenuItem_2_2);
		PainelPrincipal = new JPanel();
		PainelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PainelPrincipal);
		GroupLayout gl_painelPrincipal = new GroupLayout(PainelPrincipal);
		gl_painelPrincipal.setHorizontalGroup(
			gl_painelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 424, Short.MAX_VALUE)
		);
		gl_painelPrincipal.setVerticalGroup(
			gl_painelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
		);
		PainelPrincipal.setLayout(gl_painelPrincipal);

	}

}
