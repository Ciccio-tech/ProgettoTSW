package servlet;

import MyException.MyServletException;
import model.Amministratore;
import model.AmministratoreDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/AdminServlet")

public class AdminAmministratoreServlet extends HttpServlet {
    AmministratoreDAO amministratoreDAO= new AmministratoreDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Amministratore amministratore= (Amministratore) request.getSession().getAttribute("amministratore");

        if(amministratore == null){
            try {
                throw new MyServletException("Utente non autorizzato");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }else{
            String username= request.getParameter("username");
            boolean rimuovi =  Boolean.parseBoolean(request.getParameter("rimuovi"));
            if(username!= null && rimuovi){
                try {
                    amministratoreDAO.doDelete(username);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                String pass= request.getParameter("pass");
                String nome = request.getParameter("nome");
                String cognome = request.getParameter("cognome");
                Amministratore newAdmin= new Amministratore(username, pass, nome, cognome);
                try {
                   if(amministratoreDAO.createAmministratore(newAdmin)){
                       request.setAttribute("notifica", "Nuovo Amministratore aggiunto con successo!");
                   }else
                       request.setAttribute("notifica", "ATTENZIONE: il nuovo Amministratore non è stato aggiunto");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("admin.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doGet(request, response);
    }
}
