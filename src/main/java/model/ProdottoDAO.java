package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*

private int codP;
    private String tipo;
    private String marca;
    private String modello;
    private float prezzo;
    private int quantità;
 */

public class ProdottoDAO {

    public List<Prodotto> doRetrieveAll(int offset, int limit) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT codP, marca, modello, prezzo, quantità FROM prodotto LIMIT ?, ?");
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setCodP(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setModello(rs.getString(3));
                p.setPrezzo(rs.getLong(4));
                p.setQuantità(rs.getInt(5));
                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Prodotto doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT  codP, marca, modello, prezzo, quantità FROM prodotto WHERE codP=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setCodP(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setModello(rs.getString(3));
                p.setPrezzo(rs.getLong(4));
                p.setQuantità(rs.getInt(5));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prodotto> doRetrieveByNome(String against, int offset, int limit) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT codP, marca, modello, prezzo, quantità FROM prodotto WHERE MATCH(nome) AGAINST(? IN BOOLEAN MODE) LIMIT ?, ?");
            ps.setString(1, against);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setCodP(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setModello(rs.getString(3));
                p.setPrezzo(rs.getLong(4));
                p.setQuantità(rs.getInt(5));
                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //aggiungere il doSave, doUpdate e doDelete.

}
