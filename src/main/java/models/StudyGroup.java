package models;

import java.time.ZonedDateTime;

public class StudyGroup {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private FormOfEducation formOfEducation; //Поле не может быть null
    private Semester semesterEnum; //Поле не может быть null
    private Person groupAdmin; //Поле может быть null

    public StudyGroup(String name) {
        this.id = Integer.valueOf((int) (Math.random() * 485123659) + 1);
        this.creationDate = ZonedDateTime.now();
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Long getStudentsCount() {
        return studentsCount;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setStudentsCount(Long studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    @Override
    public String toString() {
        return
                "Id: " + Integer.valueOf(id).toString() + "\n" +
                        "Name: " + name + "\n" +
                        "Coordinates: " + coordinates.toString() + "\n" +
                        "Creation date: " + creationDate.toString() + "\n" +
                        "Students count: " + Long.valueOf(studentsCount).toString() + "\n" +
                        "Form of education: " + formOfEducation.toString() + "\n" +
                        "Semester enum: " + semesterEnum.toString() + "\n" +
                        "Group admin: " + groupAdmin.toString();
    }
}

