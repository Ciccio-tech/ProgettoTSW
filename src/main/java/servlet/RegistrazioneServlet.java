package servlet;

import MyException.MyServletException;
import model.ClienteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Registrazione")

public class RegistrazioneServlet extends HttpServlet {
    private ClienteDAO clienteDAO= new ClienteDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getSession().getAttribute("utente") != null){
            try {
                throw new MyServletException("Utente già loggato!");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }

        String username = request.getParameter("username");
        if(!(username != null && username.length()>= 6 && username.matches("^[0-9a-zA-Z]+$"))){
            try {
                throw new MyServletException("Username non valido");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }




    }
}
