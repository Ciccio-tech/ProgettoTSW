package servlet;


import MyException.MyServletException;
import model.Cliente;
import model.ClienteDAO;


//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet( "/LoginServlet")
public class LoginServlet extends HttpServlet {
    final ClienteDAO clienteDAO= new ClienteDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username= request.getParameter("username");
        String password= request.getParameter("pass");
        Cliente cliente= null;
        if(username != null && password!= null){
            cliente = clienteDAO.doRetrieveByUsernamePassword(username, password);
        }
        else
            try {
                throw new MyServletException("username o password non corretti");
            } catch (MyServletException e) {
                e.printStackTrace();
            }

        assert cliente != null;

        response.sendRedirect("index.jsp");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }



}
