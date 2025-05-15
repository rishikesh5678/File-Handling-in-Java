import java.io.*;

public class FileOperations {

    /* Creates a new file.
      If the file already exists, it does nothing.
     */
    public static void createFile(String filePath) {
        File file = new File(filePath);

        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("The new file is created.");
            } else {
                System.out.println("The file already exists.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Writes the given content to a file.
      If the file does not exist, it creates the file.
     */
    public static void writeToFile(String filePath, String content) {
        try (FileWriter output = new FileWriter(filePath)) {
            output.write(content);
            System.out.println("Data is written to the file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Reads and prints the content of a file.
    public static void readFromFile(String filePath) {
        char[] array = new char[100];
        try (FileReader input = new FileReader(filePath)) {
            input.read(array);
            System.out.print("Data in the file: ");
            System.out.println(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Modifies the content of a file by replacing occurrences of an old string with a new string
    public static void modifyFile(String filePath, String oldString, String newString) {
        File fileToBeModified = new File(filePath);
        StringBuilder oldContent = new StringBuilder();

        // Read the existing content of the file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified))) {
            String line;
            while ((line = reader.readLine()) != null) {
                oldContent.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        // Replace the old string with the new string
        String newContent = oldContent.toString().replace(oldString, newString);

        // Write the new content back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToBeModified))) {
            writer.write(newContent);
            System.out.println("File modified successfully.");
            System.out.print("after file modification content is="); 
                  System.out.println(newContent);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    //Deletes a file.
    public static void deleteFile(String filePath) {
        File file = new File(filePath);

        boolean value = file.delete();
        if (value) {
            System.out.println("The file is deleted.");
        } else {
            System.out.println("The file is not deleted.");
        }
    }
    public static void main(String[] args) {
        String file = "myFile.txt";
     
         // Create a file
        createFile(file);

        // Write to the file
        writeToFile(file, "This is my first task of internship");

        // Read from the file
        readFromFile(file);

        // Modify the file
        modifyFile(file, "internship", "Java");

        // Delete the file     
       deleteFile(file);
    }
}
