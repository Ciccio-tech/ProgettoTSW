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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;



@WebServlet("/RegistrazioneServlet")

public class RegistrazioneServlet extends HttpServlet {
    private final ClienteDAO clienteDAO= new ClienteDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        RequestDispatcher requestDispatcher;
        if(request.getSession().getAttribute("utente_registrato") != null){
            try {
                throw new MyServletException("Utente già loggato!");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }

        String username = request.getParameter("username");
        if(!(username != null && username.length()>= 6 && username.matches("^[0-9a-zA-Z]+$"))){
            try {
                throw new MyServletException("Username non valido");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }
        Cliente cl1;
        try {
            cl1=clienteDAO.doRetrieveByUsername(username);
            session.setAttribute("warning", true);
            requestDispatcher= request.getRequestDispatcher("Registrazione.jsp");
            requestDispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            }

        String password= request.getParameter("pass");
        if(!(password != null && password.length()>=8 && !password.toUpperCase().equals(password) && !password.toLowerCase().equals(password) && password.matches(".*[0-9].*"))){
            try {
                throw new MyServletException("Password non valida");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }

        String passwordConferma= request.getParameter("confermaPassword");
        assert password != null;
        if(!password.equals(passwordConferma)) {
            try {
                throw new MyServletException("Password e password di conferma differenti.");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }


        String nome = request.getParameter("nome");
        if(!(nome != null && nome.trim().length() > 0 && nome.matches("^[ a-zA-Z\\u00C0-\\u00ff]+$"))){
            try {
                throw new MyServletException("Nome non valido");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }

        String cognome = request.getParameter("cognome");
        if(!(cognome != null && cognome.trim().length() > 0 && cognome.matches("^[ a-zA-Z\\u00C0-\\u00ff]+$"))){
            try {
                throw new MyServletException("Cognome non valido");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }

        String email= request.getParameter("email");
        if(!(email != null && email.matches("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w+)+$"))){
            try {
                throw new MyServletException("Email non valida");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }


        Cliente cliente= new Cliente();
        cliente.setUsername(username);
        cliente.setPassword(password);
        cliente.setNome(nome);
        cliente.setCognome(cognome);
        cliente.setP_elettronica(email);

        try {
            clienteDAO.doSave(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("utente_registrato", cliente);
        response.sendRedirect("index.jsp");
    }



    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        doGet(request, response);
    }
}
