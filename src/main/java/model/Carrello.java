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

    public void setP_carrello(ArrayList<prodottiCarrello> p_carrello) {
        this.p_carrello = p_carrello;
    }

    public void setP_carrelloV() {
        this.p_carrello = new ArrayList<>();
    }

    public boolean add(int codP, int quantita){
        if(codP != 0 && quantita != 0) {
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            Prodotto prodotto;
            prodotto = prodottoDAO.doRetrieveById(codP);
            prodottiCarrello prodottiCarrello;
            if (prodotto != null) {
                prodottiCarrello = new prodottiCarrello(prodotto, quantita);
                this.p_carrello.add(prodottiCarrello);
                return true;
            } else
                return false;
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

    public ArrayList<prodottiCarrello> removeProduct(ArrayList<prodottiCarrello> c , int codP){
        if(c!= null) {
            System.out.println("siamo nell'if");
            int i=0;
            for (prodottiCarrello p : c) {
                System.out.println("siamo nel for");
                System.out.println(p.getProdotto().toString());
                //Prodotto prodotto = p.getProdotto();
                int cod = p.getProdotto().getCodP();
                if (codP == cod) {
                    System.out.println("siamo nel secondo if");
                    c.remove(i);
                    System.out.println("rimozione");
                }
                i++;
            }
            for(prodottiCarrello p : c){
                System.out.println(p.getProdotto().toString());
            }
            return c;
        }else
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
