package servlet;

import model.Cliente;
import model.ClienteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CambioPasswordServlet")
public class CambioPasswordServlet extends HttpServlet {
    ClienteDAO clienteDAO= new ClienteDAO();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getHeader("x-requested-with") != null) {
            String username= request.getParameter("username");
            String vecchiaPassword;
            String nuovaP;  //nuova password
            String ConfermaNP; //conferma nuova password
            Cliente cliente;
            if(username != null) {
                vecchiaPassword= request.getParameter("vecchiaPassword");
                nuovaP=  request.getParameter("password");
                ConfermaNP =  request.getParameter("conferma_password");
                if(nuovaP.equals(ConfermaNP)) {
                    cliente = clienteDAO.doRetrieveByUsernamePassword(username, vecchiaPassword);
                    if (cliente != null) {
                        try {
                            if(clienteDAO.updatePassword(nuovaP, username)){
                                response.setStatus(200);
                            }else
                                response.setStatus(500);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            else{
                response.setStatus(500);
            }
        }
        else{
            response.setStatus(500);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
