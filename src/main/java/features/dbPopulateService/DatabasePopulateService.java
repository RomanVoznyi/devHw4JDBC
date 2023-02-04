package features.dbPopulateService;

import features.database.Database;
import features.settings.Settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();

        try (Statement st = connection.createStatement()) {
            st.executeUpdate(readSql());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Database.getInstance().close();
        System.gc();
    }

    private static String readSql() {
        try {
            String sqlFilePath = new Settings().getSetting(Settings.POPULATE_DB_SQL_KEY);
            return String.join("\n", Files.readAllLines(Paths.get(sqlFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
