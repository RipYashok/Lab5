package commands;

import models.StudyGroup;


public class InsertNull extends Command{

    public InsertNull(){
        setTitle("insert null");
        setDescription("insert null {element} - добавляет новый элемент с заданным ключом в коллекцию");

    }
    @Override
    public void execute(String... args) {
        StudyGroup studyGroup = new StudyGroup();

    }
}
