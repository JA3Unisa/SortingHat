package Model.Discussione;

import Controller.Http.Paginator;
import Model.Categoria.Categoria;
import Model.Categoria.SqlCategoriaDAO;
import Model.ConPool.ConPool;
import Model.Utente.SqlUtenteDAO;
import Model.Utente.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlDiscussioneDAO implements DiscussioneDAO{
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
                    dis.setIdDiscussione(rs.getInt("idDiscussione"));
                    dis.setCorpo(rs.getString("nome"));
                    dis.setDataOra(rs.getTimestamp("dataOra"));          //?
                    dis.setTitolo(rs.getString("titolo"));
                    int idCategoria=(rs.getInt("idCategorie"));
                    SqlCategoriaDAO sqlCategoriaDAO=new SqlCategoriaDAO();
                    Optional<Categoria> categoria=sqlCategoriaDAO.fetchCategoriesByID(idCategoria);

                    int idUtente=(rs.getInt("idUtente"));
                    SqlUtenteDAO sqlUtenteDAO=new SqlUtenteDAO();
                    Optional<Utente> utente=sqlUtenteDAO.findUtentebyID(idUtente);
                    dis.setUtente(utente.get());



                    discussioni.add(dis);
                }

                return discussioni;
            }
        }
    }

    @Override
    public Optional<Discussione> fetchDiscussioniByID(int id) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("SELECT * FROM discussione WHERE iddiscussione=?")) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                Discussione  dis = new Discussione();
                if (rs.next()) {
                    dis.setIdDiscussione(rs.getInt("idDiscussione"));
                    dis.setCorpo(rs.getString("nome"));
                    // dis.setDataOra(rs.get("dataOra"));          //?
                    dis.setTitolo(rs.getString("titolo"));
                    int idCategoria=(rs.getInt("idCategorie"));
                    SqlCategoriaDAO sqlCategoriaDAO=new SqlCategoriaDAO();
                    Optional<Categoria> categoria=sqlCategoriaDAO.fetchCategoriesByID(idCategoria);

                    int idUtente=(rs.getInt("idUtente"));
                    SqlUtenteDAO sqlUtenteDAO=new SqlUtenteDAO();
                    Optional<Utente> utente=sqlUtenteDAO.findUtentebyID(idUtente);
                    dis.setUtente(utente.get());


                }

                return Optional.ofNullable(dis);
            }
        }
    }

    @Override
    public boolean createDiscussione(Discussione discussione) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (   PreparedStatement ps =
                            con.prepareStatement("INSERT INTO discussione (iddiscussione,corpo,dataora,titolo,idcategoria,idutente) VALUES(?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1,discussione.getIdDiscussione());
                ps.setString(2, discussione.getCorpo());
                ps.setTimestamp(3,discussione.getDataOra());
                ps.setString(4, discussione.getTitolo());
                ps.setInt(5, discussione.getCategoria().getIdCategoria());
                ps.setInt(6, discussione.getUtente().getIdUtente());

                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }
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
    @Override
    public boolean updateDiscussione(Discussione discussioneAgg) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("UPDATE  discussione SET = ?,= ? ,=?,=?,=? WHERE iddiscussione=?;")) {

                ps.setString(2, discussioneAgg.getCorpo());
                ps.setTimestamp(3,discussioneAgg.getDataOra());
                ps.setString(4, discussioneAgg.getTitolo());
                ps.setInt(5, discussioneAgg.getCategoria().getIdCategoria());
                ps.setInt(6, discussioneAgg.getUtente().getIdUtente());

                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }





}
