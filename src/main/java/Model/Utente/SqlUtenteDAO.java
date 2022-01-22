package Model.Utente;

import Controller.Http.Paginator;
import Model.ConPool.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlUtenteDAO implements UtenteDAO<SQLException> {
    @Override
    public boolean createUtente(Utente utente) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("Insert into Utente(nome,cognome,email,password,universitario,ruolo) " +
                    "as value (?,?,?,?,?,?)")) {

                //Inserimento utente nel db
                ps.setString(1, utente.getNome());
                ps.setString(2, utente.getCognome());
                ps.setString(3, utente.getEmail());
                ps.setString(4, utente.getPassword());
                ps.setBoolean(5, utente.getUniversitario());
                ps.setInt(6, utente.getRuolo());

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
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("UPDATE Utente " +
                    "SET nome = ?, cognome = ?, email = ?, password = ?, universitario = ?, ruolo = ?" +
                    "WHERE id = ?;")) {

                //Inserimento utente nel db
                ps.setString(1, utente.getNome());
                ps.setString(2, utente.getCognome());
                ps.setString(3, utente.getEmail());
                ps.setString(4, utente.getPassword());
                ps.setBoolean(5, utente.getUniversitario());
                ps.setInt(6, utente.getRuolo());
                ps.setInt(7, utente.getIdUtente());

                int rows = ps.executeUpdate();

                return rows == 1;
            }
        }
    }

    @Override
    public boolean deleteUtente(int id) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("DELETE from Utente where id = ?;")) {

                ps.setInt(1, id);

                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public int countAllUtente() throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("SELECT count(*) as totaleUtenti from Utente")) {
                ResultSet rs = ps.executeQuery();
                int size = 0;
                if (rs.next()) {
                    size = rs.getInt("totaleUtenti");
                }
                return size;
            }
        }
    }

    @Override
    public Optional<Utente> findUtente(String email, String password) throws SQLException{
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("Select * from Utente where password=? AND mail=? ;")) {
                ps.setString(1, password);
                ps.setString(2, email);
                ResultSet rs = ps.executeQuery();
                Utente utente = new Utente();
                //   System.out.println("POST ESEGUO FIND"+cliente.getNome()+" "+ps.toString());
                if (rs.next()) {
                    utente.setIdUtente(rs.getInt("idUtente"));
                    utente.setEmail(rs.getString("mail"));
                    utente.setNome(rs.getString("nome"));
                    utente.setCognome(rs.getString("cognome"));
                    utente.setUniversitario(rs.getBoolean("universitario"));
                    utente.setRuolo(rs.getInt("ruolo"));
                }

                return Optional.ofNullable(utente);
            }

        }
    }

    @Override
    public List<Utente> fetchAccounts(Paginator paginatore) throws SQLException {

        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("SELECT * FROM Utente LIMIT ?,?")) {
                ps.setInt(1, paginatore.getOffset());
                ps.setInt(2, paginatore.getLimite());
                ResultSet rs = ps.executeQuery();
                List<Utente> clienti = new ArrayList<>();
                while (rs.next()) {
                    Utente utente = new Utente();
                    utente.setIdUtente(rs.getInt("idUtente"));
                    utente.setEmail(rs.getString("mail"));
                    utente.setNome(rs.getString("nome"));
                    utente.setCognome(rs.getString("cognome"));
                    utente.setUniversitario(rs.getBoolean("universitario"));
                    utente.setRuolo(rs.getInt("ruolo"));
                    clienti.add(utente);
                }

                return clienti;
            }
        }
    }

    @Override
    public Optional<Utente> findUtentebyID(int idCl)throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (   PreparedStatement ps =
                            con.prepareStatement("SELECT * FROM Utente WHERE idUtente=?")){
                ps.setInt(1, idCl);
                ResultSet rs = ps.executeQuery();
                Utente utente =new Utente();
                if (rs.next()) {
                    utente.setIdUtente(rs.getInt("idUtente"));
                    utente.setEmail(rs.getString("mail"));
                    utente.setNome(rs.getString("nome"));
                    utente.setCognome(rs.getString("cognome"));
                    utente.setUniversitario(rs.getBoolean("universitario"));
                    utente.setRuolo(rs.getInt("ruolo"));


                }

                return Optional.ofNullable(utente);
            }
        }
    }


}
