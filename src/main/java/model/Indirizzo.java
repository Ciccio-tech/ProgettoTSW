package model;

public class Indirizzo implements java.io.Serializable {

    private static final long serialVersionUID = 6021946553406606291L;
    private String nation;
    private String via;
    private int nCv;
    private int CAP;
    private String prov;
    private String citta;
    private int cod;

    public String getNazione() {
        return nation;
    }
    public void setNazione(String nation) {
        this.nation = nation;
    }
    public String getVia() {
        return via;
    }
    public void setVia(String via) {
        this.via = via;
    }
    public int getnCv() {
        return nCv;
    }
    public void setnCv(int nCv) {
        this.nCv = nCv;
    }
    public int getCAP() {
        return CAP;
    }
    public void setCAP(int cAP) {
        CAP = cAP;
    }
    public String getProvincia() {return prov; }
    public void setProvincia(String province) {
        this.prov = province;
    }
    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public int getCodice() {
        return cod;
    }
    public void setCodice(int codice) {
        this.cod = codice;
    }

    public String toString (){
        return "Indirizzo: "+ via +", "+nCv +"; CAP: " +CAP +" citta: " +citta;
    }
}
