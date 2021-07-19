package servlet;

import model.Carrello;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Carrello")

public class CarrelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Carrello carrello= (Carrello) session.getAttribute("carrello");
        if(carrello == null){
            carrello = new Carrello();
            session.setAttribute("carrello", carrello);
        }

        String IdProdottoS= request.getParameter("codP");
        if(IdProdottoS != null){
            int Idprodotto= Integer.parseInt(IdProdottoS);

            String addS = request.getParameter("numero_prodotti");
            if(addS!=null){
                int add= Integer.parseInt(addS);
                carrello.add(Idprodotto, add);
            }
        }

        RequestDispatcher requestDispatcher= request.getRequestDispatcher("Carrello.jsp"); //JSP DA FARE
        requestDispatcher.include(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
