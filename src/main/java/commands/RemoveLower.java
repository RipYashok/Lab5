package commands;

import managers.utils.HashTable;
import models.StudyGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

public class RemoveLower extends Command{
    public RemoveLower(){
        setTitle("remove_lower");
        setDescription("remove_lower {element} - удаляет из коллекции все элементы, меньшие, чем заданный");
    }

    public void execute(HashTable collection, BufferedReader reader) throws IOException {
        InsertNull insertNull = new InsertNull();
        StudyGroup group = insertNull.execute(reader);
        Enumeration<StudyGroup> groups = collection.elements();
        Enumeration<String> keys = collection.keys();
        while (groups.hasMoreElements() == true){
            if (group.hashCode() > groups.nextElement().hashCode()){
                collection.remove(keys.nextElement());
            }
        }
    }
}
