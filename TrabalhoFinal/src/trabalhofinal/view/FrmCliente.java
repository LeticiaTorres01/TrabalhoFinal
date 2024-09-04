package trabalhofinal.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import trabalhofinal.controller.ClienteController;
import trabalhofinal.negocio.Cliente;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FrmCliente extends JFrame {

	private JLabel lblMensagem;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblConsulta;
	private JTextField txtEndereco;
	private JTextField txtIDCliente;
	private JTextField txtRgCliente;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtNascimentoCliente;
	private JTextField txtCepCliente;
	private JTextField txtEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
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
	public FrmCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 546, Short.MAX_VALUE)))
					.addGap(2))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addGap(6))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String codCliente = tblConsulta.getValueAt(linha, 0).toString();
				String rgCliente = tblConsulta.getValueAt(linha, 1).toString();
				String endereco = tblConsulta.getValueAt(linha, 3).toString();
				String bairro = tblConsulta.getValueAt(linha, 2).toString();
				String cidade = tblConsulta.getValueAt(linha, 3).toString();
				String estado = tblConsulta.getValueAt(linha, 3).toString();
				String cepCliente = tblConsulta.getValueAt(linha, 3).toString();
				String nascimento = tblConsulta.getValueAt(linha, 3).toString();
				txtIDCliente.setText(codCliente);
				txtRgCliente.setText(rgCliente);
				txtEndereco.setText(endereco);
				txtBairro.setText(bairro);
				txtCidade.setText(cidade);
				txtEstado.setText(estado);
				txtCepCliente.setText(cepCliente);
				txtNascimentoCliente.setText(nascimento);
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Cliente", "RG", "Endereço"/*"Endere\u00E7o"*/, "Bairro", "Cidade", "Estado", "CEP", "Data de Nascimento"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(4).setResizable(false);
		tblConsulta.getColumnModel().getColumn(5).setResizable(false);
		tblConsulta.getColumnModel().getColumn(6).setResizable(false);
		tblConsulta.getColumnModel().getColumn(7).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente emp = new Cliente();
				ClienteController ec = new ClienteController();
				emp.setCodCliente(Integer.parseInt(txtIDCliente.getText()));
				emp.setRgCliente(txtRgCliente.getText());
				emp.setEnderecoCliente(txtEndereco.getText());
				emp.setBairroCliente(txtBairro.getText());
				emp.setCidadeCliente(txtCidade.getText());
				emp.setEstadoCliente(txtEstado.getText());
				emp.setCepCliente(txtCepCliente.getText());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		        try {
		            java.util.Date utilDate = formatter.parse(txtNascimentoCliente.getText());
		            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		            emp.setNascimentoCliente(sqlDate);
		        } catch (ParseException ex) {
		            ex.printStackTrace();
		        }
				lblMensagem.setText(ec.alterar(emp));
			}
		});
		btnAlterar.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente emp = new Cliente();
				ClienteController cc = new ClienteController();
				emp.setCodCliente(Integer.parseInt(txtIDCliente.getText()));
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse Cliente: "+txtIDCliente.getText()+"?","Exclusão",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
				lblMensagem.setText(cc.excluir(emp));
				}
			}
		});
		btnExcluir.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Cliente> listaEmp = new ArrayList<Cliente>();
				ClienteController cc = new ClienteController();
				listaEmp = cc.listarTodos();
				DefaultTableModel tbm =(DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
				tbm.removeRow(i);
				}
				int i = 0;
				for(Cliente ep : listaEmp){
				tbm.addRow(new String[1]);
				tblConsulta.setValueAt(ep.getCodCliente(), i, 0);
				tblConsulta.setValueAt(ep.getRgCliente(), i, 1);
				tblConsulta.setValueAt(ep.getEnderecoCliente(), i, 2);
				tblConsulta.setValueAt(ep.getBairroCliente(), i, 3);
				tblConsulta.setValueAt(ep.getCidadeCliente(), i, 4);
				tblConsulta.setValueAt(ep.getEstadoCliente(), i, 5);
				tblConsulta.setValueAt(ep.getCepCliente(), i, 6);
				tblConsulta.setValueAt(ep.getNascimentoCliente(), i, 7);
				i++;
				}
			}
		});
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIDCliente.setText("");
				txtRgCliente.setText("");
				txtEndereco.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				txtEstado.setText("");
				txtCepCliente.setText("");
				txtNascimentoCliente.setText("");
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
					tbm.removeRow(i);
				}
			}
		});
		btnLimpar.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmCliente.this.dispose();
			}
		});
		btnSair.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnNewButton_1 = new JButton("Inserir");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente emp = new Cliente();
				ClienteController cc = new ClienteController();
				emp.setCodCliente(Integer.parseInt(txtIDCliente.getText()));
				emp.setRgCliente(txtRgCliente.getText());
				emp.setEnderecoCliente(txtEndereco.getText());
				emp.setBairroCliente(txtBairro.getText());
				emp.setCidadeCliente(txtCidade.getText());
				emp.setEstadoCliente(txtEstado.getText());
				emp.setCepCliente(txtCepCliente.getText());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		        try {
		            java.util.Date utilDate = formatter.parse(txtNascimentoCliente.getText());
		            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		            emp.setNascimentoCliente(sqlDate);
		        } catch (ParseException ex) {
		            ex.printStackTrace();
		        }
		        lblMensagem.setText(cc.inserir(emp));
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPesquisar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLimpar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblIdCliente = new JLabel("ID Cliente:");
		
		JLabel lblRg = new JLabel("RG:");
		
		JLabel lblEndereo = new JLabel("Endereço:");
		
		JLabel lblBairro = new JLabel("Bairro:");
		
		JLabel lblCidade = new JLabel("Cidade:");
		
		JLabel lblEstado = new JLabel("Estado:");
		
		JLabel lblCep = new JLabel("CEP:");
		
		JLabel lblDataDeNascimento = new JLabel("Nascimento:");
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		
		txtIDCliente = new JTextField();
		txtIDCliente.setColumns(10);
		
		txtRgCliente = new JTextField();
		txtRgCliente.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		
		txtNascimentoCliente = new JTextField();
		txtNascimentoCliente.setColumns(10);
		
		txtCepCliente = new JTextField();
		txtCepCliente.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		
		lblMensagem = new JLabel("Mensagem:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIdCliente)
								.addComponent(lblRg)
								.addComponent(lblEndereo))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtIDCliente, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtRgCliente, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addComponent(txtEndereco, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addComponent(txtBairro, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addComponent(txtCidade, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
									.addGap(2))))
						.addComponent(lblBairro)
						.addComponent(lblCidade))
					.addGap(61)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblEstado)
									.addGap(46)
									.addComponent(txtEstado, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblCep)
									.addGap(69)
									.addComponent(txtCepCliente, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblDataDeNascimento)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNascimentoCliente, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
							.addGap(14))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMensagem)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdCliente)
						.addComponent(lblEstado)
						.addComponent(txtIDCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRg)
						.addComponent(lblCep)
						.addComponent(txtRgCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCepCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo)
						.addComponent(lblDataDeNascimento)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNascimentoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBairro)
								.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCidade)
								.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(lblMensagem)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

}
