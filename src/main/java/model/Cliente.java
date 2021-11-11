package model;



import java.util.List;

public class Cliente {

        private String username;
        private String password;
        private String nome;
        private String cognome;
        private String p_elettronica;
        private List<Ordine> ordine;

        public Cliente(String username, String password, String nome, String cognome, String p_elettronica){
            this.username=username;
            this.password=password;
            this.nome=nome;
            this.cognome=cognome;
            this.p_elettronica=p_elettronica;
        }

    public Cliente() {

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


    public String getP_elettronica() {
        return p_elettronica;
    }

    public void setP_elettronica(String p_elettronica) {
        this.p_elettronica = p_elettronica;
    }

    @Override
    public String toString() {
        return "cliente{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", p_elettronica='" + p_elettronica + '\'' ;
    }
}



