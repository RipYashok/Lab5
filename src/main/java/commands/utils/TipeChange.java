package commands.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import managers.utils.HashTable;
import models.StudyGroup;

import java.io.*;

public class TipeChange {
    ObjectMapper mapper = new ObjectMapper();

    public String ChangeInJSON(HashTable collection) throws JsonProcessingException {
        String jsonCollection = mapper.writeValueAsString(collection);
        return jsonCollection;
    }

    public HashTable ChangeFromJSON(String string) throws IOException {
        HashTable collection = mapper.readValue(string, HashTable.class);
        return collection;
    }
}
