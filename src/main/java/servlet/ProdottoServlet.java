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
import javax.servlet.http.HttpSession;
import javax.sound.midi.SysexMessage;
import java.io.IOException;


@WebServlet("/ProdottoServlet")
public class ProdottoServlet extends HttpServlet {

    private final ProdottoDAO prodottoDAO= new ProdottoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //String id= (String) session.getAttribute("codP");
        Object o= session.getAttribute("codP");
        String s= String.valueOf(o);
        System.out.println(session.getAttributeNames());
        int codP=0;
        if(s != null) {
            codP = Integer.parseInt(s);
            System.out.println(codP);
        }
            Prodotto p = prodottoDAO.doRetrieveById(codP);
            if (p == null) {
                try {
                    throw new MyServletException("Prodotto non trovato");
                } catch (MyServletException e) {
                    e.printStackTrace();
                }
            }

        request.setAttribute("Prodotto", p);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("prodotto.jsp");
        requestDispatcher.include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
