package model;

/*

CREATE TABLE prodotto(
codP INT PRIMARY KEY,
tipo char(30) NOT NULL,
marca char(15) NOT NULL,
modello char(200) NOT NULL,
prezzo float NOT NULL,
quantità int Not null
);
 */


public class Prodotto {
    private int codP;
    private String tipo;
    private String marca;
    private String modello;
    private float prezzo;
    private int quantita;
    private String immagine;

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
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
