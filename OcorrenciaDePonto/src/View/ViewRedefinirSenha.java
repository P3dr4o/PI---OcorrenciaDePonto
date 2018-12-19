package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class ViewRedefinirSenha extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField txtSenha;
	private JPasswordField txtConfirmSenha;
	private String retorno;
	
	public String getRetorno() {
		return retorno;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewRedefinirSenha dialog = new ViewRedefinirSenha();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewRedefinirSenha() {
		setTitle("Redefinir Senha");
		setBounds(100, 100, 269, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblSenha = new JLabel("Digite uma senha");
		lblSenha.setBounds(10, 11, 99, 14);
		contentPanel.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 36, 233, 20);
		contentPanel.add(txtSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha");
		lblConfirmarSenha.setBounds(10, 78, 99, 14);
		contentPanel.add(lblConfirmarSenha);
		
		txtConfirmSenha = new JPasswordField();
		txtConfirmSenha.setBounds(10, 103, 233, 20);
		contentPanel.add(txtConfirmSenha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(String.valueOf(txtSenha.getPassword()).equals(String.valueOf(txtConfirmSenha.getPassword()))) {
							retorno = String.valueOf(txtSenha.getPassword());
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Digite a mesma senha", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						retorno = null;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
