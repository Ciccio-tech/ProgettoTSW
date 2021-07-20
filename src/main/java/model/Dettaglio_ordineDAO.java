package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dettaglio_ordineDAO {

    private void setOrdine (ResultSet rs,Ordine2 ord) throws SQLException {
        //fattura, prodotto, prezzoAp, quantita, ivaAp, scontoAp

        try(Connection c= ConPool.getConnection()){
            PreparedStatement ps= c.prepareStatement("SELECT * from ordine LIMIT ?, ?");
            Prodotto p= new Prodotto();

            p.setCodP(rs.getInt("codP"));
            p.setTipo(rs.getString("tipo"));
            p.setMarca(rs.getString("marca"));
            p.setModello(rs.getString("modello"));
            p.setPrezzo(rs.getFloat("prezzo"));
            p.setImmagine(rs.getString("immagine"));

            ord.setProdotto(p);
            ord.setQuantita(rs.getInt("quantità"));
        }
    }

    public void doSave(Dettagli_ordine det)throws Exception{

    }

}
