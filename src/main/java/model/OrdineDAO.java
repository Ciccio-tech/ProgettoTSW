package model;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

/*
codO int primary key,
stato boolean NOT NULL,
dataO date NOT NULL,
username varchar(20)  not null,
foreign key(username) references utente_registrato(username)
 */


public class OrdineDAO {

    public ArrayList<Ordine> doRetrieveAll(int offset, int limit) throws SQLException {
        try(Connection c= ConPool.getConnection()){
            PreparedStatement ps= c.prepareStatement("SELECT * FROM ordine LIMIT ?, ?");
            ArrayList<Ordine> ArrOr = new ArrayList<>();
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Ordine ordine= new Ordine();
                ordine.setCodO(Integer.parseInt(rs.getString(1)));
                ordine.setStato(Boolean.parseBoolean(rs.getString(2)));
                ordine.SetDataS(rs.getString(3));
                ordine.setUsername(rs.getString(4));
                ArrOr.add(ordine);
            }
            return ArrOr;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean createOrdine(Ordine ordine) throws SQLException{
        try(Connection c = ConPool.getConnection()){
            QueryBuilder queryBuilder= new QueryBuilder("ordine");
            queryBuilder.insert("codO, stato, dataO, username");
            PreparedStatement ps= c.prepareStatement(queryBuilder.GenerateQuery());
            ps.setInt(1, ordine.getCodO());
            ps.setBoolean(2, ordine.isStato());
            ps.setString(3, ordine.getData());
            ps.setString(4, ordine.getUsername());
            if(ps.executeUpdate() == 1)
                return true;
            else
                return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean deleteOrdine(Ordine ordine)throws SQLException{
        try(Connection c= ConPool.getConnection()){
            QueryBuilder queryBuilder= new QueryBuilder("ordine");
            queryBuilder.delete().where("codO=?");
            PreparedStatement ps= c.prepareStatement(queryBuilder.GenerateQuery());
            ps.setInt(1, ordine.getCodO());
            if(ps.executeUpdate() == 1)
                return true;
            else
                return false;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Ordine> doRetrieveByUsername(String username) throws SQLException{
        try(Connection c = ConPool.getConnection()){
            /*
            QueryBuilder queryBuilder = new QueryBuilder("ordine");
            queryBuilder.select("*").where("username= ?");
             */
            PreparedStatement ps= c.prepareStatement("SELECT * FROM ordine WHERE username=?");
            ps.setString(1, username);
            ResultSet rs= ps.executeQuery();
            ArrayList<Ordine> ordini = new ArrayList<>();
            while(rs.next()){
                Ordine o= new Ordine();
                o.setCodO(rs.getInt(1));
                o.setStato(rs.getBoolean(2));
                o.SetDataS(rs.getString(3));
                o.setUsername(rs.getString(4));
                ordini.add(o);
            }
            return ordini;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


}
