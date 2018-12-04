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
import DAO.CargoDao;
import Model.Cargo;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewCargo extends JFrame {

	private JPanel contentPane;
	private JTable tableCargo;
	private DefaultTableModel modelo;
	private ArrayList<Cargo> listCargo = new CargoDao().selectAllCargos();
	private Iterator<Cargo> iterator = listCargo.iterator(); 

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
					ViewCargo frame = new ViewCargo();
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
	public ViewCargo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneCargo = new JScrollPane();
		scrollPaneCargo.setBounds(10, 11, 415, 239);
		contentPane.add(scrollPaneCargo);
		
		tableCargo = new JTable();
		modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Cargos"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		while (iterator.hasNext()) {
			Cargo c = iterator.next();
			modelo.addRow(new String[] {
					c.getNomeCargo()
			});
		}
		tableCargo.setModel(modelo);
		tableCargo.getColumnModel().getColumn(0).setResizable(false);
		
		//código para NÃO deixar mover o cabeçalho da tabela
		tableCargo.getTableHeader().setReorderingAllowed(false);
		
		scrollPaneCargo.setViewportView(tableCargo);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewNovoCargo vnc = new ViewNovoCargo();
				vnc.setVisible(true);
			}
		});
		btnNovo.setBounds(336, 261, 89, 23);
		contentPane.add(btnNovo);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableCargo.getSelectedRow() != -1) {
					if(CargoController.excluirCargo(listCargo.get(tableCargo.getSelectedRow()).getIdCargo())) {
						listCargo.remove(tableCargo.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Cargo apagado com sucesso");
						modelo.removeRow(tableCargo.getSelectedRow());
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao deletar cargo: Verifique se existe algum funcionario relacionado a esse cargo",
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cargo para excluir", "Excluir", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnExcluir.setBounds(237, 261, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(tableCargo.getSelectedRow() != -1) {
					String cargoEdit = JOptionPane.showInputDialog(null, "Alterar", tableCargo.getValueAt(tableCargo.getSelectedRow(), 0));
					if(cargoEdit != null) {
						if(CargoController.alterarCargo(listCargo.get(tableCargo.getSelectedRow()).getIdCargo(), cargoEdit)) {
							listCargo.get(tableCargo.getSelectedRow()).setNomeCargo(cargoEdit);
							modelo.setValueAt(cargoEdit, tableCargo.getSelectedRow(), 0);
							JOptionPane.showMessageDialog(null, "Cargo alterado com sucesso");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao alterar cargo", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cargo para Alterar", "Excluir", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAlterar.setBounds(138, 261, 89, 23);
		contentPane.add(btnAlterar);
	}
}
