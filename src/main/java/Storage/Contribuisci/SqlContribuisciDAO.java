package Storage.Contribuisci;

import Storage.ConPool.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlContribuisciDAO implements ContribuisciDAO {
    /**
     * Questo metodo permette di ottenere tutti i contribuisci
     * @return
     * @throws SQLException
     */
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
