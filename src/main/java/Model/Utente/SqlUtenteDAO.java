package Model.Utente;

import Model.ConPool.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUtenteDAO implements UtenteDAO<SQLException>{
    @Override
    public boolean createUtente(Utente utente) throws SQLException {
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("Insert into Utente(nome,cognome,email,password,universitario,ruolo) " +
                    "as value (?,?,?,?,?,?)")){

                //Inserimento utente nel db
                ps.setString(1,utente.getNome());
                ps.setString(2,utente.getCognome());
                ps.setString(3,utente.getEmail());
                ps.setString(4,utente.getPassword());
                ps.setBoolean(5,utente.getUniversitario());
                ps.setInt(6,utente.getRuolo());

                int rows = ps.executeUpdate();

                /*Fetching dell'id
                ResultSet rs = ps.getGeneratedKeys();
                int id = rs.next() ? rs.getInt(1): -1;
                utente.setIdUtente(id);
                */
                return rows == 1;
            }
        }
    }

    @Override
    public boolean updateUtente(Utente utente) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteUtente(int id) throws SQLException {
        return false;
    }

    @Override
    public int countAllUtente() throws SQLException {
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("SELECT count(*) as totaleUtenti from Utente")){
                ResultSet rs = ps.executeQuery();
                int size = 0;
                if(rs.next()){
                    size = rs.getInt("totaleUtenti");
                }
                return size;
            }
        }
    }
}
