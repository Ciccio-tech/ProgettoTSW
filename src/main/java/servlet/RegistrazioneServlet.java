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
import java.sql.SQLException;
import java.util.GregorianCalendar;


@WebServlet("/Registrazione")

public class RegistrazioneServlet extends HttpServlet {
    private ClienteDAO clienteDAO= new ClienteDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getSession().getAttribute("utente") != null){
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

        String password= request.getParameter("pass");
        if(!(password != null && password.length()>=8 && !password.toUpperCase().equals(password) && !password.toLowerCase().equals(password) && password.matches(".*[0-9].*"))){
            try {
                throw new MyServletException("Password non valida");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }

        String passwordConferma= request.getParameter("passwordConferma");
        if(!password.equals(passwordConferma)){
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

        String cognome = request.getParameter("nome");
        if(!(cognome != null && cognome.trim().length() > 0 && cognome.matches("^[ a-zA-Z\\u00C0-\\u00ff]+$"))){
            try {
                throw new MyServletException("Cognome non valido");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }

        String email= request.getParameter("email");
        if(!(email != null && email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$"))){
            try {
                throw new MyServletException("Email non valida");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }

        String numero_t = request.getParameter("n_telefomo");
        if(!(numero_t != null && numero_t.length()>=9 && numero_t.length()<=11 && numero_t.matches("^[0-9]+$"))){
            try {
                throw new MyServletException("Numero di telefono non valido");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }

        String dataN = request.getParameter("dataN");
        if(!(dataN!=null)){
            try {
                throw new MyServletException("Data non valida");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }


        String indirizzo = request.getParameter("indirizzo");
        if(!(indirizzo!=null)){
            try {
                throw new MyServletException("Indirizzo non valida");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }


        Cliente cliente= new Cliente();
        cliente.setUsername(username);
        cliente.setPassword(password);
        cliente.setNome(nome);
        cliente.setCognome(cognome);
        cliente.setTelefono(Long.parseLong(numero_t));
        GregorianCalendar today= new GregorianCalendar();
        cliente.setData_registrazione(today);
        cliente.setDataNascitaS(dataN);
        cliente.setIndirizzo(indirizzo);
        try {
            clienteDAO.doSave(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("cliente", cliente);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/registrazioneSuccesso.jsp");
        requestDispatcher.forward(request, response);
    }



    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        doGet(request, response);
    }
}
