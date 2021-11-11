package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Prodotto {
    private int codP;
    private String tipo;
    private String marca;
    private String modello;
    private float prezzo;
    private int quantita;
    private String immagine;
    private int iva;
    private ArrayList<Recensione> recensione;

    public int getIva() {
        return iva;
    }

    public ArrayList<Recensione> getRecensione() throws SQLException {
        RecensioneDAO recensioneDAO= new RecensioneDAO();
        ArrayList<Recensione> recensioni= recensioneDAO.doRetrieveByCodP(this.codP);
        if(!recensioni.isEmpty()) {
            recensione= recensioni;
            return recensioni;
        }
        else
            return null;
    }


    public Prodotto(int codP, String tipo, String marca, String modello, float prezzo, int quantita, String immagine, int iva){
        this.codP=codP;
        this.tipo=tipo;
        this.marca=marca;
        this.modello=modello;
        this.prezzo=prezzo;
        this.quantita=quantita;
        this.immagine=immagine;
        this.iva=iva;
    }

    public Prodotto(){

    }

    public Prodotto(int id){
        codP=id;
    }


    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public int getCodP() {
        return this.codP;
    }

    public void setCodP(int id) {
        this.codP = id;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        if(this.quantita == 0)
            return -1;
        else
            return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getIVA() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public float calculateIva () {
        return prezzo*(iva/100);
    }
    public double getPrezzoConIva () {
        double iva = calculateIva();
        double money = prezzo;
        return  (money + iva);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return codP == prodotto.codP;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codP);
    }
}
