package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ViewFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNRegistro;
	private JTable tableFuncionario;
	private JButton btnNovo;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JLabel lblUsurio;
	private JTextField textField;
	private JLabel lblSenha;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFuncionario frame = new ViewFuncionario();
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
	public ViewFuncionario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 484, 179);
		panel.setBorder(new TitledBorder(null, "Dados do Funcion\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 70, 46, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 67, 408, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNRegistro = new JLabel("N\u00BA Registro");
		lblNRegistro.setBounds(10, 28, 80, 14);
		panel.add(lblNRegistro);
		
		txtNRegistro = new JTextField();
		txtNRegistro.setBounds(100, 25, 169, 20);
		panel.add(txtNRegistro);
		txtNRegistro.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 107, 46, 14);
		panel.add(lblCargo);
		
		JComboBox comboBoxCargo = new JComboBox();
		comboBoxCargo.setBounds(65, 104, 150, 20);
		panel.add(comboBoxCargo);
		
		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setBounds(249, 107, 46, 14);
		panel.add(lblSetor);
		
		JComboBox comboBoxSetor = new JComboBox();
		comboBoxSetor.setBounds(305, 104, 169, 20);
		panel.add(comboBoxSetor);
		
		lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(10, 143, 46, 14);
		panel.add(lblUsurio);
		
		textField = new JTextField();
		textField.setBounds(66, 140, 149, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(249, 146, 46, 14);
		panel.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(305, 143, 169, 20);
		panel.add(passwordField);
		
		JScrollPane scrollPaneFuncionario = new JScrollPane();
		scrollPaneFuncionario.setBounds(10, 235, 484, 274);
		contentPane.add(scrollPaneFuncionario);
		
		tableFuncionario = new JTable();
		tableFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00BA Registro", "Nome", "Cargo", "Setor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableFuncionario.getColumnModel().getColumn(0).setResizable(false);
		tableFuncionario.getColumnModel().getColumn(1).setResizable(false);
		tableFuncionario.getColumnModel().getColumn(2).setResizable(false);
		tableFuncionario.getColumnModel().getColumn(3).setResizable(false);
		
		//código para NÃO deixar mover o cabeçalho da tabela
		tableFuncionario.getTableHeader().setReorderingAllowed(false);
		
		scrollPaneFuncionario.setViewportView(tableFuncionario);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusBotoes(false, false, true, false, true);
			}
		});
		btnNovo.setBounds(10, 201, 89, 23);
		contentPane.add(btnNovo);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusBotoes(false, false, true, false, true);
			}
		});
		btnEditar.setBounds(109, 201, 89, 23);
		contentPane.add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(307, 201, 89, 23);
		contentPane.add(btnExcluir);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusBotoes(true, true, false, true, false);
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(208, 201, 89, 23);
		contentPane.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusBotoes(true, true, false, true, false);
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(406, 201, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	//metodo para mudar o status dos bot�es
		private void statusBotoes(boolean novo, boolean editar, boolean salvar, boolean excluir, boolean cancelar) {
			if(novo == true)
				btnNovo.setEnabled(true);
			else
				btnNovo.setEnabled(false);
			
			if(editar == true)
				btnEditar.setEnabled(true);
			else
				btnEditar.setEnabled(false);
			
			if(salvar == true) 
				btnSalvar.setEnabled(true);
			else
				btnSalvar.setEnabled(false);
			
			if(excluir == true)
				btnExcluir.setEnabled(true);
			else
				btnExcluir.setEnabled(false);
			
			if(cancelar == true)
				btnCancelar.setEnabled(true);
			else
				btnCancelar.setEnabled(false);
		}
		
		//metodo para mudar o status dos campos cnpj e razao social
		private void statusCampos(boolean editable) {
			/*if(editable == true) {
				txtCNPJ.setEditable(true);
				txtRazaoSocial.setEditable(true);
			} else {
				txtCNPJ.setEditable(false);
				txtRazaoSocial.setEditable(false);
			}*/
		}
}
