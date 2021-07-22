package servlet;


import MyException.MyServletException;
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
        Cliente cliente= null;
        Amministratore amministratore = null;


        if(username != null && password!= null){
            if((amministratore = amministratoreDAO.doRetrieveByUsernamePassword(username, password)) != null){
                System.out.println(amministratore.getNome());
                session.setAttribute("username", username);
                session.setAttribute("amministratore", amministratore);
                response.sendRedirect("admin.jsp");
            }else {
                cliente = clienteDAO.doRetrieveByUsernamePassword(username, password);
            }
        }
        else
            try {
                throw new MyServletException("username o password non corretti");
            } catch (MyServletException e) {
                e.printStackTrace();
            }

        if(cliente != null) {
            session.setAttribute("username", username);
            session.setAttribute("pass", password);
        }

        assert cliente != null;

        if(amministratore == null) {
            response.sendRedirect("index.jsp");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }



}
