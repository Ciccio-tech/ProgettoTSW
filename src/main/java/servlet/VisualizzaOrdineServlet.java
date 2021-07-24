package servlet;

import model.Ordine;
import model.OrdineDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/VisualizzaOrdine")

public class VisualizzaOrdineServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        OrdineDAO ordineDAO= new OrdineDAO();
        String username = request.getParameter("username");
        if(username != null) {
            try {
                System.out.println(username);
                ArrayList<Ordine> ordini = ordineDAO.doRetrieveByUsername(username);
                System.out.println(ordini.get(1).getUsername());
                request.setAttribute("ordini", ordini);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("VisualizzaOrdine.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doGet(request, response);
    }
}
