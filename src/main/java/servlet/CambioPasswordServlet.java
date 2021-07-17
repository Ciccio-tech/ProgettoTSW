package servlet;

import MyException.MyServletException;
import model.Cliente;
import model.ClienteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CambioPassword")
public class CambioPasswordServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session= request.getSession();
        ClienteDAO clienteDAO= new ClienteDAO();
        String username= request.getParameter("username");
        String vecchiaPassword;
        String nuovaP;  //nuova password
        String ConfermaNP; //conferma nuova password
        Cliente cliente;
        if(session != null) {
            vecchiaPassword= (String) session.getAttribute("vecchiaPassword");
            nuovaP= (String) session.getAttribute("nuovaPassword");
            ConfermaNP = (String) session.getAttribute("ConfermaNP");
            if(nuovaP.equals(ConfermaNP)) {
                cliente = clienteDAO.doRetrieveByUsernamePassword(username, vecchiaPassword);
                if (cliente != null)
                    cliente.setPassword(nuovaP);
            }
        }
        else{
            try {
                throw new MyServletException("Utente non loggato");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("index.jsp");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
