import features.dbQueryService.DatabaseQueryService;
import features.dbQueryService.queriesClasses.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Run DatabaseInitService class and DatabasePopulateService class at first
        // Then execute this one

        DatabaseQueryService queryService = new DatabaseQueryService();

        List<LongestProject> longestProjects = queryService.findLongestProject();
        System.out.println("------------- Find Longest Project: --------------");
        printList(longestProjects);

        List<MaxProjectsClient> clients = queryService.findMaxProjectsClient();
        System.out.println("------------- Find Max Projects Client: --------------");
        printList(clients);

        List<MaxSalaryWorker> workers = queryService.findMaxSalaryWorker();
        System.out.println("------------- Find Max Salary Worker: --------------");
        printList(workers);

        List<YoungestEldest> youngEldworkers = queryService.findYoungestEldestWorkers();
        System.out.println("------------- Find Youngest Eldest Workers: --------------");
        printList(youngEldworkers);

        List<ProjectPrices> prices = queryService.printProjectPrices();
        System.out.println("------------- Print Project Prices: --------------");
        printList(prices);
    }

    private static <T> void printList(List<T> list) {
        for (T object : list) {
            System.out.println(object);
        }
        System.out.println();
    }
}
