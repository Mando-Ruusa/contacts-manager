// class tester with main method

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsManagerTest {

    public static void main(String[] args) throws IOException {
        ArrayList<Contact> contactList = new ArrayList<>(); //empty arraylist to add contacts

        Contact contact = new Contact();
        int action = 0; //initialize user entry to 0;

//        contact.setName("Joy");
//             System.out.println(contact1.getName());

        while (action != 5) {

            System.out.println("\n[1] View contacts");
            System.out.println("\n[2] Add a new contact");
            System.out.println("\n[3] Search a contact by name");
            System.out.println("\n[4] Delete an existing contact");
            System.out.println("\n[5] Exit");
            System.out.print("\n\nenter an option (1, 2, 3, 4 or 5):  ");

            Scanner reader = new Scanner(System.in);
            reader.useDelimiter("\n");
            action = reader.nextInt();

            if (action <= 0 || action > 5) {
                System.out.println("Your selection was not accepted - try again. ");


            }

            switch (action) {
                case 1: {

                }
                case 2: {
                    System.out.println("Enter contact's first and last name:  ");
                    String name = reader.next();
                    if (name == null) {
                        System.out.println("\n Bad entry!! Try again. ");
                        break;
                    } else {
                        contact.setName(name.toLowerCase());
                    }
                    System.out.println("Enter contact's Phone Number: ");
                    String phoneNumber = reader.next();
                    contact.setPhoneNumber(phoneNumber.toLowerCase());

//adding new contact to list
                    contactList.add(contact);


                    try {

                        Contact contact1 = contact;

                        File file = new File("contacts.txt");

                        // If file doesn't exists, then create it.
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        try (PrintWriter output = new PrintWriter(new FileWriter(
                                "contacts.txt", true))) {
                            output.printf("%s\r\n", contact1);
                        } catch (Exception e) {
                        }

                        System.out.println("new contact added successfully");
                    }

                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                break;

                case 3:

                    try {
                        System.out.println("\nSearch by name: ");
                        String searchterm = reader.next();

                        // Open the file as a buffered reader
                        BufferedReader bf = new BufferedReader(new FileReader(
                                "contacts.txt"));

                        // Starting line count
                        int linecount = 0;
                        String line = null;

                        System.out.println("\nSearching for " + searchterm
                                + " in file...");

                        // Loop through each line, stashing the line into our line
                        // variable.
                        boolean noMatches = true;
                        while ((line = bf.readLine()) != null) {

                            // Increment the count and find the index of the word.
                            linecount++;
                            int indexfound = line.indexOf(searchterm.toLowerCase());

                            // If greater than -1, means we found a match.
                            if (indexfound > -1) {
                                System.out.println("\ncontact listing found"
                                        + "\nContact " + linecount + ": " + line);
                                noMatches = false;
                            }
                        }
                        // Close the file after done searching
                        bf.close();
                        if (noMatches) {
                            System.out.println("\nNO MATCH FOUND.\n");
                        }
                    }

                    catch (IOException e) {
                        System.out.println("IO Error Occurred: " + e.toString());
                    }

                    break;








                }
            }

    }}
