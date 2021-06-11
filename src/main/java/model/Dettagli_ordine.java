package model;

/*
create table dettaglio_ordine(
codO int not null,
codP int not null,
FOREIGN KEY (codO) REFERENCES ordine(codO)
on delete cascade
on update cascade,
FOREIGN KEY (codP) REFERENCES prodotto(codP)
on delete cascade
on update cascade,
quantita int NOT NULL,
IVA int NOT NULL,
primary key(codO, codP)
);
 */

public class Dettagli_ordine {
    private int codO;
    private int codP;
    private int quantita;
    private int IVA;

    public Dettagli_ordine(int codO, int codP, int quantita, int IVA) {
        this.codO = codO;
        this.codP = codP;
        this.quantita = quantita;
        this.IVA = IVA;
    }

    public int getCodO() {
        return codO;
    }

    public void setCodO(int codO) {
        this.codO = codO;
    }

    public int getCodP() {
        return codP;
    }

    public void setCodP(int codP) {
        this.codP = codP;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getIVA() {
        return IVA;
    }

    public void setIVA(int IVA) {
        this.IVA = IVA;
    }

    @Override
    public String toString() {
        return "Dettagli_ordine{" +
                "codO=" + codO +
                ", codP=" + codP +
                ", quantità=" + quantita +
                ", IVA=" + IVA +
                '}';
    }
}
