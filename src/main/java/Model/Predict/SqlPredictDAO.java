package Model.Predict;

import Controller.Http.Paginator;
import Model.ConPool.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlPredictDAO implements PredictDAO {

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
