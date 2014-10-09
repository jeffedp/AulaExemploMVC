/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import teste.jdbc.ContatoDao;

@WebServlet("/lista-contatos")
public class ListaContatosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ContatoDao dao = new ContatoDao()) {
            req.setAttribute("contatos", dao.getLista());
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        req.getRequestDispatcher("/WEB-INF/pages/lista-contatos.jsp").forward(req, resp);
    }
}
