package commands.interactives;

import models.Coordinates;
import models.StudyGroup;

import java.io.BufferedReader;
import java.io.IOException;

public class CreateStudyGroup {

    public void CreateName(StudyGroup group, BufferedReader reader) throws IOException {
        System.out.println("Введите название группы");
        String name = reader.readLine();
        while (name.isEmpty() || name == null ){
            System.out.println("Не надо оставлять группу без названия");
            System.out.println("Попробуйте ещё раз");
        }
    }
    public void CreateCoordinateX(Coordinates coordinates, BufferedReader reader) {
        while (true) {
            try {
                System.out.print("Введите координату X: ");
                String x = reader.readLine();
                while (x == null || x.isEmpty()) {
                    System.out.println("Координата X это число");
                    System.out.print("Введите координату X: ");
                    x = reader.readLine();
                }
                coordinates.setX(Float.parseFloat(x));
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Координата X *это число");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void CreateCoordinateY(Coordinates coordinates, BufferedReader reader) {
        while (true) {
            try {
                System.out.print("Введите координату X: ");
                Float x = Float.parseFloat(reader.readLine());
                while (x == null || x < -550) {
                    System.out.println("Координата X это число");
                    System.out.print("Введите координату X: ");
                    x = Float.parseFloat(reader.readLine());
                }
                coordinates.setX(x);
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Координата X *это число");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void CreateStudentCount(StudyGroup group, BufferedReader reader){
        while (true) {
            try {
                System.out.print("Какое количество человек в вашей группе?: ");
                Integer count = Integer.parseInt(reader.readLine());
                while (count == null || count < 0){
                    System.out.println("Недостаточное количество человек в группе!!!");
                    System.out.print("Так сколько же человек в вашей группе?: ");
                    count = Integer.parseInt(reader.readLine());
                }
                group.setStudentsCount(count);
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Запишите количество цифрами пожалуйста");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
