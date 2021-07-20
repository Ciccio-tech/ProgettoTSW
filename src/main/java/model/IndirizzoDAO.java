package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static model.ConPool.getConnection;
import static model.ConPool.releaseConnection;

public class IndirizzoDAO {

        protected void setBean (ResultSet rs, Indirizzo ind) throws SQLException {
            ind.setCodice(rs.getInt("codInd"));
            ind.setCAP(rs.getInt("cap"));
            ind.setVia(rs.getString("via"));
            ind.setnCv(rs.getInt("nCivico"));
            ind.setCitta(rs.getString("citta"));
            ind.setProvincia(rs.getString("provincia"));
            ind.setNazione(rs.getString("stato"));
        }
        protected void prepareInsertStatement (PreparedStatement preparedStatement, Cliente cliente ,Indirizzo indirizzo) throws SQLException {
            preparedStatement.setString(1, cliente.getUsername());
            preparedStatement.setString(2, indirizzo.getVia());
            preparedStatement.setInt(3,indirizzo.getCAP());
            preparedStatement.setInt(4, indirizzo.getnCv());
            preparedStatement.setString(5, indirizzo.getCitta());
            preparedStatement.setString(6, indirizzo.getProvincia());
            preparedStatement.setString(7, indirizzo.getNazione());

        }

        private int retrieveCode (Indirizzo indirizzo, String nomeUtente, Connection connection) throws SQLException {
            String checkSQL = "SELECT codInd FROM indirizzo WHERE username = ? AND via = ? AND cap = ? AND nCivico = ? AND citta = ? AND provincia = ? AND stato = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(checkSQL);
            //registrato, via, cap,  nCivico, citta, provincia, stato
            prepareStatement.setString(1, nomeUtente);
            prepareStatement.setString(2, indirizzo.getVia());
            prepareStatement.setInt(3, indirizzo.getCAP());
            prepareStatement.setInt(4, indirizzo.getnCv());
            prepareStatement.setString(5, indirizzo.getCitta());
            prepareStatement.setString(6, indirizzo.getProvincia());
            prepareStatement.setString(7, indirizzo.getNazione());

            ResultSet rs = prepareStatement.executeQuery();

            return rs.next() ? rs.getInt(1) : -1;
        }

    public int doSave(Indirizzo indirizzo, Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            prepareInsertStatement(preparedStatement, cliente, indirizzo);

            preparedStatement.executeUpdate();
            int code = retrieveCode (indirizzo, cliente.getUsername(), connection);

            return code;
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                connection.close();
            }
        }


    }

    public boolean doDelete(int code) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, code);

            result = preparedStatement.executeUpdate();

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                releaseConnection(connection);
            }
        }
        return (result != 0);
    }

    public java.util.Map<Integer, Indirizzo> doRetrieveAll(String nomeUtente) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        java.util.HashMap<Integer, Indirizzo> products = new java.util.HashMap<Integer,Indirizzo>();
        System.out.println(nomeUtente);
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(selectAllSQL);
            preparedStatement.setString(1, nomeUtente);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Indirizzo indirizzo = new Indirizzo();

                setBean(rs, indirizzo);
                products.put(indirizzo.getCodice(), indirizzo);
            }

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
              releaseConnection(connection);
            }
        }
        return products;

    }

    public boolean doModify(int code, Indirizzo indirizzo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;

        try {
            connection =getConnection();
            preparedStatement = connection.prepareStatement(updateSQL);

            preparedStatement.setString(1, indirizzo.getVia());
            preparedStatement.setInt(2, indirizzo.getCAP());
            preparedStatement.setInt(3, indirizzo.getnCv());
            preparedStatement.setString(4, indirizzo.getCitta());
            preparedStatement.setString(5, indirizzo.getProvincia());
            preparedStatement.setString(6, indirizzo.getNazione());
            preparedStatement.setInt(7, code);

            result = preparedStatement.executeUpdate();

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                releaseConnection(connection);
            }
        }
        return (result != 0);
    }


    public Indirizzo doRetrieve(int code) throws SQLException {
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Indirizzo indirizzo = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, code);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                indirizzo = new Indirizzo();
                setBean(rs, indirizzo);
            }



        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                releaseConnection(connection);
            }
        }
        return indirizzo;

    }


        protected static final String TABLE_NAME = "indirizzo";
        protected static final String selectAllSQL = "SELECT * FROM " + TABLE_NAME +" WHERE username = ?";
        protected static final String deleteSQL = "UPDATE "+TABLE_NAME+" SET utente_registrato = null WHERE username = ?";
        protected static final String insertSQL = "INSERT INTO indirizzo "
                + "(username, via, cap,  nCivico, citta, provincia, stato)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        protected static final String updateSQL = "UPDATE indirizzo SET via = ?, cap = ?, nCivico = ?, citta = ?, provincia = ?, stato = ? "
                + "WHERE codInd = ?";
        private static final String selectSQL = "SELECT * FROM " + TABLE_NAME +" WHERE codInd = ?";

    }


