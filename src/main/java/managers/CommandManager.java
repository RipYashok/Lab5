package managers;

import commands.*;
import managers.utils.HashTable;
import models.FormOfEducation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    InsertNull insertNull = new InsertNull();
    Save save = new Save();
    Show show = new Show();
    Exit exit = new Exit();
    Clear clear = new Clear();
    RemoveKey removeKey = new RemoveKey();
    ExecuteScript executeScript = new ExecuteScript();
    MaxByID maxByID = new MaxByID();
    AverageOfStudentsCount averageOfStudentsCount = new AverageOfStudentsCount();
    RemoveAllByOfEducation removeAllByOfEducation = new RemoveAllByOfEducation();
    ReplaceIfLowe replaceIfLowe = new ReplaceIfLowe();
    History history = new History();
    RemoveLower removeLower = new RemoveLower();
    Undate undate = new Undate();
    Info info = new Info();
    Help help = new Help();
    ArrayList<String> commandNameList = new ArrayList<>(Arrays.asList(insertNull.getTitle(), save.getTitle(), show.getTitle(), exit.getTitle(),
            clear.getTitle(), removeKey.getTitle(), executeScript.getTitle(), maxByID.getTitle(), averageOfStudentsCount.getTitle(), removeAllByOfEducation.getTitle(),
            replaceIfLowe.getTitle(), history.getTitle(), removeLower.getTitle(), undate.getTitle(), info.getTitle(), help.getTitle()));

    public void run(BufferedReader reader, HashTable collection) throws IOException{
        ArrayList<String> commandHistory = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", "", "", ""));
        boolean flag = true;
        while (flag){
            try {
                String string = reader.readLine().trim();
                List<String> commandString = new ArrayList<>(Arrays.asList(string.split(" ")));
                history.createHistory(commandHistory, commandString.get(0));
                if (commandString.get(0).equals(exit.getTitle())) {
                    flag = exit.execute();
                } else if (commandString.get(0).equals(insertNull.getTitle())) {
                    collection.put(commandString.get(1), insertNull.execute(reader));
                } else if (commandString.get(0).equals(show.getTitle())){
                    show.execute(collection);
                } else if (commandString.get(0).equals(save.getTitle())){
                    save.excute(collection);
                } else if (commandString.get(0).equals(clear.getTitle())){
                    clear.execute(collection);
                } else if (commandString.get(0).equals(removeKey.getTitle())){
                    removeKey.execute(collection, commandString.get(1));
                } else if (commandString.get(0).equals(executeScript.getTitle())){
                    executeScript.execute(commandString.get(1), collection);
                } else if (commandString.get(0).equals(maxByID.getTitle())){
                    maxByID.execute(collection);
                } else if (commandString.get(0).equals(averageOfStudentsCount.getTitle())){
                    averageOfStudentsCount.execute(collection);
                } else if (commandString.get(0).equals(removeAllByOfEducation.getTitle())){
                    removeAllByOfEducation.execute(collection, FormOfEducation.valueOf(commandString.get(1)));
                } else if (commandString.get(0).equals(replaceIfLowe.getTitle())){
                    collection.put(commandString.get(1), replaceIfLowe.execute(collection, commandString.get(1), reader));
                } else if (commandString.get(0).equals(history.getTitle())){
                    history.execute(commandHistory, commandNameList);
                } else if (commandString.get(0).equals(removeLower.getTitle())){
                    removeLower.execute(collection, Integer.valueOf(commandString.get(1)));
                } else if (commandString.get(0).equals(undate.getTitle())){
                    undate.execute(collection, Long.valueOf(commandString.get(1)), reader);
                } else if (commandString.get(0).equals(info.getTitle())){
                    info.execute(collection);
                } else if (commandString.get(0).equals(help.getTitle())){
                    help.execute();
                }
                else if (string.isBlank()){
                    System.out.print("");
                }
                else {
                    System.out.println(ANSI_RED + "Такой команды не существует" + "\n" + ANSI_YELLOW + "Введите help, чтобы увидеть весь список доступных команд");
                }

            } catch (IndexOutOfBoundsException indexOutOfBoundsException){
                System.out.println(ANSI_YELLOW + "Введите help, чтобы увидеть весь список доступных команд");
            } catch (IllegalArgumentException IllegalArgumentException){
                System.out.println(ANSI_RED + "Неверное значение аргумента");
            } catch (NullPointerException nullPointerException){
                System.out.println("");
            }
        }
    }
}