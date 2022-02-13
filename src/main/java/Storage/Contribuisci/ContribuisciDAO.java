package Storage.Contribuisci;

import java.util.List;

public interface ContribuisciDAO <E extends Exception>{
    List<Contribuisci> fetchAll() throws E;
}
