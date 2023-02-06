package features.dbQueryService;

import features.database.Database;
import features.dbQueryService.queriesClasses.*;
import features.settings.Settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<LongestProject> findLongestProject() {
        String query = readSql(Settings.LONGEST_PROJECT_SQL_KEY);
        List<LongestProject> longestProjects = new ArrayList<>();

        try (Connection cn = Database.getInstance().getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String project_name = rs.getString("project_name");
                float month_count = rs.getFloat("month_count");
                longestProjects.add(new LongestProject(id, project_name, month_count));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return longestProjects;
    }

    public List<MaxProjectsClient> findMaxProjectsClient() {
        String query = readSql(Settings.MAX_PROJECTS_CLIENT_SQL_KEY);
        List<MaxProjectsClient> clients = new ArrayList<>();

        try (Connection cn = Database.getInstance().getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                String name = rs.getString("name");
                int project_count = rs.getInt("project_count");
                clients.add(new MaxProjectsClient(name, project_count));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String query = readSql(Settings.MAX_SALARY_SQL_KEY);
        List<MaxSalaryWorker> workers = new ArrayList<>();

        try (Connection cn = Database.getInstance().getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                workers.add(new MaxSalaryWorker(name, salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workers;
    }

    public List<YoungestEldest> findYoungestEldestWorkers() {
        String query = readSql(Settings.YOUNGEST_ELDEST_SQL_KEY);
        List<YoungestEldest> workers = new ArrayList<>();

        try (Connection cn = Database.getInstance().getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                String type = rs.getString("type");
                String name = rs.getString("name");
                LocalDate birthday = LocalDate.parse(rs.getString("birthday"));
                workers.add(new YoungestEldest(type, name, birthday));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workers;
    }

    public List<ProjectPrices> printProjectPrices() {
        String query = readSql(Settings.PROJECT_PRICES_SQL_KEY);
        List<ProjectPrices> prices = new ArrayList<>();

        try (Connection cn = Database.getInstance().getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                String project = rs.getString("project_name");
                float price = rs.getFloat("price");
                prices.add(new ProjectPrices(project, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prices;
    }

    private static String readSql(String key) {
        try {
            String sqlFilePath = new Settings().getSetting(key);
            return String.join("\n", Files.readAllLines(Paths.get(sqlFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
