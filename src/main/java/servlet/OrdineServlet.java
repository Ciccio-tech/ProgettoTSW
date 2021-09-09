package servlet;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;

//<!-- name, email, adr, city, prov, cap, card -->

@WebServlet("/Ordine")

public class OrdineServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();
        Carrello carrello = (Carrello) session.getAttribute("carrello");
        OrdineDAO ordineDAO= new OrdineDAO();
        ProdottoDAO prodottoDAO= new ProdottoDAO();
        Cliente cliente= (Cliente) session.getAttribute("cliente");
        RequestDispatcher requestDispatcher;
        System.out.println(carrello.totale() + " " + cliente.getUsername());
        if(carrello != null && cliente!= null){
            String name= request.getParameter("name");
            String email= request.getParameter("email");
            String address = request.getParameter("adr");
            String citta = request.getParameter("city");
            String provincia = request.getParameter("prov");
            String cap= request.getParameter("cap");
            String carta= request.getParameter("card");
            String indirizzo = address + " " +citta + " "+ provincia + " "+ cap;
            System.out.println( name+ email + indirizzo + carta);
            if(name != null && email != null && carta != null){
                try {
                    ArrayList<Ordine> ordini = ordineDAO.doRetrieveAll(0, 100);
                    System.out.println(ordini.get(1).getUsername());
                    int size=ordini.size();
                    Ordine o= ordini.get(size-1);
                    int lastC= o.getCodO();
                    int codO= lastC+1;
                    boolean stato= true;
                    GregorianCalendar data = new GregorianCalendar();
                    Ordine ordine = new Ordine();
                    ordine.setUsername(cliente.getUsername());
                    ordine.setCodO(codO);
                    ordine.setStato(stato);
                    ordine.setDataO(data);
                    System.out.println(data.toString());
                    ordine.setCarrello(carrello);
                    try {
                        if(ordineDAO.createOrdine(ordine)){
                            Carrello c= ordine.getCarrello();
                            for(Map.Entry<Prodotto,Integer> e : c.getEntryset()) {
                                Prodotto prodotto = e.getKey();
                                int q = e.getValue();
                                prodottoDAO.UpdateQuantita(prodotto,q);
                            }
                            requestDispatcher = request.getRequestDispatcher("ConfermaOrdine.jsp");
                            session.setAttribute("carrello", new Carrello()); //svuota il carrello dopo l'acquisto
                        }
                        else{
                            requestDispatcher = request.getRequestDispatcher("404.jsp");
                        }
                        requestDispatcher.forward(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doGet(request, response);
    }
}
