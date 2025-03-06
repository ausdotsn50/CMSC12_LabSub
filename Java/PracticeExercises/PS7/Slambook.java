import java.util.ArrayList;
import java.util.HashMap;

public class Slambook {
    // hashmap (key, value)
    private HashMap<String, Person> map = new HashMap<String, Person>();
    private ArrayList<Person> person = new ArrayList<Person>();

    public void addEntry(String username, String name, int age, String gender, String crush, String favoriteMovie, String favoriteColor, String favoriteSubject, String motto) {
        // the put() method writes an entry into the map
        Person newPerson = new Person(username, name, age, gender, crush, favoriteMovie, favoriteColor, favoriteSubject, motto);
        person.add(newPerson);
        map.put(username, newPerson); 
    }

    public void searchEntry(String username) {
        int index = findEntry(username);
        if(index < 0) {
            return;
        }
        else {
            printEntry(index);
        }
    }

    public void listEntries() {
        for(int index = 0; index < person.size(); index++) {
            // person -> ArrayList
            // get(i) -> retrieve element at index i
            System.out.print("\nEntry " + (index + 1) + "\n");
            printEntry(index);
        }
    }


    public void deleteEntry(String username) {
        int index = findEntry(username);
        if(index < 0) {
            return;
        }
        else {
            person.remove(index);
            System.out.print("\nEntry successfully deleted!\n");
        }
        
    }

    // general use
    // iterated
    public void printEntry(int i) {
        System.out.print("\nUsername: " + person.get(i).getUsername() + "\n");
        System.out.println("Name: " + person.get(i).getName());
        System.out.println("Age: " + person.get(i).getAge());
        System.out.println("Gender: " + person.get(i).getGender());
        System.out.println("Crush: " + person.get(i).getCrush());
        System.out.println("Favorite Movie: " + person.get(i).getFavMovie());    
        System.out.println("Favorite Color: " + person.get(i).getFavColor());    
        System.out.println("Favorite Subject: " + person.get(i).getFavSub());
        System.out.println("Motto: " + person.get(i).getMotto());
    }

    public int findEntry(String key) {
        // note that map.get(key) returns key value of type Person
        Person targetEntry = map.get(key);
        if(targetEntry == null) {
            System.out.print("\nUser not found!\n");
            return -1;

        }
        return person.indexOf(targetEntry);
    }
}