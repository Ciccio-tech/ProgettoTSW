package servlet;

import MyException.MyServletException;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ProdottoServlet")
public class ProdottoServlet {

    private final ProdottoDAO prodottoDAO= new ProdottoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws MyServletException, ServletException, IOException {
        int codP= Integer.parseInt(request.getParameter("codP"));
        Prodotto p=prodottoDAO.doRetrieveById(codP);
        if(p==null){
            throw new MyServletException("Prodotto non trovato");
        }
        request.setAttribute("Prodotto", p);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../webapp/WEB-INF/prodotto.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MyServletException {
        doGet(request, response);
    }

}
