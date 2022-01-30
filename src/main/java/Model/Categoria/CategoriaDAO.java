package Model.Categoria;

import Controller.Http.Paginator;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CategoriaDAO <E extends Exception>{
    int countAll() throws SQLException;

    List<Categoria> fetchCategories(Paginator paginatore) throws SQLException;
    boolean deleteCategoria(String id) throws SQLException;
    Optional<Categoria> fetchCategoriesByID(int id) throws SQLException;
    boolean updateCategoria(Categoria categoriaAgg) throws SQLException;
    boolean createCategoria(Categoria categoria) throws SQLException;

    List<Categoria> fetchCategoriesAll() throws SQLException;
    // aggiungere i metodi sia qua che i metodi ed il corpo nel discussioniDAO
}
