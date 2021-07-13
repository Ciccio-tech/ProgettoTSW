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


@WebServlet( "/LoginServlet")
public class LoginServlet extends HttpServlet {
    static ClienteDAO clienteDAO= new ClienteDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        Cliente cliente = null;
        if(username != null && password!= null){
            cliente = clienteDAO.doRetrieveByUsernamePassword(username, password);
        }
        if(cliente == null) {
            try {
                throw new MyServletException("username o password non validi");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }
        request.getSession().setAttribute("cliente", cliente);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("../../webapp/index.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /*
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        boolean paying = session.getAttribute("wasPaying") == null ? false : (Boolean) session.getAttribute("wasPaying");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String page = new String();

        try {
            Cliente user = utente.doRetrieveByUsernamePassword(username);
            if (user != null ? user.getPassword().equals(password) : false){ //non è perfetto perché getpassword potrebbbe essere null
                session.setAttribute("user", user);
                session.setAttribute("isUser", true);
                session.removeAttribute("wasPaying");

                if (paying) {
                    request.getRequestDispatcher("/Billing").forward(request, response);
                } else page = "index.jsp";
            } else{
               /* UserBean administrator = admin.login(username, password);
                if (administrator != null){
                    session.setAttribute("isAdmin", true);
                    page = "amministratore.jsp";
                    session.removeAttribute("cart");
                } else throw new Exception();
            }
            response.sendRedirect(response.encodeURL(page));
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("warning", true);
            getServletContext().getRequestDispatcher(response.encodeURL("/index.jsp")).forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

     */

}
