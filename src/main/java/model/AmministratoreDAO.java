package model;

/*
username varchar(20) primary key,
pass varchar(20) NOT NULL,
nome char(15) NOT NULL,
cognome char(15) NOT NULL
 */

import java.sql.*;
import java.util.ArrayList;

public class AmministratoreDAO {

    public ArrayList<Amministratore> doRettieveAll(int offset, int limit) throws SQLException {
        try (Connection c= ConPool.getConnection()){
            PreparedStatement ps= c.prepareStatement("SELECT * FROM amministratore LIMIT ?,?");
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ArrayList<Amministratore> arr= new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Amministratore a=new Amministratore();
                a.setUsername(rs.getString(1));
                a.setPassword(rs.getString(2));
                a.setNome(rs.getString(3));
                a.setCognome(rs.getString(4));
                arr.add(a);
            }
            return arr;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public boolean createAmministratore(Amministratore amministratore) throws SQLException {
        try(Connection c = ConPool.getConnection()){
            QueryBuilder queryBuilder = new QueryBuilder("amministratore", "admin");
            queryBuilder.insert("username, pass, nome, cognome");
            PreparedStatement ps=c.prepareStatement(queryBuilder.GenerateQuery());
                ps.setString(1, amministratore.getUsername());
                ps.setString(2, amministratore.getPassword());
                ps.setString(3, amministratore.getNome());
                ps.setString(4, amministratore.getCognome());
            if(ps.executeUpdate() == 1)
                return true;
            else
                return false;

        }
    }

    public boolean deleteAmministratore(String username) throws SQLException {
        try(Connection c=ConPool.getConnection()){
            QueryBuilder queryBuilder = new QueryBuilder("amministratore", "admin");
            queryBuilder.delete().where("username=?");
            PreparedStatement ps=c.prepareStatement(queryBuilder.GenerateQuery());
            ps.setString(1, username);
            if(ps.executeUpdate() == 1)
                return true;
            else
                return false;
        }
    }

}
