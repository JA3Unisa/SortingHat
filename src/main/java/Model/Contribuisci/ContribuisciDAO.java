package Model.Contribuisci;

import java.sql.SQLException;
import java.util.List;

public interface ContribuisciDAO <E extends Exception>{
    List<Contribuisci> fetchAll() throws E;
}
