package features.database;

import features.settings.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANCE = new Database();

    private Database() {
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            String connectionUrl = new Settings().getSetting(Settings.DB_CONNECTION_KEY);
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
