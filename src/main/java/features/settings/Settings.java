package features.settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Settings {
    private static final String DEFAULT_SETTINGS_FILENAME = "prefs.json";
    public static final String DB_CONNECTION_KEY = "dbUrl";
    public static final String INIT_DB_SQL_KEY = "initDBSql";
    public static final String POPULATE_DB_SQL_KEY = "populateDBSql";
    public static final String LONGEST_PROJECT_SQL_KEY = "longestProjectSql";
    public static final String MAX_PROJECTS_CLIENT_SQL_KEY = "maxProjectsClientSql";
    public static final String MAX_SALARY_SQL_KEY = "maxSalarySql";
    public static final String YOUNGEST_ELDEST_SQL_KEY = "youngestEldestSql";
    public static final String PROJECT_PRICES_SQL_KEY = "projectPricesSql";
    private Map<String, Object> settings = new HashMap<>();

    public Settings() {
        try {
            String json = String.join("\n",Files.readAllLines(Paths.get(DEFAULT_SETTINGS_FILENAME)));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type typeOfHashMap = new TypeToken<Map<String, Object>>() {
            }.getType();
            settings = gson.fromJson(json, typeOfHashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSetting(String key) {
        return settings.get(key).toString();
    }
}