package Storage.Discussione;

import ApplicationLogic.Http.Paginator;
import Storage.Categoria.Categoria;
import Storage.Categoria.SqlCategoriaDAO;
import Storage.ConPool.ConPool;
import Storage.Utente.SqlUtenteDAO;
import Storage.Utente.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlDiscussioneDAO implements DiscussioneDAO{
    /**
     * Permette di contare le discussioni
     * @return
     * @throws SQLException
     */
    @Override
    public int countAll () throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("Select count(*) as totaleDiscussione FROM discussione ;")) {
                ResultSet resultSet = ps.executeQuery();
                int size = 0;
                if (resultSet.next()) {
                    size = resultSet.getInt("totaleDiscussione");
                }
                System.out.println(size);
                return size;
            }
        }
    }

    /**
     * Ottiene tutte le discussioni in base ad un paginatore
     * @param paginatore
     * @return
     * @throws SQLException
     */

    @Override
    public List<Discussione> fetchDiscussioni(Paginator paginatore)  throws SQLException{
        try (Connection con = ConPool.getConnection()) {
            try (  PreparedStatement ps =
                           con.prepareStatement("SELECT * FROM discussione LIMIT ?,?")) {
                ps.setInt(1, paginatore.getOffset());
                ps.setInt(2, paginatore.getLimite());
                ResultSet rs = ps.executeQuery();
                List<Discussione> discussioni = new ArrayList<>();
                while (rs.next()) {
                    Discussione dis = new Discussione();
                    dis.setIdDiscussione(rs.getInt("iddiscussione"));
                    dis.setCorpo(rs.getString("corpo"));
                    dis.setDataOra(rs.getTimestamp("dataOra"));
                    dis.setTitolo(rs.getString("titolo"));
                    int idCategoria=(rs.getInt("idcategoria"));
                    SqlCategoriaDAO sqlCategoriaDAO=new SqlCategoriaDAO();
                    Optional<Categoria> categoria=sqlCategoriaDAO.fetchCategoriesByID(idCategoria);
                    dis.setCategoria(categoria.get());

                    int idUtente=(rs.getInt("idutente"));
                    SqlUtenteDAO sqlUtenteDAO=new SqlUtenteDAO();
                    Optional<Utente> utente=sqlUtenteDAO.findUtentebyID(idUtente);
                    dis.setUtente(utente.get());



                    discussioni.add(dis);
                }
                rs.close();

                return discussioni;
            }
        }
    }

    /**
     * Ottiene la discussione corrispondente ad un id
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Optional<Discussione> fetchDiscussioniByID(int id) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("SELECT * FROM discussione WHERE iddiscussione=?")) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                Discussione  dis = new Discussione();
                if (rs.next()) {
                    dis.setIdDiscussione(rs.getInt("iddiscussione"));
                    dis.setCorpo(rs.getString("corpo"));
                    dis.setDataOra(rs.getTimestamp("dataOra"));
                    dis.setTitolo(rs.getString("titolo"));
                    int idCategoria=(rs.getInt("idcategoria"));
                    SqlCategoriaDAO sqlCategoriaDAO=new SqlCategoriaDAO();
                    Optional<Categoria> categoria=sqlCategoriaDAO.fetchCategoriesByID(idCategoria);

                    int idUtente=(rs.getInt("idutente"));
                    SqlUtenteDAO sqlUtenteDAO=new SqlUtenteDAO();
                    Optional<Utente> utente=sqlUtenteDAO.findUtentebyID(idUtente);
                    dis.setUtente(utente.get());


                }

                return Optional.ofNullable(dis);
            }
        }
    }

    /**
     * Permette di creare una discussione
     * @param discussione
     * @return
     * @throws SQLException
     */
    @Override
    public boolean createDiscussione(Discussione discussione) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (   PreparedStatement ps =
                            con.prepareStatement("INSERT INTO discussione (iddiscussione,corpo,dataora,titolo,idcategoria,idutente) VALUES(?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1,discussione.getIdDiscussione());
                ps.setString(2, discussione.getCorpo());
              //  ps.setTimestamp(3,discussione.getDataOra());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                ps.setTimestamp(3,timestamp);
                ps.setString(4, discussione.getTitolo());
                ps.setInt(5, discussione.getCategoria().getIdCategoria());
                ps.setInt(6, discussione.getUtente().getIdUtente());
                System.out.println(ps.toString());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    /**
     * Permette all'utente di creare una discussione
     * @param discussione
     * @return
     * @throws SQLException
     */
    public int createDiscussioneUtente(Discussione discussione) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (   PreparedStatement ps =
                            con.prepareStatement("INSERT INTO discussione (iddiscussione,corpo,dataora,titolo,idcategoria,idutente) VALUES(?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1,discussione.getIdDiscussione());
                ps.setString(2, discussione.getCorpo());
                //  ps.setTimestamp(3,discussione.getDataOra());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                ps.setTimestamp(3,timestamp);
                ps.setString(4, discussione.getTitolo());
                ps.setInt(5, discussione.getCategoria().getIdCategoria());
                ps.setInt(6, discussione.getUtente().getIdUtente());


                 ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                int id = rs.next() ? rs.getInt(1): 0;
                System.out.println("CHIAVE"+id);
                return id;
            }
        }
    }

    /**
     * Permette di ottenere le discussioni di una particolare categoria
     * @param categoria
     * @param paginatore
     * @return
     * @throws SQLException
     */
    @Override
    public List<Discussione> fetchDiscussioniByCategoria(Categoria categoria,Paginator paginatore) throws SQLException {
        String str = "SELECT * FROM discussione WHERE idcategoria = " + categoria.getIdCategoria() + " LIMIT ?,?";
        try (Connection con = ConPool.getConnection()) {
            try (  PreparedStatement ps =
                           con.prepareStatement(str)) {
                ps.setInt(1, paginatore.getOffset());
                ps.setInt(2, paginatore.getLimite());
                ResultSet rs = ps.executeQuery();
                List<Discussione> discussione = new ArrayList<>();
                while (rs.next()) {
                    Discussione dis = new Discussione();
                    dis.setIdDiscussione(rs.getInt("iddiscussione"));
                    dis.setCorpo(rs.getString("corpo"));
                    dis.setDataOra(rs.getTimestamp("dataOra"));          //?
                    dis.setTitolo(rs.getString("titolo"));
                    int idCategoria = (rs.getInt("idcategoria"));
                    SqlCategoriaDAO sqlCategoriaDAO = new SqlCategoriaDAO();
                    Optional<Categoria> categorie = sqlCategoriaDAO.fetchCategoriesByID(idCategoria);
                    dis.setCategoria(categorie.get());

                    int idUtente = (rs.getInt("idutente"));
                    SqlUtenteDAO sqlUtenteDAO = new SqlUtenteDAO();
                    Optional<Utente> utente = sqlUtenteDAO.findUtentebyID(idUtente);
                    dis.setUtente(utente.get());

                    discussione.add(dis);
                }
                // System.out.println("qui in sql"+categorie.get(0).getIdCategoria());

                return discussione;
            }
        }
    }

    /**
     * Ottiene tutte le discussioni
     * @return
     * @throws SQLException
     */
    @Override
    public List<Discussione> fetchDiscussioniAll()  throws SQLException{
        try (Connection con = ConPool.getConnection()) {
            try (  PreparedStatement ps =
                           con.prepareStatement("SELECT * FROM discussione")) {

                ResultSet rs = ps.executeQuery();
                List<Discussione> discussione = new ArrayList<>();
                while (rs.next()) {
                    Discussione dis = new Discussione();
                    dis.setIdDiscussione(rs.getInt("iddiscussione"));
                    dis.setCorpo(rs.getString("corpo"));
                    dis.setDataOra(rs.getTimestamp("dataOra"));          //?
                    dis.setTitolo(rs.getString("titolo"));
                    int idCategoria = (rs.getInt("idcategoria"));
                    SqlCategoriaDAO sqlCategoriaDAO = new SqlCategoriaDAO();
                    Optional<Categoria> categoria = sqlCategoriaDAO.fetchCategoriesByID(idCategoria);
                    dis.setCategoria(categoria.get());

                    int idUtente = (rs.getInt("idutente"));
                    SqlUtenteDAO sqlUtenteDAO = new SqlUtenteDAO();
                    Optional<Utente> utente = sqlUtenteDAO.findUtentebyID(idUtente);
                    dis.setUtente(utente.get());

                    discussione.add(dis);
                }
                // System.out.println("qui in sql"+categorie.get(0).getIdCategoria());

                return discussione;
            }
        }
    }

    /**
     * Permette di eliminare la discussione corrispondente all'id
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public boolean deleteDiscussione(String id) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("DELETE FROM discussione WHERE iddiscussione=?;")) {
                ps.setString(1, id);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    /**
     * Permette di aggiornare una discussione
     * @param discussioneAgg
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateDiscussione(Discussione discussioneAgg) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("UPDATE  discussione SET corpo= ?,dataOra= ? ,titolo=?,idcategoria=?,idutente=? WHERE iddiscussione=?;")) {

                ps.setString(1, discussioneAgg.getCorpo());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                ps.setTimestamp(2,timestamp);
                ps.setString(3, discussioneAgg.getTitolo());
                ps.setInt(4, discussioneAgg.getCategoria().getIdCategoria());
                ps.setInt(5, discussioneAgg.getUtente().getIdUtente());
                ps.setInt(6,discussioneAgg.getIdDiscussione());

                System.out.println(ps.toString());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }





}
