package trabalhofinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalhofinal.negocio.Cliente;

public class ClienteDAOImp implements ClienteDAO {
	@Override
	public String inserir(Cliente cli) {
		String sql = "insert into cliente(codCliente,rgCliente,enderecoCliente,bairroCliente,cidadeCliente,estadoCliente,CEPCliente,nascimentoCliente)values (?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, cli.getCodCliente());
			pst.setString(2, cli.getRgCliente());
			pst.setString(3, cli.getEnderecoCliente());
			pst.setString(4, cli.getBairroCliente());
			pst.setString(5, cli.getCidadeCliente());
			pst.setString(6, cli.getEstadoCliente());
			pst.setString(7, cli.getCepCliente());
			pst.setDate(8, cli.getNascimentoCliente());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String alterar(Cliente cli) {
		String sql = "update cliente set rgCliente=?,enderecoCliente=?,bairroCliente=?,cidadeCliente=?,estadoCliente=?,CEPCliente=?,nascimentoCliente=? where codCliente=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cli.getRgCliente());
			pst.setString(2, cli.getEnderecoCliente());
			pst.setString(3, cli.getBairroCliente());
			pst.setString(4, cli.getCidadeCliente());
			pst.setString(5, cli.getEstadoCliente());
			pst.setString(6, cli.getCepCliente());
			pst.setDate(7, cli.getNascimentoCliente());
			pst.setInt(8, cli.getCodCliente());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String excluir(Cliente cli) {
		String sql = "delete from cliente where codCliente=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, cli.getCodCliente());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Excluído com sucesso.";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Cliente> listarTodos() {
		String sql = "select * from cliente";
		Connection con = ConnectionFactory.getConnection();
		List<Cliente> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Cliente ep = new Cliente();
					ep.setCodCliente(rs.getInt(1));
					ep.setEnderecoCliente(rs.getString(2));
					ep.setRgCliente(rs.getString(3));
					ep.setBairroCliente(rs.getString(4));
					ep.setCidadeCliente(rs.getString(5));
					ep.setEstadoCliente(rs.getString(6));
					ep.setCepCliente(rs.getString(7));
					ep.setNascimentoCliente(rs.getDate(8));

					lista.add(ep);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public Cliente pesquisarPorCodCliente(int codCliente) {
		String sql = "select * from cliente where codCliente=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, codCliente);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Cliente ep = new Cliente();
				ep.setCodCliente(rs.getInt(1));
				ep.setRgCliente(rs.getString(2));
				ep.setEnderecoCliente(rs.getString(3));
				ep.setBairroCliente(rs.getString(4));
				ep.setCidadeCliente(rs.getString(5));
				ep.setEstadoCliente(rs.getString(6));
				ep.setCepCliente(rs.getString(7));
				ep.setNascimentoCliente(rs.getDate(8));
				return ep;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
}