package commands;

import managers.utils.HashTable;
import models.StudyGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

public class RemoveLower extends Command{
    public RemoveLower(){
        setTitle("remove_lower");
        setDescription("remove_lower {element} - удаляет из коллекции все элементы, значение studentsCount которых, меньшие, чем заданное");
    }

    public void execute(HashTable collection, Integer value) throws IOException {
        Enumeration<StudyGroup> groups = collection.elements();
        Enumeration<String> keys = collection.keys();
        while (groups.hasMoreElements() == true){
            if (value > groups.nextElement().getStudentsCount()){
                collection.remove(keys.nextElement());
            }
        }
    }
}
