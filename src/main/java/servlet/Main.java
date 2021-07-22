package servlet;

import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] arg) throws SQLException {
        System.out.println("CIAOO SONO IL MAIN");

       ProdottoDAO operazioni= new ProdottoDAO();
        ArrayList<Prodotto> array= new ArrayList<>();
       array.addAll(operazioni.doRetrieveDyTipo("fotocamera"));

        System.out.println(array.get(0).getCodP());
    }
}
