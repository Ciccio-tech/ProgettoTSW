package model;

import java.math.BigDecimal;

public class prodottiCarrello {
    private Prodotto prodotto;
    private int quantita;

    public prodottiCarrello(Prodotto prodotto, int quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
    }

    public prodottiCarrello () {

    }

    public Prodotto getProdotto() {
        return prodotto;
    }
    public void setProdotto (Prodotto prodotto){
        this.prodotto=prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double totale(){
        return prodotto.getPrezzo()* quantita;
    }

    public float calculateIva () {
        return prodotto.getPrezzo()*(prodotto.getIVA()/100);
    }
    public double getPrezzoConIva () {
        double iva = calculateIva();
        double money = prodotto.getPrezzo();

        return  (money + iva);
    }



}
