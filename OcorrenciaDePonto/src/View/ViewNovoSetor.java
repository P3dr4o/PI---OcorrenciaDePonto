package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewNovoSetor extends JFrame {

	private JPanel contentPane;
	private JTextField txtSetor;
	private JTable tableNovoSetor;
	private JTextField textField;

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

	/**
	 * Create the frame.
	 */
	public ViewNovoSetor() {
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
		btnAdicionar.setBounds(379, 36, 89, 23);
		contentPane.add(btnAdicionar);
		
		JScrollPane scrollPaneNovoSetor = new JScrollPane();
		scrollPaneNovoSetor.setBounds(10, 70, 458, 180);
		contentPane.add(scrollPaneNovoSetor);
		
		tableNovoSetor = new JTable();
		scrollPaneNovoSetor.setViewportView(tableNovoSetor);
		
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
		
		textField = new JTextField();
		textField.setBounds(66, 39, 303, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
