import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDAO {

    private Connection connection;

    public ContatoDAO() throws SQLException {
        this.connection = new ConnectionF().getConnection();
    }

    public void adicionar(ContatoEntity contato) {

        String query = "INSERT INTO contatos (nome,email,endereco) VALUES (?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}



