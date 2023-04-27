import managers.CommandManager;
import managers.utils.FileReader;
import managers.utils.HashTable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        HashTable collection = new HashTable();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommandManager commandManager = new CommandManager();
        FileReader fileReader = new FileReader();
        collection.putAll(fileReader.saveCollaction(args[0]));
        commandManager.run(reader, collection);
    }
}

