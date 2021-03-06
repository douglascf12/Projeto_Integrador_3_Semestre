package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.VooDAO;
import br.senac.tads3.pi03b.gruposete.models.Voo;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "BuscaVooServlet", urlPatterns = {"/BuscaVoo"})
public class BuscaVooServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/BuscaVoo.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VooDAO dao = new VooDAO();
        String pesquisa = request.getParameter("pesquisa");

        try {
            if ("".equals(pesquisa.trim())) {
                List<Voo> encontrados = dao.ListarVoo();
                request.setAttribute("encontrados", encontrados);
                request.setAttribute("pesquisa", pesquisa);
            } else {
                List<Voo> encontrados = dao.procurarVoo(pesquisa);
                request.setAttribute("encontrados", encontrados);
                request.setAttribute("pesquisa", pesquisa);
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ListaVoo.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BuscaVooServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
