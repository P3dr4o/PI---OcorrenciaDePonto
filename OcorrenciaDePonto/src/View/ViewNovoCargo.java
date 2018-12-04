package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.CargoController;
import DAO.CargoDao;
import Model.Cargo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewNovoCargo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCargo;
	private JTable tableNovoCargo;
	private DefaultTableModel modelo;
	private CargoDao cg = new CargoDao();
	boolean teste;

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
					ViewNovoCargo frame = new ViewNovoCargo();
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
	public ViewNovoCargo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 494, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 11, 46, 14);
		contentPane.add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(66, 8, 303, 20);
		contentPane.add(txtCargo);
		txtCargo.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				modelo.addRow(new String[] {txtCargo.getText()});
				/*teste = cg.createCargo(new Cargo(cg.gerarMaxID(), txtCargo.getText()));
				if(teste)
					JOptionPane.showMessageDialog(null, "Salvo com sucesso", null, JOptionPane.OK_OPTION);
				else
					JOptionPane.showMessageDialog(null, "Erro ao gravar!", null, JOptionPane.ERROR_MESSAGE);*/
			}
		});
		btnAdicionar.setBounds(379, 7, 89, 23);
		contentPane.add(btnAdicionar);
		
		JScrollPane scrollPaneNovoCargo = new JScrollPane();
		scrollPaneNovoCargo.setBounds(10, 46, 458, 204);
		contentPane.add(scrollPaneNovoCargo);
		
		tableNovoCargo = new JTable();
		scrollPaneNovoCargo.setViewportView(tableNovoCargo);
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
		tableNovoCargo.setModel(modelo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Deseja realmente salvar?", "Salvar", JOptionPane.YES_NO_OPTION) == 0) {
					for(int i = 1; i <= modelo.getRowCount(); i++) {
						CargoController.salvarCargo((String) modelo.getValueAt(i - 1, 0));
					}
					limparTable(modelo);
					txtCargo.setText("");
					JOptionPane.showMessageDialog(null, "Salvo com sucesso");
				}
			}
		});
		btnSalvar.setBounds(181, 261, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar esta operação?", "Cancelar", JOptionPane.YES_NO_OPTION) == 0) {
					limparTable(modelo);
					txtCargo.setText("");
				}
			}
		});
		btnCancelar.setBounds(280, 261, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ViewCargo vc = new ViewCargo();
				vc.setVisible(true);
				dispose();
			}
		});
		btnConcluir.setBounds(379, 261, 89, 23);
		contentPane.add(btnConcluir);
	}
	
	private void limparTable(DefaultTableModel modelo) {
		for(int i = modelo.getRowCount(); i > 0; i--) {
			modelo.removeRow(i-1);
		}
	}
}
