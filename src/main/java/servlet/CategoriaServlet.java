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

@WebServlet("/Categorie")

public class CategoriaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        /*
        System.out.println("servlet Categorie");
        String q= request.getQueryString();
        q= q.replaceAll("\\D+", "");

         */
        String tipo= request.getParameter("tipo");
        System.out.println(tipo);
        ProdottoDAO prodottoDAO= new ProdottoDAO();
        ArrayList<Prodotto> prodotti = null;
        try {
            prodotti= prodottoDAO.doRetrieveDyTipo(tipo);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(prodotti != null){
            request.setAttribute("products", prodotti);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("fotocamere.jsp");
        requestDispatcher.include(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doGet(request, response);
    }
}
