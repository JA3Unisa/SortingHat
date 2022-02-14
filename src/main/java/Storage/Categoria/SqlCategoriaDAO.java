package Storage.Categoria;

import ApplicationLogic.Http.Paginator;
import Storage.ConPool.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlCategoriaDAO implements CategoriaDAO {
    /**
     * Questa funziona permette di contare le categorie
     * @return
     * @throws SQLException
     */
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

                return size;
            }
        }
    }

    /**
     * Questa funzione permettere di ottenere le categorie in base ad un paginatore
     * @param paginatore
     * @return
     * @throws SQLException
     */

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

                return categorie;
            }
        }
    }

    /**
     * Questa funzione permette di ottenere la categoria corrispondente ad un id
     * @param id
     * @return
     * @throws SQLException
     */
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
                    cat.setTitoloDescrizione(rs.getString("titoloDescrizione"));
                    cat.setDataOra(rs.getTimestamp("dataOra"));

                }

                return Optional.ofNullable(cat);
            }
        }
    }

    /**
     * Permette di eliminare una categoria
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public boolean deleteCategoria(String id) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("DELETE FROM categoria WHERE idcategoria=?;")) {
                ps.setString(1, id);
                System.out.println(ps.toString());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    /**
     * Permette di creare una categoria
     * @param categoria
     * @return
     * @throws SQLException
     */
    @Override
    public boolean createCategoria(Categoria categoria) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (   PreparedStatement ps =
                            con.prepareStatement("INSERT INTO categoria (nome, descrizione,titoloDescrizione,dataOra) VALUES(?,?,?,?);", Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, categoria.getNome());
                ps.setString(2, categoria.getDescrizione());
                ps.setString(3,categoria.getTitoloDescrizione());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                ps.setTimestamp(4,timestamp);

                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    /**
     * Ottiene tutte le categorie
     * @return
     * @throws SQLException
     */
    @Override
    public List<Categoria> fetchCategoriesAll() throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (   PreparedStatement ps =
                            con.prepareStatement("SELECT * FROM categoria")) {
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

                return categorie;
            }
        }
    }

    /**
     * Permette di aggiornare una categoria
     * @param categoriaAgg
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateCategoria(Categoria categoriaAgg) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (PreparedStatement ps =
                         con.prepareStatement("UPDATE  categoria SET nome= ?,descrizione= ?,titoloDescrizione=?,dataOra=? WHERE idcategoria=?;")) {
                ps.setString(1, categoriaAgg.getNome());
                ps.setString(2, categoriaAgg.getDescrizione());
                ps.setString(3, categoriaAgg.getTitoloDescrizione());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                ps.setTimestamp(4,timestamp);
                ps.setInt(5, categoriaAgg.getIdCategoria());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }
}
