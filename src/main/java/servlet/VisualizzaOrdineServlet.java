package servlet;

import model.Ordine;
import model.OrdineDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/VisualizzaOrdine")

public class VisualizzaOrdineServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        System.out.println("sERVLET");
        OrdineDAO ordineDAO= new OrdineDAO();
        String username = (String) session.getAttribute("username");
        System.out.println(username);
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
        requestDispatcher.include(request, response);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doGet(request, response);
    }
}
