package servlet;

import model.Carrello;
import model.Prodotto;
import model.prodottiCarrello;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/RimuoviProdotto")
public class RimuoviProdottoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String codP;
        String q= request.getQueryString();
        q= q.replaceAll("\\D+", "");
        System.out.println(q);
        String IdProdottoS = q;
        System.out.println(IdProdottoS);
        int Idprodotto= Integer.parseInt(IdProdottoS);
        HttpSession session = request.getSession();
        Carrello carrello= (Carrello) session.getAttribute("carrello");

        ArrayList<prodottiCarrello> a= carrello.getP_carrello();
        /*
        ArrayList<prodottiCarrello> n;
        n=carrello.removeProduct(a, Idprodotto);
        Carrello Nc= new Carrello(n);
         */

        /*
        for(prodottiCarrello p: a){
            int c=p.getProdotto().getCodP();
            System.out.println(c + a.size());
            if(c == Idprodotto)
                a.remove(p);
        }
        */
        carrello.removeProduct(a, Idprodotto);

        session.setAttribute("carrello", carrello);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Carrello.jsp");
        requestDispatcher.include(request, response);
        //response.sendRedirect("Carrello.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        doGet(request, response);
    }
}
