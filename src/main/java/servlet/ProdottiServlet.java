package servlet;

import MyException.MyServletException;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/ProdottiServlet")
public class ProdottiServlet extends HttpServlet {
    ProdottoDAO prodottoDAO= new ProdottoDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Prodotto> prodotti;
        prodotti= (ArrayList<Prodotto>) prodottoDAO.doRetrieveAll(0,100);
        if(prodotti.size()==0){
            try {
                throw new MyServletException("Non ci sono prodotti");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("products", prodotti);
        //response.sendRedirect("Catalogo.jsp");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Catalogo.jsp");
        requestDispatcher.include(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doGet(request, response);
    }
}
