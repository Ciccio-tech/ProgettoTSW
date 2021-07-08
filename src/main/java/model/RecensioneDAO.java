package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


 /*
 username varchar(20) not null,
codP int not null,
FOREIGN KEY (username) REFERENCES utente_registrato(username)
on delete cascade
on update cascade,
FOREIGN KEY (codP) REFERENCES prodotto(codP)
on delete cascade
on update cascade,
primary key(username, codP),
dataR date NOT NULL,
voto int NOT NULL,
commento char(50)
  */
public class RecensioneDAO {

    public ArrayList<Recensione> doRetrieveAll(int offset, int limit) throws SQLException {
        try (Connection c = ConPool.getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM recensioni LIMI ?, ?");
            ResultSet rs = ps.executeQuery();
            ArrayList<Recensione> recensioni = new ArrayList<>();
            while (rs.next()) {
                Recensione r = new Recensione();
                r.setUsername(rs.getString(1));
                r.setCodP(rs.getInt(2));
                r.setDataS(rs.getString(3));
                r.setVoto(rs.getInt(4));
                r.setCommento(rs.getString(5));
                recensioni.add(r);
            }
            return recensioni;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean createRecensione(Recensione recensione) throws SQLException {
        try(Connection c= ConPool.getConnection()){
            QueryBuilder queryBuilder = new QueryBuilder("recensione", "rec");
            queryBuilder.insert("username, codP, dataR, voto, commento");
            PreparedStatement ps= c.prepareStatement(queryBuilder.GenerateQuery());
            if(ps.executeUpdate() == 1)
                return true;
            else
                return false;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public boolean deleteRecensione(Recensione recensione) throws SQLException{
        try(Connection c= ConPool.getConnection()){
            QueryBuilder queryBuilder = new QueryBuilder("recensione","rec");
            queryBuilder.delete().where("username = ?, codP= ?");
            PreparedStatement ps= c.prepareStatement(queryBuilder.GenerateQuery());
            ps.setString(1, recensione.getUsername());
            ps.setInt(2, recensione.getCodP());
            if(ps.executeUpdate() == 1)
                return true;
            else
                return false;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Recensione> doRetrieveByUsername(Cliente cliente) throws SQLException{
        try(Connection c= ConPool.getConnection()){
            QueryBuilder queryBuilder = new QueryBuilder("recensione","rec");
            queryBuilder.select("*").where("username = ?");
            PreparedStatement ps= c.prepareStatement(queryBuilder.GenerateQuery());
            ps.setString(1, cliente.getUsername());
            ResultSet rs=ps.executeQuery();
            ArrayList<Recensione> recensioni= new ArrayList<>();
            while(rs.next()){
                Recensione recensione= new Recensione();
                recensione.setUsername(rs.getString(1));
                recensione.setCodP(rs.getInt(2));
                recensione.setDataS(rs.getString(3));
                recensione.setVoto(rs.getInt(4));
                recensione.setCommento(rs.getString(5));
                recensioni.add(recensione);
            }
            return recensioni;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


     public ArrayList<Recensione> doRetrieveByCodP(Prodotto prodotto) throws SQLException{
         try(Connection c= ConPool.getConnection()){
             QueryBuilder queryBuilder = new QueryBuilder("recensione","rec");
             queryBuilder.select("*").where("codP = ?");
             PreparedStatement ps= c.prepareStatement(queryBuilder.GenerateQuery());
             ps.setInt(1, prodotto.getCodP());
             ResultSet rs=ps.executeQuery();
             ArrayList<Recensione> recensioni= new ArrayList<>();
             while(rs.next()){
                 Recensione recensione= new Recensione();
                 recensione.setUsername(rs.getString(1));
                 recensione.setCodP(rs.getInt(2));
                 recensione.setDataS(rs.getString(3));
                 recensione.setVoto(rs.getInt(4));
                 recensione.setCommento(rs.getString(5));
                 recensioni.add(recensione);
             }
             return recensioni;
         }catch(SQLException e){
             throw new RuntimeException(e);
         }
     }

}
