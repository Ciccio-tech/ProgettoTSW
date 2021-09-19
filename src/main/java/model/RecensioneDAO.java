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

     public ArrayList<Recensione> doRetrieveByCodP(int codP) throws SQLException{
         try(Connection c= ConPool.getConnection()){
             PreparedStatement ps = c.prepareStatement("SELECT * FROM recensione WHERE codP=?");
             ps.setInt(1, codP);
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
