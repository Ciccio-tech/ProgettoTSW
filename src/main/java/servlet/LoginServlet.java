package servlet;

import model.cliente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        cliente c=null;
        if(username!=null && password != null){
            //c=clienteDAO.doRetrieveByUsernamePassword(username, password);
        }

        if(c==null){
            throw new ServletException("Username e/o Password errati.");
        }
        request.getSession().setAttribute("utente", c);

        //da continuare
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}
