import features.dbQueryService.DatabaseQueryService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Run DatabaseInitService class and DatabasePopulateService class at first
        // Then execute this one

        DatabaseQueryService queryService = new DatabaseQueryService();

        printList(queryService.findLongestProject(), "Find Longest Project");
        printList(queryService.findMaxProjectsClient(), "Find Max Projects Client");
        printList(queryService.findMaxSalaryWorker(), "Find Max Salary Worker");
        printList(queryService.findYoungestEldestWorkers(), "Find Youngest Eldest Workers");
        printList(queryService.printProjectPrices(), "Print Project Prices");

        System.gc();
    }

    private static <T> void printList(List<T> list, String topic) {
        System.out.println("------------- " + topic + ": --------------");
        for (T object : list) {
            System.out.println(object);
        }
        System.out.println();
    }
}
