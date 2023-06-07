package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class CalculadoraServico extends JFrame {

	double remuneracao, custo, hora, valor, total;
	int cargaHoraria, estimativa;
	
	DecimalFormat formatador = new DecimalFormat("#0.000");

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRemuneracao;
	private JTextField txtCusto;
	private JTextField txtCargaHoraria;
	private JTextField txtEstimativa;
	private JLabel lblValor;
	private JLabel lblTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraServico frame = new CalculadoraServico();
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
	public CalculadoraServico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalculadoraServico.class.getResource("/img/calc.png")));
		setTitle("Calculadora de serviços em TI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 400);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Remuneração mensal pertendida: ");
		lblNewLabel.setBounds(10, 28, 226, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Custo operacional mensal:");
		lblNewLabel_1.setBounds(10, 53, 195, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Carga horária mensal de trabalho: ");
		lblNewLabel_2.setBounds(10, 81, 213, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Valor da hora:");
		lblNewLabel_3.setBounds(10, 217, 112, 25);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Estimativa de horas do serviço: ");
		lblNewLabel_4.setBounds(10, 272, 195, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Total a ser cobrado do cliente: ");
		lblNewLabel_5.setBounds(10, 310, 195, 25);
		contentPane.add(lblNewLabel_5);

		txtRemuneracao = new JTextField();
		txtRemuneracao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtRemuneracao.setBounds(227, 25, 205, 20);
		contentPane.add(txtRemuneracao);
		txtRemuneracao.setColumns(10);
		
		txtCusto = new JTextField();
		txtCusto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCusto.setColumns(10);
		txtCusto.setBounds(227, 53, 205, 20);
		contentPane.add(txtCusto);

		txtCargaHoraria = new JTextField();
		txtCargaHoraria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCargaHoraria.setColumns(10);
		txtCargaHoraria.setBounds(227, 78, 205, 20);
		contentPane.add(txtCargaHoraria);

		txtEstimativa = new JTextField();
		txtEstimativa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtEstimativa.setColumns(10);
		txtEstimativa.setBounds(227, 269, 132, 20);
		contentPane.add(txtEstimativa);

		JButton btnCalcular = new JButton("");
		btnCalcular.setBorder(null);
		btnCalcular.setContentAreaFilled(false);
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.setIcon(new ImageIcon(CalculadoraServico.class.getResource("/img/calcu.png")));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular();
			}
		});
		btnCalcular.setBounds(81, 142, 92, 64);
		contentPane.add(btnCalcular);

		JButton btnLimpar = new JButton("");
		btnLimpar.setBorder(null);
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setIcon(new ImageIcon(CalculadoraServico.class.getResource("/img/borracha.png")));
		btnLimpar.setBounds(298, 142, 92, 64);
		contentPane.add(btnLimpar);

		lblValor = new JLabel("");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValor.setBounds(102, 217, 134, 25);
		contentPane.add(lblValor);

		lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(227, 310, 205, 25);
		contentPane.add(lblTotal);

		JButton lblTotal = new JButton("");
		lblTotal.setBorder(null);
		lblTotal.setToolTipText("Total");
		lblTotal.setContentAreaFilled(false);
		lblTotal.setIcon(new ImageIcon(CalculadoraServico.class.getResource("/img/calc.png")));
		lblTotal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				calcularTotal();
			}
		});
		lblTotal.setBounds(384, 251, 48, 48);
		contentPane.add(lblTotal);
	}

	private void LimparCampos() {
		txtRemuneracao.setText(null);
		txtCusto.setText(null);
		txtCargaHoraria.setText(null);
		txtEstimativa.setText(null);
		lblTotal.setText(null);
		lblValor.setText(null);
	}

	private void Calcular() {

		if (txtRemuneracao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Preecha a Remuneração mensal pretendida! ");
			txtRemuneracao.requestFocus();

		} else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Preecha o Custo operacional mensal! ");
			txtCusto.requestFocus();

		} else if (txtCargaHoraria.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Preecha a Carga horária mensal de trabalho! ");
			txtCargaHoraria.requestFocus();

		} else {
			remuneracao = Double.parseDouble(txtRemuneracao.getText());
			custo = Double.parseDouble(txtCusto.getText());
			cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());
			valor = (remuneracao + (0.3 * remuneracao) + (0.2 * remuneracao) + custo) / cargaHoraria;
			lblValor.setText("R$: " + formatador.format(valor));
		}
	}

	private void calcularTotal() {

		if (txtEstimativa.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Estimativa de Horas do Serviço!");
			txtEstimativa.requestFocus();

		} else {
			estimativa = Integer.parseInt(txtEstimativa.getText());
			total = estimativa * valor;
			lblTotal.setText("R$: " + formatador.format(total));
		}
	}
}
