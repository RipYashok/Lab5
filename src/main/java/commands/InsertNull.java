package commands;

import models.*;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;


public class InsertNull extends Command{

    public InsertNull(){
        setTitle("insert null");
        setDescription("insert null {element} - добавляет новый элемент с заданным ключом в коллекцию");

    }
    @Override
    public void execute(String... args) {
        StudyGroup studyGroup = new StudyGroup();

    }


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public void ChooseeName(StudyGroup group, BufferedReader reader) throws IOException {
        System.out.println(ANSI_GREEN + "Введите название группы");
        String name = reader.readLine();
        while (StringUtils.isBlank(name) || StringUtils.isNumeric(name)) {
            System.out.println(ANSI_RED + "Не надо оставлять группу без названия");
                System.out.println(ANSI_GREEN + "Попробуйте ещё раз");
                name = reader.readLine();
            }
        }
    public void ChooseCoordinateX(Coordinates coordinates, BufferedReader reader) {
        while (true) {
            try {
                System.out.print(ANSI_RED + "Введите координату X: ");
                String x = reader.readLine();
                while (x == null || x.isEmpty()) {
                    System.out.println(ANSI_RED + "Координата X это число");
                    System.out.print(ANSI_GREEN + "Введите координату X: ");
                    x = reader.readLine();
                }
                coordinates.setX(Float.parseFloat(x));
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(ANSI_RED + "Координата X *это число");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void ChooseCoordinateY(Coordinates coordinates, BufferedReader reader) {
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Введите координату Y: ");
                Float y = Float.parseFloat(reader.readLine());
                while (y == null || y < -550) {
                    System.out.println(ANSI_RED + "Координата Y это число");
                    System.out.print(ANSI_GREEN + "Введите координату Y: ");
                    y = Float.parseFloat(reader.readLine());
                }
                coordinates.setX(y);
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(ANSI_RED + "Координата Y *это число");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void ChooseStudentCount(StudyGroup group, BufferedReader reader) {
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Какое количество человек в вашей группе?: ");
                Integer count = Integer.parseInt(reader.readLine());
                while (count == null || count < 0) {
                    System.out.println(ANSI_RED + "Недостаточное количество человек в группе!!!");
                    System.out.print(ANSI_GREEN + "Так сколько же человек в вашей группе?: ");
                    count = Integer.parseInt(reader.readLine());
                }
                group.setStudentsCount(count);
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(ANSI_RED + "Запишите количество цифрами пожалуйста");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void ChooseFormOfEducation(StudyGroup group, BufferedReader reader) {
        System.out.println(ANSI_YELLOW + "Введите 0, если у вас дистанционное обучение");
        System.out.println(ANSI_YELLOW + "Введите 1, если у вас дневное очное обучение");
        System.out.println(ANSI_YELLOW + "Введите 2, если у вас вечернее очное обучение");
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Какая форма обучения у вашей группы?: ");
                String form = reader.readLine();
                while (!(form.equals("0") || form.equals("1") || form.equals("2")) || form == null){
                    System.out.println(ANSI_RED + "Пожалуйста следуйте инструкции выше");
                    System.out.print(ANSI_GREEN + "Какая форма обучения у вашей группы?: ");
                    form = reader.readLine();
                }
                if (form.equals("0")){
                    group.setFormOfEducation(FormOfEducation.DISTANCE_EDUCATION);
                    break;
                }
                else if (form.equals("1")) {
                    group.setFormOfEducation(FormOfEducation.FULL_TIME_EDUCATION);
                    break;
                } else if (form.equals("2")) {
                    group.setFormOfEducation(FormOfEducation.EVENING_CLASSES);
                    break;
                }
            } catch (IOException e) {
            }
        }
    }
    public void ChooseSemester(StudyGroup group, BufferedReader reader){
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Введите номер семестра: ");
                Integer sem = Integer.parseInt(reader.readLine());
                while (!((1 <= sem) && (sem <= 8)) || sem == null) {
                    System.out.println(ANSI_RED + "Вы вышли за рамки возможного");
                    System.out.print(ANSI_GREEN + "Введите номер семестра ещё раз: ");
                    sem = Integer.parseInt(reader.readLine());
                }
                switch (sem){
                    case 1: group.setSemesterEnum(Semester.FIRST);
                    break;
                    case 2: group.setSemesterEnum(Semester.SECOND);
                    break;
                    case 3: group.setSemesterEnum(Semester.THIRD);
                    break;
                    case 4: group.setSemesterEnum(Semester.FOURTH);
                    break;
                    case 5: group.setSemesterEnum(Semester.FIVETH);
                    break;
                    case 6: group.setSemesterEnum(Semester.SIXTH);
                    break;
                    case 7: group.setSemesterEnum(Semester.SEVENTH);
                    break;
                    case 8: group.setSemesterEnum(Semester.EIGHTH);
                    break;
                }
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(ANSI_RED + "Запишите номер семестра числом");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void ChooseAdmin(StudyGroup group, Person admin){
        group.setGroupAdmin(admin);
    }
    public void ChooseAdminName(Person admin, BufferedReader reader) throws IOException {
        System.out.println(ANSI_GREEN + "Введите имя админа: ");
        String name = reader.readLine();
        while (name.isEmpty() || name == null) {
            System.out.println(ANSI_RED + "Не надо оставлять группу без админа");
            System.out.println(ANSI_GREEN + "Попробуйте ещё раз: ");
            name = reader.readLine();
        }
    }
    public void ChooseAdminPasswordID(Person admin, BufferedReader reader) {
        System.out.println(ANSI_YELLOW + "Пароль должен быть не длиннее 20 символов");
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Введите пароль админа: ");
                String password = reader.readLine();
                while (password.isEmpty() || password.length() > 20) {
                    if (password.isEmpty()){
                    System.out.println(ANSI_RED + "Без пароля нельзя!!!");
                    System.out.println(ANSI_GREEN + "Введите пароль админа: ");
                    password = reader.readLine();
                    }
                    else {
                        System.out.println(ANSI_RED + "Пароль слишком длинный");
                        System.out.println(ANSI_GREEN + "Введите пароль админа: ");
                        password = reader.readLine();
                    }
                }
                admin.setPassportID(password);
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException nullPointerException){
                admin.setPassportID(null);
                break;
            }
        }
    }
}