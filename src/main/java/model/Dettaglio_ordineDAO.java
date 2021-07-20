package model;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static model.ConPool.getConnection;
import static model.ConPool.releaseConnection;

public class  Dettaglio_ordineDAO {

    private void setOrdine (ResultSet rs,Ordine2 ord) throws SQLException {
        //fattura, prodotto, prezzoAp, quantita,

        try(Connection c= getConnection()){
            PreparedStatement ps= c.prepareStatement("SELECT * from ordine LIMIT ?, ?");
            prodottiCarrello p= new prodottiCarrello();

            p.getProdotto().setCodP(rs.getInt("codP"));
            p.getProdotto().setTipo(rs.getString("tipo"));
            p.getProdotto().setMarca(rs.getString("marca"));
            p.getProdotto().setModello(rs.getString("modello"));
            p.getProdotto().setPrezzo(rs.getFloat("prezzo"));
            p.getProdotto().setImmagine(rs.getString("immagine"));

            ord.setProd(p);
            ord.setQuantita(rs.getInt("quantita"));
        }
    }

    public void doSave(Dettaglio_ordine2 dettagli_ordine)throws Exception {

        Connection connection= getConnection();
        PreparedStatement preparedStatement = null, insert = null;
        java.util.Date da = new java.util.Date();

        try {

            if (updateQtyProducts(dettagli_ordine.getProdotti(), connection)) {
                preparedStatement = connection.prepareStatement(NEW_DET_ORD, java.sql.Statement.RETURN_GENERATED_KEYS);


                preparedStatement.setString(1, dettagli_ordine.getCliente().getUsername());
                preparedStatement.setDate(2, new java.sql.Date(da.getTime()));
                preparedStatement.setInt(3, dettagli_ordine.getIndirizzo().getCodice());
                preparedStatement.executeUpdate();

                ResultSet rs = preparedStatement.getGeneratedKeys();

                if (rs.next()) {
                    dettagli_ordine.setCod(rs.getInt(1));
                    java.util.List<Ordine2> list = dettagli_ordine.getProdotti();

                    for (Ordine2 o : list) {
                        prodottiCarrello prodotto = o.getProdotto();
                        insert = connection.prepareStatement(inserisciOrdine);
                        insert.setInt(1, dettagli_ordine.getCod());
                        insert.setInt(2, prodotto.getProdotto().getCodP());
                        insert.setDouble(3, prodotto.getProdotto().getPrezzo());
                        insert.setInt(4, o.getQuantita());
                        insert.setDouble(5, prodotto.getProdotto().getIVA());

                        insert.executeUpdate();
                    }

                }
            } else throw new Exception();

        } finally {
            try {
                if (preparedStatement != null || insert != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    releaseConnection(connection);
            }
        }
    }

    private boolean updateQtyProducts(List<Ordine2> prodotti, Connection connection) throws java.sql.SQLException {
        PreparedStatement preparedStatement = null;
        String updateProd = "UPDATE prodotto SET quantita = quantita - ? where codice = ?";
        int cont = 0;
        try {

            for (Ordine2 o : prodotti) {

            prodottiCarrello prodotto = o.getProdotto();
                preparedStatement = connection.prepareStatement(updateProd);
                preparedStatement.setInt(1, o.getQuantita());
                preparedStatement.setInt(2, prodotto.getProdotto().getCodP());

                preparedStatement.executeUpdate();
                cont++;
            }

        } catch (SQLException e) {
            String updateBack = "UPDATE prodotto SET quantita = quantita + ? where codice = ?";
            for (int i = 0; i < cont; i++) {
                Ordine2 o = prodotti.get(i);
                prodottiCarrello bean = o.getProdotto();
                preparedStatement = connection.prepareStatement(updateBack);
                preparedStatement.setInt(1, o.getQuantita());
                preparedStatement.setInt(2, bean.getProdotto().getCodP());

                preparedStatement.executeUpdate();
            }
            if (preparedStatement != null)
                preparedStatement.close();
            return false;
        }
        return true;
    }

    public boolean hasPurchased (prodottiCarrello prodotto,Cliente cli) throws SQLException{
        Connection connection= null;
        PreparedStatement preparedStatement = null;

        String sql= "select * from ordine join dettaglio_ordine on dettaglio_ordine = codF where username = ? and codP = ?";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cli.getUsername());
            preparedStatement.setInt(2, prodotto.getProdotto().getCodP());

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return true;
            }

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    releaseConnection(connection);
            }
        }
        return false;
    }

    /* recupero ordine*/

    public java.util.List<Ordine2> retrieveOrders (Cliente cliente, java.util.Date date, java.util.Date date2) throws java.sql.SQLException {
        Connection connection = null;
        SimpleDateFormat s = new SimpleDateFormat ("yyyy-MM-dd");
        String da = date != null ? s.format(date) : null;
        String a = date2 != null ? s.format(date2) : null;
        PreparedStatement preparedStatement = null;
        String selectSQL = da != null && a != null ? recuperoOrdine + " AND dataO BETWEEN "+da +" AND " +a : da == null && a == null ? recuperoOrdine: da == null && a!= null ? recuperoOrdine +" AND dataO < " +a : recuperoOrdine +" AND dataO> " +da;

        java.util.ArrayList<Ordine2 > prodotto = new java.util.ArrayList<Ordine2>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL + " ORDER BY codF");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Ordine2 bean = new Ordine2();

                setOrdine(rs, bean);
                prodotto.add(bean);
            }

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    releaseConnection(connection);
            }
        }
        return prodotto;
    }

    /*recuperare dettaglio ordini (fattura)*/
    private java.util.List<Ordine2> retrieveInvoiceOrders (int dettaglio,Connection c) throws java.sql.SQLException {

            PreparedStatement preparedStatement = null;
            java.util.List<Ordine2> list = new java.util.ArrayList<Ordine2>();

            preparedStatement = c.prepareStatement(recuperaDettaglioOrdine);
            preparedStatement.setInt(1, dettaglio);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Ordine2 o = new Ordine2();

                setOrdine(rs, o);
                list.add(o);
            }

            return list;

    }
    // recupera dettaglio_ordine
    public Dettaglio_ordine2 retrieveInvoice (Cliente cliente, int code) throws java.sql.SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Dettaglio_ordine2 det_or = new Dettaglio_ordine2();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(recuperaDettaglio);
            preparedStatement.setString(1, cliente.getUsername());
            preparedStatement.setInt(2, code);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                java.util.GregorianCalendar cl = new java.util.GregorianCalendar();
                cl.setTime(rs.getDate("dataO"));

                det_or.setCod(rs.getInt("codiceO"));
                det_or.setProdotti(this.retrieveInvoiceOrders(det_or.getCod(), connection));
                det_or.setCliente(new ClienteDAO().doRetrieveByUsername(cliente.getUsername()));
                det_or.setIndirizzo(new IndirizzoDAO().doRetrieve(rs.getInt("codInd")));
                det_or.setData(cl);
            }

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    releaseConnection(connection);
            }
        }

        return det_or;
    }

    public java.util.List<Dettaglio_ordine2> retrieveInvoices (Cliente cliente, java.util.Date data, java.util.Date data2) throws java.sql.SQLException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM " +ORDINE_TABLE + " WHERE username= ?";

        java.util.List<Dettaglio_ordine2> list = new java.util.ArrayList<Dettaglio_ordine2> ();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            if (data != null && data2 != null) {
                selectSQL = selectSQL + " AND dataO BETWEEN ? AND ?";
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setString(1, cliente.getUsername());
                preparedStatement.setDate(2, new java.sql.Date(data.getTime()));
                preparedStatement.setDate(3, new java.sql.Date(data2.getTime()));
            } else if (data != null && data2 == null) {
                selectSQL = selectSQL + " AND dataO > ?";
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setString(1, cliente.getUsername());
                preparedStatement.setDate(2, new java.sql.Date(data.getTime()));
            } else if (data == null && data2 != null) {
                selectSQL = selectSQL + " AND dataFattura < ?";
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setString(1, cliente.getUsername());
                preparedStatement.setDate(2, new java.sql.Date(data2.getTime()));
            } else {
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setString(1, cliente.getUsername());
            }



            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Dettaglio_ordine2 dett = new Dettaglio_ordine2();

                java.util.GregorianCalendar cl = new java.util.GregorianCalendar();
                cl.setTime(rs.getDate("dataO"));

                dett.setCod(rs.getInt("codF"));
                dett.setProdotti(this.retrieveInvoiceOrders(dett.getCod(), connection));
                dett.setIndirizzo(new IndirizzoDAO().doRetrieve(rs.getInt("codInd")));
                dett.setData(cl);
                dett.setCliente(cliente);

                list.add(dett);
            }

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    releaseConnection(connection);
            }
        }
        return list;
    }

    public List<Dettaglio_ordine2> retrieveInvoices(java.util.Date data, java.util.Date data2) throws SQLException {
        // TODO Auto-generated method stub
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM " +DET_TABLE +" JOIN " + UT_REG_TABLE + " ON username = username ";
        java.util.List<Dettaglio_ordine2> list = new java.util.ArrayList<Dettaglio_ordine2> ();

        try {
            connection = getConnection();

            if (data != null && data2 != null) {
                selectSQL = selectSQL + " WHERE dataO BETWEEN ? AND ?";
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setDate(1, new java.sql.Date(data.getTime()));
                preparedStatement.setDate(2, new java.sql.Date(data2.getTime()));
            } else if (data != null && data2 == null) {
                selectSQL = selectSQL + " WHERE dataO > ?";
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setDate(1, new java.sql.Date(data.getTime()));
            } else if (data == null && data2 != null) {
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setDate(1, new java.sql.Date(data2.getTime()));
            } else
                preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Dettaglio_ordine2 dett = new Dettaglio_ordine2();
                Cliente cliente = new Cliente ();
                java.util.GregorianCalendar cl = new java.util.GregorianCalendar();
                cl.setTime(rs.getDate("dataO"));

                ClienteDAO.setCliente(rs,cliente);
                dett.setCod(rs.getInt("codF"));
                dett.setProdotti(retrieveInvoiceOrders(dett.getCod(), connection));
                dett.setIndirizzo(new IndirizzoDAO().doRetrieve(rs.getInt("codInd")));
                dett.setData(cl);
                dett.setCliente(cliente);

                list.add(dett);
            }

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                      releaseConnection(connection);
            }
        }
        return list;
    }

    private static final String ORDINE_TABLE = "ordine";
    private static final String PROD_TABLE = "prodotto";
    private static final String DET_TABLE = "dettaglio_ordine";
    private static final String UT_REG_TABLE= "utente_registrato";
    private static final String NEW_DET_ORD="INSERT INTO " +DET_TABLE +" (codO,codP) VALUE (?,?) ";
    private static final String inserisciOrdine = "INSERT INTO "+ORDINE_TABLE+" VALUES (?, ?, ?, ?, ?, ?)";
    private static final String recuperoOrdine = "SELECT * FROM "+ORDINE_TABLE +" JOIN " +PROD_TABLE + " ON codP = codP WHERE username = ?";
    private static final String recuperaDettaglioOrdine= "SELECT * FROM " +ORDINE_TABLE +" JOIN " +PROD_TABLE + " ON codP = codP  WHERE codF = ?";
    private static final String recuperaDettaglio = "SELECT * FROM " +DET_TABLE +" WHERE username = ? AND codF = ?";

}