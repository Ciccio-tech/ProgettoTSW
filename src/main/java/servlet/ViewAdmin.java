package servlet;

import model.Amministratore;
import model.AmministratoreDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/ViewAdmin")
public class ViewAdmin extends HttpServlet {
    private final AmministratoreDAO adminDAO= new AmministratoreDAO();
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Amministratore> admin = null;
        try{
            admin=adminDAO.doRettieveAll();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("admin", admin);

        RequestDispatcher requestDispatcher= request.getRequestDispatcher("admin.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}

