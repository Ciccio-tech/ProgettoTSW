package model;

/*
create table utente_registrato(
username varchar(20) primary key,
pass varchar(20) NOT NULL,
nome char(15) NOT NULL,
cognome char(15) NOT NULL,
n_telefono char(10) NOT NULL,
email char(30) NOT NULL,
data_nascita date NOT NULL,
data_registrazione date NOT NULL,
indirizzo varchar(50) NOT NULL
);
 */

import java.util.GregorianCalendar;
import java.util.List;

public class Cliente {

        private String username;
        private String password;
        private String nome;
        private String cognome;
        private String p_elettronica;
        private long telefono;
        private List<Ordine> ordine;

        public Cliente(String username, String password, String nome, String cognome, String p_elettronica, long telefono){
            this.username=username;
            this.password=password;
            this.nome=nome;
            this.cognome=cognome;
            this.p_elettronica=p_elettronica;
            this.telefono=telefono;
        }

    public Cliente() {

    }

    public List<Ordine> getOrdine() {
        return ordine;
    }

    public void setOrdine(List<Ordine> ordine) {
        this.ordine = ordine;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /*
    public GregorianCalendar getData_nascita() {
        return data_nascita;
    }

    public String getData_nascitaS(){
        String data;
        int mese= this.data_nascita.get(Calendar.MONTH);
        int giorno= this.data_nascita.get(Calendar.DAY_OF_MONTH);
        int anno=this.data_nascita.get(Calendar.YEAR);
        data=giorno+"/"+mese+ ""+anno;
        return data;
    }


    public void setData_nascita(GregorianCalendar data_nascita) {
        this.data_nascita = data_nascita;
    }


    public void setDataNascitaS(String data){
        GregorianCalendar d= new GregorianCalendar();
        String[] a = data.split("/");
        for(int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
        int mese;
        switch (a[1]){
            case "JANUARY": mese=0;
            case "FEBRUARY": mese=1;
            case "MARCH": mese=2;
            case "APRIL": mese=3;
            case "MAY": mese=4;
            case "JUNE": mese=5;
            case "JULY": mese=6;
            case "AUGUST": mese=7;
            case "SEPTEMBER": mese=8;
            case "OCTOBER": mese=9;
            case "NOVEMBER": mese=10;
            case "DECEMBER": mese=11;
            default: mese=0;
        }

        d.set(Integer.parseInt(a[0]),  mese, Integer.parseInt(a[2]));
        this.data_nascita=d;
    }




    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


     */

    public String getP_elettronica() {
        return p_elettronica;
    }

    public void setP_elettronica(String p_elettronica) {
        this.p_elettronica = p_elettronica;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /*
    public GregorianCalendar getData_registrazione() {
        return data_registrazione;
    }

    public void setData_registrazione(GregorianCalendar data_registrazione) {
        this.data_registrazione = data_registrazione;
    }
    */


    @Override
    public String toString() {
        return "cliente{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", p_elettronica='" + p_elettronica + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}



