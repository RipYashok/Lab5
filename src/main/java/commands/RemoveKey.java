package commands;

import managers.utils.HashTable;

public class RemoveKey extends Command{

    public RemoveKey(){
        setTitle("remove_key");
        setDescription("remove_key null - удаляет элемент из коллекции по его ключу");
    }
    public void execute(HashTable collection, String key){
        collection.remove(key);
    }
}
