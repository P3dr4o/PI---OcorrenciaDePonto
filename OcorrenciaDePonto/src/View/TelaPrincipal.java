package View;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import Model.Funcionario;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame{

	//protected static final DefaultTableCellRenderer DEFAULT_RENDERER = null;
	private JFrame frame;
	private JTable table;
	private ImageIcon iconAten;
	private ImageIcon iconOK;
	private JTable table_1;
	private Funcionario funcionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}

			}
		} catch (Exception e) {
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal(Funcionario f) {
		this.funcionario = f;
		initialize();
		rodar();
	}
	
	public TelaPrincipal() {
		initialize();
	}
	
	public static void rodar() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}

			}
		} catch (Exception e) {
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */

	/**
	 * 
	 */
	public void OrganizaJTable() {
		
		//código para deixar a tabela NÃO editável
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		DefaultTableModel modelo_1 = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		modelo.addColumn("Data Apontamento");
		modelo.addColumn("Horário de Trabalho");
		modelo.addColumn("Apontamentos");
		modelo.addColumn("Rendimento");
		modelo.addColumn("Descontos");
		modelo.addColumn("Banco de Horas");
		modelo.addColumn("Observações");

		// este codigo a seguir � apenas para ilustra��o da tabela
		modelo.addRow(new String[] { "01/09/2018 Sab", "", "", "", "", "", "Folga" });
		modelo.addRow(new String[] { "02/09/2018 Dom", "", "", "", "", "", "Folga" });
		modelo.addRow(new String[] { "03/09/2018 Seg", "07:00 12:00 13:00 17:00", "07:09 12:39 13:39 17:03", "", "", "",
				"" });
		modelo.addRow(new String[] { "04/09/2018 Ter", "07:00 12:00 13:00 17:00", "07:08 13:24 14:24 17:06", "", "", "",
				"" });
		modelo.addRow(new String[] { "05/09/2018 Qua", "07:00 12:00 13:00 17:00", "07:14 11:48 12:47 17:00", "", "", "",
				"" });
		modelo.addRow(new String[] { "06/09/2018 Qui", "07:00 12:00 13:00 17:00", "07:03 13:09", "", "", "", "" });
		modelo.addRow(new String[] { "07/09/2018 Sex", "", "", "", "", "", "Feriado" });
		modelo.addRow(new String[] { "08/09/2018 Sab", "", "", "", "", "", "Folga" });
		modelo.addRow(new String[] { "09/09/2018 Dom", "", "", "", "", "", "Folga" });
		modelo.addRow(new String[] { "10/09/2018 Seg", "07:00 12:00 13:00 17:00", "07:08 11:58 12:58 17:06", "", "", "",
				"" });
		modelo.addRow(new String[] { "11/09/2018 Ter", "07:00 12:00 13:00 17:00", "07:01 13:18 14:18 17:06", "", "", "",
				"" });
		modelo.addRow(new String[] { "12/09/2018 Qua", "07:00 12:00 13:00 17:00", "07:10 12:17 13:19 17:00", "",
				"00:12", "", "" });
		modelo.addRow(new String[] { "13/09/2018 Qui", "07:00 12:00 13:00 17:00", "07:00 12:31 13:32 18:06", "", "",
				"01:06", "" });
		modelo.addRow(new String[] { "14/09/2018 Sex", "07:00 12:00 13:00 16:00", "07:01 12:00 13:00 15:54", "", "", "",
				"" });

		table.setModel(modelo);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(1).setPreferredWidth(135);
		table.getColumnModel().getColumn(2).setPreferredWidth(135);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(6).setPreferredWidth(800);
		
		//código para NÃO deixar mover o cabeçalho da tabela
		table.getTableHeader().setReorderingAllowed(false);
		
		addCor(table);

		// table.getColumnModel().getColumn(6).setWidth(100);

		modelo_1.addColumn("Data da Ocorr�ncia");
		modelo_1.addColumn("Setor");
		modelo_1.addColumn("Data Apontamento");
		modelo_1.addColumn("Nome do Funcion�rio");

		modelo_1.addRow(new String[] { "14/09/2018 Sex", "Faturamento", "10/09/2018 Seg", "Sulem Gomes Pereira" });
		modelo_1.addRow(new String[] { "13/09/2018 Sex", "Qualidade", "13/09/2018 Qui", "Tamires Miranda Silva" });
		modelo_1.addRow(new String[] { "15/09/2018 Sab", "Compras", "04/09/2018 Ter", "Jo�o Pereira Neto" });

		table_1.setModel(modelo_1);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table_1.getColumnModel().getColumn(0).setPreferredWidth(110);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(110);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(500);
		addCor(table_1);

	}

	private void addCor(JTable tab) {
		
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(UIManager.getColor("Label.background"));

		for (int i = 0; i < tab.getModel().getColumnCount(); i++) {
		    tab.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		}
		tab.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
//				Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
//				        table, value, isSelected, hasFocus, row, column);
				super.getTableCellRendererComponent(tab, value, isSelected, hasFocus, row, column);
				// aqui voc� coloca a condi��o para pintar a linha, neste caso se o valor da
				// coluna 4 da linha for menor que 2 (table.getValueAt(row,4), aqui table � o
				// nome que est� no parametro ali em cima, row � a linha atual da verifica��o)
				// if (Float.valueOf(table.getValueAt(row, 4).toString()) < 2) {
				Color foreground, background;
				if (isSelected) {
					foreground = Color.WHITE;
					background = Color.orange;
				} else {
					if (row % 2 != 0) {
						setBackground(new Color(204, 204, 255));
						foreground = Color.black;
						background = new Color(204, 204, 255);
					} else {
						foreground = Color.black;
						background = Color.white;					}
				}
				
				setForeground(foreground);
			    setBackground(background);
				
				return this;
			}
		});
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icons\\icons8-cartao-de-ponto-48.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCadastrarUsurio = new JMenuItem("Usuário");
		mntmCadastrarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewFuncionario vf = new ViewFuncionario();
				vf.setVisible(true);
			}
		});
		mnCadastro.add(mntmCadastrarUsurio);
		
		JMenuItem mntmSetor = new JMenuItem("Setor");
		mntmSetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSetor vs = new ViewSetor();
				vs.setVisible(true);
			}
		});
		mnCadastro.add(mntmSetor);
		
		JMenuItem mntmCargo = new JMenuItem("Cargo");
		mntmCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCargo vc = new ViewCargo();
				vc.setVisible(true);
			}
		});
		mnCadastro.add(mntmCargo);

		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmListagemDeOcorrncias = new JMenuItem("Listagem de ocorr\u00EAncias");
		mnRelatrios.add(mntmListagemDeOcorrncias);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		scrollPane.setViewportView(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Meu registro de ponto", new ImageIcon("icons\\icons8-cart\u00E3o-de-ponto-filled-16.png"),
				panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();

		JMonthChooser monthChooser = new JMonthChooser();
		panel_3.add(monthChooser);

		JYearChooser yearChooser = new JYearChooser();
		panel_3.add(yearChooser);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewOcorrenciaDePonto vop = new ViewOcorrenciaDePonto();
				vop.setVisible(true);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				/*System.out.println(tabbedPane.getSelectedIndex());
				 * Essa fu��o utilizada dentro Sysout retorna o indice da aba que est� selecionada, talvez ajude pra alguma copisa
				 * */
				if (tabbedPane.getIconAt(1).equals(iconOK))
					tabbedPane.setIconAt(1, iconAten);
				else
					tabbedPane.setIconAt(1, iconOK);
			}
		});
		btnNewButton.setBackground(new Color(51, 255, 153));
		btnNewButton.setToolTipText("Novo formul\u00E1rio de ocorr\u00EAncia de ponto");
		btnNewButton.setIcon(new ImageIcon(
				"icons\\icons8-nova-ocorrencia-40.png"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(310)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(211).addComponent(btnNewButton).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(5)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(btnNewButton).addComponent(
						panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		panel.setLayout(gl_panel);

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		scrollPane_1.setViewportView(table);

		// panel_1.add(table, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		iconAten = new ImageIcon("icons\\icons8-aten\u00E7\u00E3o-16.png");
		iconOK = new ImageIcon("icons\\icons8-ok-16.png");
		tabbedPane.addTab("Ocorr\u00EAncias p/ aprovar", iconOK, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.NORTH);

		JPanel panel_5 = new JPanel();

		JLabel lblDescricao = new JLabel("Ocorr\u00EAncias pendentes de aprova\u00E7\u00E3o");
		lblDescricao.setBackground(UIManager.getColor("Label.background"));
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_5.add(lblDescricao);

		JButton button_1 = new JButton("");
		button_1.setBackground(new Color(0, 153, 204));
		button_1.setIcon(new ImageIcon(
				"icons\\icons8-\u00F3culos-40.png"));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addGap(216)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(133).addComponent(button_1).addContainerGap()));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING).addComponent(button_1).addComponent(
						panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2, BorderLayout.CENTER);

		scrollPane_2.setViewportView(table_1);
		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setSurrendersFocusOnKeystroke(true);
		scrollPane_2.setViewportView(table_1);
		// table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		OrganizaJTable();
	}
}
