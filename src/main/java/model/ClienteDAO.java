package model;

import java.sql.*;
import java.util.ArrayList;


/*
create table utente_registrato(
username varchar(20) primary key,
pass varchar(20) NOT NULL,
nome char(15) NOT NULL,
cognome char(15) NOT NULL,
n_telefono char(10) NOT NULL,
email char(30) NOT NULL,
data_nascita date NOT NULL,
data_registrazione date NOT NULL,
indirizzo varchar(50) NOT NULL
);
 */

public class ClienteDAO {

    public ArrayList<Cliente> doRettieveAll(int offset, int limit) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT username, pass, nome, cognome, p_elettronica, data_nascita FROM utente LIMIT ?, ?");
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ArrayList<Cliente> cli = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setUsername(rs.getString(1));
                c.setPassword(rs.getString(2)); //creare un metodo hash per nascondere la password
                c.setNome(rs.getString(3));
                c.setCognome(rs.getString(4));
                c.setP_elettronica(rs.getString(5));
                //inserire la data
                cli.add(c);
            }
            return cli;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


  public static Cliente doRetrieveByUsernamePassword(String username){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT username, pass, nome, email FROM utente_registrato WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente p = new Cliente();
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


    public Cliente doRetrieveByUsername(String username) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT username, passwordhash, nome, cognome, p_elettronica FROM utente WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente cl = new Cliente();
                cl.setUsername(rs.getString(1));
                cl.setPassword(rs.getString(2));
                cl.setNome(rs.getString(3));
                cl.setCognome(rs.getString(4));
                cl.setP_elettronica(rs.getString(5));
                return cl;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return null;
    }


    //da fare il metodo doSave


    public ArrayList<Cliente> fetchCliente(int start, int end) throws SQLException {
        try (Connection c = ConPool.getConnection()) {
            QueryBuilder queryBuilder = new QueryBuilder("account", "acc");
            String query = queryBuilder.select().GenerateQuery();
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ps.setInt(1, start);
                ps.setInt(2, end);
                ResultSet set = ps.executeQuery();
                Cliente account = new Cliente();
                ArrayList<Cliente> accounts = new ArrayList<Cliente>();
                while (set.next()) {
                    accounts.add(account);
                }
                return accounts;
            }
        }
    }


    //creare un metodo che prende anche le informazioni delle relazioni

    public boolean createCliente(Cliente cliente) throws SQLException {
        try (Connection c = ConPool.getConnection()) {
            QueryBuilder queryBuilder = new QueryBuilder("cliente", "cli");
            queryBuilder.insert("username, passwordhash, nome, cognome, p_elettronica");
            try (PreparedStatement ps = c.prepareStatement(queryBuilder.GenerateQuery())) {
                ps.setString(1, cliente.getUsername());
                ps.setString(2, cliente.getPassword());
                ps.setString(3, cliente.getNome());
                ps.setString(4, cliente.getCognome());
                ps.setString(5, cliente.getP_elettronica());
                if (ps.executeUpdate() == 1) {
                    return true;
                } else
                    return false;
            }
        }
    }

    public boolean updateCliente(Cliente c) throws SQLException {
        try (Connection conn = ConPool.getConnection()) {
            QueryBuilder queryBuilder = new QueryBuilder("cliente", "cli");
            queryBuilder.update("nome", "cognome").where("username=?");
            try (PreparedStatement ps = conn.prepareStatement(queryBuilder.GenerateQuery())) {
                ps.setString(1, c.getNome());
                ps.setString(2, c.getCognome());
                ps.setString(3, c.getUsername());
                if (ps.executeUpdate() == 1)
                    return true;
                else
                    return false;
            }
        }
    }

    public boolean deleteCliente(String username) throws SQLException {
        try (Connection conn = ConPool.getConnection()) {
            QueryBuilder queryBuilder = new QueryBuilder("cliente", "cli");
            queryBuilder.delete().where("username=?");
            try (PreparedStatement ps = conn.prepareStatement(queryBuilder.GenerateQuery())) {
                ps.setString(1, username);
                return ps.executeUpdate() == 1;
            }
        }
    }

    public void doSave(Cliente cliente) throws SQLException{
        try(Connection c = ConPool.getConnection()){
            QueryBuilder queryBuilder = new QueryBuilder("cliente","cli");
            queryBuilder.insert("username, pass, nome, cognome, n_telefono, email, data_nascita, indirizzo");
            PreparedStatement ps= c.prepareStatement(queryBuilder.GenerateQuery());
            ps.setString(1, cliente.getUsername());
            ps.setString(2, cliente.getPassword());
            ps.setString(3, cliente.getNome());
            ps.setString(4, cliente.getCognome());
            ps.setLong(5, cliente.getTelefono());
            ps.setString(6, cliente.getP_elettronica());
            if(ps.executeUpdate() != 1)
                throw new RuntimeException("Insert Error");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


}