package commands;

import managers.utils.HashTable;
import models.FormOfEducation;
import models.StudyGroup;

import java.util.ArrayList;
import java.util.Enumeration;

public class RemoveAllByOfEducation extends Command{

    public RemoveAllByOfEducation(){
        setTitle("remove_all_by_form_of_education");
        setDescription("remove_all_by_form_of_education formOfEducation - удаляет из коллекции все элементы, значение поля formOfEducation которого эквивалентно заданному"
                + "\n" + "Записывайте форму обучения слудуюущим образом:" + "\n" + "Дистанционное - DISTANCE_EDUCATION"
                + "\n" + "Полный учебный день - FULL_TIME_EDUCATION" + "\n" + "Вечернее обучение - EVENING_CLASSES");
    }

    public void execute(HashTable collection, FormOfEducation form){
        Enumeration<StudyGroup> groups = collection.elements();
        Enumeration<String> keys = collection.keys();
        ArrayList<StudyGroup> allGroups = new ArrayList<>();
        ArrayList<String> allKeys = new ArrayList<>();
        while (groups.hasMoreElements() == true){
            StudyGroup group = groups.nextElement();
            allGroups.add(group);
            String key = keys.nextElement();;
            allKeys.add(key);
            if (group.getFormOfEducation().equals(form)){
                collection.remove(allKeys.get(allGroups.indexOf(group)));
            }
        }
    }
}
