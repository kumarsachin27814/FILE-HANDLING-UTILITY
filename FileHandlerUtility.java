import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileHandlerUtility {

    
    private static final String FILE_NAME = "internship_certificate.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            
            writeToFile();

            
            System.out.println("\n=== File Content ===");
            readFromFile();

            
            System.out.print("\nEnter your internship END DATE (e.g. 2025-06-30): ");
            String endDate = scanner.nextLine();
            modifyFile(endDate);

           
            System.out.println("\n=== Modified File Content ===");
            readFromFile();

        } catch (IOException e) {
            System.err.println("An error occurred during file operations: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // WRITE content to the file
    private static void writeToFile() throws IOException {
        String content = """
                CREATE A JAVA PROGRAM TO READ,
                WRITE, AND MODIFY TEXT FILES.

                COMPLETION CERTFICATE WILL BE
                ISSUED ON Y0UR INTERNSHIP

                END DATE .

                CODTECH

                INS T R U C T I O NS :
                FILE HANDLING

                UTILITY

                DELIVERABLE: A SCRIPT
                DEMONSTRATING FILE OPERATIONS
                WITH CLEAR DOCUMENTATION.
                """;

        Files.write(Paths.get(FILE_NAME), content.getBytes());
        System.out.println("File written successfully.");
    }

    
    private static void readFromFile() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
        for (String line : lines) {
            System.out.println(line);
        }
    }

    
    private static void modifyFile(String endDate) throws IOException {
        Path path = Paths.get(FILE_NAME);
        List<String> lines = Files.readAllLines(path);
        List<String> modifiedLines = new ArrayList<>();

        for (String line : lines) {
            if (line.trim().equalsIgnoreCase("END DATE .")) {
                modifiedLines.add("END DATE: " + endDate);
            } else {
                modifiedLines.add(line);
            }
        }

        Files.write(path, modifiedLines);
        System.out.println("File modified successfully.");
    }
}
