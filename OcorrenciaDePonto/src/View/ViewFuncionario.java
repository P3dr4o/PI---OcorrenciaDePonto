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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNRegistro;
	private JComboBox<Cargo> comboBoxCargo;
	private JComboBox<Setor> comboBoxSetor;
	private JTable tableFuncionario;
	private JButton btnNovo;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JLabel lblUsurio;
	private JTextField txtUsuario;
	private JLabel lblSenha;
	private JPasswordField txtSenha;
	private ArrayList<Funcionario> listFuncionario;
	private ArrayList<Cargo> cargos;
	private ArrayList<Setor> setores;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 * 
	 */
	
	public void carregaTabela() {
		listFuncionario = FuncionarioDao.selectAllFuncionarios();
		for (Funcionario fs : listFuncionario) {
			modelo.addRow(new String[] {
						String.valueOf(fs.getNum_Registro()),
						fs.getNome_Funcionario(),
						fs.getCargo().getNomeCargo(),
						fs.getSetor().getNome()
					});
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
		txtNome.setEditable(false);
		txtNome.setBounds(66, 67, 408, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNRegistro = new JLabel("N\u00BA Registro");
		lblNRegistro.setBounds(10, 28, 80, 14);
		panel.add(lblNRegistro);
		
		txtNRegistro = new JTextField();
		txtNRegistro.setEditable(false);
		txtNRegistro.setBounds(100, 25, 169, 20);
		panel.add(txtNRegistro);
		txtNRegistro.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 107, 46, 14);
		panel.add(lblCargo);
		
		comboBoxCargo = new JComboBox<Cargo>();
		comboBoxCargo.setEnabled(false);
		cargos = CargoDao.selectAllCargos();
		comboBoxCargo.addItem(new Cargo(-1, "Selecione o cargo"));
		for(Cargo cargo : cargos) {
			comboBoxCargo.addItem(cargo);
		}
		
		
		comboBoxCargo.setBounds(65, 104, 150, 20);
		panel.add(comboBoxCargo);
		
		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setBounds(249, 107, 46, 14);
		panel.add(lblSetor);
		
		comboBoxSetor = new JComboBox<Setor>();
		comboBoxSetor.setEnabled(false);
		setores = SetorDao.selectAllSetores();
		comboBoxSetor.addItem(new Setor("Selecione o setor", -1, null));
		for(Setor setor : setores) {
			comboBoxSetor.addItem(setor);
		}
		
		
		comboBoxSetor.setBounds(305, 104, 169, 20);
		
		
		
		panel.add(comboBoxSetor);
		
		lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(10, 143, 46, 14);
		panel.add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(66, 140, 149, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(249, 146, 46, 14);
		panel.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setEditable(false);
		txtSenha.setBounds(305, 143, 169, 20);
		panel.add(txtSenha);
		
		JScrollPane scrollPaneFuncionario = new JScrollPane();
		scrollPaneFuncionario.setBounds(10, 235, 484, 274);
		contentPane.add(scrollPaneFuncionario);
		
		tableFuncionario = new JTable();
		modelo = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"n\u00BA Registro", "Nome", "Cargo", "Setor"
						}
					) {
						boolean[] columnEditables = new boolean[] {
							false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					};
		carregaTabela();
		tableFuncionario.setModel(modelo);
		tableFuncionario.getColumnModel().getColumn(0).setPreferredWidth(90);
		tableFuncionario.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableFuncionario.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableFuncionario.getColumnModel().getColumn(3).setPreferredWidth(100);
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
				statusCampos(true);
			}
		});
		btnNovo.setBounds(10, 201, 89, 23);
		contentPane.add(btnNovo);
		
		btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(tableFuncionario.getSelectedRow() != -1) {
					statusBotoes(false, false, true, false, true);
					statusCampos(true);
					txtNRegistro.setText((String) tableFuncionario.getValueAt(tableFuncionario.getSelectedRow(), 0));
					txtNome.setText((String) tableFuncionario.getValueAt(tableFuncionario.getSelectedRow(), 1));
					for(int i = 0; i < cargos.size(); i++) {
						if(cargos.get(i).getNomeCargo().equals(tableFuncionario.getValueAt(tableFuncionario.getSelectedRow(), 2))) {
							comboBoxCargo.setSelectedIndex(i + 1);
						}
					}
					for(int i = 0; i < setores.size(); i++) {
						if(setores.get(i).getNome().equals(tableFuncionario.getValueAt(tableFuncionario.getSelectedRow(), 3))) {
							comboBoxSetor.setSelectedIndex(i + 1);
						}
					}
					for(int i = 0; i < listFuncionario.size(); i++) {
						if(listFuncionario.get(i).getNum_Registro() ==  Integer.parseInt((String) tableFuncionario.getValueAt(tableFuncionario.getSelectedRow(), 0))) {
							txtUsuario.setText(listFuncionario.get(i).getLogin().getUsuario());
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um funcionário para Alterar", "Alterar", JOptionPane.WARNING_MESSAGE);
				}
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
				//try {
					Cargo c = (Cargo) comboBoxCargo.getSelectedItem();
					Setor s = (Setor) comboBoxSetor.getSelectedItem();
					Funcionario f;
					Login l;
					if(txtNRegistro.getText() != null && txtNome.getText() != null && txtSenha.getPassword() != null && txtUsuario.getText() != null && c.getIdCargo() > 0 && s.getId_Setor() > 0) {
						f = new Funcionario(-1, txtNome.getText(), Integer.parseInt(txtNRegistro.getText()), c, s);
						int idFun = FuncionarioDao.gerarMaxID();
						
						l = new Login(txtUsuario.getText(), LoginController.getMD5(""+txtSenha.getPassword()), new Funcionario(idFun, "", 0, null));
						if(f.persistir() && l.persistir()) {
							JOptionPane.showMessageDialog(null, "Funcionário gravado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
							modelo.addRow(new String[] { 
									txtNRegistro.getText(),
									txtNome.getText(),
									comboBoxCargo.getSelectedItem().toString(),
									comboBoxSetor.getSelectedItem().toString()
							});
							listFuncionario = FuncionarioDao.selectAllFuncionarios();
							limparCampos();
							statusBotoes(true, true, false, true, false);
							statusCampos(false);
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao gravar no banco de dados!", "", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Falta informação ou são inválidas!", null, JOptionPane.WARNING_MESSAGE);
					}
						
				//} catch (Exception e2) {
					// @TODO: handle exception
				//}
					
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(208, 201, 89, 23);
		contentPane.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				statusBotoes(true, true, false, true, false);
				statusCampos(false);
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
		
		//metodo para mudar o status dos campos
		private void statusCampos(boolean editable) {
			if(editable == true) {
				txtNRegistro.setEditable(true);
				txtNome.setEditable(true);
				comboBoxCargo.setEnabled(true);
				comboBoxSetor.setEnabled(true);
				txtUsuario.setEditable(true);
				txtSenha.setEditable(true);
			} else {
				txtNRegistro.setEditable(false);
				txtNome.setEditable(false);
				comboBoxCargo.setEnabled(false);
				comboBoxSetor.setEnabled(false);
				txtUsuario.setEditable(false);
			}
		}
		
		private void limparCampos() {
			txtNRegistro.setText("");
			txtNome.setText("");
			comboBoxCargo.setSelectedIndex(0);
			comboBoxSetor.setSelectedIndex(0);
			txtUsuario.setText("");
			txtSenha.setText("");
		}
}
