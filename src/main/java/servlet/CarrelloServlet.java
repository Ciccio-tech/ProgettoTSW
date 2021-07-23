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

        /*
        String q= request.getQueryString();
        q= q.replaceAll("\\D+", "");
        System.out.println(q);
        */


        if(carrello == null){
            carrello = new Carrello();
            carrello.setP_carrelloV();
        }

        String IdProdottoS = request.getParameter("codP");
        System.out.println(IdProdottoS);
        int Idprodotto= Integer.parseInt(IdProdottoS);

        String addS = request.getParameter("qty");
        System.out.println(addS);
        int a= Integer.parseInt(addS);

        /*
        if(addS!=null){
            int add= Integer.parseInt(addS);
            System.out.println(Idprodotto + add);
            //carrello.add(Idprodotto, add);
            System.out.println(carrello.toString());
        }
        */


        RequestDispatcher requestDispatcher;

        if(carrello.add(Idprodotto, a)) {
            session.setAttribute("carrello", carrello);
            requestDispatcher = request.getRequestDispatcher("Carrello.jsp");
        }
        else {
            requestDispatcher = request.getRequestDispatcher("Catalogo.jsp");
        }
        requestDispatcher.include(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
