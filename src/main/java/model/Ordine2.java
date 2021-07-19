package model;

import java.math.RoundingMode;

public class Ordine2 {
    @Override
    public String toString() {
        return "Order [product=" + prod + ", qty=" + qty + "]\n";
    }
    private static final long serialVersionUID = -7625196350124530857L;
    private Prodotto prod;
    private int qty;

    public Ordine2 () {

    }

    public Ordine2 (int id) {
        prod = new Prodotto (id);
    }

    public Ordine2 (Prodotto e, int quantity) {
        prod = e;
        qty = quantity;
    }

    public Prodotto getProduct() {
        return prod;
    }
    public void setProdotto(Prodotto prod) {
        this.prod = prod;
    }
    public int getQuantita() {
        return qty;
    }
    public void setQuantita(int qty) {
        this.qty = qty;
    }

    /*-----	utilities ------*/
    public java.math.BigDecimal getTotal () {
        return new java.math.BigDecimal(prod.getPrezzo()*qty).setScale(2, RoundingMode.HALF_EVEN);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prod == null) ? 0 : prod.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ordine2 other = (Ordine2) obj;
        if (prod == null) {
            if (other.prod != null)
                return false;
        } else if (!prod.equals(other.prod))
            return false;
        return true;
    }
}

