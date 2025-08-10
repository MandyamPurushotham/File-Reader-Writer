
import java.io.*;
import java.util.Scanner;

public class NotesManager {

    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Notes Manager ===");
            System.out.println("1. Write a note");
            System.out.println("2. Read notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 ->
                    writeNote(scanner);
                case 2 ->
                    readNotes();
                case 3 ->
                    System.out.println("Exiting... Goodbye!");
                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void writeNote(Scanner scanner) {
        System.out.println("Enter your note (type 'END' on a new line to finish):");

        try (FileWriter fw = new FileWriter(FILE_NAME, true); BufferedWriter bw = new BufferedWriter(fw)) {

            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("END")) {
                    break;
                }
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Note saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    private static void readNotes() {
        System.out.println("\n=== Your Notes ===");

        try (FileReader fr = new FileReader(FILE_NAME); BufferedReader br = new BufferedReader(fr)) {

            String line;
            boolean hasNotes = false;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                hasNotes = true;
            }

            if (!hasNotes) {
                System.out.println("(No notes found)");
            }

        } catch (FileNotFoundException e) {
            System.out.println("(No notes file found yet)");
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }
}
