package managers.utils;

public class GeneratorID {
    private static long id = 1;

    public static Long newId(){
        return id++;
    }
}
