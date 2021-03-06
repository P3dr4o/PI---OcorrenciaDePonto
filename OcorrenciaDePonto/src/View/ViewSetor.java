package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import Controller.CargoController;
import Controller.SetorController;
import Model.Setor;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewSetor extends JFrame {

	private JPanel contentPane;
	private JTable tableSetor;
	private DefaultTableModel modelo;
	private ArrayList<Setor> listSetor = SetorController.getSetores();

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
					ViewSetor frame = new ViewSetor();
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
	public ViewSetor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPaneSetor = new JScrollPane();
		scrollPaneSetor.setBounds(10, 11, 415, 239);
		contentPane.add(scrollPaneSetor);
		
		tableSetor = new JTable();
		modelo = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Setor", "Gestor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tableSetor.setModel(modelo);
		for (int i = 0; i < listSetor.size(); i++) {
			Setor setor = listSetor.get(i);
			if(setor.getFuncionario() == null) {
				modelo.addRow(new String[] {
						setor.getNome(),
				});
			} else {
				modelo.addRow(new String[] {
						setor.getNome(),
						setor.getFuncionario().getNome_Funcionario()
				});
			}
		}
		tableSetor.getColumnModel().getColumn(0).setResizable(false);
		
		//código para NÃO deixar mover o cabeçalho da tabela
		tableSetor.getTableHeader().setReorderingAllowed(false);
		
		scrollPaneSetor.setViewportView(tableSetor);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewNovoSetor vns = new ViewNovoSetor();
				vns.setVisible(true);
			}
		});
		btnNovo.setBounds(336, 261, 89, 23);
		contentPane.add(btnNovo);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(tableSetor.getSelectedRow() != -1) {
					if(SetorController.excluirSetor(listSetor.get(tableSetor.getSelectedRow()).getId_Setor())) {
						listSetor.remove(tableSetor.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Setor apagado com sucesso");
						modelo.removeRow(tableSetor.getSelectedRow());
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao deletar setor: não é possível apagar um setor que possui setor pai ou um funcionario gestor",
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um setor para excluir", "Excluir", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		btnExcluir.setBounds(237, 261, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(tableSetor.getSelectedRow() != -1) {
					
					ViewNovoSetor vns = new ViewNovoSetor(listSetor.get(tableSetor.getSelectedRow()), true);
					vns.setVisible(true);
					dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um setor para Alterar", "Alterar", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAlterar.setBounds(138, 261, 89, 23);
		contentPane.add(btnAlterar);
	}
}
