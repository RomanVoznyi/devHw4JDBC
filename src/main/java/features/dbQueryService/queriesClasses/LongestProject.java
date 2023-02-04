package features.dbQueryService.queriesClasses;

import lombok.Data;

@Data
public class LongestProject {
    private long id;
    private String project_name;
    private float month_count;

    public LongestProject(long id, String project_name, float month_count) {
        this.id = id;
        this.project_name = project_name;
        this.month_count = month_count;
    }

    @Override
    public String toString() {
        return "{id: '" + id + "', project: '" + project_name + "', months: '" + month_count + "'}";
    }
}
