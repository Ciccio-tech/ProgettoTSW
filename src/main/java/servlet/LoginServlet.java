package servlet;

import model.Cliente;
import model.ClienteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/LoginServlet")
public class LoginServlet extends HttpServlet {
    static ClienteDAO utente;


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
                session.setAttribute("isUser", new Boolean(true));
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
                } else throw new Exception();*/
            }
            response.sendRedirect(response.encodeURL(page));
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("warning", new Boolean (true));
            getServletContext().getRequestDispatcher(response.encodeURL("/Login.jsp")).forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
