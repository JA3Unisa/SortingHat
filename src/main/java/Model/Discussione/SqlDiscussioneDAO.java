package Model.Discussione;

import Controller.Http.Paginator;
import Model.Categoria.Categoria;
import Model.Categoria.SqlCategoriaDAO;
import Model.ConPool.ConPool;
import Model.Utente.SqlUtenteDAO;
import Model.Utente.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlDiscussioneDAO implements DiscussioneDAO{
    @Override
    public int countAll () throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("Select count(*) as totaleDiscussione FROM Discussione ;")) {
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
                           con.prepareStatement("SELECT * FROM Categoria LIMIT ?,?")) {
                ps.setInt(1, paginatore.getOffset());
                ps.setInt(2, paginatore.getLimite());
                ResultSet rs = ps.executeQuery();
                List<Discussione> discussioni = new ArrayList<>();
                while (rs.next()) {
                    Discussione dis = new Discussione();
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
                         con.prepareStatement("SELECT * FROM Categoria WHERE idCategoria=?")) {
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
}
