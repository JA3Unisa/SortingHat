package Model.Discussione;

import Controller.Http.Paginator;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DiscussioneDAO <E extends Exception>{
    int countAll() throws SQLException;

    List<Discussione> fetchDiscussioni(Paginator paginatore) throws SQLException;

    Optional<Discussione> fetchDiscussioniByID(int id) throws SQLException;
    public boolean deleteDiscussione(String id) throws SQLException;
    public boolean updateDiscussione(Discussione discussioneAgg) throws SQLException;
    public boolean createDiscussione(Discussione discussione) throws SQLException;
}
