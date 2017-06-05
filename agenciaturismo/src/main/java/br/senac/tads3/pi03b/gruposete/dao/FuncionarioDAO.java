package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Funcionario;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

    public void inserir(Funcionario funcionario) throws SQLException, Exception {
        String sql = "INSERT INTO Funcionario (nome, cpf, sexo, data_nasc, numero, "
                + "cep, rua, estado, cidade, complemento, celular, telefone, email, "
                + "cargo, filial, departamento, ativo, login, senha, acesso) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getCpf());
            preparedStatement.setString(3, funcionario.getSexo());
            preparedStatement.setString(4, funcionario.getData_nasc());
            preparedStatement.setInt(5, funcionario.getNumero());
            preparedStatement.setString(6, funcionario.getCep());
            preparedStatement.setString(7, funcionario.getRua());
            preparedStatement.setString(8, funcionario.getEstado());
            preparedStatement.setString(9, funcionario.getCidade());
            preparedStatement.setString(10, funcionario.getComplemento());
            preparedStatement.setString(11, funcionario.getCelular());
            preparedStatement.setString(12, funcionario.getTelefone());
            preparedStatement.setString(13, funcionario.getEmail());
            preparedStatement.setString(14, funcionario.getCargo());
            preparedStatement.setString(15, funcionario.getFilial());
            preparedStatement.setString(16, funcionario.getDepartamento());
            preparedStatement.setBoolean(17, true);
            preparedStatement.setString(18, funcionario.getLogin());
            preparedStatement.setString(19, funcionario.getSenha());
            preparedStatement.setString(20, funcionario.getAcesso());

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

    public void alterar(Funcionario func) throws SQLException, Exception {
        String sql = "UPDATE funcionario "
                + "SET nome = ?, "
                + "sexo = ?, "
                + "data_nasc = ?, "
                + "numero = ?, "
                + "cep = ?, "
                + "rua = ?, "
                + "cpf = ?, "
                + "estado = ?, "
                + "cidade = ?, "
                + "complemento = ?, "
                + "celular = ?, "
                + "telefone = ?, "
                + "email = ?, "
                + "cargo = ?, "
                + "filial = ?, "
                + "departamento = ?, "
                + "acesso = ? "
                + "WHERE id_funcionario = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, func.getNome());
            preparedStatement.setString(2, func.getSexo());
            preparedStatement.setString(3, func.getData_nasc());
            preparedStatement.setInt(4, func.getNumero());
            preparedStatement.setString(5, func.getCep());
            preparedStatement.setString(6, func.getRua());
            preparedStatement.setString(7, func.getCpf());
            preparedStatement.setString(8, func.getEstado());
            preparedStatement.setString(9, func.getCidade());
            preparedStatement.setString(10, func.getComplemento());
            preparedStatement.setString(11, func.getCelular());
            preparedStatement.setString(12, func.getTelefone());
            preparedStatement.setString(13, func.getEmail());
            preparedStatement.setString(14, func.getCargo());
            preparedStatement.setString(15, func.getFilial());
            preparedStatement.setString(16, func.getDepartamento());
            preparedStatement.setString(17, func.getAcesso());
            preparedStatement.setInt(18, func.getId());

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
        String slq = "UPDATE funcionario SET ativo = ? WHERE id_funcionario = ?";

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

    public Funcionario getFuncionarioById(int id) throws SQLException, ClassNotFoundException {
        Funcionario func = new Funcionario();
        String query = "SELECT * FROM funcionario WHERE id_funcionario = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                func.setId(resultSet.getInt("id_funcionario"));
                func.setCpf(resultSet.getString("cpf"));
                func.setNome(resultSet.getString("nome"));
                func.setSexo(resultSet.getString("sexo"));
                func.setData_nasc(resultSet.getString("data_nasc"));
                func.setNumero(resultSet.getInt("numero"));
                func.setCep(resultSet.getString("cep"));
                func.setRua(resultSet.getString("rua"));
                func.setEstado(resultSet.getString("estado"));
                func.setCidade(resultSet.getString("cidade"));
                func.setComplemento(resultSet.getString("complemento"));
                func.setCelular(resultSet.getString("celular"));
                func.setTelefone(resultSet.getString("telefone"));
                func.setEmail(resultSet.getString("email"));
                func.setCargo(resultSet.getString("cargo"));
                func.setFilial(resultSet.getString("filial"));
                func.setDepartamento(resultSet.getString("departamento"));
                func.setLogin(resultSet.getString("login"));
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            connection.close();
        }
        return func;
    }

    public List<Funcionario> ListaFuncionario() throws SQLException, ClassNotFoundException {
        List<Funcionario> listaFuncionario = new ArrayList<>();
        String query = "SELECT * FROM Funcionario ORDER BY nome WHERE ativo = true";

        try {
            connection = DbUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Funcionario func = new Funcionario();

                func.setCpf(resultSet.getString("cpf"));
                func.setNome(resultSet.getString("nome"));
                func.setSexo(resultSet.getString("sexo"));
                func.setData_nasc(resultSet.getString("data_nasc"));
                func.setNumero(resultSet.getInt("numero"));
                func.setCep(resultSet.getString("cep"));
                func.setRua(resultSet.getString("rua"));
                func.setEstado(resultSet.getString("estado"));
                func.setCidade(resultSet.getString("cidade"));
                func.setComplemento(resultSet.getString("complemento"));
                func.setCelular(resultSet.getString("celular"));
                func.setTelefone(resultSet.getString("telefone"));
                func.setEmail(resultSet.getString("email"));
                func.setCargo(resultSet.getString("cargo"));
                func.setFilial(resultSet.getString("filial"));
                func.setDepartamento(resultSet.getString("departamento"));

                listaFuncionario.add(func);
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaFuncionario;
    }

    public List<Funcionario> procurarFuncionario(String busca) throws SQLException, ClassNotFoundException {
        List<Funcionario> listaResultado = new ArrayList<>();
        String sql;

        if (busca.length() != 0) {

            sql = "SELECT * FROM funcionario WHERE"
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
                    + " OR cidade = ?"
                    + " OR cargo = ?"
                    + " OR filial = ?"
                    + " OR departamento = ?"
                    + " OR login = ?"
                    + " OR acesso = ?)"
                    + " AND ativo = true";

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
            preparedStatement.setString(9, busca);

            int n1 = 0;
            try {
                n1 = Integer.parseInt(busca);
            } catch (NumberFormatException e) {
                System.out.println("Erro");
            }
            preparedStatement.setInt(10, n1);
            preparedStatement.setString(11, busca);
            preparedStatement.setString(12, busca);
            preparedStatement.setString(13, busca);
            preparedStatement.setString(14, busca);
            preparedStatement.setString(15, busca);
            preparedStatement.setString(16, busca);
            preparedStatement.setString(17, busca);
            preparedStatement.setString(18, busca);

        } else {
            sql = "SELECT * FROM funcionario WHERE ativo = true";
            preparedStatement = connection.prepareStatement(sql);
        }

        try (ResultSet result = preparedStatement.executeQuery()) {
            while (result.next()) {
                Funcionario func = new Funcionario();

                func.setId(result.getInt("id_funcionario"));
                func.setEstado(result.getString("estado"));
                func.setCelular(result.getString("celular"));
                func.setCep(result.getString("cep"));
                func.setComplemento(result.getString("complemento"));
                func.setCpf(result.getString("cpf"));
                func.setData_nasc(result.getString("data_nasc"));
                func.setEmail(result.getString("email"));
                func.setNome(result.getString("nome"));
                func.setNumero(result.getInt("numero"));
                func.setRua(result.getString("rua"));
                func.setSexo(result.getString("sexo"));
                func.setTelefone(result.getString("telefone"));
                func.setCidade(result.getString("cidade"));
                func.setCargo(result.getString("cargo"));
                func.setFilial(result.getString("filial"));
                func.setDepartamento(result.getString("departamento"));

                listaResultado.add(func);
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

    public boolean verificarCPF(String cpf) throws SQLException, ClassNotFoundException {
        String slq = "SELECT COUNT(*) FROM funcionario WHERE cpf = ?";

        connection = DbUtil.getConnection();
        preparedStatement = connection.prepareStatement(slq);
        preparedStatement.setString(1, cpf);
        resultSet = preparedStatement.executeQuery();

        int numeroDeCounts = 0;

        while (resultSet.next()) {
            numeroDeCounts = resultSet.getInt("COUNT(*)");
        }
        connection.close();

        return numeroDeCounts < 1;
    }

    public Funcionario obterFuncionario(String userLogin, String passwordLogin) throws SQLException {
        Funcionario func = new Funcionario();
        String query = "SELECT * FROM Funcionario WHERE login = ? AND senha = ? AND ativo = true";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userLogin);
            preparedStatement.setString(2, passwordLogin);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String filial = resultSet.getString("filial");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String acesso = resultSet.getString("acesso");
                String cpf = resultSet.getString("cpf");

                func.setFilial(filial);
                func.setNome(nome);
                func.setLogin(login);
                func.setSenha(senha);
                func.setAcesso(acesso);
                func.setCpf(cpf);
                break;
            }

        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return func;
    }
}
