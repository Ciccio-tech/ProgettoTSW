package servlet;

import MyException.MyServletException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Registrazione")

public class RegistrazioneFormServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MyServletException {
        if (request.getSession().getAttribute("utente") != null) {
            throw new MyServletException("Utente loggato.");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MyServletException {
        doGet(request, response);
    }


}
