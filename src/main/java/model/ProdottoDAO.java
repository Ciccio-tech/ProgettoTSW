package model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProdottoDAO {

    public ArrayList<Prodotto> doRetrieveAll() {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT codP, tipo, marca, modello, prezzo, quantità, immagine, IVA FROM prodotto ");
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto bean = new Prodotto();
                bean.setCodP(rs.getInt(1));
                bean.setTipo(rs.getString(2));
                bean.setMarca(rs.getString(3));
                bean.setModello(rs.getString(4));
                bean.setPrezzo(rs.getFloat(5));
                bean.setQuantita(rs.getInt(6));
                bean.setImmagine(rs.getString(7));
                bean.setIva(rs.getInt(8));
                prodotti.add(bean);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Prodotto doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT  codP, marca, modello, prezzo, quantità, immagine,IVA FROM prodotto WHERE codP=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setCodP(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setModello(rs.getString(3));
                p.setPrezzo(rs.getLong(4));
                p.setQuantita(rs.getInt(5));
                p.setImmagine(rs.getString(6));
                p.setIva(rs.getInt(7));
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
                    "SELECT codP, marca, modello, prezzo, quantità, immagine, IVA FROM prodotto WHERE MATCH(nome) AGAINST(? IN BOOLEAN MODE) LIMIT ?, ?");
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
                p.setQuantita(rs.getInt(5));
                p.setIva(rs.getInt(6));
                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Prodotto> doRetrieveByModelloorMarca(String against) throws SQLException {
        try(Connection c= ConPool.getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT codP, tipo, marca, modello, prezzo, quantità, immagine, IVA FROM prodotto WHERE (marca LIKE ? or modello LIKE ?) ORDER BY marca");
            ps.setString(1, "%"+against+"%");
            ps.setString(2, "%"+against+"%");
            ResultSet rs = ps.executeQuery();
            ArrayList<Prodotto> prodotti= new ArrayList<>();
            while(rs.next()){
                Prodotto p= new Prodotto();
                p.setCodP(rs.getInt(1));
                p.setTipo(rs.getString(2));
                p.setMarca(rs.getString(3));
                p.setModello(rs.getString(4));
                p.setPrezzo(rs.getFloat(5));
                p.setQuantita(rs.getInt(6));
                p.setImmagine(rs.getString(7));
                p.setIva(rs.getInt(8));
                prodotti.add(p);
            }
            return prodotti;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Prodotto> doRetrieveDyTipo(String tipo) throws SQLException{
        try(Connection c = ConPool.getConnection()){
            PreparedStatement ps= c.prepareStatement("SELECT codP, tipo, marca, modello, prezzo, quantità, immagine, IVA FROM prodotto WHERE tipo=?");
            ps.setString(1, tipo);
            ResultSet rs= ps.executeQuery();
            ArrayList<Prodotto> prodotti= new ArrayList<>();
           while(rs.next()){
                Prodotto bean= new Prodotto();
                bean.setCodP(rs.getInt(1));
                bean.setTipo(rs.getString(2));
                bean.setMarca(rs.getString(3));
                bean.setModello(rs.getString(4));
                bean.setPrezzo(rs.getFloat(5));
                bean.setQuantita(rs.getInt(6));
                bean.setImmagine(rs.getString(7));
                bean.setIva(rs.getInt(8));
                prodotti.add(bean);
            }
            return prodotti;
        }
    }

    public boolean doSave(Prodotto prodotto) throws SQLException{
        try(Connection c= ConPool.getConnection()){
            PreparedStatement ps= c.prepareStatement("INSERT INTO prodotto (codP, tipo, marca, modello, prezzo, quantità, immagine, IVA) VALUES(?,?,?,?,?,?,?,?)");
            ps.setInt(1, prodotto.getCodP());
            ps.setString(2, prodotto.getTipo());
            ps.setString(3, prodotto.getMarca());
            ps.setString(4, prodotto.getModello());
            ps.setFloat(5, prodotto.getPrezzo());
            ps.setInt(6, prodotto.getQuantita());
            ps.setString(7, prodotto.getImmagine());
            ps.setInt(8,prodotto.getIVA());
            return ps.executeUpdate() == 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doDelete(int codP) throws SQLException {
        try(Connection c= ConPool.getConnection()) {
            PreparedStatement ps = c.prepareStatement("DELETE FROM prodotto WHERE codP=?");
            ps.setInt(1, codP);
            if (ps.executeUpdate() != 1)
                throw new RuntimeException("DELETE ERROR");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Prodotto prodotto) throws SQLException{
        try(Connection c= ConPool.getConnection()){
            PreparedStatement ps= c.prepareStatement("UPDATE prodotto SET tipo=?, marca=?, modello=?, prezzo=?, quantità=?, immagine=?, IVA=? WHERE codP=?");
            ps.setString(1, prodotto.getTipo());
            ps.setString(2, prodotto.getMarca());
            ps.setString(3, prodotto.getModello());
            ps.setFloat(4, prodotto.getPrezzo());
            ps.setInt(5, prodotto.getQuantita());
            ps.setInt(6, prodotto.getCodP());
            ps.setString(7, prodotto.getImmagine());
            ps.setInt(8,prodotto.getIVA());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE ERROR.");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void UpdateQuantita(Prodotto prodotto, int q){
        int quantità= prodotto.getQuantita() - q;
        try(Connection c= ConPool.getConnection()){
            PreparedStatement ps= c.prepareStatement("UPDATE prodotto SET quantità=? WHERE codP=?");
            ps.setInt(1, quantità);
            ps.setInt(2,prodotto.getCodP());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE ERROR.");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
