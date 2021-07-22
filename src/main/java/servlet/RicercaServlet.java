package servlet;


import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Ricerca")
public class RicercaServlet {

    private final ProdottoDAO prodottoDAO= new ProdottoDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        ArrayList<Prodotto> prodotti = prodottoDAO.doRetrieveByModelloorMarca(request.getParameter("ricerca"), 0, 10);
        request.setAttribute("prodotti", prodotti);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("ricerca.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        doGet(request, response);
    }

}
