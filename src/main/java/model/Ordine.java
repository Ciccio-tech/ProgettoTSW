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

import java.util.GregorianCalendar;

public class Ordine {
    private int codO;
    private boolean stato;
    private GregorianCalendar dataO;
    private String username;
    private Carrello carrello;

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
}
