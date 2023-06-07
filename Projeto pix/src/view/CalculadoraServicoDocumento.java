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

public class CalculadoraServicoDocumento extends JFrame {
	Locale localeBR = new Locale("pt","BR");
	
	//variaveis
	double remuneracao,custo,hora,valor, total;
	int cargaHoraria,estimativa;
	
	NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

	/**
	 * 
	 */
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
					CalculadoraServicoDocumento frame = new CalculadoraServicoDocumento();
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
	public CalculadoraServicoDocumento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalculadoraServicoDocumento.class.getResource("/img/calc.png")));
		setTitle("Calculadora de serviços em TI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 400);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(143, 202, 142));
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
				//digitacao...
				String caracteres = "0123456789.";
				//Se na digitacao algum caractere nao permitdo
				if (!caracteres.contains(e.getKeyChar() + "")) {
					//ignorar
					e.consume();
				}
			}
		});
		txtRemuneracao.setBounds(227, 25, 132, 20);
		contentPane.add(txtRemuneracao);
		txtRemuneracao.setColumns(10);
		
		txtCusto = new JTextField();
		txtCusto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				//Se na digitacao algum caractere nao permitdo
				if (!caracteres.contains(e.getKeyChar() + "")) {
					//ignorar
					e.consume();
				}
			}
		});
		txtCusto.setColumns(10);
		txtCusto.setBounds(227, 53, 132, 20);
		contentPane.add(txtCusto);
		
		txtCargaHoraria = new JTextField();
		txtCargaHoraria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				//Se na digitacao algum caractere nao permitdo
				if (!caracteres.contains(e.getKeyChar() + "")) {
					//ignorar
					e.consume();
				}
			}
		});
		txtCargaHoraria.setColumns(10);
		txtCargaHoraria.setBounds(227, 78, 132, 20);
		contentPane.add(txtCargaHoraria);
		
		txtEstimativa = new JTextField();
		txtEstimativa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				//Se na digitacao algum caractere nao permitdo
				if (!caracteres.contains(e.getKeyChar() + "")) {
					//ignorar
					e.consume();
				}
			}
		});
		txtEstimativa.setColumns(10);
		txtEstimativa.setBounds(227, 269, 132, 20);
		contentPane.add(txtEstimativa);
		
		JButton btnCalcular = new JButton("");
		btnCalcular.setContentAreaFilled(false);
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.setIcon(new ImageIcon(CalculadoraServicoDocumento.class.getResource("/img/Cal.png")));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular();
			}
		});
		btnCalcular.setBounds(102, 145, 92, 64);
		contentPane.add(btnCalcular);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setIcon(new ImageIcon(CalculadoraServicoDocumento.class.getResource("/img/borracha.png")));
		btnLimpar.setBounds(315, 145, 92, 64);
		contentPane.add(btnLimpar);
		
		lblValor = new JLabel("");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValor.setBounds(102, 217, 118, 25);
		contentPane.add(lblValor);
		
		lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(227, 310, 132, 25);
		contentPane.add(lblTotal);
		
		JButton lblTotal = new JButton("");
		lblTotal.setContentAreaFilled(false);
		lblTotal.setIcon(new ImageIcon(CalculadoraServicoDocumento.class.getResource("/img/calcu.png")));
		lblTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularTotal();
				
			}
		});
		lblTotal.setBounds(386, 268, 48, 48);
		contentPane.add(lblTotal);
	}//Fim construtor
	
	private void LimparCampos() {
		txtRemuneracao.setText(null);
		txtCusto.setText(null);
		txtCargaHoraria.setText(null);
		txtEstimativa.setText(null);
		lblTotal.setText(null);
		lblValor.setText(null);
	}
	private void Calcular() {
		//tst do botão
		//System.out.print("tst!");
		
		//validacao de campos obrigatorios
		if (txtRemuneracao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Preecha a Remuneração mensal pretendida! ");
		txtRemuneracao.requestFocus();
		
		}else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Preecha o Custo operacional mensal! ");
			txtCusto.requestFocus();
			
		}else if (txtCargaHoraria.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Preecha a Carga horária mensal de trabalho! ");
			txtCargaHoraria.requestFocus();
			
		}else {
		
		//entrada
		remuneracao = Double.parseDouble(txtRemuneracao.getText());
		custo = Double.parseDouble(txtCusto.getText());
		// estimativa = Integer.parseInt(txtEstimativa.getText());
		cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());
		
		//processamento
		valor = (remuneracao + (0.3* remuneracao) + (0.2 * remuneracao) +custo) / cargaHoraria;
		//total = valor * estimativa;
		
		//saida
		//formatacao do resultado (numero de casas decimais)
		DecimalFormat formatador = new DecimalFormat("#0.000");
		lblValor.setText("R$: " + formatador.format(valor));
		
		//lblValor.setText(dinheiro.format(valor));
		//lblTotal.setText(dinheiro.format(total));
	}//
	
	}
	
	/**
	 * Metodo responsavel pelo calculo  do valor total do serviço
	 */
	private void calcularTotal() {
		//validacao de campos obrigatorios
	 if (txtEstimativa.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Preencha a Estimativa de Horas do Serviço!");
		txtEstimativa.requestFocus();
	}else {
		
		//entrada
		estimativa = Integer.parseInt(txtEstimativa.getText());
		//processando
		total = estimativa * valor;
		DecimalFormat formatador = new DecimalFormat("#0.000");
		lblTotal.setText("R$: " + formatador.format(total));
		}
	}
}//FIM
