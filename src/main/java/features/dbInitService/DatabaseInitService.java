package features.dbInitService;

import features.database.Database;
import features.settings.Settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) {

        try (Connection cn = Database.getInstance().getConnection();
             Statement st = cn.createStatement()) {
            st.executeUpdate(readSql());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.gc();
    }

    private static String readSql() {
        try {
            String sqlFilePath = new Settings().getSetting(Settings.INIT_DB_SQL_KEY);
            return String.join("\n", Files.readAllLines(Paths.get(sqlFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
