package model;

import java.math.RoundingMode;

public class Dettaglio_ordine2 implements java.io.Serializable{

    private static final long serialVersionUID = -7048837643544538726L;
    private java.util.List <Ordine2> prod;
    private int cod;
    private java.util.GregorianCalendar data;
    private Indirizzo indirizzo;
    private Cliente user;

    public java.util.List<Ordine2> getProdotti() {
        return prod;
    }
    public void setProdotti(java.util.List<Ordine2> prod) {
        this.prod = prod;
    }
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    public java.util.GregorianCalendar getData() {
        return data;
    }
    public void setData(java.util.GregorianCalendar data) {
        this.data = data;
    }
    public Indirizzo getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }
    public Cliente getUser() {
        return user;
    }
    public void setUser(Cliente user) {
        this.user = user;
    }
    public int size () {
        return prod.size();
    }
    public java.math.BigDecimal getTotal () {
        double total = 0;
        java.util.List<Ordine2> list = prod;

        for (Ordine2 o : list) {

            Prodotto item = o.getProdotto();

            total = total + o.getQuantita()*(item.getIVA());
        }

        return new java.math.BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN);
    }
    @Override
    public String toString() {
        return "Dettagli = [cod=" + cod + ", date=" + data + ", shipping=" + indirizzo + "]"+"\n prodotti=" + prod
                + ", user=" + user;
    }
}
