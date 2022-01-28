package Model.Categoria;

import Controller.Http.Paginator;
import Model.ConPool.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlCategoriaDAO implements CategoriaDAO {
    @Override
    public int countAll() throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("Select count(*) as totaleCategorie FROM categoria ;")) {
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
    public List<Categoria> fetchCategories(Paginator paginatore) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("SELECT * FROM categoria LIMIT ?,?")) {
                ps.setInt(1, paginatore.getOffset());
                ps.setInt(2, paginatore.getLimite());
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                List<Categoria> categorie = new ArrayList<>();
                while (rs.next()) {
                    Categoria cat = new Categoria();
                    cat.setIdCategoria(rs.getInt("idcategoria"));
                    cat.setNome(rs.getString("nome"));
                    cat.setDescrizione(rs.getString("descrizione"));
                    cat.setTitoloDescrizione(rs.getString("titoloDescrizione"));
                    cat.setDataOra(rs.getTimestamp("dataOra"));
                    categorie.add(cat);
                }
                System.out.println(categorie.size());
                return categorie;
            }
        }
    }

    @Override
    public Optional<Categoria> fetchCategoriesByID(int id) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("SELECT * FROM categoria WHERE idcategoria=?")) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                Categoria cat = new Categoria();
                if (rs.next()) {

                    cat.setIdCategoria(rs.getInt("idcategoria"));
                    cat.setNome(rs.getString("nome"));
                    cat.setDescrizione(rs.getString("descrizione"));
                }

                return Optional.ofNullable(cat);
            }
        }
    }

    @Override
    public boolean deleteCategoria(String id) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("DELETE FROM categoria WHERE idcategoria=?;")) {
                ps.setString(1, id);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean createCategoria(Categoria categoria) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (   PreparedStatement ps =
                            con.prepareStatement("INSERT INTO categoria (nome, descrizione) VALUES(?,?);", Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, categoria.getNome());
                ps.setString(2, categoria.getDescrizione());
                System.out.println(ps.toString());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean updateCategoria(Categoria categoriaAgg) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("UPDATE  categoria SET nome= ?,descrizione= ? WHERE idcategoria=?;")) {
                ps.setString(1, categoriaAgg.getNome());
                ps.setString(2, categoriaAgg.getDescrizione());
                ps.setInt(3, categoriaAgg.getIdCategoria());

                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }
}
