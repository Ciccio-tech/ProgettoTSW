package servlet;


import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Ricerca")
public class RicercaServlet extends HttpServlet {

    private final ProdottoDAO prodottoDAO= new ProdottoDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ArrayList<Prodotto> prodotti = null;
        try {
            prodotti = prodottoDAO.doRetrieveByModelloorMarca(request.getParameter("ricerca"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("prodotti", prodotti);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("Catalogo.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doGet(request, response);
    }

}
