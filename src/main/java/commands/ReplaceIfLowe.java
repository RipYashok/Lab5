package commands;

import managers.utils.HashTable;
import models.StudyGroup;

import java.io.BufferedReader;
import java.io.IOException;

public class ReplaceIfLowe extends Command{

    public ReplaceIfLowe(){
        setTitle("replace_if_lowe");
        setDescription("replace_if_lowe null {element} - заменяет значение по ключу, если новое значение меньше старого");

    }
    public StudyGroup execute(HashTable collection, String key, BufferedReader reader) throws IOException {
        InsertNull insertNull = new InsertNull();
        StudyGroup group = insertNull.execute(reader);
        if (group.hashCode() < collection.get(key).hashCode()){
            return group;
        }

        return collection.get(key);
    }
}
