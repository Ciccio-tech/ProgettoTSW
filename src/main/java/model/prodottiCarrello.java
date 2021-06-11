package model;

public class prodottiCarrello {
    private final Prodotto prodotto;
    private final int quantita;

    public prodottiCarrello(Prodotto prodotto, int quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public double totale(){
        return prodotto.getPrezzo()* prodotto.getQuantità();
    }
}
