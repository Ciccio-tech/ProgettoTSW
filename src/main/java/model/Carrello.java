package model;

import java.util.ArrayList;

public class Carrello {
    private ArrayList<prodottiCarrello> p_carrello;

    public Carrello(ArrayList<prodottiCarrello> p_carrello){
        this.p_carrello=p_carrello;
    }

    public Carrello() {

    }

    public double totale(){
        double totale=0.0;
        for(prodottiCarrello p: p_carrello){
            totale += p.totale();
        }
        return totale;
    }


}
