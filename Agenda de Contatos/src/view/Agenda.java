package view;

import java.awt.Color;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import model.DAO;
import utils.Validador;

public class Agenda extends JFrame {
	//Instanciar OBJ JDBC
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JLabel lblStatus;
	private JButton btnAdicionar;
	private JButton btnDeletar;
	private JButton btnEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//Ativação da janela 
				status();
			}
		});
		setTitle("Agenda de contatos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Agenda.class.getResource("/img/Address Book (2).png")));
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 325);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 27, 23, 14);
		contentPane.add(lblNewLabel);

		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(82, 24, 110, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		JLabel txtID = new JLabel("Nome");
		txtID.setBounds(10, 66, 49, 14);
		contentPane.add(txtID);

		txtNome = new JTextField();
		txtNome.setBounds(82, 63, 257, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtNome.setDocument( new Validador(30));

		JLabel lblNewLabel_2 = new JLabel("Fone:");
		lblNewLabel_2.setBounds(10, 104, 31, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setBounds(10, 140, 38, 14);
		contentPane.add(lblNewLabel_3);

		txtFone = new JTextField();
		txtFone.setBounds(82, 101, 110, 20);
		contentPane.add(txtFone);
		txtFone.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(82, 137, 257, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		btnAdicionar = new JButton("");
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
			
		});
		btnAdicionar.setBorder(null);
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setToolTipText("Adicionar Contato");
		btnAdicionar.setIcon(new ImageIcon(Agenda.class.getResource("/img/add.png")));
		btnAdicionar.setBounds(66, 171, 64, 64);
		contentPane.add(btnAdicionar);

		btnDeletar = new JButton("");
		btnDeletar.setEnabled(false);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		btnDeletar.setToolTipText("Deletar");
		btnDeletar.setBorder(null);
		btnDeletar.setContentAreaFilled(false);
		btnDeletar.setIcon(new ImageIcon(Agenda.class.getResource("/img/delete (2).png")));
		btnDeletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeletar.setBounds(266, 171, 64, 64);
		contentPane.add(btnDeletar);

		btnEditar = new JButton("");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarContato();
			}
			
		});
		btnEditar.setBorder(null);
		btnEditar.setToolTipText("Editar");
		btnEditar.setContentAreaFilled(false);
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setIcon(new ImageIcon(Agenda.class.getResource("/img/edit (2).png")));
		btnEditar.setBounds(168, 171, 64, 64);
		contentPane.add(btnEditar);

		JButton btnApagar = new JButton("");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
				
			}
		});
		btnApagar.setBorder(null);
		btnApagar.setToolTipText("Apagar");
		btnApagar.setIcon(new ImageIcon(Agenda.class.getResource("/img/borracha.png")));
		btnApagar.setContentAreaFilled(false);
		btnApagar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnApagar.setBounds(351, 171, 64, 64);
		contentPane.add(btnApagar);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evento clicar no botão
				buscar();
			}
		});
		btnPesquisar.setBorder(null);
		btnPesquisar.setToolTipText("Pesquisa");
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnPesquisar.setIcon(new ImageIcon(Agenda.class.getResource("/img/Pesquise.png")));
		btnPesquisar.setBounds(338, 46, 48, 48);
		contentPane.add(btnPesquisar);
		
		lblStatus = new JLabel("");
		lblStatus.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		lblStatus.setToolTipText("");
		lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/Databases OFF.png")));
		lblStatus.setBounds(497, 227, 48, 48);
		contentPane.add(lblStatus);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clicar no botão sobre
				//mostra a janela sobre
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setBorder(null);
		btnSobre.setContentAreaFilled(false);
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setIcon(new ImageIcon(Agenda.class.getResource("/img/about.png")));
		btnSobre.setBounds(497, 11, 48, 48);
		contentPane.add(btnSobre);
		
		//substituir o click pela tecla enter em um botão
		getRootPane().setDefaultButton(btnPesquisar);
	
	}// FIM DO CONSTRUTOR
	

	/**
	 * Método responsável por limpar os campos
	 */
	private void LimparCampos() {
		textID.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		btnDeletar.setEnabled(false);
		btnEditar.setEnabled(false);
		btnAdicionar.setEnabled(false);
	}
	//Fim do metodo Limpar Campos()
	/**
	 * Metodo responsavel por exibir o status da conexão
	 */
	private void status () {
		try {
			//abrir a conexão
			con = dao.conectar();
			if (con == null) {
				//System.out.println(" Erro de conexão! ");
				lblStatus.setIcon(new ImageIcon (Agenda.class.getResource("/img/Databaeses OFF.png")));
			}else {
				//System.out.println(" Banco conectado! ");
				lblStatus.setIcon(new ImageIcon (Agenda.class.getResource("/img/Databaeses ON.png")));
			}
			//Nunca esquecer de fechar a conexão
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}//fim do metodo status()
	/**
	 * Método para buscar um contato pelo nome
	 */
	private void buscar() {
		//dica - testar o evento primeiro
		//System.out.println("teste do botão buscar");
		//criar uma variavel com a query (instrução do banco)
		String read = "select * from contatos where nome = ?";
		try {
			//abrir a conexão
			con = dao.conectar();
			//preparar a execução de query(intrução sql - CRUD Read)
			//
			pst = con.prepareStatement(read);
			pst.setString(1, txtNome.getText());
			//
			rs = pst.executeQuery();
			//
			//
			if(rs.next()) {
				//
				textID.setText(rs.getString(1));//
				txtFone.setText(rs.getString(3));//
				txtEmail.setText(rs.getString(4));//
				//validacao (liberacao dos botoes alterar e exclir)
				btnEditar.setEnabled(true);
				btnDeletar.setEnabled(true);
			}else {
			//System.out.println("Contatos não cadastrados");
			JOptionPane.showMessageDialog(null, "Contatos inexistente");
				btnAdicionar.setEnabled(true);
			}
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void adicionar() {
		//System.out.println(" !!!!TESTE!!!! ");
		//validação de campos obrigatorios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do contatos");
			txtNome.requestFocus();
		}else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o fone do contatos");
			txtFone.requestFocus();
		}else {
			//lógica principal
			String create = "insert into contatos (nome,fone,email)values (?,?,?)";
			//tratamento de exceções
			try {
				//abrir a conexão
				con = dao.conectar();
				
				pst = con.prepareStatement(create);
				
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null," Contatos adicionado! ");
				
				LimparCampos();
				
				con.close();
				
			}catch (Exception e) {
				System.out.println(e);
				
			}
		} 
		
	}//fim do método add
	/**
	 * Metodo para editar um contato (atenção! usar o id)
	 */
	private void editarContato() {
		//System.out.print("teste! ");
		//validação dos campos obrigatorios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome!");
			txtNome.requestFocus();
		}else if(txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o fone do contato");
			txtFone.requestFocus();
		}else {
			//
			//
			String update = "update contatos set nome=?,fone=?,email=? where id=?";
			//
			try {
				con = dao.conectar();
				pst = con.prepareStatement(update);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, textID.getText());
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, " Dados de contatos editados com sucesso! ");
				
				LimparCampos();
				con.close();
				
			}catch (Exception e) {
				System.out.print(e);
			}
			
		}
		
	}// fim do metodo editar
	/**
	 * 
	 */
	private void excluirContato() {
		//System.out.println("teste do botão");
		//validação de exclusão - a variavel comfirma captura a opção escolida
		int confirma = JOptionPane.showConfirmDialog(null, " Confirmar a exclusão desse contato? "," !!!Atenção!!! ", JOptionPane.YES_NO_OPTION);
		if(confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from contatos where id=?";
		
			try {
				con = dao.conectar();
				
				pst = con.prepareStatement(delete);
				
				pst.setString(1, textID.getText());
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, " Contato excluído! ");
				
				con.close();
			
			}
			
		catch (Exception e) {
			System.out.print(e);
		}
		}
	}//Fim do metodo excluir!
	
	
}// FIM DO CÓDIGO
