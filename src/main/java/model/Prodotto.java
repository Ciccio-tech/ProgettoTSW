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
    private int quantità;

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

    public int getQuantità() {
        return quantità;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
