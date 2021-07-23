package servlet;

import MyException.MyServletException;
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

@WebServlet("/CambioPasswordServlet")
public class CambioPasswordServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ClienteDAO clienteDAO= new ClienteDAO();
        String username= request.getParameter("username");
        System.out.println(username);
        String vecchiaPassword;
        String nuovaP;  //nuova password
        String ConfermaNP; //conferma nuova password
        Cliente cliente;
        RequestDispatcher requestDispatcher = null;
        if(username != null) {
            vecchiaPassword= request.getParameter("vecchiaPassword");
            nuovaP=  request.getParameter("password");
            ConfermaNP =  request.getParameter("conferma_password");
            if(nuovaP.equals(ConfermaNP)) {
                cliente = clienteDAO.doRetrieveByUsernamePassword(username, vecchiaPassword);
                if (cliente != null) {
                    try {
                        if(clienteDAO.updatePassword(nuovaP, username)){
                            requestDispatcher = request.getRequestDispatcher("index.jsp");
                        }else
                            requestDispatcher = request.getRequestDispatcher("ProfiloPrivato.jsp");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else{
            try {
                throw new MyServletException("Utente non loggato");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
