package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import Conexao.ConexaoBD;
import Controller.FuncionarioController;
import Controller.LoginController;
import Model.Funcionario;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame{

	private JFrame frame;
	private JTextField fieldUsuario;
	private JPasswordField fieldSenha;
	private Funcionario f;
	private TelaPrincipal tl;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void rodar() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icons\\icons8-cart�o-de-ponto-filled-16.png"));
		frame.getContentPane().setBackground(UIManager.getColor("Label.background"));
		frame.setBounds(100, 100, 450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		fieldUsuario = new JTextField();
		fieldUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					btnLogin.doClick();
			}
		});
		
		
	
		fieldUsuario.setText("Digite o seu usu\u00E1rio");
		fieldUsuario.selectAll();
		fieldUsuario.setBounds(130, 99, 213, 25);
		frame.getContentPane().add(fieldUsuario);
		fieldUsuario.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f = LoginController.verificaLogin(fieldUsuario.getText(), String.valueOf(fieldSenha.getPassword()));
				if(f != null)
					new TelaPrincipal(f);
					//tl.rodar();
				else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
					//tl = new TelaPrincipal(f);
					//tl.rodar();
				
					
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(51, 153, 255));
		btnLogin.setBounds(104, 161, 239, 34);
		frame.getContentPane().add(btnLogin);
		
		fieldSenha = new JPasswordField("Digite sua senha!");
		fieldSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				fieldSenha.setText("");
				fieldSenha.setEchoChar('●');			}
		});
		fieldSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					btnLogin.doClick();
			}
		});
		fieldSenha.setToolTipText("");
		fieldSenha.setBounds(130, 130, 213, 25);
		frame.getContentPane().add(fieldSenha);
		JLabel lblSen = new JLabel("");
		lblSen.setIcon(new ImageIcon("icons\\icons8-chave-2-16.png"));
		lblSen.setBounds(104, 130, 16, 20);
		frame.getContentPane().add(lblSen);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icons\\icons8-usu\u00E1rio-16.png"));
		label.setBounds(104, 99, 16, 20);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("icons\\Logo.png"));
		lblNewLabel.setBounds(94, 11, 262, 85);
		frame.getContentPane().add(lblNewLabel);
	}
}
