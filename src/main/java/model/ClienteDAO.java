package model;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;


public class ClienteDAO {

    public ArrayList<cliente> doRettieveAll(int offset, int limit) throws SQLException {
        try(Connection con= ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT username, passwordhash, nome, cognome, p_elettronica, data_nascita admin FROM utente LIMIT ?, ?");
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ArrayList<cliente> clienti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              cliente c=new cliente();
              c.setUsername(rs.getString(1));
              c.setPassword(rs.getString(2)); //creare un metodo hash per nascondere la password
              c.setNome(rs.getString(3));
              c.setCognome(rs.getString(4));
              c.setP_elettronica(rs.getString(5));
              //inserire la data
              clienti.add(c);
            }
            return clienti;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

 /*   public cliente doRetriveByUsernamePassword(String username, String password){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT username, password, nome, email, admin FROM utente WHERE username=?");
            ps.setString(0, username);
            ps.setString(1, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente p = new cliente();
                p.setUsername(rs.getString(1));
                p.setPassword(rs.getString(2));
                p.setNome(rs.getString(3));
                p.setP_elettronica(rs.getString(4));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
*/

    public cliente doRetrieveByUsername(String username) throws SQLException {
        try(Connection con= ConPool.getConnection()){
            PreparedStatement ps= con.prepareStatement("SELECT username, passwordhash, nome, cognome, p_elettronica, admin FROM utente WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cliente cl=new cliente();
                cl.setUsername(rs.getString(1));
                cl.setPassword(rs.getString(2));
                cl.setNome(rs.getString(3));
                cl.setCognome(rs.getString(4));
                cl.setP_elettronica(rs.getString(5));
                return cl;
            }
            return null;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    //da fare il metodo doSave

/*
    public ArrayList<cliente> fetchCliente(int start, int end) throws SQLException {
        DataSource source;
        try(Connection c= source.getConnection()){
            QueryBuilder queryBuilder = new QueryBuilder("account", "acc");
            String query = queryBuilder.select().GenerateQuery();
            try(PreparedStatement ps= c.prepareStatement(query)){
                ps.setInt(1, start);
                ps.setInt(2, end);
                ResultSet set = ps.executeQuery();
                cliente account = new cliente();
                ArrayList<cliente> accounts = new ArrayList<cliente>();
                while(set.next()){
                    accounts.add(c);
                }
                return accounts;
            }
        }
    }
*/
    public Boolean createCliente(cliente c) throws SQLException{
        return false;
    }

    public Boolean updateCliente(cliente c) throws  SQLException{
        return false;
    }

    public Boolean deleteCliente(cliente c) throws SQLException{
        return false;
    }

}