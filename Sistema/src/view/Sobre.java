package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Cursor;
import java.awt.Color;

public class Sobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		getContentPane().setBackground(new Color(117, 160, 164));
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/about.png")));
		setTitle("Sobre");
		setBounds(100, 100, 510, 374);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Autor: Thaina J.M. Santos");
		lblNewLabel.setFont(new Font("Bodoni MT", Font.ITALIC, 15));
		lblNewLabel.setBounds(10, 308, 276, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sob a Licença MIT");
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(339, 256, 171, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Sobre.class.getResource("/img/mit-icon.png")));
		lblNewLabel_2.setBounds(339, 142, 128, 128);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Relojoaria");
		lblNewLabel_3.setFont(new Font("Bodoni MT", Font.ITALIC, 30));
		lblNewLabel_3.setBounds(163, 22, 222, 71);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Sobre.class.getResource("/img/TTP.png")));
		lblLogo.setBounds(33, 124, 128, 128);
		getContentPane().add(lblLogo);
		
		JLabel lblNewLabel_1_1 = new JLabel("TTP");
		lblNewLabel_1_1.setFont(new Font("Bodoni MT", Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(81, 263, 46, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JTextPane txtpnPolticaDeConsertos = new JTextPane();
		txtpnPolticaDeConsertos.setEditable(false);
		txtpnPolticaDeConsertos.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnPolticaDeConsertos.setFont(new Font("Bodoni MT", Font.ITALIC, 15));
		txtpnPolticaDeConsertos.setText("Sistema para gestão de consertos de bijuterioas");
		txtpnPolticaDeConsertos.setBounds(81, 78, 304, 35);
		getContentPane().add(txtpnPolticaDeConsertos);

	}
}
