import java.io.IOException;
import java.util.logging.*;

public class InfoLogger {
    private static final Logger logger = Logger.getLogger(InfoLogger.class.getName());

    public static void log(String content) {
        try {
            // Create a FileHandler to write logs to a file
            FileHandler fileHandler = new FileHandler("info.log", true); // true for append mode

            // Set a simple formatter
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            // Log messages
            logger.info(content);

        } catch (IOException e) {
            System.out.println("Error occurred while setting up file logger: " + e.getMessage());
        }
    }
}
