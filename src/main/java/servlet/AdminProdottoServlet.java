package servlet;

import MyException.MyServletException;
import model.Amministratore;
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

@WebServlet("/AdminProdotto")

public class AdminProdottoServlet extends HttpServlet {

    private final ProdottoDAO prodottoDAO= new ProdottoDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Amministratore amministratore = (Amministratore) request.getSession().getAttribute("amministratore");
        if(amministratore == null){
            try {
                throw new MyServletException("Utente non autorizzato.");
            } catch (MyServletException e) {
                e.printStackTrace();
            }
        }

        String idP=request.getParameter("cod");
        if(idP != null){
            boolean rimuovi =  Boolean.parseBoolean(request.getParameter("rimuovi"));
            if(rimuovi){
                try {
                    prodottoDAO.doDelete(Integer.parseInt(idP));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("notifica", "Prodotto rimosso con successo!");
            }else{
                /* codP, tipo, marca, modello, prezzo, quantità, immagine, iva*/
                Prodotto prodotto;
                String tipo= request.getParameter("tipo");
                String marca= request.getParameter("marca");
                String modello= request.getParameter("modello");
                String prezzo = request.getParameter("prezzo");
                String immagine= request.getParameter("immagine");
                String quantita = request.getParameter("quantita");
                String IVA = request.getParameter("iva");
                if(tipo!=null && marca!=null && modello!=null && prezzo!=null && quantita!=null) {
                    prodotto = new Prodotto();
                    prodotto.setCodP(Integer.parseInt(idP));
                    prodotto.setTipo(tipo);
                    prodotto.setMarca(marca);
                    prodotto.setModello(modello);
                    prodotto.setPrezzo(Float.parseFloat(prezzo));
                    prodotto.setQuantita(Integer.parseInt(quantita));
                    prodotto.setImmagine(immagine);
                    prodotto.setIva(Integer.parseInt(IVA));
                        try {
                            prodottoDAO.doSave(prodotto);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                }else{
                    int codP= Integer.parseInt(idP);
                    prodotto= prodottoDAO.doRetrieveById(codP);
                }
                request.setAttribute("prodotto", prodotto);
            }
        }
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("admin.jsp");
        requestDispatcher.forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
