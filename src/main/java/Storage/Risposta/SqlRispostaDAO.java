package Storage.Risposta;

import ApplicationLogic.Http.Paginator;
import Storage.ConPool.ConPool;
import Storage.Discussione.Discussione;
import Storage.Discussione.SqlDiscussioneDAO;
import Storage.Utente.SqlUtenteDAO;
import Storage.Utente.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlRispostaDAO implements RispostaDAO {
    @Override
    public boolean createRisposta(Risposta risposta) throws Exception {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("Insert into risposta(corpo,dataora,idutente,iddiscussione) " +
                    " values (?,?,?,?);")) {
System.out.println("PRE CREATE");
                ps.setString(1, risposta.getCorpo());
                //Date date = new Date(risposta.getdataOra().getTimeInMillis());
                // ps.setDate(2,date);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                ps.setTimestamp(2,timestamp);
                ps.setInt(3, risposta.getUtente().getIdUtente());
                ps.setInt(4, risposta.getDiscussione().getIdDiscussione());
System.out.println(ps.toString());
                int rows = ps.executeUpdate();

                return rows == 1;
            }
        }
    }

    @Override
    public boolean updateRisposta(Risposta risposta) throws Exception {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("UPDATE risposta " +
                    "SET corpo = ?, dataora = ?, idutente = ?, iddiscussione = ? " +
                    "WHERE idrisposta = ?;")) {

                //Inserimento utente nel db
                ps.setString(1, risposta.getCorpo());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                ps.setTimestamp(2,timestamp);
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

                return size;
            }
        }
    }

    @Override
    public List<Risposta> fetchRispostaByIdDiscussione(int idDiscussione, Paginator paginator) throws SQLException {
        String query ="SELECT * FROM risposta r WHERE r.idDiscussione = "+idDiscussione+" LIMIT ?,?";
        try (Connection con = ConPool.getConnection()){
            try (PreparedStatement ps =
                    con.prepareStatement(query)){
                ps.setInt(1,paginator.getOffset());
                ps.setInt(2,paginator.getLimite());
                ResultSet rs = ps.executeQuery();
                List<Risposta> risposte = new ArrayList<>();
                while (rs.next()){
                    Risposta r = new Risposta();
                    r.setIdRisposta(rs.getInt("idrisposta"));
                    r.setCorpo(rs.getString("corpo"));
                    r.setDataOra(rs.getTimestamp("dataOra"));

                    int idUtente = rs.getInt("idUtente");
                    SqlUtenteDAO utenteDAO = new SqlUtenteDAO();
                    Utente utente = utenteDAO.findUtentebyID(idUtente).get();
                    r.setUtente(utente);

                    SqlDiscussioneDAO discussioneDAO = new SqlDiscussioneDAO();
                    Discussione discussione = discussioneDAO.fetchDiscussioniByID(idDiscussione).get();
                    r.setDiscussione(discussione);

                    risposte.add(r);
                }
                return risposte;
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
                    cat.setIdRisposta(rs.getInt("idrisposta"));
                    cat.setCorpo(rs.getString("corpo"));
                    cat.setDataOra(rs.getTimestamp("dataOra"));

                    int idUtente = (rs.getInt("idutente"));
                    SqlUtenteDAO sqlUtenteDAO = new SqlUtenteDAO();
                    Optional<Utente> utente = sqlUtenteDAO.findUtentebyID(idUtente);
                    cat.setUtente(utente.get());


                    int idDiscussione = (rs.getInt("iddiscussione"));
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

                    cat.setIdRisposta(rs.getInt("idrisposta"));
                    cat.setCorpo(rs.getString("corpo"));
                    cat.setDataOra(rs.getTimestamp("dataOra"));
                    int idUtente = (rs.getInt("idutente"));
                    SqlUtenteDAO sqlUtenteDAO = new SqlUtenteDAO();
                    Optional<Utente> utente = sqlUtenteDAO.findUtentebyID(idUtente);
                    cat.setUtente(utente.get());


                    int idDiscussione = (rs.getInt("iddiscussione"));
                    SqlDiscussioneDAO sqlDiscussioneDAO = new SqlDiscussioneDAO();
                    Optional<Discussione> discussione=sqlDiscussioneDAO.fetchDiscussioniByID(idDiscussione);
                     cat.setDiscussione(discussione.get());

                }

                return Optional.ofNullable(cat);
            }
        }
    }
}
