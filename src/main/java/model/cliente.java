package model;

public class cliente {

        public cliente(String nome, String cognome, String gender, String birthday, String citta, String provincia, int codice,  String  p_elettronica, long telefono){
            this.nome=nome;
            this.cognome=cognome;
            this.birthday=birthday;
            this.gender=gender;
            this.citta=citta;
            this.provincia=provincia;
            this.codice=codice;
            this.p_elettronica=p_elettronica;
            this.telefono=telefono;
        }

        public void setGender(String gender) {this.gender=gender;}
        public void setNome(String nome) {
            this.nome = nome;
        }
        public void setCognome(String cognome) {
            this.cognome = cognome;
        }
        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
        public void setCitta(String citta) {
            this.citta = citta;
        }
        public void setProvincia(String provincia) {
            this.provincia = provincia;
        }
        public void setCodice(int codice) {
            this.codice = codice;
        }
        public void setP_elettroncia(String p_elettronica) {
            this.p_elettronica = p_elettronica;
        }
        public void setTelefono(long telefono) {
            this.telefono = telefono;
        }
        public String getGender() {return this.gender;}
        public String getNome() {
            return nome;
        }
        public String getCognome() {
            return cognome;
        }
        public String getBirthday() {
            return birthday;
        }
        public String getCitta() {
            return citta;
        }
        public String getProvincia() {
            return provincia;
        }
        public int getCodice() {
            return codice;
        }
        public String getP_elettronica() {
            return p_elettronica;
        }
        public long getTelefono() {
            return telefono;
        }


        private String nome;
        private String cognome;
        private String birthday;
        private String gender;
        private String citta;
        private String provincia;
        private int codice;
        private String p_elettronica;
        private long telefono;
}



