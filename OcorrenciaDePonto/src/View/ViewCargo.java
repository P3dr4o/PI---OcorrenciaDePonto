package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCargo extends JFrame {

	private JPanel contentPane;
	private JTable tableCargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		tableCargo.setModel(new DefaultTableModel(
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
		});
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
		btnExcluir.setBounds(237, 261, 89, 23);
		contentPane.add(btnExcluir);
	}

}
