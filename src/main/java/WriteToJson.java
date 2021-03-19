import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WriteToJson {
    /**
     * Write user list to json file
     * @param json merchant/operator user list
     * @param fileName name of the json file
     * @throws IOException
     */
    public static void writeToFile(List json, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(fileName+".json"), json);
    }
}
