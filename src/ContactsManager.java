import java.util.ArrayList;

public class ContactsManager {

    private String name;
    private String phoneNumber; //string for numbers to accomodate the dash.
    private ArrayList<String> ContactsList = new ArrayList<>(); // constructor for arraylist.

    // Consturctor to create new contacts
    public  ContactsManager(){
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

    public ArrayList<String> getContactsList() {
        return ContactsList;
    }

    public void setContactsList(ArrayList<String> contactsList) {
        ContactsList = contactsList;
    }
}


