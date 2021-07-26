package servlet;

import model.Carrello;
import model.Prodotto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/RimuoviProdotto")
public class RimuoviProdottoServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String q= request.getQueryString();
        q= q.replaceAll("\\D+", "");
        System.out.println(q);
        String IdProdottoS = q;
        System.out.println(IdProdottoS);
        int Idprodotto= Integer.parseInt(IdProdottoS);
        HttpSession session = request.getSession();
        Carrello carrello= (Carrello) session.getAttribute("carrello");

        Prodotto p= new Prodotto();
        p.setCodP(Idprodotto);
        carrello.removeProduct(p);

        session.setAttribute("carrello", carrello);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Carrello.jsp");
        requestDispatcher.include(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        doGet(request, response);
    }
}
