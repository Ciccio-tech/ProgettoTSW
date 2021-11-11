package servlet;

import model.Amministratore;
import model.AmministratoreDAO;
import model.Cliente;
import model.ClienteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet( "/LoginServlet")
public class LoginServlet extends HttpServlet {
    final ClienteDAO clienteDAO= new ClienteDAO();
    final AmministratoreDAO amministratoreDAO = new AmministratoreDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session= request.getSession();
        String username= request.getParameter("username");
        String password= request.getParameter("pass");
        Cliente cliente;
        String page = new String();
        Amministratore amministratore;

        try {
            if(username != null && password!= null){
                if((amministratore = amministratoreDAO.doRetrieveByUsernamePassword(username, password)) != null){
                    session.setAttribute("username", username);
                    session.setAttribute("amministratore", amministratore);
                    page="admin.jsp";
                }else {
                   if( (cliente = clienteDAO.doRetrieveByUsernamePassword(username, password)) != null) {
                       session.setAttribute("username", username);
                       session.setAttribute("pass", password);
                       session.setAttribute("cliente", cliente);
                       page="index.jsp";
                   }
                }
            }
            if (page.length() == 0){
                request.setAttribute("warning", Boolean.TRUE);
                getServletContext().getRequestDispatcher(response.encodeURL("/Login.jsp")).forward(request, response);
            } else
                response.sendRedirect(response.encodeURL(page));
        }catch (Exception e) {
            response.sendRedirect("error.jsp");
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }



}
