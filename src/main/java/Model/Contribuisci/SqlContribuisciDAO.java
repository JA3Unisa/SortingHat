package Model.Contribuisci;

import Controller.Http.Paginator;
import Model.ConPool.ConPool;
import Model.Contribuisci.ContribuisciDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqlContribuisciDAO implements ContribuisciDAO {

    @Override
    public List<Contribuisci> fetchAll() throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            try (   PreparedStatement ps =
                            con.prepareStatement("SELECT * FROM contribuisci")) {
                ResultSet rs = ps.executeQuery();
                List<Contribuisci> contributi = new ArrayList<>();
                while (rs.next()) {
                    Contribuisci contributo = new Contribuisci();
                    contributo.setId(rs.getInt("id"));
                    ArrayList<Integer> domande = new ArrayList<>();
                    domande.add(rs.getInt("domanda1"));
                    contributo.setDomande(domande);
                    contributi.add(contributo);
                }

                return contributi;
            }
        }
    }

}
