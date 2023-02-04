package features.dbQueryService.queriesClasses;

import lombok.Data;

@Data
public class ProjectPrices {
    String project_name;
    float price;

    public ProjectPrices(String project_name, float price) {
        this.project_name = project_name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{project: '" + project_name + "', price: '" + price + "'}";
    }
}
