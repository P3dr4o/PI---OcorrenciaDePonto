package View;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ViewOcorrenciaDePonto extends JFrame {

	private JPanel contentPane;
	private ButtonGroup bgEventos;
	private ButtonGroup bgSolicito;
	private ButtonGroup bgSolicito2;
	private JFormattedTextField txtChegadaAtrasada;
	private JFormattedTextField txtChegadaAntecipada;
	private JFormattedTextField txtSaidaAntecipada;
	private JTextField txtFuncionarioDaEnfermagem;
	private JLabel lblDia;
	private JFormattedTextField txtDia;
	private JFormattedTextField txtNDeHoras;
	private JLabel lblNDeHoras;
	private JRadioButton rdbtnBH;
	private JRadioButton rdbtnPagar;
	private JLabel lblParaODia;
	private JFormattedTextField txtParaODia;
	private JLabel lblFuncionarioDaEnfermagem;
	private JLabel lblJustificativa;
	private JButton btnSolicitar;
	private JButton btnCancelar;
	private JTextArea txtAreaJustificativa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOcorrenciaDePonto frame = new ViewOcorrenciaDePonto();
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
	public ViewOcorrenciaDePonto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 506, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblOcorrnciaDePonto = new JLabel("Ocorr\u00EAncia de Ponto");
		lblOcorrnciaDePonto.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcorrnciaDePonto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOcorrnciaDePonto.setBounds(78, 11, 321, 14);
		contentPane.add(lblOcorrnciaDePonto);
		
		JPanel panelEventos = new JPanel();
		panelEventos.setBorder(new TitledBorder(null, "Eventos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEventos.setBounds(10, 36, 469, 153);
		contentPane.add(panelEventos);
		panelEventos.setLayout(null);
		
		JRadioButton rdbtnChegadaAtrasada = new JRadioButton("Chegada Atrasada \u00E0s");
		rdbtnChegadaAtrasada.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(rdbtnChegadaAtrasada.isSelected() == true) {
					txtChegadaAtrasada.setEditable(true);
				} else {
					txtChegadaAtrasada.setEditable(false);
				}
				
			}
		});
		rdbtnChegadaAtrasada.setBounds(6, 21, 164, 23);
		panelEventos.add(rdbtnChegadaAtrasada);
		
		JRadioButton rdbtnChegadaAntecipada = new JRadioButton("Chegada Antecipada \u00E0s");
		rdbtnChegadaAntecipada.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(rdbtnChegadaAntecipada.isSelected() == true) {
					txtChegadaAntecipada.setEditable(true);
				} else {
					txtChegadaAntecipada.setEditable(false);
				}
				
			}
		});
		rdbtnChegadaAntecipada.setBounds(6, 47, 164, 23);
		panelEventos.add(rdbtnChegadaAntecipada);
		
		JRadioButton rdbtnAusenciaDeMarcPonto = new JRadioButton("Aus\u00EAncia de Marca\u00E7\u00E3o de Ponto");
		rdbtnAusenciaDeMarcPonto.setBounds(6, 73, 208, 23);
		panelEventos.add(rdbtnAusenciaDeMarcPonto);
		
		JRadioButton rdbtnNaoComparecimento = new JRadioButton("N\u00E3o Comparecimento");
		rdbtnNaoComparecimento.setBounds(6, 99, 164, 23);
		panelEventos.add(rdbtnNaoComparecimento);
		
		JRadioButton rdbtnSaidaAntecipada = new JRadioButton("Sa\u00EDda Antecipada");
		rdbtnSaidaAntecipada.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(rdbtnSaidaAntecipada.isSelected() == true) {
					txtSaidaAntecipada.setEditable(true);
				} else {
					txtSaidaAntecipada.setEditable(false);
				}
				
			}
		});
		rdbtnSaidaAntecipada.setBounds(6, 125, 138, 23);
		panelEventos.add(rdbtnSaidaAntecipada);
		
		bgEventos = new ButtonGroup();
		bgEventos.add(rdbtnSaidaAntecipada);
		bgEventos.add(rdbtnNaoComparecimento);
		bgEventos.add(rdbtnAusenciaDeMarcPonto);
		bgEventos.add(rdbtnChegadaAntecipada);
		bgEventos.add(rdbtnChegadaAtrasada);
		
		
		try {
			txtChegadaAtrasada = new JFormattedTextField(new MaskFormatter("##:## hs"));
			txtChegadaAntecipada = new JFormattedTextField(new MaskFormatter("##:## hs"));
			txtSaidaAntecipada = new JFormattedTextField(new MaskFormatter("##:## hs"));
			txtDia = new JFormattedTextField(new MaskFormatter("##/##/####"));
			txtNDeHoras = new JFormattedTextField(new MaskFormatter("##:## hs"));
			txtParaODia = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtChegadaAtrasada.setBounds(225, 22, 61, 20);
		txtChegadaAtrasada.setEditable(false);
		panelEventos.add(txtChegadaAtrasada);
		
		txtChegadaAntecipada.setBounds(225, 48, 61, 21);
		txtChegadaAntecipada.setEditable(false);
		panelEventos.add(txtChegadaAntecipada);
		
		txtSaidaAntecipada.setEditable(false);
		txtSaidaAntecipada.setBounds(225, 126, 61, 21);
		panelEventos.add(txtSaidaAntecipada);
		
		JPanel panelSolicito = new JPanel();
		panelSolicito.setBorder(new TitledBorder(null, "Solicito", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSolicito.setBounds(10, 200, 469, 60);
		contentPane.add(panelSolicito);
		panelSolicito.setLayout(null);
		
		JRadioButton rdbtnFolgaExtra = new JRadioButton("Folga Extra");
		rdbtnFolgaExtra.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(rdbtnFolgaExtra.isSelected() == true) {
					setBounds(getX(), getY(), 506, 477);
					btnSolicitar.setBounds(390, 415, 89, 23);
					btnCancelar.setBounds(291, 415, 89, 23);
					lblJustificativa.setBounds(16, 97, 82, 14);
					txtAreaJustificativa.setBounds(16, 117, 443, 74);
					panelSolicito.setBounds(10, 200, 469, 205);
					lblDia.setVisible(true);
					txtDia.setVisible(true);
				} else {
					txtDia.setText("");
					lblDia.setVisible(false);
					txtDia.setVisible(false);
				}
				
			}
		});
		rdbtnFolgaExtra.setBounds(6, 22, 109, 23);
		panelSolicito.add(rdbtnFolgaExtra);
		
		JRadioButton rdbtnHorasExtras = new JRadioButton("Horas Extras");
		rdbtnHorasExtras.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(rdbtnHorasExtras.isSelected() == true) {
					setBounds(getX(), getY(), 506, 568);
					btnSolicitar.setBounds(390, 505, 89, 23);
					btnCancelar.setBounds(291, 505, 89, 23);
					panelSolicito.setBounds(10, 200, 469, 292);
					lblJustificativa.setBounds(16, 181, 82, 14);
					txtAreaJustificativa.setBounds(16, 206, 443, 74);
					lblDia.setVisible(true);
					txtDia.setVisible(true);
					lblNDeHoras.setVisible(true);
					txtNDeHoras.setVisible(true);
					rdbtnBH.setVisible(true);
					rdbtnPagar.setVisible(true);
				} else {
					txtDia.setText("");
					txtNDeHoras.setText("");
					bgSolicito2.clearSelection();
					lblDia.setVisible(false);
					txtDia.setVisible(false);
					lblNDeHoras.setVisible(false);
					txtNDeHoras.setVisible(false);
					rdbtnBH.setVisible(false);
					rdbtnPagar.setVisible(false);
				}
				
			}
		});
		rdbtnHorasExtras.setBounds(167, 22, 109, 23);
		panelSolicito.add(rdbtnHorasExtras);
		
		JRadioButton rdbtnTrocaDePlantao = new JRadioButton("Troca de Plant\u00E3o");
		rdbtnTrocaDePlantao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(rdbtnTrocaDePlantao.isSelected() == true) {
					setBounds(getX(), getY(), 506, 568);
					btnSolicitar.setBounds(390, 505, 89, 23);
					btnCancelar.setBounds(291, 505, 89, 23);
					panelSolicito.setBounds(10, 200, 469, 292);
					lblJustificativa.setBounds(16, 181, 82, 14);
					txtAreaJustificativa.setBounds(16, 206, 443, 74);
					lblDia.setText("Do Dia:");
					lblDia.setVisible(true);
					txtDia.setVisible(true);
					lblParaODia.setVisible(true);
					txtParaODia.setVisible(true);
					lblFuncionarioDaEnfermagem.setVisible(true);
					txtFuncionarioDaEnfermagem.setVisible(true);
				} else {
					lblDia.setText("Dia:");
					txtDia.setText("");
					txtParaODia.setText("");
					txtFuncionarioDaEnfermagem.setText("");
					lblDia.setVisible(false);
					txtDia.setVisible(false);
					lblParaODia.setVisible(false);
					txtParaODia.setVisible(false);
					lblFuncionarioDaEnfermagem.setVisible(false);
					txtFuncionarioDaEnfermagem.setVisible(false);
				}
				
			}
		});
		rdbtnTrocaDePlantao.setBounds(335, 22, 128, 23);
		panelSolicito.add(rdbtnTrocaDePlantao);
		
		bgSolicito = new ButtonGroup();
		bgSolicito.add(rdbtnFolgaExtra);
		bgSolicito.add(rdbtnHorasExtras);
		bgSolicito.add(rdbtnTrocaDePlantao);
		
		lblDia = new JLabel("Dia:");
		lblDia.setBounds(16, 68, 59, 14);
		lblDia.setVisible(false);
		panelSolicito.add(lblDia);
		
		txtDia.setBounds(85, 65, 134, 21);
		txtDia.setVisible(false);
		panelSolicito.add(txtDia);
		
		txtNDeHoras.setBounds(108, 94, 111, 20);
		txtNDeHoras.setVisible(false);
		panelSolicito.add(txtNDeHoras);
		
		lblNDeHoras = new JLabel("N\u00BA de horas:");
		lblNDeHoras.setBounds(16, 97, 82, 14);
		lblNDeHoras.setVisible(false);
		panelSolicito.add(lblNDeHoras);
		
		rdbtnBH = new JRadioButton("B. H.");
		rdbtnBH.setBounds(90, 126, 82, 23);
		rdbtnBH.setVisible(false);
		panelSolicito.add(rdbtnBH);
		
		rdbtnPagar = new JRadioButton("Pagar");
		rdbtnPagar.setBounds(6, 126, 82, 23);
		rdbtnPagar.setVisible(false);
		panelSolicito.add(rdbtnPagar);
		
		bgSolicito2 = new ButtonGroup();
		bgSolicito2.add(rdbtnBH);
		bgSolicito2.add(rdbtnPagar);
		
		lblParaODia = new JLabel("Para o Dia:");
		lblParaODia.setBounds(229, 68, 82, 14);
		lblParaODia.setVisible(false);
		panelSolicito.add(lblParaODia);
		
		txtParaODia.setBounds(339, 65, 120, 20);
		txtParaODia.setVisible(false);
		panelSolicito.add(txtParaODia);
		
		lblFuncionarioDaEnfermagem = new JLabel("Funcion\u00E1rio da Enfermagem dispon\u00EDvel para troca:");
		lblFuncionarioDaEnfermagem.setBounds(97, 125, 303, 14);
		lblFuncionarioDaEnfermagem.setVisible(false);
		panelSolicito.add(lblFuncionarioDaEnfermagem);
		
		txtFuncionarioDaEnfermagem = new JTextField();
		txtFuncionarioDaEnfermagem.setBounds(16, 150, 443, 20);
		txtFuncionarioDaEnfermagem.setVisible(false);
		panelSolicito.add(txtFuncionarioDaEnfermagem);
		txtFuncionarioDaEnfermagem.setColumns(10);
		
		lblJustificativa = new JLabel("Justificativa:");
		lblJustificativa.setBounds(16, 181, 82, 14);
		panelSolicito.add(lblJustificativa);
		
		txtAreaJustificativa = new JTextArea();
		txtAreaJustificativa.setBounds(16, 206, 443, 74);
		panelSolicito.add(txtAreaJustificativa);
		
		btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setBounds(390, 271, 89, 23);
		contentPane.add(btnSolicitar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(291, 270, 89, 23);
		contentPane.add(btnCancelar);
		
		
	}
}
