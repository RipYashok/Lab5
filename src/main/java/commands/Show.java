package commands;

import managers.utils.HashTable;
import models.StudyGroup;

public class Show extends Command{

    public Show(){
        setTitle("show");
        setDescription("show - выводит в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    public void execute(HashTable collection){
        System.out.println(collection.toString());
    }
}
