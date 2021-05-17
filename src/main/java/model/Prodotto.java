package model;

public class Prodotto {
    private int id;
    private String nome;
    private String descrizione;
    private long prezzoCent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public long getPrezzoCent() {
        return prezzoCent;
    }

    public void setPrezzoCent(long prezzoCent) {
        this.prezzoCent = prezzoCent;
    }

    public String getPrezzoEuro() {
        return String.format("%.2f", prezzoCent / 100.);
    }

    @Override
    public String toString() {
        return "Prodotto [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzoCent=" + prezzoCent
                + ", categorie="+ "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
        result = prime * result + id;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + (int) (prezzoCent ^ (prezzoCent >>> 32));
        return result;
    }

}
