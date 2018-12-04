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
	private JComboBox jcbFuncionarios;
	private JComboBox jcbSetores;
	private ArrayList<Funcionario> gestores;

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
		gestores = FuncionarioController.getFuncionarios();
		for (int i = 0; i < gestores.size(); i++) {
			jcbFuncionarios.addItem(gestores.get(i).getNome_Funcionario());
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
				
				if(JOptionPane.showConfirmDialog(null, "Deseja realmente salvar?", "Salvar", JOptionPane.YES_NO_OPTION) == 0) {
					
				}
			}
		});
		btnSalvar.setBounds(121, 99, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(220, 99, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnConcluir = new JButton("Concluir");
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
		
 		
	}
}
