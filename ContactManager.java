import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class Contact {
    String name;
    String number;

    Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "," + number;
    }
}

public class ContactManager {

    static final String FILE_NAME = "sample.txt";

    // Add Contact
    static void addContact(String name, String number) {
        try (FileWriter fr = new FileWriter(FILE_NAME, true)) {
            fr.write(name + "," + number + "\n");
            System.out.println("Added Successfully");
        } catch (Exception e) {
            System.out.println("Error1");
        }
    }

    // View Contacts
    static void viewContacts() {
        try (BufferedReader f = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = f.readLine()) != null) {
                String[] data = line.split(",");

if(data.length == 2){
    System.out.println("Name: " + data[0] + " Number: " + data[1]);
}

}

        } catch (Exception e) {
            System.out.println("Error2");
        }
    }

    // Search Contact
    static void searchContacts(String searchname) {

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equalsIgnoreCase(searchname)) {
                    System.out.println("Contact Found -> Name: " + data[0] + " Number: " + data[1]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Not Found");
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    // Delete Contact
    static void delContact(String name) {

        File input = new File(FILE_NAME);
        File temp = new File("temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(input));
             FileWriter fw = new FileWriter(temp)) {

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (!data[0].equalsIgnoreCase(name)) {
                    fw.write(line + "\n");
                } else {
                    found = true;
                }
            }

            if (found) {
                System.out.println("Deleted");
                // Attempt to delete the original file
                if (input.delete()) {
                    // Rename the temporary file to the original file name
                    if (!temp.renameTo(input)) {
                        System.out.println("Error: Failed to rename temp file to input file.");
                    }
                } else {
                    System.out.println("Error: Failed to delete the original file.");
                    // Clean up the temporary file
                    temp.delete();
                }
            } else {
                System.out.println("Not Found");
                // Clean up the temporary file
                if (!temp.delete()) {
                    System.out.println("Error: Failed to delete the temporary file.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error3");
        }
        
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Contact Manager =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    addContact(name, phone);
                    break;

                case 2:
                    viewContacts();
                    break;

                case 3:
                    System.out.print("Enter Name to Search: ");
                    String search = sc.nextLine();
                    searchContacts(search);
                    break;

                case 4:
                    System.out.print("Enter Name to Delete: ");
                    String del = sc.nextLine();
                    delContact(del);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

