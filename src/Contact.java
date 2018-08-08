
    // class blueprint/framework

import java.io.File;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Contact {

    private String name;
    private String phoneNumber; //string for numbers to accomodate the dash.
//    private ArrayList<String> ContactsList = new ArrayList<>(); // constructor for arraylist.

    // Consturctor to create new contacts
    public Contact(){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public ArrayList<String> getContactsList() {
//        return ContactsList;
//    }
//
//    public void setContactsList(ArrayList<String> contactsList) {
//        this.ContactsList = new ArrayList<>();
//    }



    // overrides the default Object method
    public String toString() {
        return name + " | " + phoneNumber;
    }

    public void read() {

    }

    static void write() {
        // Will write the contact information to contacts.txt

        try {
            Contact contact;
            contact = new Contact();
            Contact c = contact;

            File file = new File("contacts.txt");

            String directory = "contactsDirectory";
            String filename = "contacts.txt";
            Path contactsDirectory = Paths.get(directory);
            Path contactsFile = Paths.get(directory, filename);
            //if directory does not exist, will create new directory
            if (!Files.isDirectory(contactsDirectory)) {
                try {
                    Files.createDirectories(contactsDirectory);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // If file doesn't exists, create it.
            if (!Files.exists(contactsFile)) {
                file.createNewFile();
            }

            try (PrintWriter output = new PrintWriter(new FileWriter(
                    "contacts.txt", true))) {
                output.printf("%s\r\n", c);
            } catch (Exception e) {
            }

            System.out.println("New contact added to list.");
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


