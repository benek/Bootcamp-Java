import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

Path plainText = Paths.get("sample-plain-text.txt");
Path pathToNewFile = Paths.get("copy-sample-plain-text.txt");

try {
    // readAllLines() approach - Read all lines from the file in one pass
    // More simple, without the need of manage a buffer, but can be memory-intensive
    // Best for small to medium files
    List<String> lines = Files.readAllLines(plainText);
    System.out.println("~~~~ Reading file using readAllLines()");

    // Output the lines to the console
    for (String line : lines) {
        System.out.println(line);
        System.out.println("-----");
    }

    Files.write(pathToNewFile, lines, StandardCharsets.UTF_8);
    System.out.println("File written successfully.");
} catch (IOException e) {
    // Handle possible I/O errors
    System.err.println("Error reading file: " + e.getMessage());
}


// BufferedReader/BufferedWriter approach
// Use try-with-resources to ensure that the BufferedReader is closed after use
try (BufferedReader reader = new BufferedReader(new FileReader(plainText.toFile()))) {
    String line;

    // Read file line by line
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    // Handle possible I/O errors
    System.err.println("Error reading file: " + e.getMessage());
}

// Use InputStreamReader instead if you need more control over the charset

/*
 * For large files or binary data: FileInputStream
 */

    String filePath = "example.png";  // The path to the file to read

    try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
        int content;
        // Read one byte at a time
        while ((content = fileInputStream.read()) != -1) {
            // Converts byte to character because read() returns an int that represents a byte value
            System.out.print((char) content);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }