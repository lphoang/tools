package com.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class XmlToJsonConverter {

    public static void main(String[] args) throws Exception {

        // Path to your XML file
        String xmlFilePath = "src/main/resources/books.xml";

        // Read the XML content
        String xmlContent = readFile(xmlFilePath);

        // Create ObjectMapper instances
        ObjectMapper xmlMapper = new XmlMapper();
        ObjectMapper jsonMapper = new ObjectMapper();

        // Parse XML to a tree representation
        Object object = xmlMapper.readValue(xmlContent, Object.class);

        // Convert the tree to JSON
        String jsonString = jsonMapper.writeValueAsString(object);

        // Path for the output JSON file (optional, modify as needed)
        String jsonFilePath = "src/main/resources/books.json";

        // Write the JSON string to a file (optional)
        writeFile(jsonFilePath, jsonString);

        System.out.println("XML file converted to JSON and saved to: " + jsonFilePath);
    }

    // Function to read file content
    private static String readFile(String filePath) throws Exception {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    // Function to write string to file
    private static void writeFile(String filePath, String content) throws Exception {
        FileWriter writer = new FileWriter(filePath);
        writer.write(content);
        writer.close();
    }
}
