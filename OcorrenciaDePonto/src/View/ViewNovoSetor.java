package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.FuncionarioController;
import Controller.SetorController;
import Model.Funcionario;
import Model.Setor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewNovoSetor extends JFrame {

	private JPanel contentPane;
	private JTextField txtSetor;
	private JTable tableNovoSetor;
	private JComboBox jcbFuncionarios;
	private JComboBox jcbSetores;
	private ArrayList<Setor> setores;
	private ArrayList<Funcionario> gestores;
	private DefaultTableModel modelo;
	

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
					ViewNovoSetor frame = new ViewNovoSetor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void carregarInformacoes() {
		setores = SetorController.getSetores();
		for (int i = 0; i < setores.size(); i++) {
			jcbSetores.addItem(setores.get(i).getNome());
		}
		gestores = FuncionarioController.getFuncionarios();
		for (int i = 0; i < gestores.size(); i++) {
			jcbFuncionarios.addItem(gestores.get(i).getNome_Funcionario());
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ViewNovoSetor() {
		
		modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		modelo.addColumn("Setor");
		modelo.addColumn("Setor Pai");
		modelo.addColumn("Gestor");
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 494, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setBounds(10, 11, 46, 14);
		contentPane.add(lblSetor);
		
		txtSetor = new JTextField();
		txtSetor.setBounds(66, 8, 303, 20);
		contentPane.add(txtSetor);
		txtSetor.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				modelo.addRow(new String[] { txtSetor.getText(), "setorTeste", "gestorTeste"});
				//modelo.addRow(new String[] { txtSetor.getText(), setores.get(jcbSetores.getSelectedIndex()).getNome(), gestores.get(jcbFuncionarios.getSelectedIndex()).getNome_Funcionario()});
				txtSetor.setText("");
				/*int idSetor =  0; //setor novo
				String[] a = gestores.get(jcbFuncionarios.getSelectedIndex());
				int idGestor = Integer.parseInt(a[0]);
				a = setores.get(jcbFuncionarios.getSelectedIndex());
				int setorPai = Integer.parseInt(a[0]);
				SetorController.salvarSetor(txtSetor.getText(), idSetor, idGestor , setorPai);*/
			}
		});
		btnAdicionar.setBounds(379, 64, 89, 23);
		contentPane.add(btnAdicionar);
		
		JScrollPane scrollPaneNovoSetor = new JScrollPane();
		scrollPaneNovoSetor.setBounds(10, 98, 458, 152);
		contentPane.add(scrollPaneNovoSetor);
		
		tableNovoSetor = new JTable();
		scrollPaneNovoSetor.setViewportView(tableNovoSetor);
		
		tableNovoSetor.setModel(modelo);

		tableNovoSetor.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(181, 261, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(280, 261, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(379, 261, 89, 23);
		contentPane.add(btnConcluir);
		
		JLabel lblGestor = new JLabel("Gestor");
		lblGestor.setBounds(10, 40, 46, 14);
		contentPane.add(lblGestor);
		
		jcbFuncionarios = new JComboBox(new String[] {"------"});
		jcbFuncionarios.setBounds(66, 37, 303, 20);
		contentPane.add(jcbFuncionarios);
		
		JLabel lblFilhoDe = new JLabel("Filho de:");
		lblFilhoDe.setBounds(10, 73, 46, 14);
		contentPane.add(lblFilhoDe);
		
		jcbSetores = new JComboBox(new String[] {"------"});
		jcbSetores.setBounds(66, 68, 303, 20);
		contentPane.add(jcbSetores);
		
 		
	}
}
