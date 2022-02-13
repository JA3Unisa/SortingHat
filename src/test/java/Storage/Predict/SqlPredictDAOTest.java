package Storage.Predict;

import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class SqlPredictDAOTest {

    private SqlPredictDAO testDAO = new SqlPredictDAO();
    private Predict testPredict = new Predict();
    @Test
    public void fetchAllOKTEST() throws SQLException {

        List<Predict> lista = testDAO.fetchAll();

    }
}