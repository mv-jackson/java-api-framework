package com.bpdts.api.api;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class FileWriter {

    
    public void WriteToFile(JSONObject s,double distance) throws IOException {

        String sampleText = CreateMessage(s,distance) +  System.getProperty("line.separator");
        Files.write(Paths.get("test.txt"), sampleText.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    private StringBuilder CreateMessage(JSONObject s,double distance){
        StringBuilder builder = new StringBuilder();
        builder.append("The user: ");
        builder.append(s.get("id"));
        builder.append(" + ");
        builder.append(s.get("first_name"));
        builder.append(" + ");
        builder.append(s.get("last_name"));
        builder.append("lives within a " + distance + " mile radius of London");

        return builder;
    }
}
