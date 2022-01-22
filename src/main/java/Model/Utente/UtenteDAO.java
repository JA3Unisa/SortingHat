package Model.Utente;

import Controller.Http.Paginator;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UtenteDAO <E extends Exception> {
    boolean createUtente (Utente utente) throws E;
    boolean updateUtente (Utente utente) throws E;
    boolean deleteUtente (int id) throws E;
    int countAllUtente() throws E;

    Optional<Utente> findUtente(String email, String password) throws SQLException;

    List<Utente> fetchAccounts(Paginator paginatore) throws SQLException;

    Optional<Utente> findUtentebyID(int idCl) throws SQLException;
}
