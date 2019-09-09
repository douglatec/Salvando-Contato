import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class AdicionarContatoServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        PrintWriter out = httpServletResponse.getWriter();

        String nome = httpServletRequest.getParameter("nome");
        String email = httpServletRequest.getParameter("email");
        String endereco= httpServletRequest.getParameter("endereco");

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

        out.println("<html>");
        out.println("<body>");
        out.println("Contato " + contato.getNome() + " adicionado com sucesso");
        out.println("</body>");
        out.println("</html>");
    }

  }
