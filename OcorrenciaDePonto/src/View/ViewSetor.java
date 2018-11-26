package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSetor extends JFrame {

	private JPanel contentPane;
	private JTable tableSetor;

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
		
		JScrollPane scrollPaneSetor = new JScrollPane();
		scrollPaneSetor.setBounds(10, 11, 415, 239);
		contentPane.add(scrollPaneSetor);
		
		tableSetor = new JTable();
		tableSetor.setModel(new DefaultTableModel(
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
		});
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
		btnExcluir.setBounds(237, 261, 89, 23);
		contentPane.add(btnExcluir);
	}

}
