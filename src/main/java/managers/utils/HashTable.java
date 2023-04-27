package managers.utils;

import models.StudyGroup;

import java.time.ZonedDateTime;
import java.util.Hashtable;

public class HashTable extends Hashtable<String, StudyGroup> {
    ZonedDateTime timeTnitialization;
    public HashTable(){
        this.timeTnitialization = ZonedDateTime.now();
    }
    public ZonedDateTime getTimeTnitialization() {
        return timeTnitialization;
    }
    @Override
    public String toString() {
        return values().toString();
    }
}
