package Storage.Predict;

import java.util.List;

/**
 * Questa è l'interfaccia che permette di gestire i predict
 * @param <E>
 */

public interface PredictDAO <E extends Exception>{
    List<Predict> fetchAll() throws E;
}
