package mortgageCreditLink.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

    /**
     * Reads JSON data from a file and converts it into a List of HashMaps.
     * 
     * @return List of HashMaps containing JSON key-value pairs.
     * @throws IOException if the file is missing, inaccessible, or parsing fails.
     */
    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {

        // Read the contents of the JSON file into a String.
        // The file path is built dynamically using the project's base directory (user.dir).
        String jsonContent = FileUtils.readFileToString(
                new File(System.getProperty("user.dir") 
                        + "\\src\\test\\java\\mortgageCreditLink\\data\\PurchaseOrder.json"),
                StandardCharsets.UTF_8);

        // Create an ObjectMapper instance to convert JSON string into Java objects.
        ObjectMapper mapper = new ObjectMapper();

        // Convert JSON string into a List of HashMaps.
        // TypeReference is used here to maintain generic type information at runtime.
        List<HashMap<String, String>> data = mapper.readValue(
                jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                });

        // Return the parsed data
        return data;
    }
}
