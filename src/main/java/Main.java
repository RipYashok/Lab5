import commands.Command;
import commands.Help;
import commands.InsertNull;
import managers.CommandManager;
import models.Coordinates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommandManager commandManager = new CommandManager();
        Command help = new Help();
        Command insertNull = new InsertNull();

        commandManager.setReader(reader);

        while (true) {
            try {
                System.out.print("Какое количество человек в вашей группе?: ");
                Integer count = Integer.parseInt(reader.readLine());
                while (count == null || count < 0) {
                    System.out.println("Недостаточное количество человек в группе!!!");
                    System.out.print("Так сколько же человек в вашей группе?: ");
                    count = Integer.parseInt(reader.readLine());
                }
                System.out.println(count);
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Запишите количество цифрами пожалуйста");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
