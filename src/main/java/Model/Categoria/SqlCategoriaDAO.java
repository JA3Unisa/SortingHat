package Model.Categoria;

import Controller.Http.Paginator;
import Model.ConPool.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlCategoriaDAO implements CategoriaDAO{
    @Override
    public int countAll () throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("Select count(*) as totaleCategorie FROM Categoria ;")) {
                ResultSet resultSet = ps.executeQuery();
                int size = 0;
                if (resultSet.next()) {
                    size = resultSet.getInt("totaleCategorie");
                }
                System.out.println(size);
                return size;
            }
        }
    }
    @Override
    public List<Categoria> fetchCategories(Paginator paginatore)  throws SQLException{
        try (Connection con = ConPool.getConnection()) {
            try (  PreparedStatement ps =
                           con.prepareStatement("SELECT * FROM Categoria LIMIT ?,?")) {
                ps.setInt(1, paginatore.getOffset());
                ps.setInt(2, paginatore.getLimite());
                ResultSet rs = ps.executeQuery();
                List<Categoria> categorie = new ArrayList<>();
                while (rs.next()) {
                    Categoria cat = new Categoria();
                    cat.setIdCategoria(rs.getInt("idCategoria"));
                    cat.setNome(rs.getString("nome"));
                    cat.setDescrizione(rs.getString("descrizione"));
                    categorie.add(cat);
                }

                return categorie;
            }
        }
    }

    @Override
    public Optional<Categoria> fetchCategoriesByID(int id) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("SELECT * FROM Categoria WHERE idCategoria=?")) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                Categoria cat = new Categoria();
                if (rs.next()) {

                    cat.setIdCategoria(rs.getInt("idCategoria"));
                    cat.setNome(rs.getString("nome"));
                    cat.setDescrizione(rs.getString("descrizione"));
                }

                return Optional.ofNullable(cat);
            }
        }
    }
}
