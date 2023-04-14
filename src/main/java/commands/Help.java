package commands;
import commands.InsertNull;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class Help extends Command {

    public Help() {
        setTitle("help");
        setDescription("help - выводит справку по доступным командам");
    }


    public void execute(){
        Reflections reflections = new Reflections("classes.comands");
        Set<Class<? extends Command>> allCommands = reflections.getSubTypesOf(Command.class);
        for (Class<? extends Command> command : allCommands) {
            try{
                System.out.println(command.getDeclaredConstructor().newInstance().getDescription());
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

