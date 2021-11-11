package model;



import java.text.SimpleDateFormat;
import java.util.Date;

public class Ordine {
    private int codO;
    private boolean stato;
    private Date dataO;
    private String username;
    private Carrello carrello;

    public Ordine(){}


    public int getCodO() {
        return codO;
    }

    public void setCodO(int codO) {
        this.codO = codO;
    }

    public boolean isStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

    public void setDataO(Date dataO) {
        this.dataO = dataO;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public String getFormattedDate(){
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy");
        return s.format(dataO);
    }

    public Date getDate () {
        return dataO;
    }

}
