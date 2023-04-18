package managers;

import commands.Command;
import commands.Exit;
import commands.InsertNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CommandManager {
    private Map<String, Command> commands;
    private BufferedReader reader;

    public CommandManager() {
        this.commands = new HashMap<>();
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }
    public void addCommand(Command command) {
        commands.put(command.getTitle(), command);
    }
    public Map<String, Command> getCommands() {
        return new HashMap<>(commands);
    }
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    Hashtable collection = new Hashtable();
    InsertNull insertNull = new InsertNull();
    Exit exit = new Exit();

    public void run(BufferedReader reader) throws IOException {
        boolean flag = true;
        while (flag){
            try {
                String string = reader.readLine().trim();
                List<String> stringList = new ArrayList<>(Arrays.asList(string.split(" ")));
                if (stringList.get(0).equals(exit.getTitle())) {
                    flag = exit.execute();
                } else if (stringList.get(0).equals(insertNull.getTitle())) {
                    collection.put(stringList.get(2), insertNull.execute());
                }
                else {
                    System.out.println(ANSI_YELLOW + "Введите help, чтобы увидеть весь список доступных команд");
                }

            } catch (IndexOutOfBoundsException indexOutOfBoundsException){
                System.out.println(ANSI_YELLOW + "Введите help, чтобы увидеть весь список доступных команд");
            }
        }
    }
}