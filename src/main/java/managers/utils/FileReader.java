package managers.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class FileReader {
    ObjectMapper mapper = new ObjectMapper();

    public HashTable saveCollaction() throws IOException {
        String fileName = "FileCollection";
        String file = "C:\\GitHub\\Lab5\\" + fileName + ".txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String test = (reader.readLine());
        HashTable mapping = mapper.readValue(test, HashTable.class);
        return mapping;
    }
}
