package model;

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

    public int getQuantita() {
        return quantita;
    }

    public double totale(){
        return prodotto.getPrezzo()* prodotto.getQuantita();
    }


}
