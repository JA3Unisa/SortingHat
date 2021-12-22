package Model.Risposta;

public interface RispostaDAO <E extends Exception>{
    boolean createRisposta (Risposta risposta) throws E;
    boolean updateRisposta (Risposta risposta) throws E;
    boolean deleteRisposta (int id) throws E;
}
