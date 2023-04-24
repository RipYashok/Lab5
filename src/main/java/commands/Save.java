package commands;

import commands.utils.TipeChange;
import managers.utils.HashTable;
import java.io.FileOutputStream;
import java.io.IOException;


public class Save extends Command{

    public Save(){
        setTitle("save");
        setDescription("save - сохраняет коллекцию в файл");
    }

    public void excute (HashTable collection) throws IOException {
        TipeChange intoJSON = new TipeChange();
        FileOutputStream fileOutPut = new FileOutputStream("C:\\GitHub\\Lab5\\FileCollection.txt");
        fileOutPut.write(intoJSON.ChangeInJSON(collection).getBytes());
    }

}
