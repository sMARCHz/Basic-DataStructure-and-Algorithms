import model.Employee;

public class SimpleHashTable {

    // In this class, it uses array backing the hash tables and uses string as a key's data type.
    // In this class, it has no collision handling (check if the index already exist or not when adding data).

    private Employee[] hashtable;

    public SimpleHashTable() {
        hashtable = new Employee[10]; // capacity needs to be 10 because our homemade hash function
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null) {
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = employee;
        }
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    }

    public void printHashTable() {
        for (Employee employee : hashtable) {
            System.out.println(employee);
        }
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length; // homemade hash function
    }
}
