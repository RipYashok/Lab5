package managers.utils;

import java.util.Hashtable;

public class HashTable extends Hashtable {
    @Override
    public String toString() {
        return values().toString();
    }
}
