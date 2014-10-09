/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import teste.jdbc.Contato;
import teste.jdbc.ContatoDao;

@WebServlet("/altera-contato")
public class AlteraContatoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try (ContatoDao dao = new ContatoDao()) {
            Contato contato = dao.buscarPorId(Long.valueOf(id));

            req.setAttribute("contato", contato);

            req.getRequestDispatcher("/WEB-INF/pages/altera-contato.jsp").forward(req, resp);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");

        Contato contato = new Contato();
        contato.setId(Long.valueOf(id));
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);

        try {
            if (request.getParameter("dataNascimento") != null && !request.getParameter("dataNascimento").isEmpty()) {
                Calendar dataNascimento = Calendar.getInstance();
                dataNascimento.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataNascimento")));
                contato.setDataNascimento(dataNascimento);
            }
        } catch (ParseException e) {
            throw new ServletException(e.getMessage());
        }

        try (ContatoDao dao = new ContatoDao()) {
            dao.edita(contato);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        request.getRequestDispatcher("/WEB-INF/pages/contato-alterado.jsp").forward(request, response);
    }
}