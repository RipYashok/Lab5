package managers;

import commands.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
}