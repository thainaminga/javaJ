package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.DAO;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Servicos extends JDialog {
	private JTextField txtOS;
	private JTextField txtData;
	private JTextField txtEquipamento;
	private JTextField txtValor;
	private JTextField txtID;
	private JTextField txtDefeito;
	
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private JTextField txtCliente;
	private JLabel lblID;
	private JScrollPane scrollPaneClientes;
	private JList listClientes;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servicos dialog = new Servicos();
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
	public Servicos() {
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPaneClientes.setVisible(false);
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Servicos.class.getResource("/img/serviço.png")));
		setModal(true);
		setBounds(100, 100, 529, 465);
		getContentPane().setLayout(null);
		
		JLabel lblOS = new JLabel("OS*");
		lblOS.setBounds(28, 25, 46, 20);
		getContentPane().add(lblOS);
		
		txtOS = new JTextField();
		txtOS.setEditable(false);
		txtOS.setBounds(28, 45, 139, 20);
		getContentPane().add(txtOS);
		txtOS.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data*");
		lblNewLabel.setBounds(28, 85, 213, 22);
		getContentPane().add(lblNewLabel);
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBounds(28, 104, 234, 22);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Bujuteria*");
		lblNewLabel_1.setBounds(254, 148, 144, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setBounds(28, 148, 46, 20);
		getContentPane().add(lblNewLabel_2);
		
		txtEquipamento = new JTextField();
		txtEquipamento.setBounds(254, 167, 234, 20);
		getContentPane().add(txtEquipamento);
		txtEquipamento.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setBounds(28, 168, 209, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		
		getRootPane().setDefaultButton(btnBuscar);
		
		btnBuscar.setBounds(177, 44, 85, 23);
		getContentPane().add(btnBuscar);
		
		JButton bntAdicionar = new JButton("Adicionar");
		bntAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		bntAdicionar.setBounds(28, 379, 89, 23);
		getContentPane().add(bntAdicionar);
		
		JButton bntEditar = new JButton("Editar");
		bntEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarOS();
			}
		});
		bntEditar.setBounds(152, 379, 89, 23);
		getContentPane().add(bntEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirOS();
			}
		});
		btnExcluir.setBounds(274, 379, 89, 23);
		getContentPane().add(btnExcluir);
		
		JLabel lblNewLabel_3 = new JLabel("Defeito*");
		lblNewLabel_3.setBounds(28, 223, 57, 17);
		getContentPane().add(lblNewLabel_3);
		
		txtDefeito = new JTextField();
		txtDefeito.setBounds(28, 238, 460, 64);
		getContentPane().add(txtDefeito);
		txtDefeito.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnLimpar.setBounds(400, 379, 89, 23);
		getContentPane().add(btnLimpar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(272, 28, 206, 99);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCliente = new JTextField();
		txtCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarClientes();			}
		});
		
		scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setVisible(false);
		scrollPaneClientes.setBounds(10, 41, 186, 39);
		panel.add(scrollPaneClientes);
		
		listClientes = new JList();
		listClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClientesLista();		
				}
		});
		scrollPaneClientes.setViewportView(listClientes);
		txtCliente.setBounds(10, 23, 186, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(10, 60, 86, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		lblID = new JLabel("ID*");
		lblID.setBounds(10, 42, 100, 20);
		panel.add(lblID);
		
		JButton btnNewButton = new JButton("Pesquisa");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(107, 59, 89, 23);
		panel.add(btnNewButton);

	}
	private void LimparCampos() {
		txtCliente.setText(null);
		txtOS.setText(null);
		txtData.setText(null);
		txtEquipamento.setText(null);
		txtDefeito.setText(null);
		txtValor.setText(null);
		txtID.setText(null);

		//scrollPaneServico.setVisible(false);

		////(os,dataOS,equipamento,defeito,valor,idcli)
		//btnDeletar.setEnabled(false);
		//btnEditar.setEnabled(false);
		//btnAdicionar.setEnabled(false);

	}// Fim do metodo Limpar Campos()
	private void buscar() {
		String numOS = JOptionPane.showInputDialog("Número da OS ");
		
		String read = "select * from servicos where os = ?";
		try {
			
			con = dao.conectar();
			
			pst = con.prepareStatement(read);
			
			pst.setString(1, numOS);
			
			rs = pst.executeQuery();
			
			
			if (rs.next()) {
				//
				
				txtOS.setText(rs.getString(1));//
				txtData.setText(rs.getString(2));//
				txtEquipamento.setText(rs.getString(3));//
				txtDefeito.setText(rs.getString(4));//
				txtValor.setText(rs.getString(5));//
				txtID.setText(rs.getString(6));//
				
				
				//btnEditar.setEnabled(true);
				//btnDeletar.setEnabled(true);
				
			} else {
				
				JOptionPane.showMessageDialog(null, "Serviço inexistente! ");
				//btnAdicionar.setEnabled(true);

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void adicionar() {
		 if (txtEquipamento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Bijuteria para o serviço! ");
			txtEquipamento.requestFocus();

		} else if (txtID.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o ID do cliente!");
			txtID.requestFocus();

		} else {

			
			String create = "insert into servicos (equipamento,defeito,valor,idcli)values (?,?,?,?)";
			
			try {

				
				con = dao.conectar();

				pst = con.prepareStatement(create);

				pst.setString(1, txtEquipamento.getText());
				pst.setString(2, txtDefeito.getText());
				pst.setString(3, txtValor.getText());
				pst.setString(4, txtID.getText());

				pst.executeUpdate();

				JOptionPane.showMessageDialog(null, " Serviço adicionado! ");

				LimparCampos();

				con.close();

			}

			catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Serviço não adicionado.\nEsta OS já está sendo utilizado.");
				txtOS.setText(null);
				txtOS.requestFocus();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}

	}
	private void editarOS() {
		 if (txtEquipamento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite a bijuteria do cliente ");
			txtEquipamento.requestFocus();

		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite a defeito do cliente ");
			txtDefeito.requestFocus();

		} else {
			// logica principal
			// CRUD - Update
			String update = "update servicos set os =?, equipamento=?, defeito=? where idcli=?";
			// trat de exceção
			try {
				// abrir conexão
				con = dao.conectar();
				// preparar a query
				pst = con.prepareStatement(update);
				pst.setString(1, txtOS.getText());
				pst.setString(2, txtEquipamento.getText());
				pst.setString(3, txtDefeito.getText());
				pst.setString(4, txtID.getText());
				// Executar query
				pst.executeUpdate();
				// confirmar para o user
				JOptionPane.showMessageDialog(null, "Dados do serviço editado com sucesso! ");
				// limpar campos
				LimparCampos();
				// fechar conexao
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}

	private void excluirOS() {
		int confirma = JOptionPane.showConfirmDialog(null, " Confirmar a exclusão desse serviço? ", " !!!Atenção!!! ",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from servicos where idcli=?";

			try {
				con = dao.conectar();

				pst = con.prepareStatement(delete);

				pst.setString(1, txtID.getText());

				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, " Serviço excluído! ");
				LimparCampos();

				con.close();

			}

			catch (Exception e) {
				System.out.print(e);
			}
		}
	}
		private void listarClientes() {
			
			DefaultListModel<String> modelo = new DefaultListModel<>();
			
			listClientes.setModel(modelo);

			String readLista = "select *from clientes where nome like '" + txtCliente.getText() + "%'" + "order by nome";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readLista);
				rs = pst.executeQuery();
				
				while (rs.next()) {
					
					scrollPaneClientes.setVisible(true);
					
					modelo.addElement(rs.getString(2));

					if (txtCliente.getText().isEmpty()) {
						scrollPaneClientes.setVisible(false);
					}

				} 
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		private void buscarClientesLista() {
			
			int linha = listClientes.getSelectedIndex();
			if (linha >= 0) {
				String readBuscaLista = "select *from clientes where nome like '" + txtCliente.getText() + "%'"
						+ "order by nome limit " + (linha) + " ,1";
				try {
					con = dao.conectar();
					pst = con.prepareStatement(readBuscaLista);
					rs = pst.executeQuery();
					if (rs.next()) {
						scrollPaneClientes.setVisible(false);

						txtID.setText(rs.getString(1));//
						txtCliente.setText(rs.getString(2));//
						
					} else {
						JOptionPane.showMessageDialog(null, "Cliente inexistente! ");

					}
					con.close();
				} catch (Exception e) {

				}

			} else {
				scrollPaneClientes.setVisible(false);

			}
		}
}
