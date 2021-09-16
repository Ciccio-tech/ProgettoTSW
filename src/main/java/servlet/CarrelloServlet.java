package servlet;

import model.Carrello;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Carrello")

public class CarrelloServlet extends HttpServlet {

    private ProdottoDAO dao=new ProdottoDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        Carrello carrello = (Carrello) session.getAttribute("carrello");


        if (carrello == null) {
            carrello = new Carrello();
        }

        String IdProdottoS = request.getParameter("codP");
        int Idprodotto = Integer.parseInt(IdProdottoS);

        String addS = request.getParameter("qty");
        int a = Integer.parseInt(addS);
        int i = 0;

        try {
            Prodotto p=dao.doRetrieveById(Idprodotto);
            if(p!=null) {
                carrello.add(p, a);
                session.setAttribute("carrello", carrello);
                response.sendRedirect("Carrello.jsp");
            }else{
                response.sendRedirect("ErrorPage/404.jsp");
            }
        } catch (Exception e){
            response.sendRedirect("ErrorPage/500.jsp");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
