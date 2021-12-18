package Model.Utente;

import Model.ConPool.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUtenteDAO implements UtenteDAO<SQLException>{
    @Override
    public boolean createUtente(Utente utente) throws SQLException {
        return false;
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
