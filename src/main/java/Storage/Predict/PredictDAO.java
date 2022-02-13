package Storage.Predict;

import java.util.List;

public interface PredictDAO <E extends Exception>{
    List<Predict> fetchAll() throws E;
}
