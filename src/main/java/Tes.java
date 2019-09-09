
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tes {
    public static void main(String[] args) {


            String nome ="nome";
            String email = "email";
            String endereco= "teste";

            ContatoEntity contato = new ContatoEntity();
            contato.setNome(nome);
            contato.setEmail(email);
            contato.setEndereco(endereco);

            ContatoDAO dao = null;
            try {
                dao = new ContatoDAO();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            dao.adicionar(contato);




    }
}
