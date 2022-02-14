package Storage.Contribuisci;

import java.util.List;

/**
 * Questa è l'interfaccia che gestisce i contribuisci
 * @param <E>
 */
public interface ContribuisciDAO <E extends Exception>{
    List<Contribuisci> fetchAll() throws E;
}
