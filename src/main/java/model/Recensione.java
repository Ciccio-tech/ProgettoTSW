package model;

import java.util.GregorianCalendar;

public class Recensione{
    private String username;
    private int codP;
    private GregorianCalendar dataR;
    private int voto;
    private String commento;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCodP() {
        return codP;
    }

    public void setCodP(int codP) {
        this.codP = codP;
    }

    public GregorianCalendar getDataR() {
        return dataR;
    }

    public void setDataR(GregorianCalendar dataR) {
        this.dataR = dataR;
    }

    public void setDataS(String data){
        GregorianCalendar d= new GregorianCalendar();
        String[] a = data.split("-");
        d.set(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]));
        this.dataR=d;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        if(voto>=0 && voto<=5)
            this.voto = voto;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }
}
