package Model.Categoria;

import Controller.Http.Paginator;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CategoriaDAO <E extends Exception>{
    int countAll() throws SQLException;

    List<Categoria> fetchCategories(Paginator paginatore) throws SQLException;

    Optional<Categoria> fetchCategoriesByID(String id) throws SQLException;
}
