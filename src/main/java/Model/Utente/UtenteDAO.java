package Model.Utente;

public interface UtenteDAO <E extends Exception> {
    boolean createUtente (Utente utente) throws E;
    boolean updateUtente (Utente utente) throws E;
    boolean deleteUtente (int id) throws E;
    int countAllUtente() throws E;
}
