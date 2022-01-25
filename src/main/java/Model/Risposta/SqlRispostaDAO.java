package Model.Risposta;

import Controller.Http.Paginator;
import Model.ConPool.ConPool;
import Model.Discussione.Discussione;
import Model.Discussione.SqlDiscussioneDAO;
import Model.Utente.SqlUtenteDAO;
import Model.Utente.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

public class SqlRispostaDAO implements RispostaDAO {
    @Override
    public boolean createRisposta(Risposta risposta) throws Exception {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("Insert into Risposta(corpo,dataora,idutente,iddiscussione) " +
                    "as value (?,?,?,?);")) {

                ps.setString(1, risposta.getCorpo());
                //Date date = new Date(risposta.getdataOra().getTimeInMillis());
                // ps.setDate(2,date);

                ps.setInt(3, risposta.getUtente().getIdUtente());
                ps.setInt(4, risposta.getDiscussione().getIdDiscussione());

                int rows = ps.executeUpdate();

                return rows == 1;
            }
        }
    }

    @Override
    public boolean updateRisposta(Risposta risposta) throws Exception {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("UPDATE utente " +
                    "SET corpo = ?, dataora = ?, idutente = ?, iddiscussione = ?" +
                    "WHERE idrisposta = ?;")) {

                //Inserimento utente nel db
                ps.setString(1, risposta.getCorpo());
                Date date = new Date(risposta.getdataOra().getTimeInMillis());
                ps.setDate(2, date);
                ps.setInt(3, risposta.getUtente().getIdUtente());
                ps.setInt(4, risposta.getDiscussione().getIdDiscussione());
                ps.setInt(5, risposta.getIdRisposta());

                int rows = ps.executeUpdate();

                return rows == 1;
            }
        }
    }

    @Override
    public boolean deleteRisposta(int id) throws Exception {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("DELETE from risposta where idrisposta = ?;")) {

                ps.setInt(1, id);

                int rows = ps.executeUpdate();

                return rows == 1;
            }
        }
    }

    @Override
    public int countAll() throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("Select count(*) as totaleRisposte FROM risposta ;")) {
                ResultSet resultSet = ps.executeQuery();
                int size = 0;
                if (resultSet.next()) {
                    size = resultSet.getInt("totaleRisposte");
                }
                System.out.println(size);
                return size;
            }
        }
    }

    @Override
    public List<Risposta> fetchRisposta(Paginator paginatore) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("SELECT * FROM risposta LIMIT ?,?")) {
                ps.setInt(1, paginatore.getOffset());
                ps.setInt(2, paginatore.getLimite());
                ResultSet rs = ps.executeQuery();
                List<Risposta> rispostas = new ArrayList<>();
                while (rs.next()) {
                    Risposta cat = new Risposta();
                    cat.setIdRisposta(rs.getInt("idRisposta"));
                    cat.setCorpo(rs.getString("corpo"));
                    Date dataR = (rs.getDate("dataOra"));
                    // cat.setDataOra(dataR);

                    int idUtente = (rs.getInt("idUtente"));
                    SqlUtenteDAO sqlUtenteDAO = new SqlUtenteDAO();
                    Optional<Utente> utente = sqlUtenteDAO.findUtentebyID(idUtente);
                    cat.setUtente(utente.get());


                    int idDiscussione = (rs.getInt("idDiscussione"));
                    SqlDiscussioneDAO sqlDiscussioneDAO = new SqlDiscussioneDAO();
                     Optional<Discussione> discussione = sqlDiscussioneDAO.fetchDiscussioniByID(idDiscussione);
                      cat.setDiscussione(discussione.get());

                    rispostas.add(cat);
                }

                return rispostas;
            }
        }
    }

    @Override
    /* private int idRisposta;
    private String corpo;
    private GregorianCalendar dataOra;

     */
    public Optional<Risposta> fetchRisposte(int idUpd) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("SELECT * FROM risposta WHERE idrisposta=?")) {
                ps.setInt(1, idUpd);
                ResultSet rs = ps.executeQuery();
                Risposta cat = new Risposta();
                if (rs.next()) {

                    cat.setIdRisposta(rs.getInt("idRisposta"));
                    cat.setCorpo(rs.getString("corpo"));
                    //  cat.setDataOra(rs.getDate("dataOra"));
                    int idUtente = (rs.getInt("idUtente"));
                    SqlUtenteDAO sqlUtenteDAO = new SqlUtenteDAO();
                    Optional<Utente> utente = sqlUtenteDAO.findUtentebyID(idUtente);
                    cat.setUtente(utente.get());


                    int idDiscussione = (rs.getInt("idDiscussione"));
                    SqlDiscussioneDAO sqlDiscussioneDAO = new SqlDiscussioneDAO();
                    Optional<Discussione> discussione=sqlDiscussioneDAO.fetchDiscussioniByID(idDiscussione);
                     cat.setDiscussione(discussione.get());

                }

                return Optional.ofNullable(cat);
            }
        }
    }
}
