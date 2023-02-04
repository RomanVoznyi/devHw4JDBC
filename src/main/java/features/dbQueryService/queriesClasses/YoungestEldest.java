package features.dbQueryService.queriesClasses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class YoungestEldest {
    String type;
    String name;
    LocalDate birthday;

    public YoungestEldest(String type, String name, LocalDate birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "{type: '" + type + "', worker: '" + name + "', birthday: '" + birthday + "'}";
    }
}
