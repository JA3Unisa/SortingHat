package Storage.ConPool;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

public final class ConPool {

    private static ConPool instance;

    private static final int MAX_ACTIVE = 100;

    private static final int INITIAL_SIZE = 10;

    private static final int MIN_IDLE = 10;

    private static final int TIMEOUT = 15;

    private ConPool() {
    }

    public static ConPool getInstance() {
        if (instance == null) {
            instance = new ConPool();
        }

        return instance;
    }


    public static Connection getConnection() throws SQLException {
        DataSource datasource = null;
        if (datasource == null) {
            PoolProperties p = new PoolProperties();
            p.setUrl("jdbc:mysql://localhost:3306/sorting_hat_test?serverTimezone=" + TimeZone.getDefault().getID());
            p.setDriverClassName("com.mysql.cj.jdbc.Driver");
            p.setUsername("root");
            p.setPassword("admin");
            p.setMaxActive(MAX_ACTIVE);
            p.setInitialSize(INITIAL_SIZE);
            p.setMinIdle(MIN_IDLE);
            p.setRemoveAbandonedTimeout(TIMEOUT);
            p.setRemoveAbandoned(true);
            datasource = new DataSource();
            datasource.setPoolProperties(p);
        }

        return datasource.getConnection();
    }


    public void closeDataSource() throws SQLException {
        Statement datasource = null;
        if (datasource != null) {
            try {
                datasource.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            datasource.close();
        }
    }
}