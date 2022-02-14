package Storage.Discussione;

import ApplicationLogic.Http.Paginator;
import Storage.Categoria.Categoria;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Interfaccia che permette di gestire le discussioni
 * @param <E>
 */
public interface DiscussioneDAO <E extends Exception>{
    int countAll() throws SQLException;

    List<Discussione> fetchDiscussioni(Paginator paginatore) throws SQLException;

    Optional<Discussione> fetchDiscussioniByID(int id) throws SQLException;
    public boolean deleteDiscussione(String id) throws SQLException;
    public boolean updateDiscussione(Discussione discussioneAgg) throws SQLException;
    public boolean createDiscussione(Discussione discussione) throws SQLException;

    List<Discussione> fetchDiscussioniByCategoria(Categoria categoria, Paginator paginatorore) throws SQLException;
    List<Discussione> fetchDiscussioniAll() throws SQLException;
    int createDiscussioneUtente(Discussione discussione) throws SQLException;

}
