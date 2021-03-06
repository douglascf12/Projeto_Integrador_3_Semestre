package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

    public void inserir(Cliente cliente) throws SQLException, Exception {

        String sql = "INSERT INTO Cliente (nome, cpf, sexo, data_nasc, numero, cep, rua, estado, cidade, complemento, celular, telefone, email, ativo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getSexo());
            preparedStatement.setString(4, cliente.getData_nasc());
            preparedStatement.setInt(5, cliente.getNumero());
            preparedStatement.setString(6, cliente.getCep());
            preparedStatement.setString(7, cliente.getRua());
            preparedStatement.setString(8, cliente.getEstado());
            preparedStatement.setString(9, cliente.getCidade());
            preparedStatement.setString(10, cliente.getComplemento());
            preparedStatement.setString(11, cliente.getCelular());
            preparedStatement.setString(12, cliente.getTelefone());
            preparedStatement.setString(13, cliente.getEmail());
            preparedStatement.setBoolean(14, true);

            preparedStatement.executeUpdate();
        } finally {

            if (preparedStatement != null && !preparedStatement.isClosed()) {

                preparedStatement.close();

            }

            if (connection != null && !connection.isClosed()) {

                connection.close();

            }

        }
    }

    public void alterar(Cliente cliente) throws SQLException, Exception {
        String sql = "UPDATE cliente "
                + "SET nome = ?, "
                + "sexo = ?, "
                + "data_nasc = ?, "
                + "numero = ?, "
                + "cep = ?, "
                + "rua = ?, "
                + "estado = ?, "
                + "cidade = ?, "
                + "complemento = ?, "
                + "celular = ?, "
                + "telefone = ?, "
                + "email = ? "
                + "WHERE id_cliente = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSexo());
            preparedStatement.setString(3, cliente.getData_nasc());
            preparedStatement.setInt(4, cliente.getNumero());
            preparedStatement.setString(5, cliente.getCep());
            preparedStatement.setString(6, cliente.getRua());
            preparedStatement.setString(7, cliente.getEstado());
            preparedStatement.setString(8, cliente.getCidade());
            preparedStatement.setString(9, cliente.getComplemento());
            preparedStatement.setString(10, cliente.getCelular());
            preparedStatement.setString(11, cliente.getTelefone());
            preparedStatement.setString(12, cliente.getEmail());
            preparedStatement.setInt(13, cliente.getId());

            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void excluir(int id) throws SQLException, ClassNotFoundException {
        // Comando SQL.
        String slq = "UPDATE cliente SET ativo = ? WHERE id_cliente = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(slq);
            // Insercoes.
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);
            // Executa.
            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

    }

    public Cliente getClienteById(int id) throws SQLException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        String query = "SELECT * FROM cliente WHERE id_cliente = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                cliente.setId(resultSet.getInt("id_cliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setSexo(resultSet.getString("sexo"));
                cliente.setData_nasc(resultSet.getString("data_nasc"));
                cliente.setNumero(resultSet.getInt("numero"));
                cliente.setCep(resultSet.getString("cep"));
                cliente.setRua(resultSet.getString("rua"));
                cliente.setEstado(resultSet.getString("estado"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setComplemento(resultSet.getString("complemento"));
                cliente.setCelular(resultSet.getString("celular"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEmail(resultSet.getString("email"));
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return cliente;
    }

    public List<Cliente> ListarCliente() throws SQLException, ClassNotFoundException {
        List<Cliente> listaClientes = new ArrayList<>();
        String query = "SELECT * FROM Cliente WHERE ativo = true";

        try {
            connection = DbUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(resultSet.getInt("id_cliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setSexo(resultSet.getString("sexo"));
                cliente.setData_nasc(resultSet.getString("data_nasc"));
                cliente.setNumero(resultSet.getInt("numero"));
                cliente.setCep(resultSet.getString("cep"));
                cliente.setRua(resultSet.getString("rua"));
                cliente.setEstado(resultSet.getString("estado"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setComplemento(resultSet.getString("complemento"));
                cliente.setCelular(resultSet.getString("celular"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEmail(resultSet.getString("email"));

                listaClientes.add(cliente);
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaClientes;
    }

    public List<Cliente> procurarCliente(String busca) throws SQLException, ClassNotFoundException {
        List<Cliente> listaResultado = new ArrayList<>();

        String sql = "SELECT * FROM cliente WHERE"
                + " (estado = ?"
                + " OR celular = ?"
                + " OR cep = ?"
                + " OR complemento = ?"
                + " OR cpf = ?"
                + " OR data_nasc = ?"
                + " OR email = ?"
                + " OR nome = ?"
                + " OR numero = ?"
                + " OR rua = ?"
                + " OR sexo = ?"
                + " OR telefone = ?"
                + " OR cidade = ?)"
                + " AND ativo = true";

        connection = DbUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);

        // Insercoes.
        preparedStatement.setString(1, busca);
        preparedStatement.setString(2, busca);
        preparedStatement.setString(3, busca);
        preparedStatement.setString(4, busca);
        preparedStatement.setString(5, busca);
        preparedStatement.setString(6, busca);
        preparedStatement.setString(7, busca);
        preparedStatement.setString(8, busca);

        int buscaN = 0;
        try {
            buscaN = Integer.parseInt(busca);
        } catch (NumberFormatException w) {
            System.out.println("Erro");
        }
        preparedStatement.setInt(9, buscaN);

        preparedStatement.setString(10, busca);
        preparedStatement.setString(11, busca);
        preparedStatement.setString(12, busca);
        preparedStatement.setString(13, busca);

        try (ResultSet result = preparedStatement.executeQuery()) {
            while (result.next()) {
                Cliente clientes = new Cliente();

                clientes.setId(result.getInt("id_cliente"));
                clientes.setEstado(result.getString("estado"));
                clientes.setCelular(result.getString("celular"));
                clientes.setCep(result.getString("cep"));
                clientes.setComplemento(result.getString("complemento"));
                clientes.setCpf(result.getString("cpf"));
                clientes.setData_nasc(result.getString("data_nasc"));
                clientes.setEmail(result.getString("email"));
                clientes.setNome(result.getString("nome"));
                clientes.setNumero(result.getInt("numero"));
                clientes.setRua(result.getString("rua"));
                clientes.setSexo(result.getString("sexo"));
                clientes.setTelefone(result.getString("telefone"));
                clientes.setCidade(result.getString("cidade"));

                listaResultado.add(clientes);
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaResultado;
    }

    public Cliente getClienteByCPF(String cpf) throws SQLException, ClassNotFoundException {

        Cliente cliente = new Cliente();

        connection = DbUtil.getConnection();

        String query = "SELECT * FROM cliente WHERE cpf  = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cpf);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            cliente.setId(resultSet.getInt("id_cliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getString("cpf"));
            cliente.setSexo(resultSet.getString("sexo"));
            cliente.setData_nasc(resultSet.getString("data_nasc"));
            cliente.setNumero(resultSet.getInt("numero"));
            cliente.setCep(resultSet.getString("cep"));
            cliente.setRua(resultSet.getString("rua"));
            cliente.setEstado(resultSet.getString("estado"));
            cliente.setCidade(resultSet.getString("cidade"));
            cliente.setComplemento(resultSet.getString("complemento"));
            cliente.setCelular(resultSet.getString("celular"));
            cliente.setTelefone(resultSet.getString("telefone"));
            cliente.setEmail(resultSet.getString("email"));
        }

        preparedStatement.close();
        connection.close();
        return cliente;
    }

    public boolean verificarCPF(String cpf) throws SQLException, ClassNotFoundException {

        // Comando SQL.
        String slq = "SELECT COUNT(*) FROM cliente WHERE cpf = ? AND ativo = true";

        connection = DbUtil.getConnection();
        preparedStatement = connection.prepareStatement(slq);
        preparedStatement.setString(1, cpf);
        resultSet = preparedStatement.executeQuery();

        int numeroDeCounts = 0;

        while (resultSet.next()) {
            numeroDeCounts = resultSet.getInt("COUNT(*)");
        }
        connection.close();

        return numeroDeCounts != 0;

    }

}
