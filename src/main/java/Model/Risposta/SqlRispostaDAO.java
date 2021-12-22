package Model.Risposta;

import Model.ConPool.ConPool;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class SqlRispostaDAO implements RispostaDAO{
    @Override
    public boolean createRisposta(Risposta risposta) throws Exception {
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("Insert into Risposta(corpo,dataOra,idUtente,idDiscussione) " +
                    "as value (?,?,?,?);")){

                ps.setString(1,risposta.getCorpo());

                ps.setInt(3,risposta.getIdUtente());
                ps.setInt(3,risposta.getIdDiscussione());

                int rows = ps.executeUpdate();

                return rows == 1;
            }
        }
    }

    @Override
    public boolean updateRisposta(Risposta risposta) throws Exception {
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("UPDATE Utente " +
                    "SET corpo = ?, dataOra = ?, idUtente = ?, idDiscussione = ?" +
                    "WHERE id = ?;")){

                //Inserimento utente nel db
                ps.setString(1,risposta.getCorpo());
                Date date = new Date(risposta.getdataOra().getTimeInMillis());
                ps.setDate(2,date);
                ps.setInt(3,risposta.getIdUtente());
                ps.setInt(4,risposta.getIdDiscussione());
                ps.setInt(5,risposta.getIdRisposta());

                int rows = ps.executeUpdate();

                return rows == 1;
            }
        }
    }

    @Override
    public boolean deleteRisposta(int id) throws Exception {
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("DELETE from Risposta where id = ?;")){

                ps.setInt(1,id);

                int rows = ps.executeUpdate();

                return rows == 1;
            }
        }
    }
}
