import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Eric on 15/10/27.
 */
public class AddressBook {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public static void main(String ...args) {

        AddressBook addressBook = new AddressBook();
        ArrayList<Contact> contacts = addressBook.getContacts();

        contacts.add(new Contact("Eric", "Wong", "18524407457", "NEU"));
        contacts.add(new Contact("Nick", "Zhong", "18524407457", "EDU"));

        /* Display all the contacts */
        addressBook.display();

        /* Sort procedure */
        addressBook.sort(new OrganisationSorting());
        System.out.println("Sorted by organisation");
        System.out.println(addressBook.getContacts());

        addressBook.sort(new GivenNameSorting());
        System.out.println("Sorted by givenName");
        System.out.println(addressBook.getContacts());

    }

    public void sort(SortStrategy strategy) {
        strategy.sort(this.contacts);
    }

    public void display() {
        System.out.println("Display all:");
        System.out.println(contacts);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}