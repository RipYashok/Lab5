package commands;

import managers.utils.HashTable;
import models.StudyGroup;

import java.util.Enumeration;

public class AverageOfStudentsCount extends Command{
    public AverageOfStudentsCount(){
        setTitle("average_of_students_count");
        setDescription("average_of_students_count - выводит среднее значение поля studentsCount для всех элементов коллекции");
    }
    public static final String ANSI_GREEN = "\u001B[32m";

    public void execute(HashTable collection) {
        Enumeration<StudyGroup> groups = collection.elements();
        Integer studentsCount = 0;
        while (groups.hasMoreElements() == true){
            studentsCount += groups.nextElement().getStudentsCount();
        }
        Double average = Double.valueOf(studentsCount/collection.size());
        System.out.println(ANSI_GREEN + "Среднее количество студентов во всех группах: " + average);
    }
}
