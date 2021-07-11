package servlet;

import MyException.MyServletException;
import model.Cliente;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AdminProdotto")

public class AdminProdottoServlet {

    private final ProdottoDAO prodottoDAO= new ProdottoDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, MyServletException, SQLException {
        Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
        if(cliente == null){
            throw new MyServletException("Utente non autorizzato.");
        }

        String idP=request.getParameter("codP");
        if(idP != null){
            if(request.getParameter("rimuovi") != null){
                prodottoDAO.doDelete(Integer.parseInt(idP));
                request.setAttribute("notifica", "Prodotto rimosso con successo!");
            }else{
                /* codP, tipo, marca, modello, prezzo, quantità*/
                Prodotto prodotto;
                String tipo= request.getParameter("tipo");
                String marca= request.getParameter("marca");
                String modello= request.getParameter("modello");
                String prezzo = request.getParameter("prezzo");
                String quantita = request.getParameter("quantità");
                if(tipo!=null && marca!=null && modello!=null && prezzo!=null && quantita!=null) {
                    prodotto = new Prodotto();
                    prodotto.setTipo(tipo);
                    prodotto.setModello(marca);
                    prodotto.setModello(modello);
                    prodotto.setPrezzo(Float.parseFloat(prezzo));
                    prodotto.setQuantita(Integer.parseInt(quantita));
                    if (idP.isEmpty()) {
                        //si aggiunge il prodotto
                        prodottoDAO.doSave(prodotto);
                        request.setAttribute("notifica", "Prodotto aggiunto con successo");
                    } else {
                        //si modifica il prodotto esistente
                        prodotto.setCodP(Integer.parseInt(idP));
                        prodottoDAO.doUpdate(prodotto);
                        request.setAttribute("notifica", "Modifica avvenuta con successo");
                    }

                }else{
                    int codP= Integer.parseInt(idP);
                    prodotto= prodottoDAO.doRetrieveById(codP);
                }
                request.setAttribute("prodotto", prodotto);
            }
        }
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("WEB-INF/Admin.jsp");
        requestDispatcher.forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, MyServletException, SQLException {
        doGet(request, response);
    }
}
