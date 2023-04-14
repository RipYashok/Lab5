import commands.Command;
import commands.Help;
import commands.InsertNull;
import managers.CommandManager;
import models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommandManager commandManager = new CommandManager();
        Command help = new Help();
        Command insertNull = new InsertNull();
        commandManager.setReader(reader);
        insertNull.execute();

    }
}

