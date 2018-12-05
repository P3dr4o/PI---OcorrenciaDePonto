package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.FuncionarioController;
import Controller.LoginController;
import Controller.Objetos;
import DAO.CargoDao;
import DAO.FuncionarioDao;
import DAO.SetorDao;
import Model.Cargo;
import Model.Funcionario;
import Model.Login;
import Model.Setor;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
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
	private JTextField texUsuario;
	private JLabel lblSenha;
	private JPasswordField passwordField;
	private ArrayList<Funcionario> listFuncionario;
	private Iterator<Funcionario> iterator;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 * 
	 */
	
	public void carregaTabela() {
		ArrayList<Funcionario> funcionarios = FuncionarioDao.selectAllFuncionarios();
		for (Funcionario fs : funcionarios) {
			modelo.addRow(new String[] {String.valueOf(fs.getNum_Registro()), fs.getNome_Funcionario()});
		}
		
	}
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
		
		JComboBox<Cargo> comboBoxCargo = new JComboBox<Cargo>();
		ArrayList<Cargo> cargos = CargoDao.selectAllCargos();
		comboBoxCargo.addItem(new Cargo(-1, "Selecione o cargo"));
		for(Cargo cargo : cargos) {
			comboBoxCargo.addItem(cargo);
		}
		
		
		comboBoxCargo.setBounds(65, 104, 150, 20);
		panel.add(comboBoxCargo);
		
		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setBounds(249, 107, 46, 14);
		panel.add(lblSetor);
		
		JComboBox<Setor> comboBoxSetor = new JComboBox<Setor>();
		ArrayList<Setor> setores = SetorDao.selectAllSetores();
		comboBoxSetor.addItem(new Setor("Selecione o setor", -1, null));
		for(Setor setor : setores) {
			comboBoxSetor.addItem(setor);
		}
		
		
		comboBoxSetor.setBounds(305, 104, 169, 20);
		
		
		
		panel.add(comboBoxSetor);
		
		lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(10, 143, 46, 14);
		panel.add(lblUsurio);
		
		texUsuario = new JTextField();
		texUsuario.setBounds(66, 140, 149, 20);
		panel.add(texUsuario);
		texUsuario.setColumns(10);
		
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
		modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {"nº Registro",
					"Nome" 
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
			carregaTabela();
			tableFuncionario.setModel(modelo);
		tableFuncionario.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableFuncionario.getColumnModel().getColumn(1).setPreferredWidth(400);	
	/*	tableFuncionario.getColumnModel().getColumn(0).setResizable(false);
		tableFuncionario.getColumnModel().getColumn(1).setResizable(false);
		tableFuncionario.getColumnModel().getColumn(2).setResizable(false);
		tableFuncionario.getColumnModel().getColumn(3).setResizable(false);*/
		
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
				//try {
					Cargo c = (Cargo) comboBoxCargo.getSelectedItem();
					Setor s = (Setor) comboBoxSetor.getSelectedItem();
					Funcionario f;
					Login l;
					if(txtNRegistro.getText() != null && txtNome.getText() != null && passwordField.getPassword() != null && texUsuario.getText() != null && c.getIdCargo() > 0 && s.getId_Setor() > 0) {
						f = new Funcionario(-1, txtNome.getText(), Integer.parseInt(txtNRegistro.getText()), c, s);
						int idFun = FuncionarioDao.gerarMaxID();
						
						l = new Login(texUsuario.getText(), LoginController.getMD5(""+passwordField.getPassword()), new Funcionario(idFun, "", 0, null));
						if(f.persistir() && l.persistir())
							JOptionPane.showMessageDialog(null, "Funcionário gravado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, "Erro ao gravar no banco de dados!", "", JOptionPane.ERROR_MESSAGE);	
					}else {
						JOptionPane.showMessageDialog(null, "Falta informação ou são inválidas!", null, JOptionPane.WARNING_MESSAGE);
					}
						
				//} catch (Exception e2) {
					// @TODO: handle exception
				//}
					modelo.addRow(new String[] { txtNRegistro.getText(), txtNome.getText() });
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
