package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class Principal extends JFrame {
	// Instanciar OBJ JDBC
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStatus;
	private JLabel lblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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

	public Principal() {
		setFont(new Font("Bodoni MT", Font.ITALIC, 12));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/Relojoaleria.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				// Ativação da janela
				status();
				setarData();
			}
		});
		setTitle("Relojoaria Sistema OS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(117, 159, 164));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnUsuarios = new JButton("");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setToolTipText("Usuários");
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/usu.png")));
		btnUsuarios.setBounds(46, 73, 128, 128);
		contentPane.add(btnUsuarios);

		JButton btnSobre = new JButton("");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/about.png")));
		btnSobre.setBorder(null);
		btnSobre.setContentAreaFilled(false);
		btnSobre.setBounds(566, 11, 48, 48);
		contentPane.add(btnSobre);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(576, 364, 48, 48);
		contentPane.add(lblStatus);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/img/TTP.png")));
		lblLogo.setBounds(221, 144, 128, 128);
		contentPane.add(lblLogo);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 111, 111));
		panel.setBounds(0, 407, 624, 34);
		contentPane.add(panel);

		lblData = new JLabel("New label");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("Bodoni MT", Font.ITALIC, 20));
		panel.add(lblData);

		JLabel lblNewLabel = new JLabel("Relojoaria");
		lblNewLabel.setFont(new Font("Bodoni MT", Font.ITALIC, 30));
		lblNewLabel.setBounds(228, 11, 172, 59);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("TTP");
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(268, 283, 46, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setToolTipText("Relatório");
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/img/relatoiro.png")));
		btnNewButton.setBounds(402, 73, 128, 128);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
				//
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/img/Cliente.png")));
		btnNewButton_1.setToolTipText("Clientes");
		btnNewButton_1.setBounds(46, 223, 128, 128);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servicos servicos = new Servicos();
				servicos.setVisible(true);
				
			}
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setIcon(new ImageIcon(Principal.class.getResource("/img/serviço.png")));
		btnNewButton_2.setToolTipText("Serviço");
		btnNewButton_2.setBounds(402, 223, 128, 128);
		contentPane.add(btnNewButton_2);
	}

	private void status() {
		try {
			// abrir a conexão
			con = dao.conectar();
			if (con == null) {
				System.out.println(" Erro de conexão! ");
				lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/dboff.png")));
			} else {
				System.out.println(" Banco conectado! ");
				lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/dbon.png")));
			}
			// Nunca esquecer de fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}
	}// fim do metodo status()

	/**
	 * Metodo responsavel por setar a data no rodape
	 */
	private void setarData() {
		Date data = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		// alterar o texto da label pela data atual formatada
		lblData.setText(formatador.format(data));
		setLocationRelativeTo(null);
	}
}// O FIMMMMM
