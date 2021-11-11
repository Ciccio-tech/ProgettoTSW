package servlet;

import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Catalogo")

public class CatalogoServlet extends HttpServlet {
    public ProdottoDAO prodottoDAO;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        prodottoDAO= new ProdottoDAO();
        ArrayList<Prodotto> prodotti= null;
        try {
            String ctgy= request.getParameter("categoria");
            int categoria = Integer.parseInt(ctgy);
            if(categoria==0){
                prodotti= prodottoDAO.doRetrieveAll();
            }
            if(categoria==1){
                prodotti= prodottoDAO.doRetrieveDyTipo("fotocamera");
            }
            if(categoria==2){
                 prodotti=prodottoDAO.doRetrieveDyTipo("obiettivi fotografici");
            }
            if(categoria==3){
                prodotti=prodottoDAO.doRetrieveDyTipo("accessori");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(prodotti!=null){
            response.setContentType("text/html");
            request.setAttribute("prodotti", prodotti);
            request.getRequestDispatcher(response.encodeURL("/Catalogo.jsp")).forward(request, response);
        }else{
            request.getRequestDispatcher(response.encodeURL("/ErrorPage/404.jsp")).forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doGet(request, response);
    }
}
