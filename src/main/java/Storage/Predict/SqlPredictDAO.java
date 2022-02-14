package Storage.Predict;

import Storage.ConPool.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlPredictDAO implements PredictDAO {
    /**
     * Permette di ottenere tutti i predict
     * @return
     * @throws SQLException
     */
    @Override
    public List<Predict> fetchAll() throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (   PreparedStatement ps =
                            con.prepareStatement("SELECT * FROM predict")) {
                ResultSet rs = ps.executeQuery();
                List<Predict> predizioni = new ArrayList<>();
                while (rs.next()) {
                    Predict pred = new Predict();
                    pred.setId(rs.getInt("idpredict"));
                    pred.setDipartimento(rs.getInt("dipartimento"));
                    pred.setDataOra(rs.getTimestamp("dateTime"));
                    predizioni.add(pred);
                }

                return predizioni;
            }
        }
    }

}
