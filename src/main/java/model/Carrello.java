package model;

import java.util.ArrayList;

public class Carrello {
    private ArrayList<prodottiCarrello> p_carrello;

    public Carrello(ArrayList<prodottiCarrello> p_carrello){
        this.p_carrello=p_carrello;
    }

    public Carrello() {
    }

    public ArrayList<prodottiCarrello> getP_carrello() {
        return p_carrello;
    }

    public boolean add(int codP, int quantita){
        ProdottoDAO prodottoDAO= new ProdottoDAO();
        Prodotto prodotto;
        prodotto= prodottoDAO.doRetrieveById(codP);
        prodottiCarrello prodottiCarrello;
        if(prodotto != null) {
            prodottiCarrello= new prodottiCarrello(prodotto, quantita);
            p_carrello.add(prodottiCarrello);
            return true;
        }
        else
            return false;
    }

    public Prodotto get(int codP){
        ProdottoDAO prodottoDAO= new ProdottoDAO();
        Prodotto prodotto= prodottoDAO.doRetrieveById(codP);
        if(prodotto != null)
            return prodotto;
        else
            return null;
    }

    public double totale(){
        double totale=0.0;
        for(prodottiCarrello p: p_carrello){
            totale += p.totale();
        }
        return totale;
    }


}
