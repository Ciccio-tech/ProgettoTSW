package servlet;

import model.Cliente;
import model.ClienteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/AdminUtenti")

public class AdminUtentiServlet extends HttpServlet {
    private final ClienteDAO clienteDAO= new ClienteDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("servlet Utenti");
        ArrayList<Cliente> clienti = null;
        try {
            clienti = clienteDAO.doRettieveAll(0, 10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("clienti", clienti);

        RequestDispatcher requestDispatcher= request.getRequestDispatcher("admin.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
