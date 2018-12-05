package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.FuncionarioController;
import Controller.SetorController;
import DAO.SetorDao;
import Model.Funcionario;
import Model.Setor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JComboBox<String> jcbFuncionarios;
	private JComboBox<String> jcbSetores;
	private ArrayList<Funcionario> gestores = FuncionarioController.getFuncionarios();
	private ArrayList<Setor> setores = SetorController.getSetores();
	private Funcionario funcionario;
	private Setor setor;

	/**
	 * by Pedro e Junio
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
		for (int i = 0; i < gestores.size(); i++) {
			jcbFuncionarios.addItem(gestores.get(i).getNome_Funcionario());
		}
		for (int i = 0; i < setores.size(); i++) {
			jcbSetores.addItem(setores.get(i).getNome());
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ViewNovoSetor() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 436, 171);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setBounds(10, 11, 46, 14);
		contentPane.add(lblSetor);
		
		txtSetor = new JTextField();
		txtSetor.setBounds(66, 8, 342, 20);
		contentPane.add(txtSetor);
		txtSetor.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(txtSetor.getText() != "" && jcbFuncionarios.getSelectedIndex() != 0 && jcbSetores.getSelectedIndex() != 0) {
					funcionario = gestores.get(jcbFuncionarios.getSelectedIndex() - 1);
					setor = setores.get(jcbSetores.getSelectedIndex() - 1);
					if(JOptionPane.showConfirmDialog(null, "Deseja realmente salvar?", "Salvar", JOptionPane.YES_NO_OPTION) == 0) {
						if(SetorController.salvarSetor(txtSetor.getText(), new SetorDao().gerarMaxID(), funcionario, setor)) {
							JOptionPane.showMessageDialog(null, "Setor salvo com sucesso");
							txtSetor.setText("");
							jcbFuncionarios.setSelectedIndex(0);
							jcbSetores.setSelectedIndex(0);
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao salvar setor", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Informe todos os campos", "Alerta", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnSalvar.setBounds(121, 99, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Deseja cancelar esta operação?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
					txtSetor.setText("");
					jcbFuncionarios.setSelectedIndex(0);
					jcbSetores.setSelectedIndex(0);
				}
			}
		});
		btnCancelar.setBounds(220, 99, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ViewSetor vs = new ViewSetor();
				vs.setVisible(true);
				dispose();
			}
		});
		btnConcluir.setBounds(319, 99, 89, 23);
		contentPane.add(btnConcluir);
		
		JLabel lblGestor = new JLabel("Gestor");
		lblGestor.setBounds(10, 40, 46, 14);
		contentPane.add(lblGestor);
		
		jcbFuncionarios = new JComboBox(new String[] {"------"});
		jcbFuncionarios.setBounds(66, 37, 342, 20);
		contentPane.add(jcbFuncionarios);
		
		JLabel lblFilhoDe = new JLabel("Filho de:");
		lblFilhoDe.setBounds(10, 73, 46, 14);
		contentPane.add(lblFilhoDe);
		
		jcbSetores = new JComboBox(new String[] {"------"});
		jcbSetores.setBounds(66, 68, 342, 20);
		contentPane.add(jcbSetores);
		
		carregarInformacoes();
	}
}
