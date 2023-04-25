package commands;

import managers.utils.HashTable;

public class Clear extends Command{
    public Clear(){
        setTitle("clear");
        setDescription("clear - очищает коллекцию");
    }
    public void execute(HashTable collection){
        collection.clear();
    }
}
