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
        private GregorianCalendar data_nascita;
        private String indirizzo;
        private String p_elettronica;
        private long telefono;
        private GregorianCalendar data_registrazione;
        private List<Ordine> ordine;

        public Cliente(String username, String password, String nome, String cognome, GregorianCalendar data_nascita, String indirizzo, String p_elettronica, long telefono, GregorianCalendar data_registrazione){
            this.username=username;
            this.password=password;
            this.nome=nome;
            this.cognome=cognome;
            this.data_nascita=data_nascita;
            this.indirizzo=indirizzo;
            this.p_elettronica=p_elettronica;
            this.telefono=telefono;
            this.data_registrazione=data_registrazione;
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

    public GregorianCalendar getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(GregorianCalendar data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

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

    public GregorianCalendar getData_registrazione() {
        return data_registrazione;
    }

    public void setData_registrazione(GregorianCalendar data_registrazione) {
        this.data_registrazione = data_registrazione;
    }

    @Override
    public String toString() {
        return "cliente{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                ", indirizzo='" + indirizzo + '\'' +
                ", p_elettronica='" + p_elettronica + '\'' +
                ", telefono=" + telefono +
                ", data_registrazione=" + data_registrazione +
                '}';
    }
}



