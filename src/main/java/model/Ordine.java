package model;

/*
CREATE TABLE ordine(
codO int primary key,
stato boolean NOT NULL,
dataO date NOT NULL,
username varchar(20)  not null,
foreign key(username) references utente_registrato(username)
on delete cascade
on update cascade
);
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ordine {
    private int codO;
    private boolean stato;
    private GregorianCalendar dataO;
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

    public GregorianCalendar getDataO() {
        return dataO;
    }

    public void setDataO(GregorianCalendar dataO) {
        this.dataO = dataO;
    }

    public void SetDataS(String data){
        GregorianCalendar d= new GregorianCalendar();
        String[] a = data.split("-");
        d.set(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]));
        this.dataO=d;
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

    public String getData(){
        String data;
        int mese= this.dataO.get(Calendar.MONTH);
        int giorno= this.dataO.get(Calendar.DAY_OF_MONTH);
        int anno=this.dataO.get(Calendar.YEAR);
        data= anno + "-" + mese+"-"+giorno;
        return data;
    }

}
