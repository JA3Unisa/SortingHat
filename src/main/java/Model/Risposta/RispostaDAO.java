package Model.Risposta;

import Controller.Http.Paginator;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface RispostaDAO <E extends Exception>{
    boolean createRisposta (Risposta risposta) throws E;
    boolean updateRisposta (Risposta risposta) throws E;
    boolean deleteRisposta (int id) throws E;

    int countAll() throws SQLException;

    List<Risposta> fetchRisposta(Paginator paginatore) throws SQLException;
    Optional<Risposta> fetchRisposte(int idUpd) throws SQLException;
}
